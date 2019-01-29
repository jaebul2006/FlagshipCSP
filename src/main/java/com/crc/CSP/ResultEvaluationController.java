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
import com.crc.CSP.bean.UserBean;
import com.crc.CSP.bean.VolumeTriggerVOStr;
import com.crc.CSP.service.BoardPager;
import com.crc.CSP.service.OsEvalService;
import com.crc.CSP.service.ResultEvaluationService;
import com.crc.CSP.service.TsaEvalService;
import com.crc.CSP.service.UserService;


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
	
	@Inject
	UserService userService;
	
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
		
		UserBean user_vo = userService.user(user_id);
		
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list;
		
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = tsa_eval_service.list_every(param_map);
		}
		else {
			list = tsa_eval_service.list(param_map);
		}
		
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
		
		UserBean user_vo = userService.user(user_id);
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list;
		
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = tsa_eval_service.list_every(param_map);
		}
		else {
			list = tsa_eval_service.list(param_map);
		}
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
		
		UserBean user_vo = userService.user(user_id);
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list;
		
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = tsa_eval_service.list_every(param_map);
		}
		else {
			list = tsa_eval_service.list(param_map);
		}
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
		
		UserBean user_vo = userService.user(user_id);
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list;
		
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = tsa_eval_service.list_every(param_map);
		}
		else {
			list = tsa_eval_service.list(param_map);
		}
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
		
		UserBean user_vo = userService.user(user_id);
		HashMap<String, Object> param_map = new HashMap<String, Object>();
		param_map.put("user_id", user_id);
		param_map.put("oper_name", oper_name);
		List<EntTotalVO> list;
		
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = tsa_eval_service.list_every(param_map);
		}
		else {
			list = tsa_eval_service.list(param_map);
		}
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getPathTriggerAsmbly("outerbreak_", outerbreak, res_map);	
		res_map = getToolsAsmbly("outerbreak_Tools_", outerbreak_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", transclival_approach_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", outerbreak_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		res_map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		res_map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		res_map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		res_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		res_map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		res_map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getPathTriggerAsmbly("septalflap_", septal_flap, res_map);	
		res_map = getToolsAsmbly("septalflap_Tools_", septal_flap_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("septal_flap");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", transclival_approach_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", septal_flap_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		res_map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		res_map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		res_map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		res_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		res_map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		res_map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("sphenoid_cells_removal_", sphenoid_cells_removal, res_map);	
		res_map = getToolsAsmbly("sphenoid_cells_removal_Tools_", sphenoid_cells_removal_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("sphenoid_cells_removal");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", transclival_approach_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", sphenoid_cells_removal_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		res_map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		res_map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		res_map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		res_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		res_map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		res_map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("transclival_drilling_", transclival_drilling, res_map);	
		res_map = getToolsAsmbly("transclival_drilling_Tools_", transclival_drilling_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_approach");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("transclival_drilling");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", transclival_approach_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", transclival_drilling_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// transclival approach 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(transclival_approach_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		PathTriggerVOStr septal_flap_vo = tsa_eval_service.getSeptalFlap(transclival_approach_id);
		res_map.put("sc_septal_flap", septal_flap_vo.getScore());
		VolumeTriggerVOStr sphenoid_cells_removal_vo = tsa_eval_service.getSphenoidCellsRemoval(transclival_approach_id);
		res_map.put("sc_sphenoid_cells_removal", sphenoid_cells_removal_vo.getScore());
		VolumeTriggerVOStr transclival_drilling_vo = tsa_eval_service.getTransclivalDrilling(transclival_approach_id);
		res_map.put("sc_transclival_drilling", transclival_drilling_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		res_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		res_map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		res_map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getPathTriggerAsmbly("outerbreak_", outerbreak, res_map);	
		res_map = getToolsAsmbly("outerbreak_Tools_", outerbreak_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_maxillary_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_maxillary_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", outerbreak_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		res_map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_superior_turbinate = tsa_eval_service.getAverSuperiorTurbinate();
		res_map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("uncinectomy_", uncinectomy, res_map);	
		res_map = getToolsAsmbly("uncinectomy_Tools_", uncinectomy_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_maxillary_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_maxillary_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", uncinectomy_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		res_map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);		
		int aver_superior_turbinate = tsa_eval_service.getAverSuperiorTurbinate();
		res_map.put("aver_sc_aver_superior_turbinate", aver_superior_turbinate);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getBoxTriggerAsmbly("superior_turbinate_", superior_turbinate, res_map);	
		res_map = getToolsAsmbly("superior_turbinate_Tools_", superior_turbinate_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_maxillary_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", superior_turbinate_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_maxillary_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_maxillary_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_maxillary_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		BoxTriggerVO superior_turbinate_vo = tsa_eval_service.getSuperiorTurbinate(acidosis_maxillary_sinus_id);
		res_map.put("sc_superior_turbinate", superior_turbinate_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);		
		int aver_superior_turbinate = tsa_eval_service.getAverSuperiorTurbinate();
		res_map.put("aver_sc_aver_superior_turbinate", aver_superior_turbinate);
				
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getPathTriggerAsmbly("outerbreak_", outerbreak, res_map);	
		res_map = getToolsAsmbly("outerbreak_Tools_", outerbreak_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_frontal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", outerbreak_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidectomy = tsa_eval_service.getAverAnteriorEthmoidectomy();
		res_map.put("aver_sc_aver_anterior_ethmoidectomy", aver_anterior_ethmoidectomy);
		int aver_anterior_sinus = tsa_eval_service.getAverScoreAnteriorSinus();
		res_map.put("aver_sc_anterior_sinus", aver_anterior_sinus);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("uncinectomy_", uncinectomy, res_map);	
		res_map = getToolsAsmbly("uncinectomy_Tools_", uncinectomy_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_frontal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", uncinectomy_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidectomy = tsa_eval_service.getAverAnteriorEthmoidectomy();
		res_map.put("aver_sc_aver_anterior_ethmoidectomy", aver_anterior_ethmoidectomy);
		int aver_anterior_sinus = tsa_eval_service.getAverScoreAnteriorSinus();
		res_map.put("aver_sc_anterior_sinus", aver_anterior_sinus);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
	
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("anterior_ethmoidectomy_", anterior_ethmoidectomy, res_map);	
		res_map = getToolsAsmbly("anterior_ethmoidectomy_Tools_", anterior_ethmoidectomy_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_ethmoidectomy");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_frontal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", anterior_ethmoidectomy_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidectomy = tsa_eval_service.getAverAnteriorEthmoidectomy();
		res_map.put("aver_sc_aver_anterior_ethmoidectomy", aver_anterior_ethmoidectomy);
		int aver_anterior_sinus = tsa_eval_service.getAverScoreAnteriorSinus();
		res_map.put("aver_sc_anterior_sinus", aver_anterior_sinus);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("anterior_sinus_", anterior_sinus, res_map);	
		res_map = getToolsAsmbly("anterior_sinus_Tools_", anterior_sinus_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_frontal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_sinus");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_frontal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", anterior_sinus_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_frontal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_frontal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidectomy_vo = tsa_eval_service.getAnteriorEthmoidectomy(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_ethmoidectomy", anterior_ethmoidectomy_vo.getScore());
		VolumeTriggerVOStr anterior_sinus_vo = tsa_eval_service.getAnteriorSinus(acidosis_frontal_sinus_id);
		res_map.put("sc_anterior_sinus", anterior_sinus_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidectomy = tsa_eval_service.getAverAnteriorEthmoidectomy();
		res_map.put("aver_sc_aver_anterior_ethmoidectomy", aver_anterior_ethmoidectomy);
		int aver_anterior_sinus = tsa_eval_service.getAverScoreAnteriorSinus();
		res_map.put("aver_sc_anterior_sinus", aver_anterior_sinus);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getPathTriggerAsmbly("outerbreak_", outerbreak, res_map);	
		res_map = getToolsAsmbly("outerbreak_Tools_", outerbreak_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("outer_break");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_ethmoidal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", outerbreak_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAverScoreAnteriorEthmoidalAirCellRemoval();
		res_map.put("aver_sc_anterior_ethmoidal_air_cell_removal", aver_anterior_ethmoidal_air_cell_removal);
		int aver_posterior_air_cell_removal = tsa_eval_service.getAverScorePosteriorAirCellRemoval();
		res_map.put("aver_sc_posterior_air_cell_removal", aver_posterior_air_cell_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("uncinectomy_", uncinectomy, res_map);	
		res_map = getToolsAsmbly("uncinectomy_Tools_", uncinectomy_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("uncinectomy");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_ethmoidal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", uncinectomy_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAverScoreAnteriorEthmoidalAirCellRemoval();
		res_map.put("aver_sc_anterior_ethmoidal_air_cell_removal", aver_anterior_ethmoidal_air_cell_removal);
		int aver_posterior_air_cell_removal = tsa_eval_service.getAverScorePosteriorAirCellRemoval();
		res_map.put("aver_sc_posterior_air_cell_removal", aver_posterior_air_cell_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("anterior_ethmoidal_air_cell_removal_", anterior_ethmoidal_air_cell_removal, res_map);	
		res_map = getToolsAsmbly("anterior_ethmoidal_air_cell_removal_Tools_", anterior_ethmoidal_air_cell_removal_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("anterior_ethmoidal_air_cell_removal");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_ethmoidal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", anterior_ethmoidal_air_cell_removal_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		// acidosis_ethmoidal_sinus 각 수술단계에 공통적으로 보여지는 표와 그래프를 위해 전체 점수를 가져와야함
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAverScoreAnteriorEthmoidalAirCellRemoval();
		res_map.put("aver_sc_anterior_ethmoidal_air_cell_removal", aver_anterior_ethmoidal_air_cell_removal);
		int aver_posterior_air_cell_removal = tsa_eval_service.getAverScorePosteriorAirCellRemoval();
		res_map.put("aver_sc_posterior_air_cell_removal", aver_posterior_air_cell_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
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
		
		HashMap<String, Object> res_map = new HashMap<String, Object>();
		res_map.put("no", no);
		res_map = getCommonAsmbly("common_", common, res_map);
		res_map = getToolsAsmbly("tools_", tools_vo, res_map);
		res_map = getVolumeTriggerAsmbly("posterior_air_cell_removal_", posterior_air_cell_removal, res_map);	
		res_map = getToolsAsmbly("posterior_air_cell_removal_Tools_", posterior_air_cell_removal_tools_vo, res_map);
		ExpertToolsVO main_oper_tool_exvo = tsa_eval_service.getExpertTools("acidosis_ethmoidal_sinus");
		res_map = getExpertToolsAsmbly("mo_ex_", main_oper_tool_exvo, res_map);
		ExpertToolsVO sub_oper_tool_exvo = tsa_eval_service.getExpertTools("posterior_air_cell_removal");
		res_map = getExpertToolsAsmbly("so_ex_", sub_oper_tool_exvo, res_map);
		res_map = getAverTools("aver_mo", acidosis_ethmoidal_sinus_id, tsa_eval_service, res_map);
		res_map = getAverTools("aver_so", posterior_air_cell_removal_id, tsa_eval_service, res_map);
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		res_map = getScoreRange("Rn", rnscore_vo, res_map);
		
		PathTriggerVOStr outer_break_vo = tsa_eval_service.getOuterBreak(acidosis_ethmoidal_sinus_id); 
		res_map.put("sc_outer_break", outer_break_vo.getScore());
		VolumeTriggerVOStr uncinectomy_vo = tsa_eval_service.getUncinectomy(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_uncinectomy", uncinectomy_vo.getScore());
		VolumeTriggerVOStr anterior_ethmoidal_air_cell_removal_vo = tsa_eval_service.getAnteriorEthmoidalAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_anterior_ethmoidal_air_cell_removal", anterior_ethmoidal_air_cell_removal_vo.getScore());
		VolumeTriggerVOStr posterior_air_cell_removal_vo = tsa_eval_service.getPosteriorAirCellRemoval(acidosis_ethmoidal_sinus_id);
		res_map.put("sc_posterior_air_cell_removal", posterior_air_cell_removal_vo.getScore());
		
		// 각 단위 수술 유저 평균
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		res_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		res_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAverScoreAnteriorEthmoidalAirCellRemoval();
		res_map.put("aver_sc_anterior_ethmoidal_air_cell_removal", aver_anterior_ethmoidal_air_cell_removal);
		int aver_posterior_air_cell_removal = tsa_eval_service.getAverScorePosteriorAirCellRemoval();
		res_map.put("aver_sc_posterior_air_cell_removal", aver_posterior_air_cell_removal);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("map", res_map);
		mav.setViewName("ViewAcidosisEthmoidalSinus_PosteriorAirCellRemoval");
		return mav;
	}
	
	// 이비인후과 Common 데이터 map을 조립해서 리턴
	private HashMap<String, Object> getCommonAsmbly(String head_str, EntCommonVO common, HashMap<String, Object> map)
	{
		map.put(head_str + "Name", common.getName());
		map.put(head_str + "ClassNo", common.getClassNo());
		map.put(head_str + "Date", common.getDate());
		map.put(head_str + "ActionCount", common.getActionCount());
		map.put(head_str + "TotalScore", common.getTotalScore());
		return map;
	}
	
	private HashMap<String, Object> getToolsAsmbly(String head_str, ToolsVO tools_vo, HashMap<String, Object> map)
	{
		map.put(head_str + "TouchCount", tools_vo.getTouchCount());
		map.put(head_str + "ToolUseCount", tools_vo.getToolUseCount());
		map.put(head_str + "ToolInnerCount", tools_vo.getToolInnerCount());
		map.put(head_str + "ToolTouchScore", tools_vo.getToolTouchScore());
		map.put(head_str + "ToolViewScore", tools_vo.getToolViewScore());
		map.put(head_str + "MaxScore", tools_vo.getMaxScore());
		return map;
	}
	
	private HashMap<String, Object> getExpertToolsAsmbly(String head_str, ExpertToolsVO tools_vo, HashMap<String, Object> map)
	{
		map.put(head_str + "TouchCount", tools_vo.getTouchCount());
		map.put(head_str + "ToolUseCount", tools_vo.getToolUseCount());
		map.put(head_str + "ToolInnerCount", tools_vo.getToolInnerCount());
		map.put(head_str + "ToolTouchScore", tools_vo.getToolTouchScore());
		map.put(head_str + "ToolViewScore", tools_vo.getToolViewScore());
		map.put(head_str + "MaxScore", tools_vo.getMaxScore());
		return map;
	}
	
	private HashMap<String, Object> getVolumeTriggerAsmbly(String head_str, VolumeTriggerVOStr volume_trigger, HashMap<String, Object> map)
	{
		map.put(head_str + "MaxScore", volume_trigger.getMaxScore());
		map.put(head_str + "Score", volume_trigger.getScore());
		map.put(head_str + "Note", volume_trigger.getNote());
		map.put(head_str + "points", volume_trigger.getPoints()); 
		map.put(head_str + "Position", volume_trigger.getPosition());
		map.put(head_str + "Rotation", volume_trigger.getRotation());
		map.put(head_str + "Localcale", volume_trigger.getLocalcale());
		map.put(head_str + "PinCount", volume_trigger.getPinCount());
		map.put(head_str + "Pins", volume_trigger.getPins());
		map.put(head_str + "TargetPins", volume_trigger.getTargetPins());
		return map;
	}
	
	private HashMap<String, Object> getPathTriggerAsmbly(String head_str, PathTriggerVOStr path_trigger, HashMap<String, Object> map)
	{
		map.put(head_str + "MaxScore", path_trigger.getMaxScore());
		map.put(head_str + "Score", path_trigger.getScore());
		map.put(head_str + "Note", path_trigger.getNote());
		map.put(head_str + "Position", path_trigger.getPosition());
		map.put(head_str + "Rotation", path_trigger.getRotation());
		map.put(head_str + "Scale", path_trigger.getScale());
		return map;
	}
	
	private HashMap<String, Object> getBoxTriggerAsmbly(String head_str, BoxTriggerVO box_trigger, HashMap<String, Object> map)
	{
		map.put(head_str + "MaxScore", box_trigger.getMaxScore());
		map.put(head_str + "Score", box_trigger.getScore());
		map.put(head_str + "Note", box_trigger.getNote());
		map.put(head_str + "InnerTriggerCount", box_trigger.getInnerTriggerCount());
		map.put(head_str + "OuterTriggerCount", box_trigger.getOuterTriggerCount());
		map.put(head_str + "InnerTriggerTouchCount", box_trigger.getInnerTriggerTouchCount());
		map.put(head_str + "OuterTriggerTouchCount", box_trigger.getOuterTriggerTouchCount());
		return map;
	}
	
	private HashMap<String, Object> getAverTools(String head_str, String oper_id, TsaEvalService srv_obj, HashMap<String, Object> map) throws Exception
	{
		map.put(head_str + "TouchCount", srv_obj.getAverTouchCount(oper_id));
		map.put(head_str + "ToolUseCount", srv_obj.getAverToolUseCount(oper_id));
		map.put(head_str + "ToolInnerCount", srv_obj.getAverToolInnerCount(oper_id));
		map.put(head_str + "ToolTouchScore", srv_obj.getAverToolTouchScore(oper_id));
		map.put(head_str + "ToolViewScore", srv_obj.getAverToolViewScore(oper_id));
		map.put(head_str + "ToolMaxScore", srv_obj.getAverMaxScore(oper_id));
		return map;
	}
	
	private HashMap<String, Object> getScoreRange(String head_str, RangeScoreVO rsvo, HashMap<String, Object> map)
	{
		map.put(head_str + "0_to_50", rsvo.getRn0_to_50());
		map.put(head_str + "51_to_60", rsvo.getRn51_to_60());
		map.put(head_str + "61_to_70", rsvo.getRn61_to_70());
		map.put(head_str + "71_to_80", rsvo.getRn71_to_80());
		map.put(head_str + "81_to_90", rsvo.getRn81_to_90());
		map.put(head_str + "91_to_100", rsvo.getRn91_to_100());
		return map;
	}
	
	// os 목록
	@RequestMapping("/EvalOS")
	public ModelAndView EvalOS(@RequestParam(defaultValue="title")String searchOption, @RequestParam(defaultValue="")String keyword,
						@RequestParam(defaultValue="1")int curPage, @RequestParam("id")String user_id) throws Exception
	{
		int count = os_eval_service.count(searchOption, keyword, user_id);
		BoardPager boardPager = new BoardPager(count, curPage);
		int start = boardPager.getPageBegin();
		int end = boardPager.getPageEnd();
		
		/*
		List<HipCommonVO> list = os_eval_service.list(start, end, searchOption, keyword, user_id);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("count", count);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		map.put("boardPager", boardPager);
		map.put("operType", "OS");
		*/
		
		UserBean user_vo = userService.user(user_id);
		List<HipCommonVO> list;
		if(user_vo.getUSERTYPE().equals("TEACHER")) {
			list = os_eval_service.list_every(start, end, searchOption, keyword, user_id);
		}
		else {
			list = os_eval_service.list(start, end, searchOption, keyword, user_id);
		}
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
		int hip01_max_score = 20;
		int hip02_max_score = 25;
		int hip03_max_score = 10;
		int hip04_max_score = 15;
		int hip05_max_score = 20;
		int hip06_max_score = 10;
		
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
		
		if(str_hip01_pinCountA != null && str_hip01_pinCountA != "") {
			String[] str_hip01_pinCnts = str_hip01_pinCountA.split(",");
			str_hip01_pinCnts[0] = str_hip01_pinCnts[0].replace("[", "");
			str_hip01_pinCnts[1] = str_hip01_pinCnts[1].replace("]", "");
			map.put("hip01_pinCountAx", str_hip01_pinCnts[0]);
			map.put("hip01_pinCountAz", str_hip01_pinCnts[1]);
		}
		else {
			map.put("hip01_pinCountAx", "");
			map.put("hip01_pinCountAz", "");
		}
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
		if(str_degree != null && str_degree != "") {
			String[] str_degrees = str_degree.split(",");
			str_degrees[0] = str_degrees[0].replace("[", "");
			str_degrees[2] = str_degrees[2].replace("]", "");
			map.put("hip01_degree1", str_degrees[0]);
			map.put("hip01_degree2", str_degrees[1]);
			map.put("hip01_degree3", str_degrees[2]);
		}
		else {
			map.put("hip01_degree1", "");
			map.put("hip01_degree2", "");
			map.put("hip01_degree3", "");
		}
		//map.put("hip01_degreeScore", hip01.getDegreeScore());
		String str_degreeScore = hip01.getDegreeScore();
		if(str_degreeScore != null && str_degreeScore != "") {
			String[] str_degreeScores = str_degreeScore.split(",");
			str_degreeScores[0] = str_degreeScores[0].replace("[", "");
			str_degreeScores[2] = str_degreeScores[2].replace("]", "");
			map.put("hip01_degreeScore1", str_degreeScores[0]);
			map.put("hip01_degreeScore2", str_degreeScores[1]);
			map.put("hip01_degreeScore3", str_degreeScores[2]);
		}
		else {
			map.put("hip01_degreeScore1", "");
			map.put("hip01_degreeScore2", "");
			map.put("hip01_degreeScore3", "");
		}
		map.put("hip01_distance", hip01.getDistance());
		map.put("hip01_distanceScore", hip01.getDistanceScore());
		map.put("hip01_ResScore", hip01.getHip01Score());
		map.put("hip01_graphAx", hip01.getGraphAx());
		map.put("hip01_graphAz", hip01.getGraphAz());
		map.put("hip01_graphBx", hip01.getGraphBx());
		map.put("hip01_graphBz", hip01.getGraphBz());
		// 백분위 점수
		double hip01_100div_score = (hip01.getHip01Score() / hip01_max_score) * 100;
		map.put("hip01_100div_score", hip01_100div_score);
		map.put("hip01_max_score", hip01_max_score);
		
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
		
		String hip02_result = hip02.getResult();
		if(hip02_result != null && hip02_result != "") {
			String[] hip02_results = hip02_result.split(",");
			hip02_results[0] = hip02_results[0].replace("[", "");
			hip02_results[2] = hip02_results[2].replace("]", "");
			map.put("hip02_result1", hip02_results[0]);
			map.put("hip02_result2", hip02_results[1]);
			map.put("hip02_result3", hip02_results[2]);
		}
		else {
			map.put("hip02_result1", "");
			map.put("hip02_result2", "");
			map.put("hip02_result3", "");
		}
		
		//map.put("hip02_Score", hip02.getScore()); // 거리, 각도1, 각도2 점수로 파싱해야함
		String str_score = hip02.getScore();
		if(str_score != null && str_score != "") {
			String[] str_scores = str_score.split(",");
			str_scores[0] = str_scores[0].replace("[", "");
			str_scores[2] = str_scores[2].replace("]", "");
			map.put("hip02_distance_score", str_scores[0]);
			map.put("hip02_degree_score1", str_scores[1]);
			map.put("hip02_degree_score2", str_scores[2]);
		}
		else {
			map.put("hip02_distance_score", "");
			map.put("hip02_degree_score1", "");
			map.put("hip02_degree_score2", "");
		}
		map.put("hip02_ResScore", hip02.getHip02Score());
		// 백분위 점수
		double hip02_100div_score = (hip02.getHip02Score() / hip02_max_score) * 100;
		map.put("hip02_100div_score", hip02_100div_score);
		map.put("hip02_max_score", hip02_max_score);
		
		map.put("hip03_positionA", hip03.getPositionA());
		map.put("hip03_rotationA", hip03.getRotationA());
		map.put("hip03_scaleA", hip03.getScaleA());
		map.put("hip03_cupRotation", hip03.getCupRotation());
		map.put("hip03_cupPosition", hip03.getCupPosition());
		map.put("hip03_cupDiatance", hip03.getCupDiatance());
		
		String hip03_result = hip03.getResult();
		if(hip03_result != null && hip03_result != "") {
			String[] hip03_results = hip03_result.split(",");
			hip03_results[0] = hip03_results[0].replace("[", "");
			hip03_results[2] = hip03_results[2].replace("]", "");
			map.put("hip03_result1", hip03_results[0]);
			map.put("hip03_result2", hip03_results[1]);
			map.put("hip03_result3", hip03_results[2]);
		}
		else {
			map.put("hip03_result1", "");
			map.put("hip03_result2", "");
			map.put("hip03_result3", "");
		}
		
		//map.put("hip03_Score", hip03.getScore());
		String str_hip03_score = hip03.getScore();
		if(str_hip03_score != null && str_hip03_score != "") {
			String[] str_hip03_scores = str_hip03_score.split(",");
			str_hip03_scores[0] = str_hip03_scores[0].replace("[", "");
			str_hip03_scores[2] = str_hip03_scores[2].replace("]", "");
			map.put("hip03_score1", str_hip03_scores[0]);
			map.put("hip03_score2", str_hip03_scores[1]);
			map.put("hip03_score3", str_hip03_scores[2]);
		}
		else {
			map.put("hip03_score1", "");
			map.put("hip03_score2", "");
			map.put("hip03_score3", "");
		}
		
		map.put("hip03_ResScore", hip03.getHip03Score());
		// 백분위 점수
		double hip03_100div_score = (hip03.getHip03Score() / hip03_max_score) * 100;
		map.put("hip03_100div_score", hip03_100div_score);
		map.put("hip03_max_score", hip03_max_score);
		
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
		
		String hip04_result = hip04.getResult();
		if(hip04_result != null && hip04_result != "") {
			String[] hip04_results = hip04_result.split(",");
			hip04_results[0] = hip04_results[0].replace("[", "");
			hip04_results[2] = hip04_results[2].replace("]", "");
			map.put("hip04_result1", hip04_results[0]);
			map.put("hip04_result2", hip04_results[1]);
			map.put("hip04_result3", hip04_results[2]);
		}
		else {
			map.put("hip04_result1", "");
			map.put("hip04_result2", "");
			map.put("hip04_result3", "");
		}
		
		//map.put("hip04_Score", hip04.getScore());
		String str_hip04_score = hip04.getScore();
		if(str_hip04_score != null && str_hip04_score != "") {
			String[] str_hip04_scores = str_hip04_score.split(",");
			str_hip04_scores[0] = str_hip04_scores[0].replace("[", "");
			str_hip04_scores[2] = str_hip04_scores[2].replace("]", "");
			map.put("hip04_score1", str_hip04_scores[0]);
			map.put("hip04_score2", str_hip04_scores[1]);
			map.put("hip04_score3", str_hip04_scores[2]);
		}
		else {
			map.put("hip04_score1", "");
			map.put("hip04_score2", "");
			map.put("hip04_score3", "");
		}
		
		map.put("hip04_ResScore", hip04.getHip04Score());
		// 백분위 점수
		double hip04_100div_score = (hip04.getHip04Score() / hip04_max_score) * 100;
		map.put("hip04_100div_score", hip04_100div_score);
		map.put("hip04_max_score", hip04_max_score);
		
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
		map.put("hip05_ResScore", hip05.getHip05Score());
		
		String hip05_result = hip05.getResult();
		if(hip05_result != null && hip05_result != "") {
			String[] hip05_results = hip05_result.split(",");
			hip05_results[0] = hip05_results[0].replace("[", "");
			hip05_results[2] = hip05_results[2].replace("]", "");
			map.put("hip05_result1", hip05_results[0]);
			map.put("hip05_result2", hip05_results[1]);
			map.put("hip05_result3", hip05_results[2]);
		}
		else {
			map.put("hip05_result1", "");
			map.put("hip05_result2", "");
			map.put("hip05_result3", "");
		}
		
		// 백분위 점수
		double hip05_100div_score = (hip05.getHip05Score() / hip05_max_score) * 100;
		map.put("hip05_100div_score", hip05_100div_score);
		map.put("hip05_max_score", hip05_max_score);
		
		String str_hip05_score = hip05.getScore();
		if(str_hip05_score != null && str_hip05_score != "") {
			String[] str_hip05_scores = str_hip05_score.split(",");
			str_hip05_scores[0] = str_hip05_scores[0].replace("[", "");
			str_hip05_scores[2] = str_hip05_scores[2].replace("]", "");
			map.put("hip05_score1", str_hip05_scores[0]);
			map.put("hip05_score2", str_hip05_scores[1]);
			map.put("hip05_score3", str_hip05_scores[2]);
		}
		else {
			map.put("hip05_score1", "");
			map.put("hip05_score2", "");
			map.put("hip05_score3", "");
		}
		
		
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
		
		String hip06_result = hip06.getResult();
		if(hip06_result != null && hip06_result != "") {
			String[] hip06_results = hip06_result.split(",");
			hip06_results[0] = hip06_results[0].replace("[", "");
			hip06_results[2] = hip06_results[2].replace("]", "");
			map.put("hip06_result1", hip06_results[0]);
			map.put("hip06_result2", hip06_results[1]);
			map.put("hip06_result3", hip06_results[2]);
		}
		else {
			map.put("hip06_result1", "");
			map.put("hip06_result2", "");
			map.put("hip06_result3", "");
		}
		
		// 백분위 점수
		double hip06_100div_score = (hip06.getHip06Score() / hip06_max_score) * 100;
		map.put("hip06_100div_score", hip06_100div_score);
		map.put("hip06_max_score", hip06_max_score);
		
		String str_hip06_score = hip06.getScore();
		if(str_hip06_score != null && str_hip06_score != "") {
			String[] str_hip06_scores = str_hip06_score.split(",");
			str_hip06_scores[0] = str_hip06_scores[0].replace("[", "");
			str_hip06_scores[2] = str_hip06_scores[2].replace("]", "");
			map.put("hip06_score1", str_hip06_scores[0]);
			map.put("hip06_score2", str_hip06_scores[1]);
			map.put("hip06_score3", str_hip06_scores[2]);
		}
		else {
			map.put("hip06_score1", "");
			map.put("hip06_score2", "");
			map.put("hip06_score3", "");
		}
		
		int total_score = hipcommonvo.getTotalScore();//(int)(hip01.getHip01Score() + hip02.getHip02Score() + hip03.getHip03Score() + hip04.getHip04Score() + hip05.getHip05Score() + hip06.getHip06Score());
		map.put("total_score", total_score);
		
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
