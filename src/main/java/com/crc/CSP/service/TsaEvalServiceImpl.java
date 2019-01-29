package com.crc.CSP.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.crc.CSP.DAO.TsaEvalDAO;
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

@Service
public class TsaEvalServiceImpl implements TsaEvalService{

	@Inject
	private TsaEvalDAO dao;
	
	@Override
	public void insertEntTotal(HashMap map) throws Exception
	{
		dao.insertEntTotal(map);
	}
	
	@Override
	public void insertEntTsa(HashMap map) throws Exception
	{
		dao.insertEntTsa(map);
	}
	
	@Override
	public void insertEntCommon(HashMap map) throws Exception
	{
		dao.insertEntCommon(map);
	}
	
	@Override
	public void insertTools(HashMap map) throws Exception
	{
		dao.insertTools(map);
	}
	
	@Override
	public void insertOuterBreak(HashMap map) throws Exception
	{
		dao.insertOuterBreak(map);
	}
	
	@Override
	public void insertSeptalFlap(HashMap map) throws Exception
	{
		dao.insertSeptalFlap(map);
	}
	
	@Override
	public void insertPoints(HashMap map) throws Exception
	{
		dao.insertPoints(map);
	}
	
	@Override
	public void insertPathPoints(HashMap map) throws Exception
	{
		dao.insertPathPoints(map);
	}
	
	@Override
	public void insertTargetPoints(HashMap map) throws Exception
	{
		dao.insertTargetPoints(map);
	}
	
	@Override
	public void insertSuperiorTurbinate(HashMap map) throws Exception
	{
		dao.insertSuperiorTurbinate(map);
	}
	
	@Override
	public void insertSphenoidCellsRemoval(HashMap map) throws Exception
	{
		dao.insertSphenoidCellsRemoval(map);
	}
	
	@Override
	public void insertSellaDuramater(HashMap map) throws Exception
	{
		dao.insertSellaDuramater(map);
	}
	
	@Override
	public void insertTransclivalDrilling(HashMap map) throws Exception
	{
		dao.insertTransclivalDrilling(map);
	}
	
	@Override
	public void insertTumorRemoval(HashMap map) throws Exception
	{
		dao.insertTumorRemoval(map);
	}
	
	@Override
	public void insertPointTrigger(HashMap map) throws Exception
	{
		dao.insertPointTrigger(map);
	}
	
	@Override
	public void insertEntTransclivalApproach(HashMap map) throws Exception
	{
		dao.insertEntTransclivalApproach(map);
	}
	
	@Override
	public void insertEntAcidosisMaxillarySinus(HashMap map) throws Exception
	{
		dao.insertEntAcidosisMaxillarySinus(map);
	}
	
	@Override
	public void insertUncinectomy(HashMap map) throws Exception
	{
		dao.insertUncinectomy(map);
	}
	
	@Override
	public void insertAnteriorEthmoidectomy(HashMap map) throws Exception
	{
		dao.insertAnteriorEthmoidectomy(map);
	}
	
	@Override
	public void insertEntAcidosisFrontalSinus(HashMap map) throws Exception
	{
		dao.insertEntAcidosisFrontalSinus(map);
	}
	
	@Override
	public void insertAnteriorSinus(HashMap map) throws Exception
	{
		dao.insertAnteriorSinus(map);
	}
	
	@Override
	public void insertEntAcidosisEthmoidalSinus(HashMap map) throws Exception
	{
		dao.insertEntAcidosisEthmoidalSinus(map);
	}
	
	@Override
	public void insertAnteriorEthmoidalAirCellRemoval(HashMap map) throws Exception
	{
		dao.insertAnteriorEthmoidalAirCellRemoval(map);
	}
	
	@Override
	public void insertPosteriorAirCellRemoval(HashMap map) throws Exception
	{
		dao.insertPosteriorAirCellRemoval(map);
	}
	
	@Override
	public EntTotalVO getEntTotal(int no) throws Exception
	{
		return dao.getEntTotal(no);
	}
	
	@Override
	public String getEntTsa(String id) throws Exception
	{
		return dao.getEntTsa(id);
	}
	
