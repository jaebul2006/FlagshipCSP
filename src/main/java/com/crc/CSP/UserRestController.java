package com.crc.CSP;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.bean.AccountVO;
import com.crc.CSP.bean.AuthTokenVO;
import com.crc.CSP.bean.ContentAuthorityVO;
import com.crc.CSP.bean.UserBean;
import com.crc.CSP.service.AccountService;
import com.crc.CSP.service.AuthTokenService;
import com.crc.CSP.service.UserService;

@RestController
public class UserRestController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(UserRestController.class);
	private static final long session_time = 600000;
	
	@Autowired
	private UserService user_service;

	@Autowired
	private AccountService account_service;

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

	
	// ���������� �ƴ� ����Ƽ�� Ŭ���̾�Ʈ �α��ο�.
	@PostMapping(value = "/restful/csplogin")
	public ResponseEntity<Object> csplogin(HttpSession session, 
			@RequestParam("id")String id,  @RequestParam("pass")String pass) throws Exception 
	{	
		System.out.println("������ ����: " + session.getId());
		// ������ ������ ���� �ð��� db�� �����ϰ� ����Ű�� Ȱ���Ѵ�.
		
		// ��� ���� map
		HashMap<String, Object>res_map = new HashMap<String, Object>();
		
		UserBean user_res;
		
		user_res = user_service.user(id);
		
		/*if(user_res != null)
		{
			BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
			boolean res_v = encode.matches(pass, user_res.getPASSWORD());
			if(res_v)
			{
				return new ResponseEntity<Object>(user_res, HttpStatus.OK); // json Ű, ���� �ҹ��ڷ� ��������.
			}
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Object>(null, HttpStatus.OK);
		}*/
		
		if(user_res != null)
		{
			if(user_res.getPASSWORD().equals(pass)) 
			{	
				AccountVO account;
				account = account_service.getAccount(user_res.getACCOUNT_ID());
				if(account != null) 
				{
					// lastLogin �� ���� �̽������� �ٽ� �����ϰ� ����� Ŭ�����Ʈ�� ������.
					SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Calendar cal = Calendar.getInstance();
					String today = null;
					today = date.format(cal.getTime());
					Timestamp ts = Timestamp.valueOf(today);
					String account_id = user_res.getACCOUNT_ID();
					
					String token_v = session.getId();
					long token_create_time = session.getCreationTime();
					
					HashMap<String, Object>map = new HashMap<String, Object>();
					map.put("ID", account_id);
					map.put("LastLogin", ts);
					map.put("AuthToken", token_v);
					account_service.updateLastInfo(map);
					
					account.setLastLogin(ts.toString());
					
					HashMap<String, Object>token_map = new HashMap<String, Object>();
					token_map.put("Token", token_v);
					token_map.put("TimeValid", token_create_time);
					token_map.put("UserId", user_res.getID());
					authtoken_service.updateAuthToken(token_map);
					
					res_map.put("lastLoginTime", today);
					res_map.put("uid", token_v);
					res_map.put("macAddress", account.getMacAddress());
					res_map.put("userLevel", user_res.getUSERTYPE());
					
					return new ResponseEntity<Object>(res_map, HttpStatus.OK); // json Ű, ���� �ҹ��ڷ� ��������.
				}
			}
			else
			{
				// �н����� ����
				res_map.put("Error", "PassError");
				return new ResponseEntity<Object>(res_map, HttpStatus.OK); // json Ű, ���� �ҹ��ڷ� ��������.
			}
		}
		else
		{
			// ������ ������������
			res_map.put("Error", "NotUser");
			return new ResponseEntity<Object>(res_map, HttpStatus.OK); // json Ű, ���� �ҹ��ڷ� ��������.
		}
		
		return new ResponseEntity<Object>(null, HttpStatus.OK); // json Ű, ���� �ҹ��ڷ� ��������.
	}
	
	
	// id �� ���� �������� Ȯ��
	@PostMapping(value = "/restful/CheckAdmin")
	public ResponseEntity<Object> CheckAdmin(@RequestParam("authtoken")String authtoken) throws Exception 
	{
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(authtoken);
		
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		UserBean user_res;
		user_res = user_service.user(user_id);
		if(user_res != null)
		{
			if(user_res.getAUTHORITY().equals("ROLE_ADMIN")) 
			{	
				return new ResponseEntity<Object>("admin", HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object>("noadmin", HttpStatus.OK);
	}
	
	
	// mac address ���� 
	@PostMapping(value="/restful/ChangeMacAddress")
	public ResponseEntity<Object> ChangeMacAddress(@RequestParam("uid")String uid, 
			@RequestParam("newMacAddress")String newMacAddress) throws Exception
	{
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(uid);
		
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", user_id);
		map.put("newMacAddress", newMacAddress);
		
		account_service.ChangeMacAddress(map);
		AccountVO accountvo = account_service.getAccountAdmin(user_id);
		System.out.println(">>>" + accountvo);
		return new ResponseEntity<Object>(accountvo, HttpStatus.OK);
	}
	
	// ��������
	@PostMapping(value="/restful/UserInfo")
	public ResponseEntity<Object> UserInfo(@RequestParam("uid")String uid) throws Exception
	{
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(uid);
		
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		UserBean user_res = user_service.user(user_id);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("protocall", "user_info");
		map.put("user_res", user_res);
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	// ������ �ش� �������� �̿��� �Ǹ��� �ִ��� Ȯ��
	@PostMapping(value="/restful/content_auth")
	public ResponseEntity<Object> content_auth(@RequestParam("uid")String uid) throws Exception
	{
		AuthTokenVO atvo = ValidAuthToken(uid);
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		
		AccountVO accountvo = account_service.getAccountByUid(uid);
		
		if(accountvo == null)
		{
			res_map.put("Error", "Invalid uid");
			return new ResponseEntity<Object>(res_map, HttpStatus.OK);
		}
		else 
		{
			String admin_id = accountvo.getAdminID();
			ContentAuthorityVO cav = account_service.getContentAuthority(admin_id);
			if(cav == null) {
				// ���ѿ� ���� ������ ���ٸ� ����Ʈ������ �־��ش�. ����Ʈ������ ��� ������ �̿밡��.
				System.out.println("������ ��������. ����Ʈ ������ ä��ǽ�");
				account_service.insertContentAuthority(admin_id);
				res_map.put("user_id", admin_id);
				res_map.put("tsa", 1);
				res_map.put("os", 1);
				return new ResponseEntity<Object>(res_map, HttpStatus.OK);
			}
			res_map.put("user_id", admin_id);
			res_map.put("tsa", cav.getTsa());
			res_map.put("os", cav.getOs());
			return new ResponseEntity<Object>(res_map, HttpStatus.OK);
		}
	}
		
		
	
	
}
