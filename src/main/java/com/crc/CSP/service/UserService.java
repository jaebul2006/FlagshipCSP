package com.crc.CSP.service;

import java.util.HashMap;

import com.crc.CSP.bean.UserBean;

public interface UserService {

	public UserBean user(String id) throws Exception;
	public int user_regist(HashMap userinfo) throws Exception;
	public int userrole_regist(HashMap userroleinfo) throws Exception;
	public int user_delete(String id) throws Exception;
	public int user_role_delete(String id) throws Exception;
	public int countUserID(String userid) throws Exception;
	public void userPhoneNumberRegist(HashMap map) throws Exception;
	public String getPhoneNumber(String user_id) throws Exception;
	public void pushTokenUpdate(HashMap map) throws Exception;
	
}
