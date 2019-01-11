package com.crc.CSP.DAO;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.crc.CSP.bean.BoxTriggerVO;
import com.crc.CSP.bean.EntCommonVO;
import com.crc.CSP.bean.EntTotalVO;
import com.crc.CSP.bean.ExpertToolsVO;
import com.crc.CSP.bean.PathTriggerVOStr;
import com.crc.CSP.bean.PointDataVOStr;
import com.crc.CSP.bean.PointTriggerVO;
import com.crc.CSP.bean.RangeScoreVO;
import com.crc.CSP.bean.ToolsVO;
import com.crc.CSP.bean.VolumeTriggerVOStr;

@Repository
public class TsaEvalDAOImpl implements TsaEvalDAO{

	private static final String namespace = "com.crc.CSP.TsaEvalMapper";
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertEntTotal(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntTotal", map);
	}
	
	@Override
	public void insertEntTsa(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntTsa", map);
	}
	
	@Override
	public void insertEntCommon(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntCommon", map);
	}
	
	@Override
	public void insertTools(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertTools", map);
	}
	
	@Override
	public void insertOuterBreak(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertOuterBreak", map); 
	}
	
	@Override
	public void insertSeptalFlap(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertSeptalFlap", map); 
	}
	
	@Override
	public void insertPoints(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertPoints", map);
	}
	
	@Override
	public void insertPathPoints(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertPathPoints", map);
	}
	
	@Override
	public void insertTargetPoints(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertTargetPoints", map);
	}
	
	@Override
	public void insertSuperiorTurbinate(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertSuperiorTurbinate", map);
	}
	
	@Override
	public void insertSphenoidCellsRemoval(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertSphenoidCellsRemoval", map);
	}
	
	@Override
	public void insertSellaDuramater(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertSellaDuramater", map);
	}
	
	@Override
	public void insertTransclivalDrilling(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertTransclivalDrilling", map);
	}
	
	@Override
	public void insertTumorRemoval(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertTumorRemoval", map);
	}
	
	@Override
	public void insertUncinectomy(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertUncinectomy", map);
	}
	
	@Override
	public void insertPointTrigger(HashMap map)throws Exception
	{
		sqlSession.insert(namespace + ".insertPointTrigger", map);
	}
	
	@Override
	public void insertEntTransclivalApproach(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntTransclivalApproach", map);
	}
	
	@Override
	public void insertEntAcidosisMaxillarySinus(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntAcidosisMaxillarySinus", map);
	}
	
	@Override
	public void insertAnteriorEthmoidectomy(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertAnteriorEthmoidectomy", map);
	}
	
	@Override
	public void insertEntAcidosisFrontalSinus(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntAcidosisFrontalSinus", map);
	}
	
	@Override
	public void insertAnteriorSinus(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertAnteriorSinus", map);
	}
	
	@Override
	public void insertEntAcidosisEthmoidalSinus(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertEntAcidosisEthmoidalSinus", map);
	}
	
	@Override
	public void insertAnteriorEthmoidalAirCellRemoval(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertAnteriorEthmoidalAirCellRemoval", map);
	}
	
