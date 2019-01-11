package com.crc.legacymvc;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownloadController {

	private static final String DOWN_FILE = "test_file.zip";
	
	@RequestMapping(value="/download")
	public void downloadFile(HttpServletResponse response) throws IOException{
		
		File file = null;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		file = new File(classloader.getResource(DOWN_FILE).getFile());
		
		if(!file.exists()) {
			String error_message = "죄송합니다. 파일이 존재하지않습니다";
			System.out.println(error_message);
			OutputStream ops = response.getOutputStream();
			ops.write(error_message.getBytes(Charset.forName("UTF-8")));
			ops.close();
			return;
		}
		
		String mime_type = URLConnection.guessContentTypeFromName(file.getName());
		if(mime_type == null) {
			System.out.println("mimetype is not detectable, will take default");
			mime_type = "application/octet-stream";
		}
		
		System.out.println("mimetype : " + mime_type);
		
		response.setContentType(mime_type);
		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
		response.setContentLength((int)file.length());
		
		InputStream input_stream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(input_stream, response.getOutputStream());
		
	}
	
}
