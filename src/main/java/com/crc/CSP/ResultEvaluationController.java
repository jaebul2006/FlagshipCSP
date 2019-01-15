package com.crc.CSP;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crc.CSP.bean.BoxTriggerVO;
import com.crc.CSP.bean.EntCommonVO;
import com.crc.CSP.bean.EntTotalVO;
import com.crc.CSP.bean.ExpertToolsVO;
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
import com.crc.CSP.bean.PathTriggerVOStr;
import com.crc.CSP.bean.PointDataVOStr;
import com.crc.CSP.bean.PointTriggerVO;
import com.crc.CSP.bean.RangeScoreVO;
import com.crc.CSP.bean.ToolsVO;
import com.crc.CSP.bean.VolumeTriggerVOStr;
import com.crc.CSP.service.BoardPager;
import com.crc.CSP.service.OsEvalService;
import com.crc.CSP.service.ResultEvaluationService;
import com.crc.CSP.service.TsaEvalService;


@Controller
public class ResultEvaluationController {

	private static final Logger logger = LoggerFactory.getLogger(ResultEvaluationController.class);
	@Resource(name="uploadPath")
	String uploadPath;
	
	@Inject
	private OsEvalService os_eval_service;
	
	@Inject
	private TsaEvalService tsa_eval_service;
	
	@Inject
	ResultEvaluationService evalBoardService;
	
	@RequestMapping("/ResultEvaluationHome")
	public String ResultEvaluationHome(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage) throws Exception
	{
		return "ResultEvaluationHome";
	}
	
	@RequestMapping("/ResultEvaluationHome2")
	public String ResultEvaluationHome2(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage) throws Exception
	{
		return "ResultEvaluationHome2";
	}
	
