package com.crc.CSP.DAO;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crc.CSP.bean.UserBean;

@Repository
public class UserDAOImpl implements UserDAO{

	private static final String namespace = "com.crc.CSP.UserMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public UserBean user(String id) throws Exception{
		return sqlSession.selectOne(namespace + ".user", id);
	}
	
	@Override
	public int user_regist(HashMap userinfo) throws Exception{
		return sqlSession.insert(namespace + ".user_regist", userinfo);
	}
	
	@Override
	public int userrole_regist(HashMap userroleinfo) throws Exception{
		return sqlSession.insert(namespace + ".userrole_regist", userroleinfo);
	}
	
	@Override
	public int user_delete(String id) throws Exception{
		return sqlSession.delete(namespace + ".user_delete", id);
	}
	
	@Override
	public int user_role_delete(String id) throws Exception{
		return sqlSession.delete(namespace + ".user_role_delete", id);
	}
	
	@Override
	public int countUserID(String userid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".countUserID", userid);
	}
	
	@Override
	public void userPhoneNumberRegist(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".userPhoneNumberRegist", map);
	}
	
	@Override
	public String getPhoneNumber(String user_id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getPhoneNumber", user_id);
	}
	
	@Override
	public void pushTokenUpdate(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".pushTokenUpdate", map);
	}
	
}
