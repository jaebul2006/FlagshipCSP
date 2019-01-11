package com.crc.CSP;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crc.CSP.bean.AuthTokenVO;
import com.crc.CSP.bean.CoachingBoardVO;
import com.crc.CSP.service.AuthTokenService;
import com.crc.CSP.service.CoachingBoardService;

@RestController
public class CoachingRestController {

	private static final long session_time = 6000000;
	@Resource(name="uploadPath")
	String uploadPath;
	
	@Autowired
	private AuthTokenService authtoken_service;
	
	@Autowired
	CoachingBoardService boardService;
	
	// ����� ����Ű�� �ִ���, �ð��� ����Ǿ����� üũ
	private AuthTokenVO ValidAuthToken(String auth_token) throws Exception
	{
		AuthTokenVO atvo;
		
		if(auth_token == null || auth_token == "") {
			atvo = null;
			return atvo;
		}
		
		// db �� ����� ���� �ִ��� Ȯ��
		atvo = authtoken_service.getAuthToken(auth_token);
		
		if(atvo != null) {
			// ������ū�� ���� �ð��� Ư�� �� ���� �����ٸ� return false
			// ����� ��ū�� ����
			System.out.println("����ð�: " + System.currentTimeMillis());
			System.out.println("������ �ð�: " + atvo.getTimeValid());
			// if ����ð� - ������ �ð� > �����ð�: ��ū ����
			//atvo = null;
			long cur_time = System.currentTimeMillis();
			long prev_time = Long.parseLong(atvo.getTimeValid());
			long elapsed_time = cur_time - prev_time;
			System.out.println("�귯�� �ð�: " + elapsed_time);
			
			// ���Ǹ���
			if(elapsed_time > session_time) {
				atvo = null;
			}
		}
		return atvo;
	}
	
	@Transactional
	@PostMapping(value="/restful/upd_coaching_movie", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_coaching_movie(@RequestParam("uid")String uid,
			@RequestParam("title")String title,
			@RequestParam("content")String content,
			@RequestParam("writer")String writer,
			@RequestParam("content_type")String content_type,
			MultipartFile file) throws Exception
	{
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(uid);
		
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		String file_name = "";
		
		if(file != null) {
			file_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		
		CoachingBoardVO vo = new CoachingBoardVO();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(user_id);
		vo.setFileName(file_name);
		vo.setContent_type(content_type);
		boardService.create(vo);
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
}