	@RequestMapping("/TSAList")
	public ModelAndView TSAList(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage,
						@RequestParam("id")String user_id, 
						@RequestParam("oper_name")String oper_name) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("TSAList");
		return mav;
	}
	
	@RequestMapping("/TransclivalApproachList")
	public ModelAndView TransclivalApproachList(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage,
						@RequestParam("id")String user_id, 
						@RequestParam("oper_name")String oper_name) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("TransclivalApproachList");
		return mav;
	}
	
	@RequestMapping("/AcidosisMaxillarySinusList")
	public ModelAndView AcidosisMaxillarySinusList(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage,
						@RequestParam("id")String user_id, 
						@RequestParam("oper_name")String oper_name) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("AcidosisMaxillarySinusList");
		return mav;
	}
	
	@RequestMapping("/AcidosisFrontalSinusList")
	public ModelAndView AcidosisFrontalSinusList(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage,
						@RequestParam("id")String user_id, 
						@RequestParam("oper_name")String oper_name) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("AcidosisFrontalSinusList");
		return mav;
	}
	
	@RequestMapping("/AcidosisEthmoidalSinusList")
	public ModelAndView AcidosisEthmoidalSinusList(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage,
						@RequestParam("id")String user_id, 
						@RequestParam("oper_name")String oper_name) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("AcidosisEthmoidalSinusList");
		return mav;
	}
	
	/*
	@RequestMapping("/ResultEvaluationTSA")
	public ModelAndView ResultEvaluationTSA(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage, @RequestParam("id")String user_id) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ResultEvaluationTSA");
		return mav;
	}
	
	
	@RequestMapping("/ResultEvaluationTSA")
	public ModelAndView ResultEvaluationTSA(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage, @RequestParam("id")String user_id) throws Exception
	{
		String content_type = "ENTSurgery";
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		List<EntTotalVO> list = tsa_eval_service.list(param_map);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("content_type", content_type);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ResultEvaluationTSA");
		return mav;
	}
	*/
	
	// 2019.01.04
	@RequestMapping(value="/ViewTSA_OuterBreak", method=RequestMethod.GET)
	public ModelAndView ViewTSA_OuterBreak(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		PathTriggerVOStr ent_tsa_outerbreak = tsa_eval_service.getOuterBreak(ent_tsa_id); // 부모의 id로 자신의 id를 찾아냄
		String outer_break_id = ent_tsa_outerbreak.getID();
		ToolsVO ent_tsa_outerbreak_tools_vo = tsa_eval_service.getTools(outer_break_id);
		List<PointDataVOStr> ent_tsa_outerbreak_points = tsa_eval_service.getPoints(outer_break_id);
		List<PointDataVOStr> ent_tsa_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outer_break_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
		
		map.put("ent_tsa_outerbreak_MaxScore", ent_tsa_outerbreak.getMaxScore());
		map.put("ent_tsa_outerbreak_Score", ent_tsa_outerbreak.getScore());
		map.put("ent_tsa_outerbreak_Note", ent_tsa_outerbreak.getNote());
		map.put("ent_tsa_outerbreak_Position", ent_tsa_outerbreak.getPosition());
		map.put("ent_tsa_outerbreak_Rotation", ent_tsa_outerbreak.getRotation());
		map.put("ent_tsa_outerbreak_Scale", ent_tsa_outerbreak.getScale());
		
		map.put("ent_tsa_outerbreak_Tools_TouchCount", ent_tsa_outerbreak_tools_vo.getTouchCount());
		map.put("ent_tsa_outerbreak_Tools_ToolUseCount", ent_tsa_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_tsa_outerbreak_Tools_ToolInnerCount", ent_tsa_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_tsa_outerbreak_Tools_ToolTouchScore", ent_tsa_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_tsa_outerbreak_Tools_ToolViewScore", ent_tsa_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_tsa_outerbreak_Tools_MaxScore", ent_tsa_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_tsa_outerbreak_points", ent_tsa_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_tsa_outerbreak_target_points", ent_tsa_outerbreak_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("tsa");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(outer_break_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(outer_break_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(outer_break_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(outer_break_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(outer_break_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(outer_break_id));
		
		// tsa 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// tsa 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(ent_tsa_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		VolumeTriggerVOStr sella_duramater_vo = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		map.put("sc_sella_duramater", sella_duramater_vo.getScore());
		VolumeTriggerVOStr tumor_removal_vo = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		map.put("sc_tumor_removal", tumor_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		map.put("aver_sc_tumor_removal", aver_tumor_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA_OuterBreak");
		return mav;
	}
	
	@RequestMapping(value="/ViewTSA_SeptalFlap", method=RequestMethod.GET)
	public ModelAndView ViewTSA_SeptalFlap(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		PathTriggerVOStr ent_tsa_septal_flap = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		String septal_flap_id = ent_tsa_septal_flap.getID();
		ToolsVO ent_tsa_septal_flap_tools_vo = tsa_eval_service.getTools(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_points = tsa_eval_service.getPoints(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_targetpoints = tsa_eval_service.getTargetPoints(septal_flap_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
		map.put("ent_tsa_septalflap_MaxScore", ent_tsa_septal_flap.getMaxScore());
		map.put("ent_tsa_septalflap_Score", ent_tsa_septal_flap.getScore());
		map.put("ent_tsa_septalflap_Note", ent_tsa_septal_flap.getNote());
		map.put("ent_tsa_septalflap_Position", ent_tsa_septal_flap.getPosition());
		map.put("ent_tsa_septalflap_Rotation", ent_tsa_septal_flap.getRotation());
		map.put("ent_tsa_septalflap_Scale", ent_tsa_septal_flap.getScale());
		
		map.put("ent_tsa_septalflap_Tools_TouchCount", ent_tsa_septal_flap_tools_vo.getTouchCount());
		map.put("ent_tsa_septalflap_Tools_ToolUseCount", ent_tsa_septal_flap_tools_vo.getToolUseCount());
		map.put("ent_tsa_septalflap_Tools_ToolInnerCount", ent_tsa_septal_flap_tools_vo.getToolInnerCount());
		map.put("ent_tsa_septalflap_Tools_ToolTouchScore", ent_tsa_septal_flap_tools_vo.getToolTouchScore());
		map.put("ent_tsa_septalflap_Tools_ToolViewScore", ent_tsa_septal_flap_tools_vo.getToolViewScore());
		map.put("ent_tsa_septalflap_Tools_MaxScore", ent_tsa_septal_flap_tools_vo.getMaxScore());
		
		map.put("ent_tsa_septalflap_points", ent_tsa_septal_flap_points); // jsp 에서 list 로 받아야함
		map.put("ent_tsa_septalflap_target_points", ent_tsa_septal_flap_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("tsa");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("septal_flap");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(septal_flap_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(septal_flap_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(septal_flap_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(septal_flap_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(septal_flap_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(septal_flap_id));
		
		// tsa 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// tsa 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(ent_tsa_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		VolumeTriggerVOStr sella_duramater_vo = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		map.put("sc_sella_duramater", sella_duramater_vo.getScore());
		VolumeTriggerVOStr tumor_removal_vo = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		map.put("sc_tumor_removal", tumor_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		map.put("aver_sc_tumor_removal", aver_tumor_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA_SeptalFlap");
		return mav;
	}
	
	@RequestMapping(value="/ViewTSA_SuperiorTurbinate", method=RequestMethod.GET)
	public ModelAndView ViewTSA_SuperiorTurbinate(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		BoxTriggerVO ent_tsa_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		String ent_tsa_superior_turbinate_id = ent_tsa_superior_turbinate.getID();
		ToolsVO ent_tsa_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_tsa_superior_turbinate_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
			
		map.put("ent_tsa_superior_turbinate_MaxScore", ent_tsa_superior_turbinate.getMaxScore());
		map.put("ent_tsa_superior_turbinate_Score", ent_tsa_superior_turbinate.getScore());
		map.put("ent_tsa_superior_turbinate_Note", ent_tsa_superior_turbinate.getNote());
		map.put("ent_tsa_superior_turbinate_InnerTriggerCount", ent_tsa_superior_turbinate.getInnerTriggerCount());
		map.put("ent_tsa_superior_turbinate_OuterTriggerCount", ent_tsa_superior_turbinate.getOuterTriggerCount());
		map.put("ent_tsa_superior_turbinate_InnerTriggerTouchCount", ent_tsa_superior_turbinate.getInnerTriggerTouchCount());
		map.put("ent_tsa_superior_turbinate_OuterTriggerTouchCount", ent_tsa_superior_turbinate.getOuterTriggerTouchCount());
		
		map.put("ent_tsa_superior_turbinate_Tools_TouchCount", ent_tsa_superior_turbinate_tools_vo.getTouchCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolUseCount", ent_tsa_superior_turbinate_tools_vo.getToolUseCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolInnerCount", ent_tsa_superior_turbinate_tools_vo.getToolInnerCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolTouchScore", ent_tsa_superior_turbinate_tools_vo.getToolTouchScore());
		map.put("ent_tsa_superior_turbinate_Tools_ToolViewScore", ent_tsa_superior_turbinate_tools_vo.getToolViewScore());
		map.put("ent_tsa_superior_turbinate_Tools_MaxScore", ent_tsa_superior_turbinate_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("tsa");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("superior_turbinate");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_superior_turbinate_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_superior_turbinate_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_superior_turbinate_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_superior_turbinate_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_superior_turbinate_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_superior_turbinate_id));
		
		// tsa 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// tsa 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(ent_tsa_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		VolumeTriggerVOStr sella_duramater_vo = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		map.put("sc_sella_duramater", sella_duramater_vo.getScore());
		VolumeTriggerVOStr tumor_removal_vo = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		map.put("sc_tumor_removal", tumor_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		map.put("aver_sc_tumor_removal", aver_tumor_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA_SuperiorTurbinate");
		return mav;
	}
	
	@RequestMapping(value="/ViewTSA_SellaDuramater", method=RequestMethod.GET)
	public ModelAndView ViewTSA_SellaDuramater(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		VolumeTriggerVOStr ent_tsa_sella_duramater = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		String ent_tsa_sella_duramater_id = ent_tsa_sella_duramater.getID();
		ToolsVO ent_tsa_sella_duramater_tools_vo = tsa_eval_service.getTools(ent_tsa_sella_duramater_id);
		List<PointTriggerVO> ent_tsa_sella_duramater_points = tsa_eval_service.getPointTriggers(ent_tsa_sella_duramater_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
			
		map.put("ent_tsa_sella_duramater_MaxScore", ent_tsa_sella_duramater.getMaxScore());
		map.put("ent_tsa_sella_duramater_Score", ent_tsa_sella_duramater.getScore());
		map.put("ent_tsa_sella_duramater_Note", ent_tsa_sella_duramater.getNote());
		map.put("ent_tsa_sella_duramater_points", ent_tsa_sella_duramater.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_tsa_sella_duramater_Position", ent_tsa_sella_duramater.getPosition());
		map.put("ent_tsa_sella_duramater_Rotation", ent_tsa_sella_duramater.getRotation());
		map.put("ent_tsa_sella_duramater_Localcale", ent_tsa_sella_duramater.getLocalcale());
		map.put("ent_tsa_sella_duramater_PinCount", ent_tsa_sella_duramater.getPinCount());
		map.put("ent_tsa_sella_duramater_Pins", ent_tsa_sella_duramater.getPins());
		map.put("ent_tsa_sella_duramater_TargetPins", ent_tsa_sella_duramater.getTargetPins());
		
		map.put("ent_tsa_sella_duramater_Tools_TouchCount", ent_tsa_sella_duramater_tools_vo.getTouchCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolUseCount", ent_tsa_sella_duramater_tools_vo.getToolUseCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolInnerCount", ent_tsa_sella_duramater_tools_vo.getToolInnerCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolTouchScore", ent_tsa_sella_duramater_tools_vo.getToolTouchScore());
		map.put("ent_tsa_sella_duramater_Tools_ToolViewScore", ent_tsa_sella_duramater_tools_vo.getToolViewScore());
		map.put("ent_tsa_sella_duramater_Tools_MaxScore", ent_tsa_sella_duramater_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("tsa");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("sella_duramater");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_sella_duramater_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_sella_duramater_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_sella_duramater_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_sella_duramater_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_sella_duramater_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_sella_duramater_id));
		
		// tsa 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// tsa 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(ent_tsa_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		VolumeTriggerVOStr sella_duramater_vo = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		map.put("sc_sella_duramater", sella_duramater_vo.getScore());
		VolumeTriggerVOStr tumor_removal_vo = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		map.put("sc_tumor_removal", tumor_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		map.put("aver_sc_tumor_removal", aver_tumor_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA_SellaDuramater");
		return mav;
	}
	
	@RequestMapping(value="/ViewTSA_TumorRemoval", method=RequestMethod.GET)
	public ModelAndView ViewTSA_TumorRemoval(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		VolumeTriggerVOStr ent_tsa_tumor_removal = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		String ent_tsa_tumor_removal_id = ent_tsa_tumor_removal.getID();
		ToolsVO ent_tsa_tumor_removal_tools_vo = tsa_eval_service.getTools(ent_tsa_tumor_removal_id);
		List<PointTriggerVO> ent_tsa_tumor_removal_points = tsa_eval_service.getPointTriggers(ent_tsa_tumor_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
			
		map.put("ent_tsa_tumor_removal_MaxScore", ent_tsa_tumor_removal.getMaxScore());
		map.put("ent_tsa_tumor_removal_Score", ent_tsa_tumor_removal.getScore());
		map.put("ent_tsa_tumor_removal_Note", ent_tsa_tumor_removal.getNote());
		map.put("ent_tsa_tumor_removal_points", ent_tsa_tumor_removal.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_tsa_tumor_removal_Position", ent_tsa_tumor_removal.getPosition());
		map.put("ent_tsa_tumor_removal_Rotation", ent_tsa_tumor_removal.getRotation());
		map.put("ent_tsa_tumor_removal_Localcale", ent_tsa_tumor_removal.getLocalcale());
		map.put("ent_tsa_tumor_removal_PinCount", ent_tsa_tumor_removal.getPinCount());
		map.put("ent_tsa_tumor_removal_Pins", ent_tsa_tumor_removal.getPins());
		map.put("ent_tsa_tumor_removal_TargetPins", ent_tsa_tumor_removal.getTargetPins());
		
		map.put("ent_tsa_tumor_removal_Tools_TouchCount", ent_tsa_tumor_removal_tools_vo.getTouchCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolUseCount", ent_tsa_tumor_removal_tools_vo.getToolUseCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolInnerCount", ent_tsa_tumor_removal_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolTouchScore", ent_tsa_tumor_removal_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tumor_removal_Tools_ToolViewScore", ent_tsa_tumor_removal_tools_vo.getToolViewScore());
		map.put("ent_tsa_tumor_removal_Tools_MaxScore", ent_tsa_tumor_removal_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("tsa");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("tumor_removal");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(ent_tsa_tumor_removal_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(ent_tsa_tumor_removal_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(ent_tsa_tumor_removal_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(ent_tsa_tumor_removal_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(ent_tsa_tumor_removal_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(ent_tsa_tumor_removal_id));
		
		// tsa 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// tsa 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(ent_tsa_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		VolumeTriggerVOStr sella_duramater_vo = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		map.put("sc_sella_duramater", sella_duramater_vo.getScore());
		VolumeTriggerVOStr tumor_removal_vo = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		map.put("sc_tumor_removal", tumor_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		map.put("aver_sc_tumor_removal", aver_tumor_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA_TumorRemoval");
		return mav;
	}
	
	@RequestMapping(value="/ViewTransclivalApproach_OuterBreak", method=RequestMethod.GET)
	public ModelAndView ViewTransclivalApproach_OuterBreak(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(transclival_approach_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(transclival_approach_id); 
		
		PathTriggerVOStr outerbreak = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		String outerbreak_id = outerbreak.getID();
		ToolsVO outerbreak_tools_vo = tsa_eval_service.getTools(outerbreak_id);
		List<PointDataVOStr> outerbreak_points = tsa_eval_service.getPoints(outerbreak_id);
		List<PointDataVOStr> outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outerbreak_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
		
		map.put("outerbreak_MaxScore", outerbreak.getMaxScore());
		map.put("outerbreak_Score", outerbreak.getScore());
		map.put("outerbreak_Note", outerbreak.getNote());
		map.put("outerbreak_Position", outerbreak.getPosition());
		map.put("outerbreak_Rotation", outerbreak.getRotation());
		map.put("outerbreak_Scale", outerbreak.getScale());
		
		map.put("outerbreak_Tools_TouchCount", outerbreak_tools_vo.getTouchCount());
		map.put("outerbreak_Tools_ToolUseCount", outerbreak_tools_vo.getToolUseCount());
		map.put("outerbreak_Tools_ToolInnerCount", outerbreak_tools_vo.getToolInnerCount());
		map.put("outerbreak_Tools_ToolTouchScore", outerbreak_tools_vo.getToolTouchScore());
		map.put("outerbreak_Tools_ToolViewScore", outerbreak_tools_vo.getToolViewScore());
		map.put("outerbreak_Tools_MaxScore", outerbreak_tools_vo.getMaxScore());
		
		map.put("outerbreak_points", outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("outerbreak_target_points", outerbreak_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(transclival_approach_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(transclival_approach_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(transclival_approach_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(transclival_approach_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(transclival_approach_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(transclival_approach_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(outerbreak_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(outerbreak_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(outerbreak_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(outerbreak_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(outerbreak_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(outerbreak_id));
		
		// transclival approach 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTransclivalApproach_OuterBreak");
		return mav;
	}
	
	@RequestMapping(value="/ViewTransclivalApproach_SeptalFlap", method=RequestMethod.GET)
	public ModelAndView ViewTransclivalApproach_SeptalFlap(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(transclival_approach_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(transclival_approach_id); 
		PathTriggerVOStr septal_flap = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		String septal_flap_id = septal_flap.getID();
		ToolsVO septal_flap_tools_vo = tsa_eval_service.getTools(septal_flap_id);
		List<PointDataVOStr> septal_flap_points = tsa_eval_service.getPoints(septal_flap_id);
		List<PointDataVOStr> septal_flap_targetpoints = tsa_eval_service.getTargetPoints(septal_flap_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
		
		map.put("septalflap_MaxScore", septal_flap.getMaxScore());
		map.put("septalflap_Score", septal_flap.getScore());
		map.put("septalflap_Note", septal_flap.getNote());
		map.put("septalflap_Position", septal_flap.getPosition());
		map.put("septalflap_Rotation", septal_flap.getRotation());
		map.put("septalflap_Scale", septal_flap.getScale());

		map.put("septalflap_Tools_TouchCount", septal_flap_tools_vo.getTouchCount());
		map.put("septalflap_Tools_ToolUseCount", septal_flap_tools_vo.getToolUseCount());
		map.put("septalflap_Tools_ToolInnerCount", septal_flap_tools_vo.getToolInnerCount());
		map.put("septalflap_Tools_ToolTouchScore", septal_flap_tools_vo.getToolTouchScore());
		map.put("septalflap_Tools_ToolViewScore", septal_flap_tools_vo.getToolViewScore());
		map.put("septalflap_Tools_MaxScore", septal_flap_tools_vo.getMaxScore());
		
		map.put("septalflap_points", septal_flap_points); // jsp 에서 list 로 받아야함
		map.put("septalflap_target_points", septal_flap_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("septal_flap");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(transclival_approach_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(transclival_approach_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(transclival_approach_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(transclival_approach_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(transclival_approach_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(transclival_approach_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(septal_flap_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(septal_flap_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(septal_flap_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(septal_flap_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(septal_flap_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(septal_flap_id));
		
		// transclival approach 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTransclivalApproach_SeptalFlap");
		return mav;
	}
	
	@RequestMapping(value="/ViewTransclivalApproach_SphenoidCellsRemoval", method=RequestMethod.GET)
	public ModelAndView ViewTransclivalApproach_SphenoidCellsRemoval(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(transclival_approach_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(transclival_approach_id); 
		VolumeTriggerVOStr sphenoid_cells_removal = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		String sphenoid_cells_removal_id = sphenoid_cells_removal.getID();
		ToolsVO sphenoid_cells_removal_tools_vo = tsa_eval_service.getTools(sphenoid_cells_removal_id);
		List<PointTriggerVO> sphenoid_cells_removal_points = tsa_eval_service.getPointTriggers(sphenoid_cells_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("sphenoid_cells_removal_MaxScore", sphenoid_cells_removal.getMaxScore());
		map.put("sphenoid_cells_removal_Score", sphenoid_cells_removal.getScore());
		map.put("sphenoid_cells_removal_Note", sphenoid_cells_removal.getNote());
		map.put("sphenoid_cells_removal_points", sphenoid_cells_removal.getPoints()); 
		map.put("sphenoid_cells_removal_Position", sphenoid_cells_removal.getPosition());
		map.put("sphenoid_cells_removal_Rotation", sphenoid_cells_removal.getRotation());
		map.put("sphenoid_cells_removal_Localcale", sphenoid_cells_removal.getLocalcale());
		map.put("sphenoid_cells_removal_PinCount", sphenoid_cells_removal.getPinCount());
		map.put("sphenoid_cells_removal_Pins", sphenoid_cells_removal.getPins());
		map.put("sphenoid_cells_removal_TargetPins", sphenoid_cells_removal.getTargetPins());
		
		map.put("sphenoid_cells_removal_Tools_TouchCount", sphenoid_cells_removal_tools_vo.getTouchCount());
		map.put("sphenoid_cells_removal_Tools_ToolUseCount", sphenoid_cells_removal_tools_vo.getToolUseCount());
		map.put("sphenoid_cells_removal_Tools_ToolInnerCount", sphenoid_cells_removal_tools_vo.getToolInnerCount());
		map.put("sphenoid_cells_removal_Tools_ToolTouchScore", sphenoid_cells_removal_tools_vo.getToolTouchScore());
		map.put("sphenoid_cells_removal_Tools_ToolViewScore", sphenoid_cells_removal_tools_vo.getToolViewScore());
		map.put("sphenoid_cells_removal_Tools_MaxScore", sphenoid_cells_removal_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("sphenoid_cells_removal");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(transclival_approach_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(transclival_approach_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(transclival_approach_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(transclival_approach_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(transclival_approach_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(transclival_approach_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(sphenoid_cells_removal_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(sphenoid_cells_removal_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(sphenoid_cells_removal_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(sphenoid_cells_removal_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(sphenoid_cells_removal_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(sphenoid_cells_removal_id));
		
		// transclival approach 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTransclivalApproach_SphenoidCellsRemoval");
		return mav;
	}
	
	@RequestMapping(value="/ViewTransclivalApproach_TransclivalDrilling", method=RequestMethod.GET)
	public ModelAndView ViewTransclivalApproach_TransclivalDrilling(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(transclival_approach_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(transclival_approach_id); 
		VolumeTriggerVOStr transclival_drilling = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		String transclival_drilling_id = transclival_drilling.getID();
		ToolsVO transclival_drilling_tools_vo = tsa_eval_service.getTools(transclival_drilling_id);
		List<PointTriggerVO> transclival_drilling_points = tsa_eval_service.getPointTriggers(transclival_drilling_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("transclival_drilling_MaxScore", transclival_drilling.getMaxScore());
		map.put("transclival_drilling_Score", transclival_drilling.getScore());
		map.put("transclival_drilling_Note", transclival_drilling.getNote());
		map.put("transclival_drilling_points", transclival_drilling.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("transclival_drilling_Position", transclival_drilling.getPosition());
		map.put("transclival_drilling_Rotation", transclival_drilling.getRotation());
		map.put("transclival_drilling_Localcale", transclival_drilling.getLocalcale());
		map.put("transclival_drilling_PinCount", transclival_drilling.getPinCount());
		map.put("transclival_drilling_Pins", transclival_drilling.getPins());
		map.put("transclival_drilling_TargetPins", transclival_drilling.getTargetPins());
		
		map.put("transclival_drilling_Tools_TouchCount", transclival_drilling_tools_vo.getTouchCount());
		map.put("transclival_drilling_Tools_ToolUseCount", transclival_drilling_tools_vo.getToolUseCount());
		map.put("transclival_drilling_Tools_ToolInnerCount", transclival_drilling_tools_vo.getToolInnerCount());
		map.put("transclival_drilling_Tools_ToolTouchScore", transclival_drilling_tools_vo.getToolTouchScore());
		map.put("transclival_drilling_Tools_ToolViewScore", transclival_drilling_tools_vo.getToolViewScore());
		map.put("transclival_drilling_Tools_MaxScore", transclival_drilling_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_drilling");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(transclival_approach_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(transclival_approach_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(transclival_approach_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(transclival_approach_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(transclival_approach_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(transclival_approach_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(transclival_drilling_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(transclival_drilling_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(transclival_drilling_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(transclival_drilling_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(transclival_drilling_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(transclival_drilling_id));
		
		// transclival approach 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTransclivalApproach_TransclivalDrilling");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisMaxillarySinus_OuterBreak", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisMaxillarySinus_OuterBreak(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_maxillary_sinus_id = tsa_eval_service.getEntAcidosisMaxillarySinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_maxillary_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_maxillary_sinus_id); 
		
		PathTriggerVOStr outerbreak = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		String outerbreak_id = outerbreak.getID();
		ToolsVO outerbreak_tools_vo = tsa_eval_service.getTools(outerbreak_id);
		List<PointDataVOStr> outerbreak_points = tsa_eval_service.getPoints(outerbreak_id);
		List<PointDataVOStr> outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outerbreak_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
		
		map.put("outerbreak_MaxScore", outerbreak.getMaxScore());
		map.put("outerbreak_Score", outerbreak.getScore());
		map.put("outerbreak_Note", outerbreak.getNote());
		map.put("outerbreak_Position", outerbreak.getPosition());
		map.put("outerbreak_Rotation", outerbreak.getRotation());
		map.put("outerbreak_Scale", outerbreak.getScale());
		
		map.put("outerbreak_Tools_TouchCount", outerbreak_tools_vo.getTouchCount());
		map.put("outerbreak_Tools_ToolUseCount", outerbreak_tools_vo.getToolUseCount());
		map.put("outerbreak_Tools_ToolInnerCount", outerbreak_tools_vo.getToolInnerCount());
		map.put("outerbreak_Tools_ToolTouchScore", outerbreak_tools_vo.getToolTouchScore());
		map.put("outerbreak_Tools_ToolViewScore", outerbreak_tools_vo.getToolViewScore());
		map.put("outerbreak_Tools_MaxScore", outerbreak_tools_vo.getMaxScore());
		
		map.put("outerbreak_points", outerbreak_points); 
		map.put("outerbreak_target_points", outerbreak_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_maxillary_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_maxillary_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(outerbreak_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(outerbreak_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(outerbreak_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(outerbreak_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(outerbreak_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(outerbreak_id));
		
		// acidosis_maxillary_sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisMaxillarySinus_OuterBreak");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisMaxillarySinus_Uncinectomy", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisMaxillarySinus_Uncinectomy(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_maxillary_sinus_id = tsa_eval_service.getEntAcidosisMaxillarySinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_maxillary_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_maxillary_sinus_id); 
		VolumeTriggerVOStr uncinectomy = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		String uncinectomy_id = uncinectomy.getID();
		ToolsVO uncinectomy_tools_vo = tsa_eval_service.getTools(uncinectomy_id);
		List<PointTriggerVO> uncinectomy_points = tsa_eval_service.getPointTriggers(uncinectomy_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("uncinectomy_MaxScore", uncinectomy.getMaxScore());
		map.put("uncinectomy_Score", uncinectomy.getScore());
		map.put("uncinectomy_Note", uncinectomy.getNote());
		map.put("uncinectomy_points", uncinectomy.getPoints()); 
		map.put("uncinectomy_Position", uncinectomy.getPosition());
		map.put("uncinectomy_Rotation", uncinectomy.getRotation());
		map.put("uncinectomy_Localcale", uncinectomy.getLocalcale());
		map.put("uncinectomy_PinCount", uncinectomy.getPinCount());
		map.put("uncinectomy_Pins", uncinectomy.getPins());
		map.put("uncinectomy_TargetPins", uncinectomy.getTargetPins());
		
		map.put("uncinectomy_Tools_TouchCount", uncinectomy_tools_vo.getTouchCount());
		map.put("uncinectomy_Tools_ToolUseCount", uncinectomy_tools_vo.getToolUseCount());
		map.put("uncinectomy_Tools_ToolInnerCount", uncinectomy_tools_vo.getToolInnerCount());
		map.put("uncinectomy_Tools_ToolTouchScore", uncinectomy_tools_vo.getToolTouchScore());
		map.put("uncinectomy_Tools_ToolViewScore", uncinectomy_tools_vo.getToolViewScore());
		map.put("uncinectomy_Tools_MaxScore", uncinectomy_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_maxillary_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_maxillary_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(uncinectomy_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(uncinectomy_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(uncinectomy_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(uncinectomy_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(uncinectomy_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(uncinectomy_id));
		
		// acidosis_maxillary_sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisMaxillarySinus_Uncinectomy");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisMaxillarySinus_SuperiorTurbinate", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisMaxillarySinus_SuperiorTurbinate(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_maxillary_sinus_id = tsa_eval_service.getEntAcidosisMaxillarySinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_maxillary_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_maxillary_sinus_id);
		BoxTriggerVO superior_turbinate = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		String superior_turbinate_id = superior_turbinate.getID();
		ToolsVO superior_turbinate_tools_vo = tsa_eval_service.getTools(superior_turbinate_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("superior_turbinate_MaxScore", superior_turbinate.getMaxScore());
		map.put("superior_turbinate_Score", superior_turbinate.getScore());
		map.put("superior_turbinate_Note", superior_turbinate.getNote());
		map.put("superior_turbinate_InnerTriggerCount", superior_turbinate.getInnerTriggerCount());
		map.put("superior_turbinate_OuterTriggerCount", superior_turbinate.getOuterTriggerCount());
		map.put("superior_turbinate_InnerTriggerTouchCount", superior_turbinate.getInnerTriggerTouchCount());
		map.put("superior_turbinate_OuterTriggerTouchCount", superior_turbinate.getOuterTriggerTouchCount());
		
		map.put("superior_turbinate_Tools_TouchCount", superior_turbinate_tools_vo.getTouchCount());
		map.put("superior_turbinate_Tools_ToolUseCount", superior_turbinate_tools_vo.getToolUseCount());
		map.put("superior_turbinate_Tools_ToolInnerCount", superior_turbinate_tools_vo.getToolInnerCount());
		map.put("superior_turbinate_Tools_ToolTouchScore", superior_turbinate_tools_vo.getToolTouchScore());
		map.put("superior_turbinate_Tools_ToolViewScore", superior_turbinate_tools_vo.getToolViewScore());
		map.put("superior_turbinate_Tools_MaxScore", superior_turbinate_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_maxillary_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("superior_turbinate");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_maxillary_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_maxillary_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_maxillary_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(superior_turbinate_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(superior_turbinate_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(superior_turbinate_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(superior_turbinate_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(superior_turbinate_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(superior_turbinate_id));
		
		// acidosis_maxillary_sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisMaxillarySinus_SuperiorTurbinate");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisFrontalSinus_OuterBreak", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisFrontalSinus_OuterBreak(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_frontal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_frontal_sinus_id); 
		
		PathTriggerVOStr outerbreak = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		String outerbreak_id = outerbreak.getID();
		ToolsVO outerbreak_tools_vo = tsa_eval_service.getTools(outerbreak_id);
		List<PointDataVOStr> outerbreak_points = tsa_eval_service.getPoints(outerbreak_id);
		List<PointDataVOStr> outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outerbreak_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
		
		map.put("outerbreak_MaxScore", outerbreak.getMaxScore());
		map.put("outerbreak_Score", outerbreak.getScore());
		map.put("outerbreak_Note", outerbreak.getNote());
		map.put("outerbreak_Position", outerbreak.getPosition());
		map.put("outerbreak_Rotation", outerbreak.getRotation());
		map.put("outerbreak_Scale", outerbreak.getScale());
		
		map.put("outerbreak_Tools_TouchCount", outerbreak_tools_vo.getTouchCount());
		map.put("outerbreak_Tools_ToolUseCount", outerbreak_tools_vo.getToolUseCount());
		map.put("outerbreak_Tools_ToolInnerCount", outerbreak_tools_vo.getToolInnerCount());
		map.put("outerbreak_Tools_ToolTouchScore", outerbreak_tools_vo.getToolTouchScore());
		map.put("outerbreak_Tools_ToolViewScore", outerbreak_tools_vo.getToolViewScore());
		map.put("outerbreak_Tools_MaxScore", outerbreak_tools_vo.getMaxScore());
		
		map.put("outerbreak_points", outerbreak_points); 
		map.put("outerbreak_target_points", outerbreak_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_frontal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(outerbreak_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(outerbreak_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(outerbreak_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(outerbreak_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(outerbreak_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(outerbreak_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisFrontalSinus_OuterBreak");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisFrontalSinus_Uncinectomy", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisFrontalSinus_Uncinectomy(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_frontal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_frontal_sinus_id); 
		VolumeTriggerVOStr uncinectomy = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		String uncinectomy_id = uncinectomy.getID();
		ToolsVO uncinectomy_tools_vo = tsa_eval_service.getTools(uncinectomy_id);
		List<PointTriggerVO> uncinectomy_points = tsa_eval_service.getPointTriggers(uncinectomy_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("uncinectomy_MaxScore", uncinectomy.getMaxScore());
		map.put("uncinectomy_Score", uncinectomy.getScore());
		map.put("uncinectomy_Note", uncinectomy.getNote());
		map.put("uncinectomy_points", uncinectomy.getPoints()); 
		map.put("uncinectomy_Position", uncinectomy.getPosition());
		map.put("uncinectomy_Rotation", uncinectomy.getRotation());
		map.put("uncinectomy_Localcale", uncinectomy.getLocalcale());
		map.put("uncinectomy_PinCount", uncinectomy.getPinCount());
		map.put("uncinectomy_Pins", uncinectomy.getPins());
		map.put("uncinectomy_TargetPins", uncinectomy.getTargetPins());
		
		map.put("uncinectomy_Tools_TouchCount", uncinectomy_tools_vo.getTouchCount());
		map.put("uncinectomy_Tools_ToolUseCount", uncinectomy_tools_vo.getToolUseCount());
		map.put("uncinectomy_Tools_ToolInnerCount", uncinectomy_tools_vo.getToolInnerCount());
		map.put("uncinectomy_Tools_ToolTouchScore", uncinectomy_tools_vo.getToolTouchScore());
		map.put("uncinectomy_Tools_ToolViewScore", uncinectomy_tools_vo.getToolViewScore());
		map.put("uncinectomy_Tools_MaxScore", uncinectomy_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_frontal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(uncinectomy_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(uncinectomy_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(uncinectomy_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(uncinectomy_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(uncinectomy_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(uncinectomy_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisFrontalSinus_Uncinectomy");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisFrontalSinus_AnteriorEthmoidectomy", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisFrontalSinus_AnteriorEthmoidectomy(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_frontal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_frontal_sinus_id); 
		VolumeTriggerVOStr anterior_ethmoidectomy = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		String anterior_ethmoidectomy_id = anterior_ethmoidectomy.getID();
		ToolsVO anterior_ethmoidectomy_tools_vo = tsa_eval_service.getTools(anterior_ethmoidectomy_id);
		List<PointTriggerVO> anterior_ethmoidectomy_points = tsa_eval_service.getPointTriggers(anterior_ethmoidectomy_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("anterior_ethmoidectomy_MaxScore", anterior_ethmoidectomy.getMaxScore());
		map.put("anterior_ethmoidectomy_Score", anterior_ethmoidectomy.getScore());
		map.put("anterior_ethmoidectomy_Note", anterior_ethmoidectomy.getNote());
		map.put("anterior_ethmoidectomy_points", anterior_ethmoidectomy.getPoints()); 
		map.put("anterior_ethmoidectomy_Position", anterior_ethmoidectomy.getPosition());
		map.put("anterior_ethmoidectomy_Rotation", anterior_ethmoidectomy.getRotation());
		map.put("anterior_ethmoidectomy_Localcale", anterior_ethmoidectomy.getLocalcale());
		map.put("anterior_ethmoidectomy_PinCount", anterior_ethmoidectomy.getPinCount());
		map.put("anterior_ethmoidectomy_Pins", anterior_ethmoidectomy.getPins());
		map.put("anterior_ethmoidectomy_TargetPins", anterior_ethmoidectomy.getTargetPins());
		
		map.put("anterior_ethmoidectomy_Tools_TouchCount", anterior_ethmoidectomy_tools_vo.getTouchCount());
		map.put("anterior_ethmoidectomy_Tools_ToolUseCount", anterior_ethmoidectomy_tools_vo.getToolUseCount());
		map.put("anterior_ethmoidectomy_Tools_ToolInnerCount", anterior_ethmoidectomy_tools_vo.getToolInnerCount());
		map.put("anterior_ethmoidectomy_Tools_ToolTouchScore", anterior_ethmoidectomy_tools_vo.getToolTouchScore());
		map.put("anterior_ethmoidectomy_Tools_ToolViewScore", anterior_ethmoidectomy_tools_vo.getToolViewScore());
		map.put("anterior_ethmoidectomy_Tools_MaxScore", anterior_ethmoidectomy_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_ethmoidectomy");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_frontal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(anterior_ethmoidectomy_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(anterior_ethmoidectomy_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(anterior_ethmoidectomy_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(anterior_ethmoidectomy_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(anterior_ethmoidectomy_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(anterior_ethmoidectomy_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisFrontalSinus_AnteriorEthmoidectomy");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisFrontalSinus_AnteriorSinus", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisFrontalSinus_AnteriorSinus(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_frontal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_frontal_sinus_id); 
		VolumeTriggerVOStr anterior_sinus = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		String anterior_sinus_id = anterior_sinus.getID();
		ToolsVO anterior_sinus_tools_vo = tsa_eval_service.getTools(anterior_sinus_id);
		List<PointTriggerVO> anterior_sinus_points = tsa_eval_service.getPointTriggers(anterior_sinus_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("anterior_sinus_MaxScore", anterior_sinus.getMaxScore());
		map.put("anterior_sinus_Score", anterior_sinus.getScore());
		map.put("anterior_sinus_Note", anterior_sinus.getNote());
		map.put("anterior_sinus_points", anterior_sinus.getPoints()); 
		map.put("anterior_sinus_Position", anterior_sinus.getPosition());
		map.put("anterior_sinus_Rotation", anterior_sinus.getRotation());
		map.put("anterior_sinus_Localcale", anterior_sinus.getLocalcale());
		map.put("anterior_sinus_PinCount", anterior_sinus.getPinCount());
		map.put("anterior_sinus_Pins", anterior_sinus.getPins());
		map.put("anterior_sinus_TargetPins", anterior_sinus.getTargetPins());
		
		map.put("anterior_sinus_Tools_TouchCount", anterior_sinus_tools_vo.getTouchCount());
		map.put("anterior_sinus_Tools_ToolUseCount", anterior_sinus_tools_vo.getToolUseCount());
		map.put("anterior_sinus_Tools_ToolInnerCount", anterior_sinus_tools_vo.getToolInnerCount());
		map.put("anterior_sinus_Tools_ToolTouchScore", anterior_sinus_tools_vo.getToolTouchScore());
		map.put("anterior_sinus_Tools_ToolViewScore", anterior_sinus_tools_vo.getToolViewScore());
		map.put("anterior_sinus_Tools_MaxScore", anterior_sinus_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_sinus");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_frontal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_frontal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_frontal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(anterior_sinus_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(anterior_sinus_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(anterior_sinus_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(anterior_sinus_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(anterior_sinus_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(anterior_sinus_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisFrontalSinus_AnteriorSinus");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisEthmoidalSinus_OuterBreak", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisEthmoidalSinus_OuterBreak(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_ethmoidal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_ethmoidal_sinus_id); 
		
		PathTriggerVOStr outerbreak = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		String outerbreak_id = outerbreak.getID();
		ToolsVO outerbreak_tools_vo = tsa_eval_service.getTools(outerbreak_id);
		List<PointDataVOStr> outerbreak_points = tsa_eval_service.getPoints(outerbreak_id);
		List<PointDataVOStr> outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outerbreak_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
		
		map.put("outerbreak_MaxScore", outerbreak.getMaxScore());
		map.put("outerbreak_Score", outerbreak.getScore());
		map.put("outerbreak_Note", outerbreak.getNote());
		map.put("outerbreak_Position", outerbreak.getPosition());
		map.put("outerbreak_Rotation", outerbreak.getRotation());
		map.put("outerbreak_Scale", outerbreak.getScale());
		
		map.put("outerbreak_Tools_TouchCount", outerbreak_tools_vo.getTouchCount());
		map.put("outerbreak_Tools_ToolUseCount", outerbreak_tools_vo.getToolUseCount());
		map.put("outerbreak_Tools_ToolInnerCount", outerbreak_tools_vo.getToolInnerCount());
		map.put("outerbreak_Tools_ToolTouchScore", outerbreak_tools_vo.getToolTouchScore());
		map.put("outerbreak_Tools_ToolViewScore", outerbreak_tools_vo.getToolViewScore());
		map.put("outerbreak_Tools_MaxScore", outerbreak_tools_vo.getMaxScore());
		
		map.put("outerbreak_points", outerbreak_points); 
		map.put("outerbreak_target_points", outerbreak_targetpoints);
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_ethmoidal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(outerbreak_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(outerbreak_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(outerbreak_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(outerbreak_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(outerbreak_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(outerbreak_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisEthmoidalSinus_OuterBreak");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisEthmoidalSinus_Uncinectomy", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisEthmoidalSinus_Uncinectomy(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_ethmoidal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_ethmoidal_sinus_id); 
		VolumeTriggerVOStr uncinectomy = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		String uncinectomy_id = uncinectomy.getID();
		ToolsVO uncinectomy_tools_vo = tsa_eval_service.getTools(uncinectomy_id);
		List<PointTriggerVO> uncinectomy_points = tsa_eval_service.getPointTriggers(uncinectomy_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("uncinectomy_MaxScore", uncinectomy.getMaxScore());
		map.put("uncinectomy_Score", uncinectomy.getScore());
		map.put("uncinectomy_Note", uncinectomy.getNote());
		map.put("uncinectomy_points", uncinectomy.getPoints()); 
		map.put("uncinectomy_Position", uncinectomy.getPosition());
		map.put("uncinectomy_Rotation", uncinectomy.getRotation());
		map.put("uncinectomy_Localcale", uncinectomy.getLocalcale());
		map.put("uncinectomy_PinCount", uncinectomy.getPinCount());
		map.put("uncinectomy_Pins", uncinectomy.getPins());
		map.put("uncinectomy_TargetPins", uncinectomy.getTargetPins());
		
		map.put("uncinectomy_Tools_TouchCount", uncinectomy_tools_vo.getTouchCount());
		map.put("uncinectomy_Tools_ToolUseCount", uncinectomy_tools_vo.getToolUseCount());
		map.put("uncinectomy_Tools_ToolInnerCount", uncinectomy_tools_vo.getToolInnerCount());
		map.put("uncinectomy_Tools_ToolTouchScore", uncinectomy_tools_vo.getToolTouchScore());
		map.put("uncinectomy_Tools_ToolViewScore", uncinectomy_tools_vo.getToolViewScore());
		map.put("uncinectomy_Tools_MaxScore", uncinectomy_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_ethmoidal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(uncinectomy_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(uncinectomy_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(uncinectomy_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(uncinectomy_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(uncinectomy_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(uncinectomy_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisEthmoidalSinus_Uncinectomy");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisEthmoidalSinus_AnteriorEthmoidalAirCellRemoval", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisEthmoidalSinus_AnteriorEthmoidalAirCellRemoval(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_ethmoidal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_ethmoidal_sinus_id); 
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		String anterior_ethmoidal_air_cell_removal_id = anterior_ethmoidal_air_cell_removal.getID();
		ToolsVO anterior_ethmoidal_air_cell_removal_tools_vo = tsa_eval_service.getTools(anterior_ethmoidal_air_cell_removal_id);
		List<PointTriggerVO> anterior_ethmoidal_air_cell_removal_points = tsa_eval_service.getPointTriggers(anterior_ethmoidal_air_cell_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("anterior_ethmoidal_air_cell_removal_MaxScore", anterior_ethmoidal_air_cell_removal.getMaxScore());
		map.put("anterior_ethmoidal_air_cell_removal_Score", anterior_ethmoidal_air_cell_removal.getScore());
		map.put("anterior_ethmoidal_air_cell_removal_Note", anterior_ethmoidal_air_cell_removal.getNote());
		map.put("anterior_ethmoidal_air_cell_removal_points", anterior_ethmoidal_air_cell_removal.getPoints()); 
		map.put("anterior_ethmoidal_air_cell_removal_Position", anterior_ethmoidal_air_cell_removal.getPosition());
		map.put("anterior_ethmoidal_air_cell_removal_Rotation", anterior_ethmoidal_air_cell_removal.getRotation());
		map.put("anterior_ethmoidal_air_cell_removal_Localcale", anterior_ethmoidal_air_cell_removal.getLocalcale());
		map.put("anterior_ethmoidal_air_cell_removal_PinCount", anterior_ethmoidal_air_cell_removal.getPinCount());
		map.put("anterior_ethmoidal_air_cell_removal_Pins", anterior_ethmoidal_air_cell_removal.getPins());
		map.put("anterior_ethmoidal_air_cell_removal_TargetPins", anterior_ethmoidal_air_cell_removal.getTargetPins());
		
		map.put("anterior_ethmoidal_air_cell_removal_Tools_TouchCount", anterior_ethmoidal_air_cell_removal_tools_vo.getTouchCount());
		map.put("anterior_ethmoidal_air_cell_removal_Tools_ToolUseCount", anterior_ethmoidal_air_cell_removal_tools_vo.getToolUseCount());
		map.put("anterior_ethmoidal_air_cell_removal_Tools_ToolInnerCount", anterior_ethmoidal_air_cell_removal_tools_vo.getToolInnerCount());
		map.put("anterior_ethmoidal_air_cell_removal_Tools_ToolTouchScore", anterior_ethmoidal_air_cell_removal_tools_vo.getToolTouchScore());
		map.put("anterior_ethmoidal_air_cell_removal_Tools_ToolViewScore", anterior_ethmoidal_air_cell_removal_tools_vo.getToolViewScore());
		map.put("anterior_ethmoidal_air_cell_removal_Tools_MaxScore", anterior_ethmoidal_air_cell_removal_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_ethmoidal_air_cell_removal");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_ethmoidal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(anterior_ethmoidal_air_cell_removal_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(anterior_ethmoidal_air_cell_removal_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(anterior_ethmoidal_air_cell_removal_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(anterior_ethmoidal_air_cell_removal_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(anterior_ethmoidal_air_cell_removal_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(anterior_ethmoidal_air_cell_removal_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisEthmoidalSinus_AnteriorEthmoidalAirCellRemoval");
		return mav;
	}
	
	@RequestMapping(value="/ViewAcidosisEthmoidalSinus_PosteriorAirCellRemoval", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisEthmoidalSinus_PosteriorAirCellRemoval(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO total_vo = tsa_eval_service.getEntTotal(no);
		String acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(total_vo.getID());
		EntCommonVO common = tsa_eval_service.getEntCommon(acidosis_ethmoidal_sinus_id);
		ToolsVO tools_vo = tsa_eval_service.getTools(acidosis_ethmoidal_sinus_id); 
		VolumeTriggerVOStr posterior_air_cell_removal = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		String posterior_air_cell_removal_id = posterior_air_cell_removal.getID();
		ToolsVO posterior_air_cell_removal_tools_vo = tsa_eval_service.getTools(posterior_air_cell_removal_id);
		List<PointTriggerVO> posterior_air_cell_removal_points = tsa_eval_service.getPointTriggers(posterior_air_cell_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		map.put("common_Name", common.getName());
		map.put("common_ClassNo", common.getClassNo());
		map.put("common_Date", common.getDate());
		map.put("common_ActionCount", common.getActionCount());
		map.put("common_TotalScore", common.getTotalScore());
		
		map.put("tools_TouchCount", tools_vo.getTouchCount());
		map.put("tools_ToolUseCount", tools_vo.getToolUseCount());
		map.put("tools_ToolInnerCount", tools_vo.getToolInnerCount());
		map.put("tools_ToolTouchScore", tools_vo.getToolTouchScore());
		map.put("tools_ToolViewScore", tools_vo.getToolViewScore());
		map.put("tools_MaxScore", tools_vo.getMaxScore());
			
		map.put("posterior_air_cell_removal_MaxScore", posterior_air_cell_removal.getMaxScore());
		map.put("posterior_air_cell_removal_Score", posterior_air_cell_removal.getScore());
		map.put("posterior_air_cell_removal_Note", posterior_air_cell_removal.getNote());
		map.put("posterior_air_cell_removal_points", posterior_air_cell_removal.getPoints()); 
		map.put("posterior_air_cell_removal_Position", posterior_air_cell_removal.getPosition());
		map.put("posterior_air_cell_removal_Rotation", posterior_air_cell_removal.getRotation());
		map.put("posterior_air_cell_removal_Localcale", posterior_air_cell_removal.getLocalcale());
		map.put("posterior_air_cell_removal_PinCount", posterior_air_cell_removal.getPinCount());
		map.put("posterior_air_cell_removal_Pins", posterior_air_cell_removal.getPins());
		map.put("posterior_air_cell_removal_TargetPins", posterior_air_cell_removal.getTargetPins());
		
		map.put("posterior_air_cell_removal_Tools_TouchCount", posterior_air_cell_removal_tools_vo.getTouchCount());
		map.put("posterior_air_cell_removal_Tools_ToolUseCount", posterior_air_cell_removal_tools_vo.getToolUseCount());
		map.put("posterior_air_cell_removal_Tools_ToolInnerCount", posterior_air_cell_removal_tools_vo.getToolInnerCount());
		map.put("posterior_air_cell_removal_Tools_ToolTouchScore", posterior_air_cell_removal_tools_vo.getToolTouchScore());
		map.put("posterior_air_cell_removal_Tools_ToolViewScore", posterior_air_cell_removal_tools_vo.getToolViewScore());
		map.put("posterior_air_cell_removal_Tools_MaxScore", posterior_air_cell_removal_tools_vo.getMaxScore());
		
		// 전문가 main oper 도구 점수
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		map.put("mo_ex_TouchCount", main_oper_tool_exvo.getTouchCount());
		map.put("mo_ex_ToolUseCount", main_oper_tool_exvo.getToolUseCount());
		map.put("mo_ex_ToolInnerCount", main_oper_tool_exvo.getToolInnerCount());
		map.put("mo_ex_ToolTouchScore", main_oper_tool_exvo.getToolTouchScore());
		map.put("mo_ex_ToolViewScore", main_oper_tool_exvo.getToolViewScore());
		map.put("mo_ex_MaxScore", main_oper_tool_exvo.getMaxScore());
		
		// 전문가 sub oper 도구 점수
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("posterior_air_cell_removal");
		map.put("so_ex_TouchCount", sub_oper_tool_exvo.getTouchCount());
		map.put("so_ex_ToolUseCount", sub_oper_tool_exvo.getToolUseCount());
		map.put("so_ex_ToolInnerCount", sub_oper_tool_exvo.getToolInnerCount());
		map.put("so_ex_ToolTouchScore", sub_oper_tool_exvo.getToolTouchScore());
		map.put("so_ex_ToolViewScore", sub_oper_tool_exvo.getToolViewScore());
		map.put("so_ex_MaxScore", sub_oper_tool_exvo.getMaxScore());
		
		// 실습자 main oper 평균 점수
		map.put("aver_moTouchCount", tsa_eval_service.getAverTouchCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolUseCount", tsa_eval_service.getAverToolUseCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolInnerCount", tsa_eval_service.getAverToolInnerCount(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolTouchScore", tsa_eval_service.getAverToolTouchScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolViewScore", tsa_eval_service.getAverToolViewScore(acidosis_ethmoidal_sinus_id));
		map.put("aver_moToolMaxScore", tsa_eval_service.getAverMaxScore(acidosis_ethmoidal_sinus_id));
		
		// 실습자 sub oper 도구 평균 점수
		map.put("aver_soTouchCount", tsa_eval_service.getAverTouchCount(posterior_air_cell_removal_id));
		map.put("aver_soToolUseCount", tsa_eval_service.getAverToolUseCount(posterior_air_cell_removal_id));
		map.put("aver_soToolInnerCount", tsa_eval_service.getAverToolInnerCount(posterior_air_cell_removal_id));
		map.put("aver_soToolTouchScore", tsa_eval_service.getAverToolTouchScore(posterior_air_cell_removal_id));
		map.put("aver_soToolViewScore", tsa_eval_service.getAverToolViewScore(posterior_air_cell_removal_id));
		map.put("aver_soToolMaxScore", tsa_eval_service.getAverMaxScore(posterior_air_cell_removal_id));
		
		// acidosis frontal sinus 점수분포
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisEthmoidalSinus_PosteriorAirCellRemoval");
		return mav;
	}
	
	/*
	// 이비인후과 수술 구조에대한 오해로 항상 처음 읽어지는 페이지인데 이 페이지는 ent total과 연결된 5가지 수술유형중에서 
	// 유효한 하나의 값을 렌더링
	@RequestMapping(value="/ViewTSA", method=RequestMethod.GET)
	public ModelAndView ViewTSA(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 1. ent_tsa
		// ENTCommon / Tools / OuterBreak / Septal_Flap / Superior_Turbinate / Sella_Duramater / Tumor_Removal
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		PathTriggerVOStr ent_tsa_outerbreak = tsa_eval_service.getOuterBreak(ent_tsa_id); // 부모의 id로 자신의 id를 찾아냄
		String outer_break_id = ent_tsa_outerbreak.getID();
		ToolsVO ent_tsa_outerbreak_tools_vo = tsa_eval_service.getTools(outer_break_id);
		List<PointDataVOStr> ent_tsa_outerbreak_points = tsa_eval_service.getPoints(outer_break_id);
		List<PointDataVOStr> ent_tsa_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outer_break_id);
		
		PathTriggerVOStr ent_tsa_septal_flap = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		String septal_flap_id = ent_tsa_septal_flap.getID();
		ToolsVO ent_tsa_septal_flap_tools_vo = tsa_eval_service.getTools(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_points = tsa_eval_service.getPoints(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_targetpoints = tsa_eval_service.getTargetPoints(septal_flap_id);
		
		BoxTriggerVO ent_tsa_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		String ent_tsa_superior_turbinate_id = ent_tsa_superior_turbinate.getID();
		ToolsVO ent_tsa_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_tsa_superior_turbinate_id);
		
		VolumeTriggerVOStr ent_tsa_sella_duramater = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		String ent_tsa_sella_duramater_id = ent_tsa_sella_duramater.getID();
		ToolsVO ent_tsa_sella_duramater_tools_vo = tsa_eval_service.getTools(ent_tsa_sella_duramater_id);
		List<PointTriggerVO> ent_tsa_sella_duramater_points = tsa_eval_service.getPointTriggers(ent_tsa_sella_duramater_id);
		
		VolumeTriggerVOStr ent_tsa_tumor_removal = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		String ent_tsa_tumor_removal_id = ent_tsa_tumor_removal.getID();
		ToolsVO ent_tsa_tumor_removal_tools_vo = tsa_eval_service.getTools(ent_tsa_tumor_removal_id);
		List<PointTriggerVO> ent_tsa_tumor_removal_points = tsa_eval_service.getPointTriggers(ent_tsa_tumor_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("tsa_ent_common_Name", tsa_ent_common.getName());
		map.put("tsa_ent_common_ClassNo", tsa_ent_common.getClassNo());
		map.put("tsa_ent_common_Date", tsa_ent_common.getDate());
		map.put("tsa_ent_common_ActionCount", tsa_ent_common.getActionCount());
		map.put("tsa_ent_common_TotalScore", tsa_ent_common.getTotalScore());
		
		map.put("ent_tsa_tools_TouchCount", ent_tsa_tools_vo.getTouchCount());
		map.put("ent_tsa_tools_ToolUseCount", ent_tsa_tools_vo.getToolUseCount());
		map.put("ent_tsa_tools_ToolInnerCount", ent_tsa_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tools_ToolTouchScore", ent_tsa_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tools_ToolViewScore", ent_tsa_tools_vo.getToolViewScore());
		map.put("ent_tsa_tools_MaxScore", ent_tsa_tools_vo.getMaxScore());
		
		map.put("ent_tsa_outerbreak_MaxScore", ent_tsa_outerbreak.getMaxScore());
		map.put("ent_tsa_outerbreak_Score", ent_tsa_outerbreak.getScore());
		map.put("ent_tsa_outerbreak_Note", ent_tsa_outerbreak.getNote());
		map.put("ent_tsa_outerbreak_Position", ent_tsa_outerbreak.getPosition());
		map.put("ent_tsa_outerbreak_Rotation", ent_tsa_outerbreak.getRotation());
		map.put("ent_tsa_outerbreak_Scale", ent_tsa_outerbreak.getScale());
		
		map.put("ent_tsa_outerbreak_Tools_TouchCount", ent_tsa_outerbreak_tools_vo.getTouchCount());
		map.put("ent_tsa_outerbreak_Tools_ToolUseCount", ent_tsa_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_tsa_outerbreak_Tools_ToolInnerCount", ent_tsa_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_tsa_outerbreak_Tools_ToolTouchScore", ent_tsa_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_tsa_outerbreak_Tools_ToolViewScore", ent_tsa_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_tsa_outerbreak_Tools_MaxScore", ent_tsa_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_tsa_outerbreak_points", ent_tsa_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_tsa_outerbreak_target_points", ent_tsa_outerbreak_targetpoints);
		
		map.put("ent_tsa_septalflap_MaxScore", ent_tsa_septal_flap.getMaxScore());
		map.put("ent_tsa_septalflap_Score", ent_tsa_septal_flap.getScore());
		map.put("ent_tsa_septalflap_Note", ent_tsa_septal_flap.getNote());
		map.put("ent_tsa_septalflap_Position", ent_tsa_septal_flap.getPosition());
		map.put("ent_tsa_septalflap_Rotation", ent_tsa_septal_flap.getRotation());
		map.put("ent_tsa_septalflap_Scale", ent_tsa_septal_flap.getScale());
		
		map.put("ent_tsa_septalflap_Tools_TouchCount", ent_tsa_septal_flap_tools_vo.getTouchCount());
		map.put("ent_tsa_septalflap_Tools_ToolUseCount", ent_tsa_septal_flap_tools_vo.getToolUseCount());
		map.put("ent_tsa_septalflap_Tools_ToolInnerCount", ent_tsa_septal_flap_tools_vo.getToolInnerCount());
		map.put("ent_tsa_septalflap_Tools_ToolTouchScore", ent_tsa_septal_flap_tools_vo.getToolTouchScore());
		map.put("ent_tsa_septalflap_Tools_ToolViewScore", ent_tsa_septal_flap_tools_vo.getToolViewScore());
		map.put("ent_tsa_septalflap_Tools_MaxScore", ent_tsa_septal_flap_tools_vo.getMaxScore());
		
		map.put("ent_tsa_septalflap_points", ent_tsa_septal_flap_points); // jsp 에서 list 로 받아야함
		map.put("ent_tsa_septalflap_target_points", ent_tsa_septal_flap_targetpoints);
		
		map.put("ent_tsa_superior_turbinate_MaxScore", ent_tsa_superior_turbinate.getMaxScore());
		map.put("ent_tsa_superior_turbinate_Score", ent_tsa_superior_turbinate.getScore());
		map.put("ent_tsa_superior_turbinate_Note", ent_tsa_superior_turbinate.getNote());
		map.put("ent_tsa_superior_turbinate_InnerTriggerCount", ent_tsa_superior_turbinate.getInnerTriggerCount());
		map.put("ent_tsa_superior_turbinate_OuterTriggerCount", ent_tsa_superior_turbinate.getOuterTriggerCount());
		map.put("ent_tsa_superior_turbinate_InnerTriggerTouchCount", ent_tsa_superior_turbinate.getInnerTriggerTouchCount());
		map.put("ent_tsa_superior_turbinate_OuterTriggerTouchCount", ent_tsa_superior_turbinate.getOuterTriggerTouchCount());
		
		map.put("ent_tsa_superior_turbinate_Tools_TouchCount", ent_tsa_superior_turbinate_tools_vo.getTouchCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolUseCount", ent_tsa_superior_turbinate_tools_vo.getToolUseCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolInnerCount", ent_tsa_superior_turbinate_tools_vo.getToolInnerCount());
		map.put("ent_tsa_superior_turbinate_Tools_ToolTouchScore", ent_tsa_superior_turbinate_tools_vo.getToolTouchScore());
		map.put("ent_tsa_superior_turbinate_Tools_ToolViewScore", ent_tsa_superior_turbinate_tools_vo.getToolViewScore());
		map.put("ent_tsa_superior_turbinate_Tools_MaxScore", ent_tsa_superior_turbinate_tools_vo.getMaxScore());
		
		map.put("ent_tsa_sella_duramater_MaxScore", ent_tsa_sella_duramater.getMaxScore());
		map.put("ent_tsa_sella_duramater_Score", ent_tsa_sella_duramater.getScore());
		map.put("ent_tsa_sella_duramater_Note", ent_tsa_sella_duramater.getNote());
		map.put("ent_tsa_sella_duramater_points", ent_tsa_sella_duramater.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_tsa_sella_duramater_Position", ent_tsa_sella_duramater.getPosition());
		map.put("ent_tsa_sella_duramater_Rotation", ent_tsa_sella_duramater.getRotation());
		map.put("ent_tsa_sella_duramater_Localcale", ent_tsa_sella_duramater.getLocalcale());
		map.put("ent_tsa_sella_duramater_PinCount", ent_tsa_sella_duramater.getPinCount());
		map.put("ent_tsa_sella_duramater_Pins", ent_tsa_sella_duramater.getPins());
		map.put("ent_tsa_sella_duramater_TargetPins", ent_tsa_sella_duramater.getTargetPins());
		
		map.put("ent_tsa_sella_duramater_Tools_TouchCount", ent_tsa_sella_duramater_tools_vo.getTouchCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolUseCount", ent_tsa_sella_duramater_tools_vo.getToolUseCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolInnerCount", ent_tsa_sella_duramater_tools_vo.getToolInnerCount());
		map.put("ent_tsa_sella_duramater_Tools_ToolTouchScore", ent_tsa_sella_duramater_tools_vo.getToolTouchScore());
		map.put("ent_tsa_sella_duramater_Tools_ToolViewScore", ent_tsa_sella_duramater_tools_vo.getToolViewScore());
		map.put("ent_tsa_sella_duramater_Tools_MaxScore", ent_tsa_sella_duramater_tools_vo.getMaxScore());
		
		map.put("ent_tsa_tumor_removal_MaxScore", ent_tsa_tumor_removal.getMaxScore());
		map.put("ent_tsa_tumor_removal_Score", ent_tsa_tumor_removal.getScore());
		map.put("ent_tsa_tumor_removal_Note", ent_tsa_tumor_removal.getNote());
		map.put("ent_tsa_tumor_removal_points", ent_tsa_tumor_removal.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_tsa_tumor_removal_Position", ent_tsa_tumor_removal.getPosition());
		map.put("ent_tsa_tumor_removal_Rotation", ent_tsa_tumor_removal.getRotation());
		map.put("ent_tsa_tumor_removal_Localcale", ent_tsa_tumor_removal.getLocalcale());
		map.put("ent_tsa_tumor_removal_PinCount", ent_tsa_tumor_removal.getPinCount());
		map.put("ent_tsa_tumor_removal_Pins", ent_tsa_tumor_removal.getPins());
		map.put("ent_tsa_tumor_removal_TargetPins", ent_tsa_tumor_removal.getTargetPins());
		
		map.put("ent_tsa_tumor_removal_Tools_TouchCount", ent_tsa_tumor_removal_tools_vo.getTouchCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolUseCount", ent_tsa_tumor_removal_tools_vo.getToolUseCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolInnerCount", ent_tsa_tumor_removal_tools_vo.getToolInnerCount());
		map.put("ent_tsa_tumor_removal_Tools_ToolTouchScore", ent_tsa_tumor_removal_tools_vo.getToolTouchScore());
		map.put("ent_tsa_tumor_removal_Tools_ToolViewScore", ent_tsa_tumor_removal_tools_vo.getToolViewScore());
		map.put("ent_tsa_tumor_removal_Tools_MaxScore", ent_tsa_tumor_removal_tools_vo.getMaxScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTSA");
		return mav;
	}
	
	// 2
	@RequestMapping(value="/ViewTransclivalApproach", method=RequestMethod.GET)
	public ModelAndView ViewTransclivalApproach(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 2. ent_transclival_approach
		// ENTCommon / Tools / OuterBreak / Septal_Flap / Superior_Turbinate / Sella_Duramater
		String ent_transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(ent_total_vo.getID());
		EntCommonVO ent_transclival_approach_common = tsa_eval_service.getEntCommon(ent_transclival_approach_id);
		ToolsVO ent_transclival_approach_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_id); 
		
		PathTriggerVOStr ent_transclival_approach_outerbreak = tsa_eval_service.getOuterBreak(ent_transclival_approach_id); 
		String ent_transclival_approach_outerbreak_id = ent_transclival_approach_outerbreak.getID();
		ToolsVO ent_transclival_approach_outerbreak_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_outerbreak_id);
		List<PointDataVOStr> ent_transclival_approach_outerbreak_points = tsa_eval_service.getPoints(ent_transclival_approach_outerbreak_id);
		List<PointDataVOStr> ent_transclival_approach_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_transclival_approach_outerbreak_id);
		
		PathTriggerVOStr ent_transclival_approach_septal_flap = tsa_eval_service.getSeptalFlap(ent_transclival_approach_id);
		String ent_transclival_approach_septal_flap_id = ent_transclival_approach_septal_flap.getID();
		ToolsVO ent_transclival_approach_septal_flap_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_septal_flap_id);
		List<PointDataVOStr> ent_transclival_approach_septal_flap_points = tsa_eval_service.getPoints(ent_transclival_approach_septal_flap_id);
		List<PointDataVOStr> ent_transclival_approach_septal_flap_targetpoints = tsa_eval_service.getTargetPoints(ent_transclival_approach_septal_flap_id);
		
		BoxTriggerVO ent_transclival_approach_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_transclival_approach_id);
		String ent_transclival_approach_superior_turbinate_id = ent_transclival_approach_superior_turbinate.getID();
		ToolsVO ent_transclival_approach_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_superior_turbinate_id);
		
		VolumeTriggerVOStr ent_transclival_approach_sella_duramater = tsa_eval_service.getSellaDuramater(ent_transclival_approach_id);
		String ent_transclival_approach_sella_duramater_id = ent_transclival_approach_sella_duramater.getID();
		ToolsVO ent_transclival_approach_sella_duramater_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_sella_duramater_id);
		List<PointTriggerVO> ent_transclival_approach_sella_duramater_points = tsa_eval_service.getPointTriggers(ent_transclival_approach_sella_duramater_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("ent_transclival_approach_common_Name", ent_transclival_approach_common.getName());
		map.put("ent_transclival_approach_common_ClassNo", ent_transclival_approach_common.getClassNo());
		map.put("ent_transclival_approach_common_Date", ent_transclival_approach_common.getDate());
		map.put("ent_transclival_approach_common_ActionCount", ent_transclival_approach_common.getActionCount());
		map.put("ent_transclival_approach_common_TotalScore", ent_transclival_approach_common.getTotalScore());
		
		map.put("ent_transclival_approach_tools_TouchCount", ent_transclival_approach_tools_vo.getTouchCount());
		map.put("ent_transclival_approach_tools_ToolUseCount", ent_transclival_approach_tools_vo.getToolUseCount());
		map.put("ent_transclival_approach_tools_ToolInnerCount", ent_transclival_approach_tools_vo.getToolInnerCount());
		map.put("ent_transclival_approach_tools_ToolTouchScore", ent_transclival_approach_tools_vo.getToolTouchScore());
		map.put("ent_transclival_approach_tools_ToolViewScore", ent_transclival_approach_tools_vo.getToolViewScore());
		map.put("ent_transclival_approach_tools_MaxScore", ent_transclival_approach_tools_vo.getMaxScore());
		
		map.put("ent_transclival_approach_outerbreak_MaxScore", ent_transclival_approach_outerbreak.getMaxScore());
		map.put("ent_transclival_approach_outerbreak_Score", ent_transclival_approach_outerbreak.getScore());
		map.put("ent_transclival_approach_outerbreak_Note", ent_transclival_approach_outerbreak.getNote());
		map.put("ent_transclival_approach_outerbreak_Position", ent_transclival_approach_outerbreak.getPosition());
		map.put("ent_transclival_approach_outerbreak_Rotation", ent_transclival_approach_outerbreak.getRotation());
		map.put("ent_transclival_approach_outerbreak_Scale", ent_transclival_approach_outerbreak.getScale());
		
		map.put("ent_transclival_approach_outerbreak_Tools_TouchCount", ent_transclival_approach_outerbreak_tools_vo.getTouchCount());
		map.put("ent_transclival_approach_outerbreak_Tools_ToolUseCount", ent_transclival_approach_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_transclival_approach_outerbreak_Tools_ToolInnerCount", ent_transclival_approach_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_transclival_approach_outerbreak_Tools_ToolTouchScore", ent_transclival_approach_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_transclival_approach_outerbreak_Tools_ToolViewScore", ent_transclival_approach_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_transclival_approach_outerbreak_Tools_MaxScore", ent_transclival_approach_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_transclival_approach_outerbreak_points", ent_transclival_approach_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_transclival_approach_outerbreak_target_points", ent_transclival_approach_outerbreak_targetpoints);
		
		map.put("ent_transclival_approach_septalflap_MaxScore", ent_transclival_approach_septal_flap.getMaxScore());
		map.put("ent_transclival_approach_septalflap_Score", ent_transclival_approach_septal_flap.getScore());
		map.put("ent_transclival_approach_septalflap_Note", ent_transclival_approach_septal_flap.getNote());
		map.put("ent_transclival_approach_septalflap_Position", ent_transclival_approach_septal_flap.getPosition());
		map.put("ent_transclival_approach_septalflap_Rotation", ent_transclival_approach_septal_flap.getRotation());
		map.put("ent_transclival_approach_septalflap_Scale", ent_transclival_approach_septal_flap.getScale());
		
		map.put("ent_transclival_approach_septalflap_Tools_TouchCount", ent_transclival_approach_septal_flap_tools_vo.getTouchCount());
		map.put("ent_transclival_approach_septalflap_Tools_ToolUseCount", ent_transclival_approach_septal_flap_tools_vo.getToolUseCount());
		map.put("ent_transclival_approach_septalflap_Tools_ToolInnerCount", ent_transclival_approach_septal_flap_tools_vo.getToolInnerCount());
		map.put("ent_transclival_approach_septalflap_Tools_ToolTouchScore", ent_transclival_approach_septal_flap_tools_vo.getToolTouchScore());
		map.put("ent_transclival_approach_septalflap_Tools_ToolViewScore", ent_transclival_approach_septal_flap_tools_vo.getToolViewScore());
		map.put("ent_transclival_approach_septalflap_Tools_MaxScore", ent_transclival_approach_septal_flap_tools_vo.getMaxScore());
		
		map.put("ent_transclival_approach_septalflap_points", ent_transclival_approach_septal_flap_points); // jsp 에서 list 로 받아야함
		map.put("ent_transclival_approach_septalflap_target_points", ent_transclival_approach_septal_flap_targetpoints);
		
		map.put("ent_transclival_approach_superior_turbinate_MaxScore", ent_transclival_approach_superior_turbinate.getMaxScore());
		map.put("ent_transclival_approach_superior_turbinate_Score", ent_transclival_approach_superior_turbinate.getScore());
		map.put("ent_transclival_approach_superior_turbinate_Note", ent_transclival_approach_superior_turbinate.getNote());
		map.put("ent_transclival_approach_superior_turbinate_InnerTriggerCount", ent_transclival_approach_superior_turbinate.getInnerTriggerCount());
		map.put("ent_transclival_approach_superior_turbinate_OuterTriggerCount", ent_transclival_approach_superior_turbinate.getOuterTriggerCount());
		map.put("ent_transclival_approach_superior_turbinate_InnerTriggerTouchCount", ent_transclival_approach_superior_turbinate.getInnerTriggerTouchCount());
		map.put("ent_transclival_approach_superior_turbinate_OuterTriggerTouchCount", ent_transclival_approach_superior_turbinate.getOuterTriggerTouchCount());
		
		map.put("ent_transclival_approach_superior_turbinate_Tools_TouchCount", ent_transclival_approach_superior_turbinate_tools_vo.getTouchCount());
		map.put("ent_transclival_approach_superior_turbinate_Tools_ToolUseCount", ent_transclival_approach_superior_turbinate_tools_vo.getToolUseCount());
		map.put("ent_transclival_approach_superior_turbinate_Tools_ToolInnerCount", ent_transclival_approach_superior_turbinate_tools_vo.getToolInnerCount());
		map.put("ent_transclival_approach_superior_turbinate_Tools_ToolTouchScore", ent_transclival_approach_superior_turbinate_tools_vo.getToolTouchScore());
		map.put("ent_transclival_approach_superior_turbinate_Tools_ToolViewScore", ent_transclival_approach_superior_turbinate_tools_vo.getToolViewScore());
		map.put("ent_transclival_approach_superior_turbinate_Tools_MaxScore", ent_transclival_approach_superior_turbinate_tools_vo.getMaxScore());
		
		map.put("ent_transclival_approach_sella_duramater_MaxScore", ent_transclival_approach_sella_duramater.getMaxScore());
		map.put("ent_transclival_approach_sella_duramater_Score", ent_transclival_approach_sella_duramater.getScore());
		map.put("ent_transclival_approach_sella_duramater_Note", ent_transclival_approach_sella_duramater.getNote());
		map.put("ent_transclival_approach_sella_duramater_points", ent_transclival_approach_sella_duramater.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_transclival_approach_sella_duramater_Position", ent_transclival_approach_sella_duramater.getPosition());
		map.put("ent_transclival_approach_sella_duramater_Rotation", ent_transclival_approach_sella_duramater.getRotation());
		map.put("ent_transclival_approach_sella_duramater_Localcale", ent_transclival_approach_sella_duramater.getLocalcale());
		map.put("ent_transclival_approach_sella_duramater_PinCount", ent_transclival_approach_sella_duramater.getPinCount());
		map.put("ent_transclival_approach_sella_duramater_Pins", ent_transclival_approach_sella_duramater.getPins());
		map.put("ent_transclival_approach_sella_duramater_TargetPins", ent_transclival_approach_sella_duramater.getTargetPins());
		
		map.put("ent_transclival_approach_sella_duramater_Tools_TouchCount", ent_transclival_approach_sella_duramater_tools_vo.getTouchCount());
		map.put("ent_transclival_approach_sella_duramater_Tools_ToolUseCount", ent_transclival_approach_sella_duramater_tools_vo.getToolUseCount());
		map.put("ent_transclival_approach_sella_duramater_Tools_ToolInnerCount", ent_transclival_approach_sella_duramater_tools_vo.getToolInnerCount());
		map.put("ent_transclival_approach_sella_duramater_Tools_ToolTouchScore", ent_transclival_approach_sella_duramater_tools_vo.getToolTouchScore());
		map.put("ent_transclival_approach_sella_duramater_Tools_ToolViewScore", ent_transclival_approach_sella_duramater_tools_vo.getToolViewScore());
		map.put("ent_transclival_approach_sella_duramater_Tools_MaxScore", ent_transclival_approach_sella_duramater_tools_vo.getMaxScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewTransclivalApproach");
		return mav;
	}
	
	// 3
	@RequestMapping(value="/ViewAcidosisMaxillarySinus", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisMaxillarySinus(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 3. ent_acidosis_maxillary_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Superior_Turbinate
		String ent_acidosis_maxillary_sinus_id = tsa_eval_service.getEntAcidosisMaxillarySinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_maxillary_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_maxillary_sinus_id);
		ToolsVO ent_acidosis_maxillary_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_id);
		
		PathTriggerVOStr ent_acidosis_maxillary_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_maxillary_sinus_id); 
		String ent_acidosis_maxillary_sinus_outerbreak_id = ent_acidosis_maxillary_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_maxillary_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_maxillary_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_maxillary_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_maxillary_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_maxillary_sinus_outerbreak_id);
		
		VolumeTriggerVOStr ent_acidosis_maxillary_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_maxillary_sinus_id);
		String ent_acidosis_maxillary_sinus_uncinectomy_id = ent_acidosis_maxillary_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_maxillary_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_maxillary_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_maxillary_sinus_uncinectomy_id);
		
		BoxTriggerVO ent_acidosis_maxillary_sinus_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_acidosis_maxillary_sinus_id);
		String ent_acidosis_maxillary_sinus_superior_turbinate_id = ent_acidosis_maxillary_sinus_superior_turbinate.getID();
		ToolsVO ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_superior_turbinate_id);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("ent_acidosis_maxillary_sinus_common_Name", ent_acidosis_maxillary_sinus_common.getName());
		map.put("ent_acidosis_maxillary_sinus_common_ClassNo", ent_acidosis_maxillary_sinus_common.getClassNo());
		map.put("ent_acidosis_maxillary_sinus_common_Date", ent_acidosis_maxillary_sinus_common.getDate());
		map.put("ent_acidosis_maxillary_sinus_common_ActionCount", ent_acidosis_maxillary_sinus_common.getActionCount());
		map.put("ent_acidosis_maxillary_sinus_common_TotalScore", ent_acidosis_maxillary_sinus_common.getTotalScore());
		
		map.put("ent_acidosis_maxillary_sinus_tools_TouchCount", ent_acidosis_maxillary_sinus_tools_vo.getTouchCount());
		map.put("ent_acidosis_maxillary_sinus_tools_ToolUseCount", ent_acidosis_maxillary_sinus_tools_vo.getToolUseCount());
		map.put("ent_acidosis_maxillary_sinus_tools_ToolInnerCount", ent_acidosis_maxillary_sinus_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_maxillary_sinus_tools_ToolTouchScore", ent_acidosis_maxillary_sinus_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_maxillary_sinus_tools_ToolViewScore", ent_acidosis_maxillary_sinus_tools_vo.getToolViewScore());
		map.put("ent_acidosis_maxillary_sinus_tools_MaxScore", ent_acidosis_maxillary_sinus_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_maxillary_sinus_outerbreak_MaxScore", ent_acidosis_maxillary_sinus_outerbreak.getMaxScore());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Score", ent_acidosis_maxillary_sinus_outerbreak.getScore());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Note", ent_acidosis_maxillary_sinus_outerbreak.getNote());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Position", ent_acidosis_maxillary_sinus_outerbreak.getPosition());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Rotation", ent_acidosis_maxillary_sinus_outerbreak.getRotation());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Scale", ent_acidosis_maxillary_sinus_outerbreak.getScale());
		
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_TouchCount", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getTouchCount());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_ToolUseCount", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_ToolInnerCount", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_ToolTouchScore", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_ToolViewScore", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_acidosis_maxillary_sinus_outerbreak_Tools_MaxScore", ent_acidosis_maxillary_sinus_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_maxillary_sinus_outerbreak_points", ent_acidosis_maxillary_sinus_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_acidosis_maxillary_sinus_outerbreak_target_points", ent_acidosis_maxillary_sinus_outerbreak_targetpoints);
		
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_MaxScore", ent_acidosis_maxillary_sinus_uncinectomy.getMaxScore());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Score", ent_acidosis_maxillary_sinus_uncinectomy.getScore());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Note", ent_acidosis_maxillary_sinus_uncinectomy.getNote());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_points", ent_acidosis_maxillary_sinus_uncinectomy.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Position", ent_acidosis_maxillary_sinus_uncinectomy.getPosition());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Rotation", ent_acidosis_maxillary_sinus_uncinectomy.getRotation());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Localcale", ent_acidosis_maxillary_sinus_uncinectomy.getLocalcale());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_PinCount", ent_acidosis_maxillary_sinus_uncinectomy.getPinCount());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Pins", ent_acidosis_maxillary_sinus_uncinectomy.getPins());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_TargetPins", ent_acidosis_maxillary_sinus_uncinectomy.getTargetPins());
		
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_TouchCount", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getTouchCount());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_ToolUseCount", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getToolUseCount());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_ToolInnerCount", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_ToolTouchScore", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_ToolViewScore", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getToolViewScore());
		map.put("ent_acidosis_maxillary_sinus_uncinectomy_Tools_MaxScore", ent_acidosis_maxillary_sinus_uncinectomy_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_MaxScore", ent_acidosis_maxillary_sinus_superior_turbinate.getMaxScore());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Score", ent_acidosis_maxillary_sinus_superior_turbinate.getScore());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Note", ent_acidosis_maxillary_sinus_superior_turbinate.getNote());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_InnerTriggerCount", ent_acidosis_maxillary_sinus_superior_turbinate.getInnerTriggerCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_OuterTriggerCount", ent_acidosis_maxillary_sinus_superior_turbinate.getOuterTriggerCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_InnerTriggerTouchCount", ent_acidosis_maxillary_sinus_superior_turbinate.getInnerTriggerTouchCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_OuterTriggerTouchCount", ent_acidosis_maxillary_sinus_superior_turbinate.getOuterTriggerTouchCount());
		
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_TouchCount", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getTouchCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_ToolUseCount", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getToolUseCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_ToolInnerCount", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_ToolTouchScore", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_ToolViewScore", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getToolViewScore());
		map.put("ent_acidosis_maxillary_sinus_superior_turbinate_Tools_MaxScore", ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo.getMaxScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisMaxillarySinus");
		return mav;
	}
	
	// 4
	@RequestMapping(value="/ViewAcidosisFrontalSinus", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisFrontalSinus(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 4. ent_acidosis_frontal_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Anterior_ethmoidectomy / Anterior_sinus
		String ent_acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_frontal_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_frontal_sinus_id);
		ToolsVO ent_acidosis_frontal_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_id);
		
		// 4-1. ent_acidosis_frontal_sinus - outerbreak
		PathTriggerVOStr ent_acidosis_frontal_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_outerbreak_id = ent_acidosis_frontal_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_frontal_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_frontal_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_frontal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_frontal_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_frontal_sinus_outerbreak_id);
		
		// 4-2. ent_acidosis_frontal_sinus - uncinectomy
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_uncinectomy_id = ent_acidosis_frontal_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_frontal_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_uncinectomy_id);
		
		// 4-3. ent_acidosis_frontal_sinus - anterior_ethmoidectomy
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_anterior_ethmoidectomy = tsa_eval_service.getAnteriorEthmoidectomy(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id = ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getID();
		ToolsVO ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_anterior_ethmoidectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id);
		
		// 4-4. ent_acidosis_frontal_sinus - anterior_sinus
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_anterior_sinus = tsa_eval_service.getAnteriorSinus(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_anterior_sinus_id = ent_acidosis_frontal_sinus_anterior_sinus.getID();
		ToolsVO ent_acidosis_frontal_sinus_anterior_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_anterior_sinus_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_anterior_sinus_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_anterior_sinus_id);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("ent_acidosis_frontal_sinus_common_Name", ent_acidosis_frontal_sinus_common.getName());
		map.put("ent_acidosis_frontal_sinus_common_ClassNo", ent_acidosis_frontal_sinus_common.getClassNo());
		map.put("ent_acidosis_frontal_sinus_common_Date", ent_acidosis_frontal_sinus_common.getDate());
		map.put("ent_acidosis_frontal_sinus_common_ActionCount", ent_acidosis_frontal_sinus_common.getActionCount());
		map.put("ent_acidosis_frontal_sinus_common_TotalScore", ent_acidosis_frontal_sinus_common.getTotalScore());
		
		map.put("ent_acidosis_frontal_sinus_tools_TouchCount", ent_acidosis_frontal_sinus_tools_vo.getTouchCount());
		map.put("ent_acidosis_frontal_sinus_tools_ToolUseCount", ent_acidosis_frontal_sinus_tools_vo.getToolUseCount());
		map.put("ent_acidosis_frontal_sinus_tools_ToolInnerCount", ent_acidosis_frontal_sinus_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_frontal_sinus_tools_ToolTouchScore", ent_acidosis_frontal_sinus_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_frontal_sinus_tools_ToolViewScore", ent_acidosis_frontal_sinus_tools_vo.getToolViewScore());
		map.put("ent_acidosis_frontal_sinus_tools_MaxScore", ent_acidosis_frontal_sinus_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_frontal_sinus_outerbreak_MaxScore", ent_acidosis_frontal_sinus_outerbreak.getMaxScore());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Score", ent_acidosis_frontal_sinus_outerbreak.getScore());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Note", ent_acidosis_frontal_sinus_outerbreak.getNote());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Position", ent_acidosis_frontal_sinus_outerbreak.getPosition());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Rotation", ent_acidosis_frontal_sinus_outerbreak.getRotation());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Scale", ent_acidosis_frontal_sinus_outerbreak.getScale());
		
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_TouchCount", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getTouchCount());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_ToolUseCount", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_ToolInnerCount", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_ToolTouchScore", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_ToolViewScore", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_acidosis_frontal_sinus_outerbreak_Tools_MaxScore", ent_acidosis_frontal_sinus_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_frontal_sinus_outerbreak_points", ent_acidosis_frontal_sinus_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_acidosis_frontal_sinus_outerbreak_target_points", ent_acidosis_frontal_sinus_outerbreak_targetpoints);
		
		map.put("ent_acidosis_frontal_sinus_uncinectomy_MaxScore", ent_acidosis_frontal_sinus_uncinectomy.getMaxScore());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Score", ent_acidosis_frontal_sinus_uncinectomy.getScore());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Note", ent_acidosis_frontal_sinus_uncinectomy.getNote());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_points", ent_acidosis_frontal_sinus_uncinectomy.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Position", ent_acidosis_frontal_sinus_uncinectomy.getPosition());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Rotation", ent_acidosis_frontal_sinus_uncinectomy.getRotation());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Localcale", ent_acidosis_frontal_sinus_uncinectomy.getLocalcale());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_PinCount", ent_acidosis_frontal_sinus_uncinectomy.getPinCount());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Pins", ent_acidosis_frontal_sinus_uncinectomy.getPins());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_TargetPins", ent_acidosis_frontal_sinus_uncinectomy.getTargetPins());
		
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_TouchCount", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getTouchCount());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_ToolUseCount", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getToolUseCount());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_ToolInnerCount", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_ToolTouchScore", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_ToolViewScore", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getToolViewScore());
		map.put("ent_acidosis_frontal_sinus_uncinectomy_Tools_MaxScore", ent_acidosis_frontal_sinus_uncinectomy_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_MaxScore", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getMaxScore());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Score", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getScore());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Note", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getNote());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_points", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Position", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getPosition());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Rotation", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getRotation());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Localcale", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getLocalcale());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_PinCount", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getPinCount());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Pins", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getPins());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_TargetPins", ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getTargetPins());
		
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_TouchCount", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getTouchCount());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_ToolUseCount", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getToolUseCount());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_ToolInnerCount", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_ToolTouchScore", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_ToolViewScore", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getToolViewScore());
		map.put("ent_acidosis_frontal_sinus_anterior_ethmoidectomy_Tools_MaxScore", ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_MaxScore", ent_acidosis_frontal_sinus_anterior_sinus.getMaxScore());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Score", ent_acidosis_frontal_sinus_anterior_sinus.getScore());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Note", ent_acidosis_frontal_sinus_anterior_sinus.getNote());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_points", ent_acidosis_frontal_sinus_anterior_sinus.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Position", ent_acidosis_frontal_sinus_anterior_sinus.getPosition());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Rotation", ent_acidosis_frontal_sinus_anterior_sinus.getRotation());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Localcale", ent_acidosis_frontal_sinus_anterior_sinus.getLocalcale());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_PinCount", ent_acidosis_frontal_sinus_anterior_sinus.getPinCount());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Pins", ent_acidosis_frontal_sinus_anterior_sinus.getPins());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_TargetPins", ent_acidosis_frontal_sinus_anterior_sinus.getTargetPins());
		
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_TouchCount", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getTouchCount());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_ToolUseCount", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getToolUseCount());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_ToolInnerCount", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_ToolTouchScore", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_ToolViewScore", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getToolViewScore());
		map.put("ent_acidosis_frontal_sinus_anterior_sinus_Tools_MaxScore", ent_acidosis_frontal_sinus_anterior_sinus_tools_vo.getMaxScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisFrontalSinus");
		return mav;
	}
	
	// 5
	@RequestMapping(value="/ViewAcidosisEthmoidalSinus", method=RequestMethod.GET)
	public ModelAndView ViewAcidosisEthmoidalSinus(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 5. ent_acidosis_ethmoidal_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Anterior_ethmoidal_air_cell_removal / Posterior_air_cell_removal
		String ent_acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_ethmoidal_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_ethmoidal_sinus_id);
		ToolsVO ent_acidosis_ethmoidal_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_id);
		
		// 5-1. ent_acidosis_ethmoidal_sinus - outerbreak
		PathTriggerVOStr ent_acidosis_ethmoidal_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_outerbreak_id = ent_acidosis_ethmoidal_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_ethmoidal_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_ethmoidal_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		
		// 5-2. ent_acidosis_ethmoidal_sinus - uncinectomy
		VolumeTriggerVOStr ent_acidosis_ethmoidal_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_uncinectomy_id = ent_acidosis_ethmoidal_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_uncinectomy_id);
		
		// 5-3. ent_acidosis_ethmoidal_sinus - anterior_ethmoidal_air_cell_removal
		VolumeTriggerVO ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id = ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id);
		
		// 5-4. ent_acidosis_ethmoidal_sinus - posterior_air_cell_removal
		VolumeTriggerVO ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal = tsa_eval_service.getPosteriorAirCellRemoval(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id = ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id);
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("no", no);
		
		map.put("ent_acidosis_ethmoidal_sinus_common_Name", ent_acidosis_ethmoidal_sinus_common.getName());
		map.put("ent_acidosis_ethmoidal_sinus_common_ClassNo", ent_acidosis_ethmoidal_sinus_common.getClassNo());
		map.put("ent_acidosis_ethmoidal_sinus_common_Date", ent_acidosis_ethmoidal_sinus_common.getDate());
		map.put("ent_acidosis_ethmoidal_sinus_common_ActionCount", ent_acidosis_ethmoidal_sinus_common.getActionCount());
		map.put("ent_acidosis_ethmoidal_sinus_common_TotalScore", ent_acidosis_ethmoidal_sinus_common.getTotalScore());
		
		map.put("ent_acidosis_ethmoidal_sinus_tools_TouchCount", ent_acidosis_ethmoidal_sinus_tools_vo.getTouchCount());
		map.put("ent_acidosis_ethmoidal_sinus_tools_ToolUseCount", ent_acidosis_ethmoidal_sinus_tools_vo.getToolUseCount());
		map.put("ent_acidosis_ethmoidal_sinus_tools_ToolInnerCount", ent_acidosis_ethmoidal_sinus_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_ethmoidal_sinus_tools_ToolTouchScore", ent_acidosis_ethmoidal_sinus_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_ethmoidal_sinus_tools_ToolViewScore", ent_acidosis_ethmoidal_sinus_tools_vo.getToolViewScore());
		map.put("ent_acidosis_ethmoidal_sinus_tools_MaxScore", ent_acidosis_ethmoidal_sinus_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_MaxScore", ent_acidosis_ethmoidal_sinus_outerbreak.getMaxScore());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Score", ent_acidosis_ethmoidal_sinus_outerbreak.getScore());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Note", ent_acidosis_ethmoidal_sinus_outerbreak.getNote());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Position", ent_acidosis_ethmoidal_sinus_outerbreak.getPosition());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Rotation", ent_acidosis_ethmoidal_sinus_outerbreak.getRotation());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Scale", ent_acidosis_ethmoidal_sinus_outerbreak.getScale());
		
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_TouchCount", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getTouchCount());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_ToolUseCount", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getToolUseCount());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_ToolInnerCount", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_ToolTouchScore", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_ToolViewScore", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getToolViewScore());
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_Tools_MaxScore", ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_points", ent_acidosis_ethmoidal_sinus_outerbreak_points); // jsp 에서 list 로 받아야함
		map.put("ent_acidosis_ethmoidal_sinus_outerbreak_target_points", ent_acidosis_ethmoidal_sinus_outerbreak_targetpoints);
		
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_MaxScore", ent_acidosis_ethmoidal_sinus_uncinectomy.getMaxScore());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Score", ent_acidosis_ethmoidal_sinus_uncinectomy.getScore());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Note", ent_acidosis_ethmoidal_sinus_uncinectomy.getNote());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_points", ent_acidosis_ethmoidal_sinus_uncinectomy.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Position", ent_acidosis_ethmoidal_sinus_uncinectomy.getPosition());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Rotation", ent_acidosis_ethmoidal_sinus_uncinectomy.getRotation());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Localcale", ent_acidosis_ethmoidal_sinus_uncinectomy.getLocalcale());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_PinCount", ent_acidosis_ethmoidal_sinus_uncinectomy.getPinCount());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Pins", ent_acidosis_ethmoidal_sinus_uncinectomy.getPins());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_TargetPins", ent_acidosis_ethmoidal_sinus_uncinectomy.getTargetPins());
		
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_TouchCount", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getTouchCount());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_ToolUseCount", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getToolUseCount());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_ToolInnerCount", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_ToolTouchScore", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_ToolViewScore", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getToolViewScore());
		map.put("ent_acidosis_ethmoidal_sinus_uncinectomy_Tools_MaxScore", ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo.getMaxScore());
		
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_MaxScore", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getMaxScore());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Score", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getScore());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Note", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getNote());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_points", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Position", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getPosition());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Rotation", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getRotation());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Localcale", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getLocalcale());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_PinCount", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getPinCount());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Pins", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getPins());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_TargetPins", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getTargetPins());
		
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_TouchCount", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getTouchCount());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_ToolUseCount", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getToolUseCount());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_ToolInnerCount", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_ToolTouchScore", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_ToolViewScore", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getToolViewScore());
		map.put("ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_Tools_MaxScore", ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo.getMaxScore());
	
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_MaxScore", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getMaxScore());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Score", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getScore());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Note", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getNote());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_points", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getPoints()); // jsp 에서 list 로 받아야함, 어떻게 써야할지 미결
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Position", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getPosition());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Rotation", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getRotation());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Localcale", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getLocalcale());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_PinCount", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getPinCount());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Pins", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getPins());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_TargetPins", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getTargetPins());
		
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_TouchCount", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getTouchCount());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_ToolUseCount", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getToolUseCount());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_ToolInnerCount", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getToolInnerCount());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_ToolTouchScore", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getToolTouchScore());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_ToolViewScore", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getToolViewScore());
		map.put("ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_Tools_MaxScore", ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo.getMaxScore());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ViewAcidosisEthmoidalSinus");
		return mav;
	}
	
	@RequestMapping(value="/ResultEvaluationTSAView", method=RequestMethod.GET)
	public ModelAndView ResultEvaluationTSAView(@RequestParam("id")int no, HttpSession session) throws Exception
	{
		EntTotalVO ent_total_vo = tsa_eval_service.getEntTotal(no);
		
		// 1. ent_tsa
		// ENTCommon / Tools / OuterBreak / Septal_Flap / Superior_Turbinate / Sella_Duramater / Tumor_Removal
		String ent_tsa_id = tsa_eval_service.getEntTsa(ent_total_vo.getID());
		EntCommonVO tsa_ent_common = tsa_eval_service.getEntCommon(ent_tsa_id);
		ToolsVO ent_tsa_tools_vo = tsa_eval_service.getTools(ent_tsa_id); // ent_tsa 의 툴 id
		
		PathTriggerVOStr ent_tsa_outerbreak = tsa_eval_service.getOuterBreak(ent_tsa_id); // 부모의 id로 자신의 id를 찾아냄
		String outer_break_id = ent_tsa_outerbreak.getID();
		ToolsVO ent_tsa_outerbreak_tools_vo = tsa_eval_service.getTools(outer_break_id);
		List<PointDataVOStr> ent_tsa_outerbreak_points = tsa_eval_service.getPoints(outer_break_id);
		
		List<PointDataVOStr> ent_tsa_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(outer_break_id);
		
		PathTriggerVOStr ent_tsa_septal_flap = tsa_eval_service.getSeptalFlap(ent_tsa_id);
		String septal_flap_id = ent_tsa_septal_flap.getID();
		ToolsVO ent_tsa_septal_flap_tools_vo = tsa_eval_service.getTools(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_points = tsa_eval_service.getPoints(septal_flap_id);
		List<PointDataVOStr> ent_tsa_septal_flap_targetpoints = tsa_eval_service.getTargetPoints(septal_flap_id);
		
		BoxTriggerVO ent_tsa_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_tsa_id);
		String ent_tsa_superior_turbinate_id = ent_tsa_superior_turbinate.getID();
		ToolsVO ent_tsa_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_tsa_superior_turbinate_id);
		
		VolumeTriggerVOStr ent_tsa_sella_duramater = tsa_eval_service.getSellaDuramater(ent_tsa_id);
		String ent_tsa_sella_duramater_id = ent_tsa_sella_duramater.getID();
		ToolsVO ent_tsa_sella_duramater_tools_vo = tsa_eval_service.getTools(ent_tsa_sella_duramater_id);
		List<PointTriggerVO> ent_tsa_sella_duramater_points = tsa_eval_service.getPointTriggers(ent_tsa_sella_duramater_id);
		
		VolumeTriggerVOStr ent_tsa_tumor_removal = tsa_eval_service.getTumorRemoval(ent_tsa_id);
		String ent_tsa_tumor_removal_id = ent_tsa_tumor_removal.getID();
		ToolsVO ent_tsa_tumor_removal_tools_vo = tsa_eval_service.getTools(ent_tsa_tumor_removal_id);
		List<PointTriggerVO> ent_tsa_tumor_removal_points = tsa_eval_service.getPointTriggers(ent_tsa_tumor_removal_id);
		
		// 2. ent_transclival_approach
		// ENTCommon / Tools / OuterBreak / Septal_Flap / Superior_Turbinate / Sella_Duramater
		String ent_transclival_approach_id = tsa_eval_service.getEntTansclivalApproach(ent_total_vo.getID());
		EntCommonVO ent_transclival_approach_common = tsa_eval_service.getEntCommon(ent_transclival_approach_id);
		ToolsVO ent_transclival_approach_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_id); 
		
		PathTriggerVOStr ent_transclival_approach_outerbreak = tsa_eval_service.getOuterBreak(ent_transclival_approach_id); 
		String ent_transclival_approach_outerbreak_id = ent_transclival_approach_outerbreak.getID();
		ToolsVO ent_transclival_approach_outerbreak_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_outerbreak_id);
		List<PointDataVOStr> ent_transclival_approach_outerbreak_points = tsa_eval_service.getPoints(ent_transclival_approach_outerbreak_id);
		List<PointDataVOStr> ent_transclival_approach_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_transclival_approach_outerbreak_id);
		
		PathTriggerVOStr ent_transclival_approach_septal_flap = tsa_eval_service.getSeptalFlap(ent_transclival_approach_id);
		String ent_transclival_approach_septal_flap_id = ent_transclival_approach_septal_flap.getID();
		ToolsVO ent_transclival_approach_septal_flap_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_septal_flap_id);
		List<PointDataVOStr> ent_transclival_approach_septal_flap_points = tsa_eval_service.getPoints(ent_transclival_approach_septal_flap_id);
		List<PointDataVOStr> ent_transclival_approach_septal_flap_targetpoints = tsa_eval_service.getTargetPoints(ent_transclival_approach_septal_flap_id);
		
		BoxTriggerVO ent_transclival_approach_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_transclival_approach_id);
		String ent_transclival_approach_superior_turbinate_id = ent_transclival_approach_superior_turbinate.getID();
		ToolsVO ent_transclival_approach_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_superior_turbinate_id);
		
		VolumeTriggerVOStr ent_transclival_approach_sella_duramater = tsa_eval_service.getSellaDuramater(ent_transclival_approach_id);
		String ent_transclival_approach_sella_duramater_id = ent_transclival_approach_sella_duramater.getID();
		ToolsVO ent_transclival_approach_sella_duramater_tools_vo = tsa_eval_service.getTools(ent_transclival_approach_sella_duramater_id);
		List<PointTriggerVO> ent_transclival_approach_sella_duramater_points = tsa_eval_service.getPointTriggers(ent_transclival_approach_sella_duramater_id);
		
		// 3. ent_acidosis_maxillary_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Superior_Turbinate
		String ent_acidosis_maxillary_sinus_id = tsa_eval_service.getEntAcidosisMaxillarySinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_maxillary_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_maxillary_sinus_id);
		ToolsVO ent_acidosis_maxillary_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_id);
		
		PathTriggerVOStr ent_acidosis_maxillary_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_maxillary_sinus_id); 
		String ent_acidosis_maxillary_sinus_outerbreak_id = ent_acidosis_maxillary_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_maxillary_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_maxillary_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_maxillary_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_maxillary_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_maxillary_sinus_outerbreak_id);
		
		VolumeTriggerVOStr ent_acidosis_maxillary_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_maxillary_sinus_id);
		String ent_acidosis_maxillary_sinus_uncinectomy_id = ent_acidosis_maxillary_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_maxillary_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_maxillary_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_maxillary_sinus_uncinectomy_id);
		
		BoxTriggerVO ent_acidosis_maxillary_sinus_superior_turbinate = tsa_eval_service.getSuperiorTurbinate(ent_acidosis_maxillary_sinus_id);
		String ent_acidosis_maxillary_sinus_superior_turbinate_id = ent_acidosis_maxillary_sinus_superior_turbinate.getID();
		ToolsVO ent_acidosis_maxillary_sinus_superior_turbinate_tools_vo = tsa_eval_service.getTools(ent_acidosis_maxillary_sinus_superior_turbinate_id);
		
		// 4. ent_acidosis_frontal_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Anterior_ethmoidectomy / Anterior_sinus
		String ent_acidosis_frontal_sinus_id = tsa_eval_service.getEntAcidosisFrontalSinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_frontal_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_frontal_sinus_id);
		ToolsVO ent_acidosis_frontal_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_id);
		
		// 4-1. ent_acidosis_frontal_sinus - outerbreak
		PathTriggerVOStr ent_acidosis_frontal_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_outerbreak_id = ent_acidosis_frontal_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_frontal_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_frontal_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_frontal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_frontal_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_frontal_sinus_outerbreak_id);
		
		// 4-2. ent_acidosis_frontal_sinus - uncinectomy
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_uncinectomy_id = ent_acidosis_frontal_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_frontal_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_uncinectomy_id);
		
		// 4-3. ent_acidosis_frontal_sinus - anterior_ethmoidectomy
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_anterior_ethmoidectomy = tsa_eval_service.getAnteriorEthmoidectomy(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id = ent_acidosis_frontal_sinus_anterior_ethmoidectomy.getID();
		ToolsVO ent_acidosis_frontal_sinus_anterior_ethmoidectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_anterior_ethmoidectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_anterior_ethmoidectomy_id);
		
		// 4-4. ent_acidosis_frontal_sinus - anterior_sinus
		VolumeTriggerVOStr ent_acidosis_frontal_sinus_anterior_sinus = tsa_eval_service.getAnteriorSinus(ent_acidosis_frontal_sinus_id);
		String ent_acidosis_frontal_sinus_anterior_sinus_id = ent_acidosis_frontal_sinus_anterior_sinus.getID();
		ToolsVO ent_acidosis_frontal_sinus_anterior_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_frontal_sinus_anterior_sinus_id);
		List<PointTriggerVO> ent_acidosis_frontal_sinus_anterior_sinus_points = tsa_eval_service.getPointTriggers(ent_acidosis_frontal_sinus_anterior_sinus_id);
		
		
		// 5. ent_acidosis_ethmoidal_sinus
		// ENTCommon / Tools / OuterBreak / Uncinectomy / Anterior_ethmoidal_air_cell_removal / Posterior_air_cell_removal
		String ent_acidosis_ethmoidal_sinus_id = tsa_eval_service.getEntAcidosisEthmoidalSinus(ent_total_vo.getID());
		EntCommonVO ent_acidosis_ethmoidal_sinus_common = tsa_eval_service.getEntCommon(ent_acidosis_ethmoidal_sinus_id);
		ToolsVO ent_acidosis_ethmoidal_sinus_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_id);
		
		// 5-1. ent_acidosis_ethmoidal_sinus - outerbreak
		PathTriggerVOStr ent_acidosis_ethmoidal_sinus_outerbreak = tsa_eval_service.getOuterBreak(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_outerbreak_id = ent_acidosis_ethmoidal_sinus_outerbreak.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_outerbreak_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_ethmoidal_sinus_outerbreak_points = tsa_eval_service.getPoints(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		List<PointDataVOStr> ent_acidosis_ethmoidal_sinus_outerbreak_targetpoints = tsa_eval_service.getTargetPoints(ent_acidosis_ethmoidal_sinus_outerbreak_id);
		
		// 5-2. ent_acidosis_ethmoidal_sinus - uncinectomy
		VolumeTriggerVOStr ent_acidosis_ethmoidal_sinus_uncinectomy = tsa_eval_service.getUncinectomy(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_uncinectomy_id = ent_acidosis_ethmoidal_sinus_uncinectomy.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_uncinectomy_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_uncinectomy_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_uncinectomy_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_uncinectomy_id);
		
		// 5-3. ent_acidosis_ethmoidal_sinus - anterior_ethmoidal_air_cell_removal
		VolumeTriggerVO ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id = ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_anterior_ethmoidal_air_cell_removal_id);
		
		// 5-4. ent_acidosis_ethmoidal_sinus - posterior_air_cell_removal
		VolumeTriggerVO ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal = tsa_eval_service.getPosteriorAirCellRemoval(ent_acidosis_ethmoidal_sinus_id);
		String ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id = ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal.getID();
		ToolsVO ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_tools_vo = tsa_eval_service.getTools(ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id);
		List<PointTriggerVO> ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_points = tsa_eval_service.getPointTriggers(ent_acidosis_ethmoidal_sinus_posterior_air_cell_removal_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("ResultEvaluationTSAView");
		return mav;
	}
	*/
	
	// os 목록
	@RequestMapping("/EvalOS")
	public ModelAndView EvalOS(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage, @RequestParam("id")String user_id) throws Exception
	{
		int count = os_eval_service.count(searchOption, keyword, user_id);
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		List<HipCommonVO> list = os_eval_service.list(start, end, searchOption, keyword, user_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);
		map.put("operType", "OS");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("EvalOS");
		return mav;
	}
	
	@RequestMapping(value="/EvalOSView", method=RequestMethod.GET)
	public ModelAndView EvalOSView(@RequestParam String id, HttpSession session) throws Exception
	{
		HipCommonVO hipcommonvo = os_eval_service.view_common(id);
		Hip01DataVOStr hip01 = os_eval_service.view(id);
		Hip02DataVOStr hip02 = os_eval_service.view2(id);
		Hip03DataVOStr hip03 = os_eval_service.view3(id);
		
		Hip04DataVOStr hip04 = os_eval_service.view4(id);
		List<Hip04PointsVOStr> hip04_points = os_eval_service.view4_points(id); // 배열로 받아야됨
		
		Hip05DataVOStr hip05 = os_eval_service.view5(id);
		List<Hip05PointsVOStr> hip05_points = os_eval_service.view5_points(id); // 배열로 받아야됨
		
		Hip06DataVOStr hip06 = os_eval_service.view6(id);
		List<Hip06PointsVOStr> hip06_points = os_eval_service.view6_points(id); // 배열로 받아야됨
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("date", hipcommonvo.getDate());
		map.put("ActionCount", hipcommonvo.getActionCount());
		map.put("totalScore", hipcommonvo.getTotalScore());
		map.put("file_name", hipcommonvo.getFile_name());
		map.put("ID", hipcommonvo.getID());
		
		map.put("hip01_positionA", hip01.getPositionA());
		map.put("hip01_rotationA", hip01.getRotationA());
		map.put("hip01_localcaleA", hip01.getLocalcaleA());
		//map.put("hip01_pinCountA", hip01.getPinCountA());
		String str_hip01_pinCountA = hip01.getPinCountA();
		String[] str_hip01_pinCnts = str_hip01_pinCountA.split(",");
		str_hip01_pinCnts[0] = str_hip01_pinCnts[0].replace("[", "");
		str_hip01_pinCnts[1] = str_hip01_pinCnts[1].replace("]", "");
		map.put("hip01_pinCountAx", str_hip01_pinCnts[0]);
		map.put("hip01_pinCountAz", str_hip01_pinCnts[1]);
		map.put("hip01_pinsA", hip01.getPinsA());
		map.put("hip01_AxResult", hip01.getAxResult());
		map.put("hip01_AzResult", hip01.getAzResult());
		map.put("hip01_positionB", hip01.getPositionB());
		map.put("hip01_rotationB", hip01.getRotationB());
		map.put("hip01_localcaleB", hip01.getLocalcaleB());
		map.put("hip01_pinCountB", hip01.getPinCountB());
		map.put("hip01_pinsB", hip01.getPinsB());
		map.put("hip01_BxResult", hip01.getBxResult());
		map.put("hip01_BzResult", hip01.getBzResult());
		
		// 각도와 각도 점수값은 3개의 값이 들어가있는데 파싱해서 각각 전달해주어야한다
		//map.put("hip01_degree", hip01.getDegree());
		String str_degree = hip01.getDegree();
		String[] str_degrees = str_degree.split(",");
		str_degrees[0] = str_degrees[0].replace("[", "");
		str_degrees[2] = str_degrees[2].replace("]", "");
		map.put("hip01_degree1", str_degrees[0]);
		map.put("hip01_degree2", str_degrees[1]);
		map.put("hip01_degree3", str_degrees[2]);
		//map.put("hip01_degreeScore", hip01.getDegreeScore());
		String str_degreeScore = hip01.getDegreeScore();
		String[] str_degreeScores = str_degreeScore.split(",");
		str_degreeScores[0] = str_degreeScores[0].replace("[", "");
		str_degreeScores[2] = str_degreeScores[2].replace("]", "");
		map.put("hip01_degreeScore1", str_degreeScores[0]);
		map.put("hip01_degreeScore2", str_degreeScores[1]);
		map.put("hip01_degreeScore3", str_degreeScores[2]);
		
		map.put("hip01_distance", hip01.getDistance());
		map.put("hip01_distanceScore", hip01.getDistanceScore());
		map.put("hip01Score", hip01.getHip01Score());
		map.put("hip01_graphAx", hip01.getGraphAx());
		map.put("hip01_graphAz", hip01.getGraphAz());
		map.put("hip01_graphBx", hip01.getGraphBx());
		map.put("hip01_graphBz", hip01.getGraphBz());
		
		map.put("hip02_positionA", hip02.getPositionA());
		map.put("hip02_rotationA", hip02.getRotationA());
		map.put("hip02_scaleA", hip02.getScaleA());
		map.put("hip02_pointsX", hip02.getPointsX());
		map.put("hip02_pointsY", hip02.getPointsY());
		map.put("hip02_pointsZ", hip02.getPointsZ());
		map.put("hip02_pointsGapX", hip02.getPointsGapX());
		map.put("hip02_pointsGapY", hip02.getPointsGapY());
		map.put("hip02_pointsGapZ", hip02.getPointsGapZ());
		map.put("hip02_pointsgapAvg", hip02.getPointsgapAvg());
		map.put("hip02_pointsgapMax", hip02.getPointsgapMax());
		map.put("hip02_cupDiatance", hip02.getCupDiatance());
		//map.put("hip02_Score", hip02.getScore()); // 거리, 각도1, 각도2 점수로 파싱해야함
		String str_score = hip02.getScore();
		String[] str_scores = str_score.split(",");
		str_scores[0] = str_scores[0].replace("[", "");
		str_scores[2] = str_scores[2].replace("]", "");
		map.put("hip02_distance_score", str_scores[0]);
		map.put("hip02_degree_score1", str_scores[1]);
		map.put("hip02_degree_score2", str_scores[2]);
		map.put("hip02_ResScore", hip02.getHip02Score());
		
		map.put("hip03_positionA", hip03.getPositionA());
		map.put("hip03_rotationA", hip03.getRotationA());
		map.put("hip03_scaleA", hip03.getScaleA());
		map.put("hip03_cupRotation", hip03.getCupRotation());
		map.put("hip03_cupPosition", hip03.getCupPosition());
		map.put("hip03_cupDiatance", hip03.getCupDiatance());
		//map.put("hip03_Score", hip03.getScore());
		String str_hip03_score = hip03.getScore();
		String[] str_hip03_scores = str_hip03_score.split(",");
		str_hip03_scores[1] = str_hip03_scores[1];
		str_hip03_scores[2] = str_hip03_scores[2].replace("]", "");
		map.put("hip03_score1", str_hip03_scores[1]);
		map.put("hip03_score2", str_hip03_scores[2]);
		map.put("hip03_ResScore", hip03.getHip03Score());
		
		map.put("hip04_positionA", hip04.getPositionA());
		map.put("hip04_rotationA", hip04.getRotationA());
		map.put("hip04_scaleA", hip04.getScaleA());
		// points 는 배열길이 만큼 출력해야됨
		map.put("hip04_points", hip04_points);
		map.put("hip04_entryPointDiatance", hip04.getEntryPointDiatance());
		map.put("hip04_degree15", hip04.getDegree15());
		map.put("hip04_pathWay", hip04.getPathWay());
		map.put("hip04_pathWayLinearX", hip04.getPathWayLinearX());
		map.put("hip04_pathWayLinearZ", hip04.getPathWayLinearZ());
		//map.put("hip04_Score", hip04.getScore());
		String str_hip04_score = hip04.getScore();
		String[] str_hip04_scores = str_hip04_score.split(",");
		str_hip04_scores[0] = str_hip04_scores[0].replace("[", "");
		str_hip04_scores[2] = str_hip04_scores[2].replace("]", "");
		map.put("hip04_score1", str_hip04_scores[0]);
		map.put("hip04_score2", str_hip04_scores[1]);
		map.put("hip04_score3", str_hip04_scores[2]);
		map.put("hip04_ResScore", hip04.getHip04Score());
		
		map.put("hip05_positionA", hip05.getPositionA());
		map.put("hip05_rotationA", hip05.getRotationA());
		map.put("hip05_scaleA", hip05.getScaleA());
		// points 는 배열길이 만큼 출력해야됨
		map.put("hip05_points", hip05_points);
		map.put("hip05_entryPointDiatance", hip05.getEntryPointDiatance());
		map.put("hip05_degree15", hip05.getDegree15());
		map.put("hip05_pathWay", hip05.getPathWay());
		map.put("hip05_pathWayLinearX", hip05.getPathWayLinearX());
		map.put("hip05_pathWayLinearZ", hip05.getPathWayLinearZ());
		map.put("hip05_Score", hip05.getScore());
		map.put("hip05_ResScore", hip05.getHip05Score());
		
		map.put("hip06_positionA", hip06.getPositionA());
		map.put("hip06_rotationA", hip06.getRotationA());
		map.put("hip06_scaleA", hip06.getScaleA());
		// points 는 배열길이 만큼 출력해야됨
		map.put("hip06_points", hip06_points);
		map.put("hip06_entryPointDiatance", hip06.getEntryPointDiatance());
		map.put("hip06_degree15", hip06.getDegree15());
		map.put("hip06_pathWay", hip06.getPathWay());
		map.put("hip06_pathWayLinearX", hip06.getPathWayLinearX());
		map.put("hip06_pathWayLinearZ", hip06.getPathWayLinearZ());
		map.put("hip06_Score", hip06.getScore());
		map.put("hip06_ResScore", hip06.getHip06Score());
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.setViewName("EvalOSView");
		return mav;
	}
	
	@RequestMapping(value="/EvalOS_RawDown", method=RequestMethod.GET)
	public void tsa_raw_download(HttpServletResponse response, @RequestParam("os_raw_id")String os_raw_id) throws Exception
	{
		String file_name = os_eval_service.getOSFilename(os_raw_id);
		System.out.println(file_name);
		
		String full_filepath = "";
		if(file_name != null) {
			full_filepath = uploadPath + file_name;
		}
		
		File file = null;
		file = new File(full_filepath);
		
		if(!file.exists()) {
			System.out.println("파일이 존재하지 않음");
		}
		
		String mime_type = URLConnection.guessContentTypeFromName(file.getName());
		if(mime_type == null) {
			System.out.println("mimetype is not detectable, will take default");
			mime_type = "application/octet-stream";
		}
		
		System.out.println("mimetype : " + mime_type);
		
		response.setContentType(mime_type);
		//response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\"")); 이 코드는 텍스를 그냥 브라우저에 읽어버린다
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));
		response.setContentLength((int)file.length());
		InputStream input_stream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(input_stream, response.getOutputStream());
	}
	
	@RequestMapping(value="/EvalOS_Recent10_Common", method=RequestMethod.GET)
	public ModelAndView EvalOS_Recent10_Common(@RequestParam("user_id") String user_id) throws Exception
	{
		List<HipCommonVO>hipcommon_10_list = os_eval_service.recent10_os_common(user_id);
		Map<String, Object> map = new HashMap<String, Object>();
		
		
		map.put("hipcommon_10_list", hipcommon_10_list);
		int[] score_list = new int[hipcommon_10_list.size()];
	
		for(int i=0; i<hipcommon_10_list.size(); i++)
		{
			score_list[i] = hipcommon_10_list.get(i).getTotalScore();
			//System.out.println(score_list[i]);
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", map);
		mav.addObject("score_list", score_list);
		mav.setViewName("EvalOS_Recent10_Common"); 
		return mav;
	}
	
	@RequestMapping(value="/EvalOS_RecentMonth_Common", method=RequestMethod.GET)
	public ModelAndView EvalOS_RecentMonth_Common(@RequestParam("user_id") String user_id) throws Exception
	{
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("user_id", user_id);
		int month = -1;
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		month = cal.get(Calendar.MONTH) + 1;
		map.put("month", month);
		List<HipCommonVO>hipcommon_month_list = os_eval_service.recent_month_os_common(map);
		// 지금 월에 대한 정보가 필요하다
		ModelAndView mav = new ModelAndView();
		mav.addObject("hipcommon_month_list", hipcommon_month_list);
		return mav;
	}
	
	// 구글 블릭키 기반 룰베이스 
	@RequestMapping(value="/EvalRuleBase", method=RequestMethod.GET)
	public ModelAndView EvalRuleBase(HttpSession session) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("EvalRuleBase");
		return mav;
	}

	
	// 이비인후과 전문가 도구 점수 편집페이지
	@RequestMapping(value="/Ent_Expert_Tools", method=RequestMethod.GET)
	public ModelAndView Ent_Expert_Tools() throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("EntExpertTools");
		return mav;
	}
	
	// 각 수술 라디오버튼 클릭할때 
	@ResponseBody
	@RequestMapping(value="/Ent_Expert_ToolsEach", method=RequestMethod.GET)
	public ResponseEntity<Object> Ent_Expert_ToolsEach(@RequestParam("oper_name")String oper_name) throws Exception
	{
		ExpertToolsVO expert_tools_vo = tsa_eval_service.getExpertTools(oper_name);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("oper_name", oper_name);
		map.put("touchCount", expert_tools_vo.getTouchCount());
		map.put("toolUseCount", expert_tools_vo.getToolUseCount());
		map.put("toolInnerCount", expert_tools_vo.getToolInnerCount());
		map.put("toolTouchScore", expert_tools_vo.getToolTouchScore());
		map.put("toolViewScore", expert_tools_vo.getToolViewScore());
		map.put("maxScore", expert_tools_vo.getMaxScore());
		
		return new ResponseEntity<Object>(map, HttpStatus.OK);
	}
	
	// 이비인후과 전문가의 도구 점수를 웹페이지로 업데이트 할 수 있게하는 함수
	@RequestMapping(value="/Ent_Expert_Tools_Update", method=RequestMethod.POST)
	public ModelAndView Ent_Expert_Tools_Update(@RequestParam("oper_name")String oper_name,
			@RequestParam("touchCount")int touchCount, @RequestParam("toolUseCount")int toolUseCount, @RequestParam("toolInnerCount")int toolInnerCount,
			@RequestParam("toolTouchScore")int toolTouchScore, @RequestParam("toolViewScore")int toolViewScore, @RequestParam("maxScore")int maxScore) throws Exception
	{
		HashMap<String, Object>map = new HashMap<String, Object>();
		map.put("oper_name", oper_name);
		map.put("touchCount", touchCount);
		map.put("toolUseCount", toolUseCount);
		map.put("toolInnerCount", toolInnerCount);
		map.put("toolTouchScore", toolTouchScore);
		map.put("toolViewScore", toolViewScore);
		map.put("maxScore", maxScore);
		
		tsa_eval_service.updateExpertTools(map);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("EntExpertTools");
		return mav;
	}
		
}
