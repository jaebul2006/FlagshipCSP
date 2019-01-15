package com.crc.CSP;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.service.TestService;

@RestController
public class TestController {

	@Autowired
	private TestService test_service;
	
	@PostMapping(value="/restful/insert_test")
	public ResponseEntity<Object> insert_test(@RequestParam("test")String test) throws Exception
	{
		int id = 2;
		int num = 2;
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("myid", id);
		map.put("mynum", num);
		test_service.insertTest(map);
		
		return new ResponseEntity<Object>("ok", HttpStatus.OK);
	}
}
