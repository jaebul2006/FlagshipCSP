package com.crc.CSP.service;

import java.util.HashMap;
import java.util.List;

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

public interface OsEvalService {

	// rest controller
	public void insertHipCommon(HashMap map) throws Exception;
	public void insertHip01(HashMap map) throws Exception;
	public void insertHip02(HashMap map) throws Exception;
	public void insertHip03(HashMap map) throws Exception;
	public void insertHip04(HashMap map) throws Exception;
	public void insertHip04Points(HashMap map) throws Exception;
	public void insertHip05(HashMap map) throws Exception;
	public void insertHip05Points(HashMap map) throws Exception;
	public void insertHip06(HashMap map) throws Exception;
	public void insertHip06Points(HashMap map) throws Exception;
	
	// controller
	public int count(String searchOption, String keyword, String user_id) throws Exception;
	public List<HipCommonVO> list(int start, int end, String searchOption, String keyword, String user_id) throws Exception;
	public Hip01DataVOStr view(String id) throws Exception;
	public Hip02DataVOStr view2(String id) throws Exception;
	public Hip03DataVOStr view3(String id) throws Exception;
	
	public Hip04DataVOStr view4(String id) throws Exception;
	public List<Hip04PointsVOStr> view4_points(String id) throws Exception;
	
	public Hip05DataVOStr view5(String id) throws Exception;
	public List<Hip05PointsVOStr> view5_points(String id) throws Exception;
	
	public Hip06DataVOStr view6(String id) throws Exception;
	public List<Hip06PointsVOStr> view6_points(String id) throws Exception;
	
	public HipCommonVO view_common(String id) throws Exception;
	public String getOSFilename(String raw_id) throws Exception;
	
	public List<HipCommonVO> recent10_os_common(String user_id) throws Exception;
	public List<HipCommonVO> recent_month_os_common(HashMap map) throws Exception;
}
