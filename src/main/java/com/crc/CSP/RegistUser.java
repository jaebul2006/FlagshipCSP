package com.crc.CSP;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.bean.AccountVO;
import com.crc.CSP.service.AccountService;
import com.crc.CSP.service.UserService;

@RestController
public class RegistUser 
{
	
	@Autowired
	AccountService account_service;
	
	@Autowired
	UserService user_service;
	
	// ���ΰ������
	@Transactional
	@PostMapping(value = "/RegistAccount")
	public ResponseEntity<Object> RegistAccount(@RequestParam("adminid")String adminid, @RequestParam("macaddress")String macaddress, 
			@RequestParam("password")String password, @RequestParam("user_type")String user_type) throws Exception
	{	
		int count = account_service.countAdminID(adminid);
		
		if(count > 0) {
			System.out.println("�����ϴ� ID");
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		}
		else {
			System.out.println("�ű� ID ���");

			AccountVO regist_account = new AccountVO();
			regist_account.setAdminID(adminid);
			regist_account.setMacAddress(macaddress);
			regist_account.setUser_type(user_type);
			account_service.regist(regist_account);
			
			AccountVO check_account = new AccountVO();
			check_account = account_service.getAccountAdmin(adminid);
			HashMap<String, Object>userinfo = new HashMap<String, Object>();
			userinfo.put("id", adminid);
			userinfo.put("password", password);
			userinfo.put("enabled", "1");
			userinfo.put("authority", "ROLE_ADMIN");
			userinfo.put("userName", adminid);
			userinfo.put("userType", user_type);
			userinfo.put("account_id", check_account.getID());
			user_service.user_regist(userinfo);
			
			return new ResponseEntity<Object>(check_account, HttpStatus.OK);
		}	
	}
	
	
	// �Ϲ��������
	@Transactional
	@PostMapping(value = "/RegistCommonAccount")
	public ResponseEntity<Object> RegistCommonAccount(@RequestParam("adminid")String adminid, @RequestParam("userid")String userid,  
			@RequestParam("password")String password, @RequestParam("nickname")String nickname) throws Exception
	{	
		AccountVO check_account = new AccountVO();
		check_account = account_service.getAccountAdmin(adminid);
		
		HashMap<String, Object>userinfo = new HashMap<String, Object>();
		userinfo.put("id", userid);
		userinfo.put("password", password);
		userinfo.put("enabled", "1");
		userinfo.put("authority", "ROLE_USER");
		String hnickname = new String(nickname.getBytes("8859_1"), "UTF-8");
		userinfo.put("userName", hnickname);
		userinfo.put("userType", "STUDENT");
		userinfo.put("account_id", check_account.getID());
		
		// ID �� ACCOUNT_ID �� ��� �����ϴٸ� �ߺ��Ƶ�ó��
		int count = user_service.countUserID(userid);
		if(count > 0)
		{
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		}
		else
		{
			user_service.user_regist(userinfo);
			return new ResponseEntity<Object>("������ϿϷ�", HttpStatus.OK);
		}
	}

}