	@Override
	public EntCommonVO getEntCommon(String id) throws Exception
	{
		return dao.getEntCommon(id);
	}
	
	@Override
	public ToolsVO getTools(String id) throws Exception
	{
		return dao.getTools(id);
	}
	
	@Override
	public PathTriggerVOStr getOuterBreak(String id) throws Exception
	{
		return dao.getOuterBreak(id);
	}
	
	@Override
	public PathTriggerVOStr getSeptalFlap(String id) throws Exception
	{
		return dao.getSeptalFlap(id);
	}

	@Override
	public BoxTriggerVO getSuperiorTurbinate(String id) throws Exception
	{
		return dao.getSuperiorTurbinate(id);
	}
	
	@Override
	public VolumeTriggerVOStr getSphenoidCellsRemoval(String id) throws Exception
	{
		return dao.getSphenoidCellsRemoval(id);
	}
	
	@Override
	public VolumeTriggerVOStr getTransclivalDrilling(String id) throws Exception
	{
		return dao.getTransclivalDrilling(id);
	}
	
	@Override
	public VolumeTriggerVOStr getSellaDuramater(String id) throws Exception
	{
		return dao.getSellaDuramater(id);
	}
	
	@Override
	public VolumeTriggerVOStr getTumorRemoval(String id) throws Exception
	{
		return dao.getTumorRemoval(id);
	}
	
	@Override
	public List<EntTotalVO> list(HashMap map) throws Exception
	{
		return dao.list(map);
	}
	
	@Override
	public List<EntTotalVO> list_every(HashMap map) throws Exception
	{
		return dao.list_every(map);
	}
	
	@Override
	public List<PointDataVOStr> getPoints(String id) throws Exception
	{
		return dao.getPoints(id);
	}
	
	@Override
	public List<PointDataVOStr> getTargetPoints(String id) throws Exception
	{
		return dao.getTargetPoints(id);
	}
	
	@Override
	public List<PointTriggerVO> getPointTriggers(String id) throws Exception
	{
		return dao.getPointTriggers(id);
	}
	
	@Override
	public String getEntTansclivalApproach(String id) throws Exception
	{
		return dao.getEntTansclivalApproach(id);
	}
	
	@Override
	public String getEntAcidosisMaxillarySinus(String id) throws Exception
	{
		return dao.getEntAcidosisMaxillarySinus(id);
	}
	
	@Override
	public VolumeTriggerVOStr getUncinectomy(String id) throws Exception
	{
		return dao.getUncinectomy(id);
	}
	
