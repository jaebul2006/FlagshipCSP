package com.crc.legacymvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InputtestController {

	@RequestMapping(value = "/inputtest", method = RequestMethod.GET)
	public String inputtest() throws Exception{
		
		return "inputtest";
	}
	
}
