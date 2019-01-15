package com.crc.CSP.DAO;

import java.util.HashMap;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAOImpl implements TestDAO{

	private static final String namespace = "com.crc.CSP.TestMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertTest(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertTest", map); 
	}
	
}
