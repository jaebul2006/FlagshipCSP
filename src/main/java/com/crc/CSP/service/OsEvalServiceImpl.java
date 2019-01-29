package com.crc.CSP.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crc.CSP.DAO.OsEvalDAO;
import com.crc.CSP.bean.Hip01DataVOStr;
import com.crc.CSP.bean.Hip02DataVOStr;
import com.crc.CSP.bean.Hip03DataVOStr;
import com.crc.CSP.bean.Hip04DataVOStr;
import com.crc.CSP.bean.Hip04PointsVOStr;
import com.crc.CSP.bean.Hip05DataVOStr;
import com.crc.CSP.bean.Hip05PointsVOStr;
import com.crc.CSP.bean.Hip06DataVOStr;
import com.crc.CSP.bean.Hip06PointsVOStr;
import com.crc.CSP.bean.HipCommonVO;

@Service
public class OsEvalServiceImpl implements OsEvalService{

	@Inject
	private OsEvalDAO dao;
	
	@Override
	public void insertHipCommon(HashMap map) throws Exception
	{
		dao.insertHipCommon(map);
	}
	
	@Override
	public void insertHip01(HashMap map) throws Exception
	{
		dao.insertHip01(map);
	}
	
	@Override
	public void insertHip02(HashMap map) throws Exception
	{
		dao.insertHip02(map);
	}
	
	@Override
	public void insertHip03(HashMap map) throws Exception
	{
		dao.insertHip03(map);
	}
	
	@Override
	public void insertHip04(HashMap map) throws Exception
	{
		dao.insertHip04(map);
	}
	
	@Override
	public void insertHip04Points(HashMap map) throws Exception
	{
		dao.insertHip04Points(map);
	}
	
	@Override
	public void insertHip05(HashMap map) throws Exception
	{
		dao.insertHip05(map);
	}
	
	@Override
	public void insertHip05Points(HashMap map) throws Exception
	{
		dao.insertHip05Points(map);
	}
	
	@Override
	public void insertHip06(HashMap map) throws Exception
	{
		dao.insertHip06(map);
	}
	
	@Override
	public void insertHip06Points(HashMap map) throws Exception
	{
		dao.insertHip06Points(map);
	}
	
	@Override
	public int count(String searchOption, String keyword, String user_id) throws Exception
	{
		return dao.count(searchOption, keyword, user_id);
	}
	
	@Override
	public List<HipCommonVO> list(int start, int end, String searchOption, String keyword, String user_id) throws Exception
	{
		return dao.list(start, end, searchOption, keyword, user_id);
	}
	
	@Override
	public List<HipCommonVO> list_every(int start, int end, String searchOption, String keyword, String user_id) throws Exception
	{
		return dao.list_every(start, end, searchOption, keyword, user_id);
	}
	
	@Override
	public Hip01DataVOStr view(String id) throws Exception
	{
		return dao.view(id);
	}
	
	@Override
	public Hip02DataVOStr view2(String id) throws Exception
	{
		return dao.view2(id);
	}
	
	@Override
	public Hip03DataVOStr view3(String id) throws Exception
	{
		return dao.view3(id);
	}
	
	@Override
	public Hip04DataVOStr view4(String id) throws Exception
	{
		return dao.view4(id);
	}
	
	@Override
	public List<Hip04PointsVOStr> view4_points(String id) throws Exception
	{
		return dao.view4_points(id);
	}
	
	@Override
	public Hip05DataVOStr view5(String id) throws Exception
	{
		return dao.view5(id);
	}
	
	@Override
	public List<Hip05PointsVOStr> view5_points(String id) throws Exception
	{
		return dao.view5_points(id);
	}
	
	@Override
	public Hip06DataVOStr view6(String id) throws Exception
	{
		return dao.view6(id);
	}
	
	@Override
	public List<Hip06PointsVOStr> view6_points(String id) throws Exception
	{
		return dao.view6_points(id);
	}
	
	@Override
	public HipCommonVO view_common(String id) throws Exception
	{
		return dao.view_common(id);
	}
	
	@Override
	public String getOSFilename(String raw_id) throws Exception
	{
		return dao.getOSFilename(raw_id);
	}
	
	@Override
	public List<HipCommonVO> recent10_os_common(String user_id) throws Exception
	{
		return dao.recent10_os_common(user_id);
	}
	
	@Override
	public List<HipCommonVO> recent_month_os_common(HashMap map) throws Exception
	{
		return dao.recent_month_os_common(map);
	}
}
