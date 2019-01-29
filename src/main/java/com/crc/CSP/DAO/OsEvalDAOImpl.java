package com.crc.CSP.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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

@Repository
public class OsEvalDAOImpl implements OsEvalDAO{

	private static final String namespace = "com.crc.CSP.OsEvalMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertHipCommon(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHipCommon", map);
	}
	
	@Override
	public void insertHip01(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip01", map);
	}
	
	@Override
	public void insertHip02(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip02", map);
	}
	
	@Override
	public void insertHip03(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip03", map);
	}
	
	@Override
	public void insertHip04(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip04", map);
	}
	
	@Override
	public void insertHip04Points(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip04Points", map);
	}
	
	@Override
	public void insertHip05(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip05", map);
	}
	
	@Override
	public void insertHip05Points(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip05Points", map);
	}

	@Override
	public void insertHip06(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip06", map);
	}	
	
	@Override
	public void insertHip06Points(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertHip06Points", map);
	}
	
	@Override
	public int count(String searchOption, String keyword, String user_id) throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("user_id", user_id);
		return sqlSession.selectOne(namespace + ".count", map);
	}
	
	@Override
	public List<HipCommonVO> list(int start, int end, String searchOption, String keyword, String user_id) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("user_id", user_id);
		return sqlSession.selectList(namespace + ".list", map);
	}
	
	@Override
	public List<HipCommonVO> list_every(int start, int end, String searchOption, String keyword, String user_id) throws Exception
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("start", start);
		map.put("end", end);
		map.put("user_id", user_id);
		return sqlSession.selectList(namespace + ".list_every", map);
	}
	
	@Override
	public Hip01DataVOStr view(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view", id);
	}
	
	@Override
	public Hip02DataVOStr view2(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view2", id);
	}
	
	@Override
	public Hip03DataVOStr view3(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view3", id);
	}
	
	@Override
	public Hip04DataVOStr view4(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view4", id);
	}
	
	@Override
	public List<Hip04PointsVOStr> view4_points(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".view4_points", id);
	}
	
	@Override
	public Hip05DataVOStr view5(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view5", id);
	}
	
	@Override
	public List<Hip05PointsVOStr> view5_points(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".view5_points", id);
	}
	
	@Override
	public Hip06DataVOStr view6(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view6", id);
	}
	
	@Override
	public List<Hip06PointsVOStr> view6_points(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".view6_points", id);
	}
	
	@Override
	public HipCommonVO view_common(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".view_common", id);
	}
	
	@Override
	public String getOSFilename(String raw_id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getOSFilename", raw_id);
	}
	
	@Override
	public List<HipCommonVO> recent10_os_common(String user_id) throws Exception
	{
		return sqlSession.selectList(namespace + ".recent10_os_common", user_id);
	}
	
	@Override
	public List<HipCommonVO> recent_month_os_common(HashMap map) throws Exception
	{
		return sqlSession.selectList(namespace + ".recent_month_os_common", map);
	}
}
