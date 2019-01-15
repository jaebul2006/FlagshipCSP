package com.crc.CSP.service;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crc.CSP.DAO.TestDAO;

@Service
public class TestServiceImpl implements TestService{

	@Inject
	private TestDAO dao;
	
	@Override
	public void insertTest(HashMap map) throws Exception
	{
		dao.insertTest(map);
	}
	
}