	@Override
	public void insertPosteriorAirCellRemoval(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".insertPosteriorAirCellRemoval", map);
	}
	
	@Override
	public EntTotalVO getEntTotal(int no) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntTotal", no);
	}
	
	@Override
	public String getEntTsa(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntTsa", id);
	}
	
	@Override
	public EntCommonVO getEntCommon(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntCommon", id);
	}
	
	@Override
	public ToolsVO getTools(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getTools", id);
	}
	
	@Override
	public PathTriggerVOStr getOuterBreak(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getOuterBreak", id);
	}
	
	@Override
	public PathTriggerVOStr getSeptalFlap(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getSeptalFlap", id);
	}
	
	@Override
	public BoxTriggerVO getSuperiorTurbinate(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getSuperiorTurbinate", id);
	}
	
	@Override
	public VolumeTriggerVOStr getSphenoidCellsRemoval(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getSphenoidCellsRemoval", id);
	}
	
	@Override
	public VolumeTriggerVOStr getTransclivalDrilling(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getTransclivalDrilling", id);
	}
	
	@Override
	public VolumeTriggerVOStr getSellaDuramater(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getSellaDuramater", id);
	}
	
	@Override
	public VolumeTriggerVOStr getTumorRemoval(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getTumorRemoval", id);
	}
	
	@Override
	public List<EntTotalVO> list(HashMap map) throws Exception
	{
		return sqlSession.selectList(namespace + ".list", map);
	}
	
	@Override
	public List<PointDataVOStr> getPoints(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".getPoints", id);
	}
	
	@Override
	public List<PointDataVOStr> getTargetPoints(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".getTargetPoints", id);
	}
	
	@Override
	public List<PointTriggerVO> getPointTriggers(String id) throws Exception
	{
		return sqlSession.selectList(namespace + ".getPointTriggers", id);
	}
	
	@Override
	public String getEntTansclivalApproach(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntTansclivalApproach", id);
	}
	
	@Override
	public String getEntAcidosisMaxillarySinus(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisMaxillarySinus", id);
	}
	
	@Override
	public VolumeTriggerVOStr getUncinectomy(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getUncinectomy", id);
	}
	
	@Override
	public String getEntAcidosisFrontalSinus(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisFrontalSinus", id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorEthmoidectomy(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAnteriorEthmoidectomy", id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorSinus(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAnteriorSinus", id);
	}
	
	@Override
	public String getEntAcidosisEthmoidalSinus(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisEthmoidalSinus", id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorEthmoidalAirCellRemoval(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAnteriorEthmoidalAirCellRemoval", id);
	}
	
	@Override
	public VolumeTriggerVOStr getPosteriorAirCellRemoval(String id) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getPosteriorAirCellRemoval", id);
	}
	
	@Override
	public int getEntTsaScoreRange(HashMap map) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntTsaScoreRange", map);
	}
	
	@Override
	public int getEntTransclivalApproachScoreRange(HashMap map) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntTransclivalApproachScoreRange", map);
	}
	
	@Override
	public int getEntAcidosisMaxillarySinusScoreRange(HashMap map) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisMaxillarySinusScoreRange", map);
	}
	
	@Override
	public int getEntAcidosisFrontalSinusScoreRange(HashMap map) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisFrontalSinusScoreRange", map);
	}
	
	@Override
	public int getEntAcidosisEthmoidalSinusScoreRange(HashMap map) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getEntAcidosisEthmoidalSinusScoreRange", map);
	}
	
	@Override
	public void updateExpertTools(HashMap map) throws Exception
	{
		sqlSession.insert(namespace + ".updateExpertTools", map);
	}
	
	@Override
	public ExpertToolsVO getExpertTools(String oper_name) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getExpertTools", oper_name);
	}
	
	@Override
	public String getAverTouchCount(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverTouchCount", pid);
	}
	
	@Override
	public String getAverToolUseCount(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverToolUseCount", pid);
	}
	
	@Override
	public String getAverToolInnerCount(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverToolInnerCount", pid);
	}
	
	@Override
	public String getAverToolTouchScore(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverToolTouchScore", pid);
	}
	
	@Override
	public String getAverToolViewScore(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverToolViewScore", pid);
	}
	
	@Override
	public String getAverMaxScore(String pid) throws Exception
	{
		return sqlSession.selectOne(namespace + ".getAverMaxScore", pid);
	}
	
	@Override
	public RangeScoreVO getRngTSA() throws Exception
	{
		RangeScoreVO vo = new RangeScoreVO();
		vo.setRn0_to_50(sqlSession.selectOne(namespace + ".TSARng0to50").toString());
		vo.setRn51_to_60(sqlSession.selectOne(namespace + ".TSARng51to60").toString());
		vo.setRn61_to_70(sqlSession.selectOne(namespace + ".TSARng61to70").toString());
		vo.setRn71_to_80(sqlSession.selectOne(namespace + ".TSARng71to80").toString());
		vo.setRn81_to_90(sqlSession.selectOne(namespace + ".TSARng81to90").toString());
		vo.setRn91_to_100(sqlSession.selectOne(namespace + ".TSARng91to100").toString());
		return vo;
	}
	
	@Override
	public RangeScoreVO getRngTransclivalApproach() throws Exception
	{
		RangeScoreVO vo = new RangeScoreVO();
		vo.setRn0_to_50(sqlSession.selectOne(namespace + ".TransclivalApproachRng0to50").toString());
		vo.setRn51_to_60(sqlSession.selectOne(namespace + ".TransclivalApproachRng51to60").toString());
		vo.setRn61_to_70(sqlSession.selectOne(namespace + ".TransclivalApproachRng61to70").toString());
		vo.setRn71_to_80(sqlSession.selectOne(namespace + ".TransclivalApproachRng71to80").toString());
		vo.setRn81_to_90(sqlSession.selectOne(namespace + ".TransclivalApproachRng81to90").toString());
		vo.setRn91_to_100(sqlSession.selectOne(namespace + ".TransclivalApproachRng91to100").toString());
		return vo;
	}
	
	@Override
	public RangeScoreVO getRngAcidosisMaxillarySinus() throws Exception
	{
		RangeScoreVO vo = new RangeScoreVO();
		vo.setRn0_to_50(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng0to50").toString());
		vo.setRn51_to_60(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng51to60").toString());
		vo.setRn61_to_70(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng61to70").toString());
		vo.setRn71_to_80(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng71to80").toString());
		vo.setRn81_to_90(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng81to90").toString());
		vo.setRn91_to_100(sqlSession.selectOne(namespace + ".AcidosisMaxillarySinusRng91to100").toString());
		return vo;
	}
	
	@Override
	public RangeScoreVO getRngAcidosisFrontalSinus() throws Exception
	{
		RangeScoreVO vo = new RangeScoreVO();
		vo.setRn0_to_50(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng0to50").toString());
		vo.setRn51_to_60(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng51to60").toString());
		vo.setRn61_to_70(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng61to70").toString());
		vo.setRn71_to_80(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng71to80").toString());
		vo.setRn81_to_90(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng81to90").toString());
		vo.setRn91_to_100(sqlSession.selectOne(namespace + ".AcidosisFrontalSinusRng91to100").toString());
		return vo;
	}
	
	@Override
	public RangeScoreVO getRngAcidosisEthmoidalSinus() throws Exception
	{
		RangeScoreVO vo = new RangeScoreVO();
		vo.setRn0_to_50(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng0to50").toString());
		vo.setRn51_to_60(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng51to60").toString());
		vo.setRn61_to_70(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng61to70").toString());
		vo.setRn71_to_80(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng71to80").toString());
		vo.setRn81_to_90(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng81to90").toString());
		vo.setRn91_to_100(sqlSession.selectOne(namespace + ".AcidosisEthmoidalSinusRng91to100").toString());
		return vo;
	}
}