	@Override
	public String getEntAcidosisFrontalSinus(String id) throws Exception
	{
		return dao.getEntAcidosisFrontalSinus(id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorEthmoidectomy(String id) throws Exception
	{
		return dao.getAnteriorEthmoidectomy(id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorSinus(String id) throws Exception
	{
		return dao.getAnteriorSinus(id);
	}
	
	@Override
	public String getEntAcidosisEthmoidalSinus(String id) throws Exception
	{
		return dao.getEntAcidosisEthmoidalSinus(id);
	}
	
	@Override
	public VolumeTriggerVOStr getAnteriorEthmoidalAirCellRemoval(String id) throws Exception
	{
		return dao.getAnteriorEthmoidalAirCellRemoval(id);
	}
	
	@Override
	public VolumeTriggerVOStr getPosteriorAirCellRemoval(String id) throws Exception
	{
		return dao.getPosteriorAirCellRemoval(id);
	}
	
	@Override
	public int getEntTsaScoreRange(HashMap map) throws Exception
	{
		return dao.getEntTsaScoreRange(map);
	}
	
	@Override
	public int getEntTransclivalApproachScoreRange(HashMap map) throws Exception
	{
		return dao.getEntTransclivalApproachScoreRange(map);
	}
	
	@Override
	public int getEntAcidosisMaxillarySinusScoreRange(HashMap map) throws Exception
	{
		return dao.getEntAcidosisMaxillarySinusScoreRange(map);
	}
	
	@Override
	public int getEntAcidosisFrontalSinusScoreRange(HashMap map) throws Exception
	{
		return dao.getEntAcidosisFrontalSinusScoreRange(map);
	}
	
	@Override
	public int getEntAcidosisEthmoidalSinusScoreRange(HashMap map) throws Exception
	{
		return dao.getEntAcidosisEthmoidalSinusScoreRange(map);
	}
	
	@Override
	public void updateExpertTools(HashMap map) throws Exception
	{
		dao.updateExpertTools(map);
	}
	
	@Override
	public ExpertToolsVO getExpertTools(String oper_name) throws Exception
	{
		return dao.getExpertTools(oper_name);
	}
	
	@Override
	public String getAverTouchCount(String pid) throws Exception
	{
		return dao.getAverTouchCount(pid);
	}
	
	@Override
	public String getAverToolUseCount(String pid) throws Exception
	{
		return dao.getAverToolUseCount(pid);
	}
	
	@Override
	public String getAverToolInnerCount(String pid) throws Exception
	{
		return dao.getAverToolInnerCount(pid);
	}
	
	@Override
	public String getAverToolTouchScore(String pid) throws Exception
	{
		return dao.getAverToolTouchScore(pid);
	}
	
	@Override
	public String getAverToolViewScore(String pid) throws Exception
	{
		return dao.getAverToolViewScore(pid);
	}
	
	@Override
	public String getAverMaxScore(String pid) throws Exception
	{
		return dao.getAverMaxScore(pid);
	}
	
	@Override
	public RangeScoreVO getRngTSA() throws Exception
	{
		return dao.getRngTSA();
	}
	
	@Override
	public RangeScoreVO getRngTransclivalApproach() throws Exception
	{
		return dao.getRngTransclivalApproach();
	}
	
	@Override
	public RangeScoreVO getRngAcidosisMaxillarySinus() throws Exception
	{
		return dao.getRngAcidosisMaxillarySinus();
	}
	
	@Override
	public RangeScoreVO getRngAcidosisFrontalSinus() throws Exception
	{
		return dao.getRngAcidosisFrontalSinus();
	}
	
	@Override
	public RangeScoreVO getRngAcidosisEthmoidalSinus() throws Exception
	{
		return dao.getRngAcidosisEthmoidalSinus();
	}
	
	@Override
	public int getAverScoreOuterBreak() throws Exception
	{
		return dao.getAverScoreOuterBreak();
	}
	
	@Override
	public int getAverScoreSeptalFlap() throws Exception
	{
		return dao.getAverScoreSeptalFlap();
	}
	
	@Override
	public int getAverScoreSuperiorTurbinate() throws Exception
	{
		return dao.getAverScoreSuperiorTurbinate();
	}
	
	@Override
	public int getAverScoreSellaDuramater() throws Exception
	{
		return dao.getAverScoreSellaDuramater();
	}
	
	@Override
	public int getAverScoreTumorRemoval() throws Exception
	{
		return dao.getAverScoreTumorRemoval();
	}
	
	@Override
	public int getAverScoreSphenoidCellsRemoval() throws Exception
	{
		return dao.getAverScoreSphenoidCellsRemoval();
	}
	
	@Override
	public int getAverScoreTransclivalDrilling() throws Exception
	{
		return dao.getAverScoreTransclivalDrilling();
	}
	
	@Override
	public int getAverScoreUncinectomy() throws Exception
	{
		return dao.getAverScoreUncinectomy();
	}
	
	@Override
	public int getAverScoreAnteriorEthmoidalAirCellRemoval() throws Exception
	{
		return dao.getAverScoreAnteriorEthmoidalAirCellRemoval();
	}
	
	@Override
	public int getAverScorePosteriorAirCellRemoval() throws Exception
	{
		return dao.getAverScorePosteriorAirCellRemoval();
	}
	
	@Override
	public int getAverAnteriorEthmoidectomy() throws Exception
	{
		return dao.getAverAnteriorEthmoidectomy();
	}
	
	@Override
	public int getAverScoreAnteriorSinus() throws Exception
	{
		return dao.getAverScoreAnteriorSinus();
	}
	
	@Override
	public int getAverSuperiorTurbinate() throws Exception
	{
		return dao.getAverSuperiorTurbinate();
	}
	
	@Override
	public int getAverUncinectomy() throws Exception
	{
		return dao.getAverUncinectomy();
	}
}
