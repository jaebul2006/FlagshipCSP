package com.crc.CSP.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crc.CSP.DAO.UserDAO;
import com.crc.CSP.bean.UserBean;

@Service
public class UserServiceImpl implements UserService{

	@Inject
	private UserDAO dao;
	
	@Override 
	public UserBean user(String id) throws Exception{
		return dao.user(id);
	}
	
	@Override
	public int user_regist(HashMap userinfo) throws Exception{
		return dao.user_regist(userinfo);
	}
	
	@Override
	public int userrole_regist(HashMap userroleinfo) throws Exception{
		return dao.userrole_regist(userroleinfo);
	}
	
	@Override
	public int user_delete(String id) throws Exception{
		return dao.user_delete(id);
	}
	
	@Override
	public int user_role_delete(String id) throws Exception{
		return dao.user_role_delete(id);
	}
	
	@Override
	public int countUserID(String userid) throws Exception
	{
		return dao.countUserID(userid);
	}
	
	@Override
	public void userPhoneNumberRegist(HashMap map) throws Exception
	{
		dao.userPhoneNumberRegist(map);
	}
	
	@Override
	public String getPhoneNumber(String user_id) throws Exception
	{
		return dao.getPhoneNumber(user_id);
	}
	
	@Override
	public void pushTokenUpdate(HashMap map) throws Exception
	{
		dao.pushTokenUpdate(map);
	}
	
}
