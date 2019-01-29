package com.crc.CSP.DAO;

import java.util.HashMap;
import java.util.List;

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

public interface TsaEvalDAO {

	public void insertEntTotal(HashMap map) throws Exception;
	public void insertEntTsa(HashMap map) throws Exception;
	public void insertEntCommon(HashMap map) throws Exception;
	public void insertTools(HashMap map) throws Exception;
	public void insertOuterBreak(HashMap map) throws Exception;
	public void insertSeptalFlap(HashMap map) throws Exception;
	public void insertSuperiorTurbinate(HashMap map) throws Exception;
	public void insertSphenoidCellsRemoval(HashMap map) throws Exception;
	public void insertSellaDuramater(HashMap map) throws Exception;
	public void insertTransclivalDrilling(HashMap map) throws Exception;
	public void insertTumorRemoval(HashMap map) throws Exception;
	
	public void insertPoints(HashMap map) throws Exception;
	public void insertPathPoints(HashMap map) throws Exception;
	public void insertTargetPoints(HashMap map) throws Exception;
	
	public void insertPointTrigger(HashMap map)throws Exception;
	
	public void insertEntTransclivalApproach(HashMap map) throws Exception;
	public void insertEntAcidosisMaxillarySinus(HashMap map) throws Exception;
	public void insertUncinectomy(HashMap map) throws Exception;
	public void insertAnteriorEthmoidectomy(HashMap map) throws Exception;
	public void insertEntAcidosisFrontalSinus(HashMap map) throws Exception;
	public void insertAnteriorSinus(HashMap map) throws Exception;
	public void insertEntAcidosisEthmoidalSinus(HashMap map) throws Exception;
	public void insertAnteriorEthmoidalAirCellRemoval(HashMap map) throws Exception;
	public void insertPosteriorAirCellRemoval(HashMap map) throws Exception;

	public EntTotalVO getEntTotal(int no) throws Exception;
	public String getEntTsa(String id) throws Exception;
	public EntCommonVO getEntCommon(String id) throws Exception;
	public ToolsVO getTools(String id) throws Exception;
	public PathTriggerVOStr getOuterBreak(String id) throws Exception;
	public PathTriggerVOStr getSeptalFlap(String id) throws Exception;
	public BoxTriggerVO getSuperiorTurbinate(String id) throws Exception;
	public VolumeTriggerVOStr getSphenoidCellsRemoval(String id) throws Exception;
	public VolumeTriggerVOStr getTransclivalDrilling(String id) throws Exception;
	public VolumeTriggerVOStr getSellaDuramater(String id) throws Exception;
	public VolumeTriggerVOStr getTumorRemoval(String id) throws Exception;
	
	public List<EntTotalVO> list(HashMap map) throws Exception;
	public List<EntTotalVO> list_every(HashMap map) throws Exception;
	public List<PointDataVOStr> getPoints(String id) throws Exception;
	public List<PointDataVOStr> getTargetPoints(String id) throws Exception;
	public List<PointTriggerVO> getPointTriggers(String id) throws Exception;
	
	public String getEntTansclivalApproach(String id) throws Exception;
	public String getEntAcidosisMaxillarySinus(String id) throws Exception;
	public VolumeTriggerVOStr getUncinectomy(String id) throws Exception;
	
	public String getEntAcidosisFrontalSinus(String id) throws Exception;
	public VolumeTriggerVOStr getAnteriorEthmoidectomy(String id) throws Exception;
	public VolumeTriggerVOStr getAnteriorSinus(String id) throws Exception;
	
	public String getEntAcidosisEthmoidalSinus(String id) throws Exception;
	
	public VolumeTriggerVOStr getAnteriorEthmoidalAirCellRemoval(String id) throws Exception;
	public VolumeTriggerVOStr getPosteriorAirCellRemoval(String id) throws Exception;
	
	public int getEntTsaScoreRange(HashMap map) throws Exception;
	public int getEntTransclivalApproachScoreRange(HashMap map) throws Exception;
	public int getEntAcidosisMaxillarySinusScoreRange(HashMap map) throws Exception;
	public int getEntAcidosisFrontalSinusScoreRange(HashMap map) throws Exception;
	public int getEntAcidosisEthmoidalSinusScoreRange(HashMap map) throws Exception;
	
	public void updateExpertTools(HashMap map) throws Exception;
	public ExpertToolsVO getExpertTools(String oper_name) throws Exception;
	
	public String getAverTouchCount(String pid) throws Exception;
	public String getAverToolUseCount(String pid) throws Exception;
	public String getAverToolInnerCount(String pid) throws Exception;
	public String getAverToolTouchScore(String pid) throws Exception;
	public String getAverToolViewScore(String pid) throws Exception;
	public String getAverMaxScore(String pid) throws Exception;
	
	public RangeScoreVO getRngTSA() throws Exception;
	public RangeScoreVO getRngTransclivalApproach() throws Exception;
	public RangeScoreVO getRngAcidosisMaxillarySinus() throws Exception;
	public RangeScoreVO getRngAcidosisFrontalSinus() throws Exception;
	public RangeScoreVO getRngAcidosisEthmoidalSinus() throws Exception;
	
	public int getAverScoreOuterBreak() throws Exception;
	public int getAverScoreSeptalFlap() throws Exception;
	public int getAverScoreSuperiorTurbinate() throws Exception;
	public int getAverScoreSellaDuramater() throws Exception;
	public int getAverScoreTumorRemoval() throws Exception;
	public int getAverScoreSphenoidCellsRemoval() throws Exception;
	public int getAverScoreTransclivalDrilling() throws Exception;
	public int getAverScoreUncinectomy() throws Exception;
	public int getAverScoreAnteriorEthmoidalAirCellRemoval() throws Exception;
	public int getAverScorePosteriorAirCellRemoval() throws Exception;
	public int getAverAnteriorEthmoidectomy() throws Exception;
	public int getAverScoreAnteriorSinus() throws Exception;
	public int getAverSuperiorTurbinate() throws Exception;
	public int getAverUncinectomy() throws Exception;
}
