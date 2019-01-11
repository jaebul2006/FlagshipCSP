package com.crc.CSP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.bean.AuthTokenVO;
import com.crc.CSP.service.AuthTokenService;

@RestController
public class EvalResult 
{
	private static final Logger logger = LoggerFactory.getLogger(EvalResult.class);
	private static final long session_time = 600000;
	
	@Autowired
	private AuthTokenService authtoken_service;
	
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
	
	// id �� ���� �������� Ȯ��
	@PostMapping(value = "/restful/EvalResult")
	public ResponseEntity<Object> EvalResult(@RequestParam("uid")String uid, @RequestParam("eval_res_data")String eval_res_data) throws Exception 
	{
		AuthTokenVO atvo = ValidAuthToken(uid);
		
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		
		return new ResponseEntity<Object>(null, HttpStatus.OK);
	}
	
	
}
