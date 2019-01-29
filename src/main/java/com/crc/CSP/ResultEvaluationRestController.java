package com.crc.CSP;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.bean.AuthTokenVO;
import com.crc.CSP.bean.BoxTriggerVO;
import com.crc.CSP.bean.EntCommonVO;
import com.crc.CSP.bean.EntTotalVO;
import com.crc.CSP.bean.Hip01DataVO;
import com.crc.CSP.bean.Hip02DataVO;
import com.crc.CSP.bean.Hip03DataVO;
import com.crc.CSP.bean.Hip04DataVO;
import com.crc.CSP.bean.Hip05DataVO;
import com.crc.CSP.bean.Hip06DataVO;
import com.crc.CSP.bean.HipCommonVO;
import com.crc.CSP.bean.PathTriggerVO;
import com.crc.CSP.bean.RangeScoreVO;
import com.crc.CSP.bean.ToolsVO;
import com.crc.CSP.bean.VolumeTriggerVO;
import com.crc.CSP.service.AuthTokenService;
import com.crc.CSP.service.OsEvalService;
import com.crc.CSP.service.ResultEvaluationService;
import com.crc.CSP.service.TsaEvalService;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@RestController
public class ResultEvaluationRestController {

	private static final long session_time = 6000000;
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@Autowired
	private AuthTokenService authtoken_service;
	
	@Autowired
	private OsEvalService os_eval_service;
	
	@Autowired
	private TsaEvalService tsa_eval_service;
	
	// 저장된 인증키가 있는지, 시간은 만료되었는지 체크
	private AuthTokenVO ValidAuthToken(String auth_token) throws Exception
	{
		AuthTokenVO atvo;
		
		if(auth_token == null || auth_token == "") {
			atvo = null;
			return atvo;
		}
		
		// db 에 저장된 값이 있는지 확인
		atvo = authtoken_service.getAuthToken(auth_token);
		
		if(atvo != null) {
			// 인증토큰의 갱신 시간이 특정 분 보다 지났다면 return false
			// 만료된 토큰은 삭제
			System.out.println("현재시간: " + System.currentTimeMillis());
			System.out.println("생성된 시간: " + atvo.getTimeValid());
			// if 현재시간 - 설정된 시간 > 설정시간: 토큰 삭제
			//atvo = null;
			long cur_time = System.currentTimeMillis();
			long prev_time = Long.parseLong(atvo.getTimeValid());
			long elapsed_time = cur_time - prev_time;
			System.out.println("흘러간 시간: " + elapsed_time);
			
			// 세션만료
			if(elapsed_time > session_time) {
				atvo = null;
			}
		}
		return atvo;
	}
	
	@Autowired
	private ResultEvaluationService result_evaluation_service;
	
	// 한번의 수술결과를 저장
	@PostMapping(value="/restful/upload_result_evaluation")
	public ResponseEntity<Object> upload_result_evaluation(@RequestParam("uid")String uid, @RequestParam("oper_type")String oper_type,
			@RequestParam("total_score")String total_score, @RequestParam("middle_score1")String middle_score1, 
			@RequestParam("middle_score2")String middle_score2, @RequestParam("middle_score3")String middle_score3) throws Exception
	{
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(uid);
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		map.put("upload_date", ts);
		map.put("content_type", oper_type);
		map.put("total_score", total_score);
		map.put("middle_score1", middle_score1);
		map.put("middle_score2", middle_score2);
		map.put("middle_score3", middle_score3);
		map.put("username", user_id);
		result_evaluation_service.insert(map);
		
		return new ResponseEntity<Object>("finish", HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value="/restful/upd_os_evaluation", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_os_evaluation(@RequestParam("HipCommon")String HipCommon, 
			@RequestParam("Hip01Data")String Hip01Data,
			@RequestParam("Hip02Data")String Hip02Data,
			@RequestParam("Hip03Data")String Hip03Data,
			@RequestParam("Hip04Data")String Hip04Data,
			@RequestParam("Hip05Data")String Hip05Data,
			@RequestParam("Hip06Data")String Hip06Data/*,
			MultipartFile file*/) throws Exception
	{
		//System.out.println(file);
		//System.out.println("originalName: " + file.getOriginalFilename());
		//System.out.println("size: " + file.getSize());
		//System.out.println("contentType: " + file.getContentType());
		String file_name = "";
		
		/*if(file != null) {
			file_name = UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}*/
		
		Gson gson = new Gson();
		HipCommonVO hipcommonvo = new HipCommonVO();
		hipcommonvo = gson.fromJson(HipCommon, HipCommonVO.class);
		String uid = hipcommonvo.getUID();
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(uid);
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		// 해당 os 수술의 id. hipcommon과 나머지 hip01, 02, 03...공유
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		
		// 'common data'
		HashMap<String, Object>map = new HashMap<String, Object>();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		map.put("user_id", user_id);
		map.put("date", ts);
		map.put("ID", id);
		map.put("UID", uid);
		map.put("name", hipcommonvo.getName());
		map.put("classNo", hipcommonvo.getClassNo());
		map.put("ActionCount", hipcommonvo.getActionCount());
		map.put("totalScore", hipcommonvo.getTotalScore());
		map.put("file_name", file_name);
		os_eval_service.insertHipCommon(map);
		
		// 'hip01'
		Hip01DataVO hip01datavo = new Hip01DataVO();
		hip01datavo = gson.fromJson(Hip01Data, Hip01DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map2 = new HashMap<String, Object>();
		map2.put("user_id", user_id);
		map2.put("id",  id);
		map2.put("positionA",  Arrays.toString(hip01datavo.getPositionA()));
		map2.put("rotationA", Arrays.toString(hip01datavo.getRotationA()));
		map2.put("localcaleA", Arrays.toString(hip01datavo.getLocalcaleA()));
		map2.put("pinCountA", Arrays.toString(hip01datavo.getPinCountA()));
		map2.put("pinsA", Arrays.toString(hip01datavo.getPinsA()));
		map2.put("AxResult", Arrays.toString(hip01datavo.getAxResult()));
		map2.put("AzResult", Arrays.toString(hip01datavo.getAzResult()));
		map2.put("positionB", Arrays.toString(hip01datavo.getPositionB()));
		map2.put("rotationB", Arrays.toString(hip01datavo.getRotationB()));
		map2.put("localcaleB", Arrays.toString(hip01datavo.getLocalcaleB()));
		map2.put("pinCountB", Arrays.toString(hip01datavo.getPinCountB()));
		map2.put("pinsB", Arrays.toString(hip01datavo.getPinsB()));
		map2.put("BxResult", Arrays.toString(hip01datavo.getBxResult()));
		map2.put("BzResult", Arrays.toString(hip01datavo.getBzResult()));
		map2.put("degree", Arrays.toString(hip01datavo.getDegree()));
		map2.put("degreeScore", Arrays.toString(hip01datavo.getDegreeScore()));
		map2.put("distance", hip01datavo.getDistance());
		map2.put("distanceScore", hip01datavo.getDistanceScore());
		map2.put("hip01Score", hip01datavo.getHip01Score());
		map2.put("dropPoint", hip01datavo.getDropPoint());
		map2.put("maxPoint", hip01datavo.getMaxPoint());
		map2.put("isDroped", hip01datavo.getIsDroped());
		map2.put("graphAx", Arrays.toString(hip01datavo.getGraphAx()));
		map2.put("graphAz", Arrays.toString(hip01datavo.getGraphAz()));
		map2.put("graphBx", Arrays.toString(hip01datavo.getGraphBx()));
		map2.put("graphBz", Arrays.toString(hip01datavo.getGraphBz()));
		os_eval_service.insertHip01(map2);
	
		// 'hip02'
		Hip02DataVO hip02datavo = new Hip02DataVO();
		hip02datavo = gson.fromJson(Hip02Data, Hip02DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map_hip02 = new HashMap<String, Object>();
		map_hip02.put("user_id", user_id);
		map_hip02.put("id", id);
		map_hip02.put("positionA", Arrays.toString(hip02datavo.getPositionA()));
		map_hip02.put("rotationA", Arrays.toString(hip02datavo.getRotationA()));
		map_hip02.put("scaleA", Arrays.toString(hip02datavo.getScaleA()));
		map_hip02.put("pointsX", Arrays.toString(hip02datavo.getPointsX()));
		map_hip02.put("pointsY", Arrays.toString(hip02datavo.getPointsY()));
		map_hip02.put("pointsZ", Arrays.toString(hip02datavo.getPointsZ()));
		map_hip02.put("pointsGapX", Arrays.toString(hip02datavo.getPointsGapX()));
		map_hip02.put("pointsGapY", Arrays.toString(hip02datavo.getPointsGapY()));
		map_hip02.put("pointsGapZ", Arrays.toString(hip02datavo.getPointsGapZ()));
		map_hip02.put("pointsgapAvg", Arrays.toString(hip02datavo.getPointsgapAvg()));
		map_hip02.put("pointsgapMax", Arrays.toString(hip02datavo.getPointsgapMax()));
		map_hip02.put("cupDiatance", hip02datavo.getCupDiatance());
		map_hip02.put("result", Arrays.toString(hip02datavo.getResult()));
		map_hip02.put("Score", Arrays.toString(hip02datavo.getScore()));
		map_hip02.put("hip02Score", hip02datavo.getHip02Score());
		map_hip02.put("dropPoint", hip02datavo.getDropPoint());
		map_hip02.put("maxPoint", hip02datavo.getMaxPoint());
		map_hip02.put("isDroped", hip02datavo.getIsDroped());
		os_eval_service.insertHip02(map_hip02);
		
		// 'hip03'
		Hip03DataVO hip03datavo = new Hip03DataVO();
		hip03datavo = gson.fromJson(Hip03Data, Hip03DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map_hip03 = new HashMap<String, Object>();
		map_hip03.put("user_id", user_id);
		map_hip03.put("id", id);
		map_hip03.put("positionA", Arrays.toString(hip03datavo.getPositionA()));
		map_hip03.put("rotationA", Arrays.toString(hip03datavo.getRotationA()));
		map_hip03.put("scaleA", Arrays.toString(hip03datavo.getScaleA()));
		map_hip03.put("cupRotation", Arrays.toString(hip03datavo.getCupRotation()));
		map_hip03.put("cupPosition", Arrays.toString(hip03datavo.getCupPosition()));
		map_hip03.put("cupDiatance", hip03datavo.getCupDiatance());
		map_hip03.put("result", Arrays.toString(hip03datavo.getResult()));
		map_hip03.put("Score", Arrays.toString(hip03datavo.getScore()));
		map_hip03.put("hip03Score", hip03datavo.getHip03Score());
		map_hip03.put("dropPoint", hip03datavo.getDropPoint());
		map_hip03.put("maxPoint", hip03datavo.getMaxPoint());
		map_hip03.put("isDroped", hip03datavo.getIsDroped());
		os_eval_service.insertHip03(map_hip03);
		
		// 'hip04'
		Hip04DataVO hip04datavo = new Hip04DataVO();
		hip04datavo = gson.fromJson(Hip04Data, Hip04DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map_hip04 = new HashMap<String, Object>();
		map_hip04.put("user_id", user_id);
		map_hip04.put("id", id);
		map_hip04.put("positionA", Arrays.toString(hip04datavo.getPositionA()));
		map_hip04.put("rotationA", Arrays.toString(hip04datavo.getRotationA()));
		map_hip04.put("scaleA", Arrays.toString(hip04datavo.getScaleA()));
		map_hip04.put("entryPointDiatance", hip04datavo.getEntryPointDiatance());
		map_hip04.put("degree15", hip04datavo.getDegree15());
		map_hip04.put("pathWay", hip04datavo.getPathWay());
		map_hip04.put("pathWayLinearX", Arrays.toString(hip04datavo.getPathWayLinearX()));
		map_hip04.put("pathWayLinearZ", Arrays.toString(hip04datavo.getPathWayLinearZ()));
		map_hip04.put("result", Arrays.toString(hip04datavo.getResult()));
		map_hip04.put("Score", Arrays.toString(hip04datavo.getScore()));
		map_hip04.put("hip04Score", hip04datavo.getHip04Score());
		map_hip04.put("dropPoint", hip04datavo.getDropPoint());
		map_hip04.put("maxPoint", hip04datavo.getMaxPoint());
		map_hip04.put("isDroped", hip04datavo.getIsDroped());
		os_eval_service.insertHip04(map_hip04);
		
		// 'hip04 points'
		int hip04point_array_cnt = hip04datavo.getPoints().length;
		for(int i=0; i<hip04point_array_cnt; i++)
		{
			//System.out.println("배열스트링상태: " + Arrays.toString(hip04datavo.getPoints()[i].getPositionA()) + "//" + Arrays.toString(hip04datavo.getPoints()[i].getRotationA()));
			HashMap<String, Object>map_hip04points = new HashMap<String, Object>();
			map_hip04points.put("user_id", user_id);
			map_hip04points.put("id", id);
			map_hip04points.put("positionA", Arrays.toString(hip04datavo.getPoints()[i].getPositionA()));
			map_hip04points.put("rotationA", Arrays.toString(hip04datavo.getPoints()[i].getRotationA()));
			os_eval_service.insertHip04Points(map_hip04points);
		}
		
		/*
		String hip04points_str = Arrays.toString(hip04datavo.getPoints());
		Hip04PointsVO hip04pointsvo = new Hip04PointsVO();
		hip04pointsvo = gson.fromJson(hip04points_str, Hip04PointsVO.class);
		HashMap<String, Object>map_hip04points = new HashMap<String, Object>();
		map_hip04points.put("user_id", user_id);
		map_hip04points.put("id", id);
		map_hip04points.put("positionA", Arrays.toString(hip04pointsvo.getPositionA()));
		map_hip04points.put("rotationA", Arrays.toString(hip04pointsvo.getRotationA()));
		os_eval_service.insertHip04Points(map_hip04points);
		*/
		
		// 'hip05'
		Hip05DataVO hip05datavo = new Hip05DataVO();
		hip05datavo = gson.fromJson(Hip05Data, Hip05DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map_hip05 = new HashMap<String, Object>();
		map_hip05.put("user_id", user_id);
		map_hip05.put("id", id);
		map_hip05.put("positionA", Arrays.toString(hip05datavo.getPositionA()));
		map_hip05.put("rotationA", Arrays.toString(hip05datavo.getRotationA()));
		map_hip05.put("scaleA", Arrays.toString(hip05datavo.getScaleA()));
		map_hip05.put("entryPointDiatance", hip05datavo.getEntryPointDiatance());
		map_hip05.put("degree15", hip05datavo.getDegree15());
		map_hip05.put("pathWay", hip05datavo.getPathWay());
		map_hip05.put("pathWayLinearX", Arrays.toString(hip05datavo.getPathWayLinearX()));
		map_hip05.put("pathWayLinearZ", Arrays.toString(hip05datavo.getPathWayLinearZ()));
		map_hip05.put("Score", Arrays.toString(hip05datavo.getScore()));
		map_hip05.put("result", Arrays.toString(hip05datavo.getResult()));
		map_hip05.put("hip05Score", hip05datavo.getHip05Score());
		map_hip05.put("dropPoint", hip05datavo.getDropPoint());
		map_hip05.put("maxPoint", hip05datavo.getMaxPoint());
		map_hip05.put("isDroped", hip05datavo.getIsDroped());
		os_eval_service.insertHip05(map_hip05);
		
		// 'hip05 points'
		int hip05point_array_cnt = hip05datavo.getPoints().length;
		for(int i=0; i<hip05point_array_cnt; i++)
		{
			//System.out.println("배열스트링상태: " + Arrays.toString(hip04datavo.getPoints()[i].getPositionA()) + "//" + Arrays.toString(hip04datavo.getPoints()[i].getRotationA()));
			HashMap<String, Object>map_hip05points = new HashMap<String, Object>();
			map_hip05points.put("user_id", user_id);
			map_hip05points.put("id", id);
			map_hip05points.put("positionA", Arrays.toString(hip05datavo.getPoints()[i].getPositionA()));
			map_hip05points.put("rotationA", Arrays.toString(hip05datavo.getPoints()[i].getRotationA()));
			os_eval_service.insertHip05Points(map_hip05points);
		}
		
		// 'hip06'
		Hip06DataVO hip06datavo = new Hip06DataVO();
		hip06datavo = gson.fromJson(Hip06Data, Hip06DataVO.class);
		// 데이터 object -> string
		HashMap<String, Object>map_hip06 = new HashMap<String, Object>();
		map_hip06.put("user_id", user_id);
		map_hip06.put("id", id);
		map_hip06.put("positionA", Arrays.toString(hip06datavo.getPositionA()));
		map_hip06.put("rotationA", Arrays.toString(hip06datavo.getRotationA()));
		map_hip06.put("scaleA", Arrays.toString(hip06datavo.getScaleA()));
		map_hip06.put("entryPointDiatance", hip06datavo.getEntryPointDiatance());
		map_hip06.put("degree15", hip06datavo.getDegree15());
		map_hip06.put("pathWay", hip06datavo.getPathWay());
		map_hip06.put("pathWayLinearX", Arrays.toString(hip06datavo.getPathWayLinearX()));
		map_hip06.put("pathWayLinearZ", Arrays.toString(hip06datavo.getPathWayLinearZ()));
		map_hip06.put("Score", Arrays.toString(hip06datavo.getScore()));
		map_hip06.put("result", Arrays.toString(hip06datavo.getResult()));
		map_hip06.put("hip06Score", hip06datavo.getHip06Score());
		map_hip06.put("dropPoint", hip06datavo.getDropPoint());
		map_hip06.put("maxPoint", hip06datavo.getMaxPoint());
		map_hip06.put("isDroped", hip06datavo.getIsDroped());
		os_eval_service.insertHip06(map_hip06);
		
		// 'hip06 points'
		int hip06point_array_cnt = hip06datavo.getPoints().length;
		for(int i=0; i<hip06point_array_cnt; i++)
		{
			//System.out.println("배열스트링상태: " + Arrays.toString(hip04datavo.getPoints()[i].getPositionA()) + "//" + Arrays.toString(hip04datavo.getPoints()[i].getRotationA()));
			HashMap<String, Object>map_hip06points = new HashMap<String, Object>();
			map_hip06points.put("user_id", user_id);
			map_hip06points.put("id", id);
			map_hip06points.put("positionA", Arrays.toString(hip06datavo.getPoints()[i].getPositionA()));
			map_hip06points.put("rotationA", Arrays.toString(hip06datavo.getPoints()[i].getRotationA()));
			os_eval_service.insertHip06Points(map_hip06points);
		}
		
			
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	
	// ent common 삽입함수
	@Transactional
	private void InsertEntCommon(String pid, EntCommonVO vo, Timestamp ts) throws Exception
	{
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ID", UUID.randomUUID().toString());
		map.put("UID", vo.getUID());
		map.put("pid", pid);
		String krname = vo.getName();
		String krname2 = new String(krname.getBytes("8859_1"), "UTF-8");
		map.put("name", krname2);
		map.put("classNo", vo.getClassNo());
		map.put("date", ts);
		map.put("ActionCount", vo.getActionCount());
		map.put("totalScore", vo.getTotalScore());
		tsa_eval_service.insertEntCommon(map);
	}
	
	@Transactional
	private void InsertTools(String parsing_str, String pid) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement ToolsElement = parser.parse(parsing_str).getAsJsonObject().get("tools");
		ToolsVO toolsvo = gson.fromJson(ToolsElement, ToolsVO.class); 
		HashMap<String, Object> tools_map = new HashMap<String, Object>();
		tools_map.put("ID", UUID.randomUUID().toString());
		tools_map.put("pid", pid);
		tools_map.put("touchCount", toolsvo.getTouchCount());
		tools_map.put("toolUseCount", toolsvo.getToolUseCount());
		tools_map.put("toolInnerCount", toolsvo.getToolInnerCount());
		tools_map.put("toolTouchScore", toolsvo.getToolTouchScore());
		tools_map.put("toolViewScore", toolsvo.getToolViewScore());
		tools_map.put("maxScore", toolsvo.getMaxScore());
		tsa_eval_service.insertTools(tools_map);
	}
	
	@Transactional
	private void InsertOuterBreak(String parsing_str, String pid, String oper_name) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement pathTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		PathTriggerVO path_trigger_vo = gson.fromJson(pathTriggerElement, PathTriggerVO.class);
		HashMap<String, Object> path_trigger_map = new HashMap<String, Object>();
		String path_trigger_id = UUID.randomUUID().toString();
		path_trigger_map.put("ID", path_trigger_id);
		path_trigger_map.put("pid", pid);
		
		path_trigger_map.put("stepScore", path_trigger_vo.getStepScore());
		path_trigger_map.put("maxScore", path_trigger_vo.getMaxScore());
		path_trigger_map.put("score", path_trigger_vo.getScore());
		path_trigger_map.put("note", path_trigger_vo.getNote());
		path_trigger_map.put("position", Arrays.toString(path_trigger_vo.getPosition()));
		path_trigger_map.put("rotation", Arrays.toString(path_trigger_vo.getRotation()));
		path_trigger_map.put("scale", Arrays.toString(path_trigger_vo.getScale()));
		tsa_eval_service.insertOuterBreak(path_trigger_map);
		
		JsonElement pathTriggerToolsElement = pathTriggerElement.getAsJsonObject().get("tools");
		ToolsVO pathtrigger_toolsvo = gson.fromJson(pathTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>pathtrigger_tools_map = new HashMap<String, Object>();
		pathtrigger_tools_map.put("ID", UUID.randomUUID().toString());
		pathtrigger_tools_map.put("pid", path_trigger_id);
		pathtrigger_tools_map.put("touchCount", pathtrigger_toolsvo.getTouchCount());
		pathtrigger_tools_map.put("toolUseCount", pathtrigger_toolsvo.getToolUseCount());
		pathtrigger_tools_map.put("toolInnerCount", pathtrigger_toolsvo.getToolInnerCount());
		pathtrigger_tools_map.put("toolTouchScore", pathtrigger_toolsvo.getToolTouchScore());
		pathtrigger_tools_map.put("toolViewScore", pathtrigger_toolsvo.getToolViewScore());
		pathtrigger_tools_map.put("maxScore", pathtrigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(pathtrigger_tools_map);
		
		int points_array_cnt = path_trigger_vo.getPoints().length;
		for(int i=0; i<points_array_cnt; i++)
		{
			HashMap<String, Object> map_point = new HashMap<String, Object>();
			map_point.put("id", UUID.randomUUID().toString());
			map_point.put("pid", path_trigger_id);
			map_point.put("positionA", Arrays.toString(path_trigger_vo.getPoints()[i].getPositionA()));
			map_point.put("rotationA", Arrays.toString(path_trigger_vo.getPoints()[i].getRotationA()));
			tsa_eval_service.insertPoints(map_point);
		}
		
		int pathpoints_array_cnt = path_trigger_vo.getPathPoints().length;
		for(int i=0; i<pathpoints_array_cnt; i++)
		{
			HashMap<String, Object> map_pathpoint = new HashMap<String, Object>();
			map_pathpoint.put("id", UUID.randomUUID().toString());
			map_pathpoint.put("pid", path_trigger_id);
			map_pathpoint.put("positionA", Arrays.toString(path_trigger_vo.getPathPoints()[i].getPositionA()));
			map_pathpoint.put("rotationA", Arrays.toString(path_trigger_vo.getPathPoints()[i].getRotationA()));
			tsa_eval_service.insertPathPoints(map_pathpoint);
		}
		
		int targetpoints_array_cnt = path_trigger_vo.getTargetPoints().length;
		for(int i=0; i<targetpoints_array_cnt; i++)
		{
			HashMap<String, Object> map_targetpoint = new HashMap<String, Object>();
			map_targetpoint.put("id", UUID.randomUUID().toString());
			map_targetpoint.put("pid", path_trigger_id);
			map_targetpoint.put("positionA", Arrays.toString(path_trigger_vo.getTargetPoints()[i].getPositionA()));
			map_targetpoint.put("rotationA", Arrays.toString(path_trigger_vo.getTargetPoints()[i].getRotationA()));
			tsa_eval_service.insertTargetPoints(map_targetpoint);
		}
	}
	
	@Transactional
	private void InsertSeptalFlap(String parsing_str, String pid, String oper_name) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement pathTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		PathTriggerVO path_trigger_vo = gson.fromJson(pathTriggerElement, PathTriggerVO.class);
		HashMap<String, Object> path_trigger_map = new HashMap<String, Object>();
		String path_trigger_id = UUID.randomUUID().toString();
		path_trigger_map.put("ID", path_trigger_id);
		path_trigger_map.put("pid", pid);
		path_trigger_map.put("stepScore", path_trigger_vo.getStepScore());
		path_trigger_map.put("maxScore", path_trigger_vo.getMaxScore());
		path_trigger_map.put("score", path_trigger_vo.getScore());
		path_trigger_map.put("note", path_trigger_vo.getNote());
		path_trigger_map.put("position", Arrays.toString(path_trigger_vo.getPosition()));
		path_trigger_map.put("rotation", Arrays.toString(path_trigger_vo.getRotation()));
		path_trigger_map.put("scale", Arrays.toString(path_trigger_vo.getScale()));
		tsa_eval_service.insertSeptalFlap(path_trigger_map);
		
		JsonElement pathTriggerToolsElement = pathTriggerElement.getAsJsonObject().get("tools");
		ToolsVO pathtrigger_toolsvo = gson.fromJson(pathTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>pathtrigger_tools_map = new HashMap<String, Object>();
		pathtrigger_tools_map.put("ID", UUID.randomUUID().toString());
		pathtrigger_tools_map.put("pid", path_trigger_id);
		pathtrigger_tools_map.put("touchCount", pathtrigger_toolsvo.getTouchCount());
		pathtrigger_tools_map.put("toolUseCount", pathtrigger_toolsvo.getToolUseCount());
		pathtrigger_tools_map.put("toolInnerCount", pathtrigger_toolsvo.getToolInnerCount());
		pathtrigger_tools_map.put("toolTouchScore", pathtrigger_toolsvo.getToolTouchScore());
		pathtrigger_tools_map.put("toolViewScore", pathtrigger_toolsvo.getToolViewScore());
		pathtrigger_tools_map.put("maxScore", pathtrigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(pathtrigger_tools_map);
		
		int points_array_cnt = path_trigger_vo.getPoints().length;
		for(int i=0; i<points_array_cnt; i++)
		{
			HashMap<String, Object> map_point = new HashMap<String, Object>();
			map_point.put("id", UUID.randomUUID().toString());
			map_point.put("pid", path_trigger_id);
			map_point.put("positionA", Arrays.toString(path_trigger_vo.getPoints()[i].getPositionA()));
			map_point.put("rotationA", Arrays.toString(path_trigger_vo.getPoints()[i].getRotationA()));
			tsa_eval_service.insertPoints(map_point);
		}
		
		int pathpoints_array_cnt = path_trigger_vo.getPathPoints().length;
		for(int i=0; i<pathpoints_array_cnt; i++)
		{
			HashMap<String, Object> map_pathpoint = new HashMap<String, Object>();
			map_pathpoint.put("id", UUID.randomUUID().toString());
			map_pathpoint.put("pid", path_trigger_id);
			map_pathpoint.put("positionA", Arrays.toString(path_trigger_vo.getPathPoints()[i].getPositionA()));
			map_pathpoint.put("rotationA", Arrays.toString(path_trigger_vo.getPathPoints()[i].getRotationA()));
			tsa_eval_service.insertPathPoints(map_pathpoint);
		}
		
		int targetpoints_array_cnt = path_trigger_vo.getTargetPoints().length;
		for(int i=0; i<targetpoints_array_cnt; i++)
		{
			HashMap<String, Object> map_targetpoint = new HashMap<String, Object>();
			map_targetpoint.put("id", UUID.randomUUID().toString());
			map_targetpoint.put("pid", path_trigger_id);
			map_targetpoint.put("positionA", Arrays.toString(path_trigger_vo.getTargetPoints()[i].getPositionA()));
			map_targetpoint.put("rotationA", Arrays.toString(path_trigger_vo.getTargetPoints()[i].getRotationA()));
			tsa_eval_service.insertTargetPoints(map_targetpoint);
		}
	}
	
	
	@Transactional
	private void InsertSuperiorTurbinate(String parsing_str, String pid, String oper_name) throws Exception // Box Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement boxTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		BoxTriggerVO boxtrigger_vo = gson.fromJson(boxTriggerElement, BoxTriggerVO.class);
		HashMap<String, Object> boxtrigger_map = new HashMap<String, Object>();
		String boxtrigger_id = UUID.randomUUID().toString();
		boxtrigger_map.put("ID", boxtrigger_id);
		boxtrigger_map.put("pid", pid);
		boxtrigger_map.put("stepScore", boxtrigger_vo.getStepScore());
		boxtrigger_map.put("maxScore", boxtrigger_vo.getMaxScore());
		boxtrigger_map.put("score", boxtrigger_vo.getScore());
		boxtrigger_map.put("note", boxtrigger_vo.getNote());
		boxtrigger_map.put("innerTriggerCount", boxtrigger_vo.getInnerTriggerCount());
		boxtrigger_map.put("outerTriggerCount", boxtrigger_vo.getOuterTriggerCount());
		boxtrigger_map.put("innerTriggerTouchCount", boxtrigger_vo.getInnerTriggerTouchCount());
		boxtrigger_map.put("outerTriggerTouchCount", boxtrigger_vo.getOuterTriggerTouchCount());
		tsa_eval_service.insertSuperiorTurbinate(boxtrigger_map);
		
		JsonElement boxTriggerToolsElement = boxTriggerElement.getAsJsonObject().get("tools");
		ToolsVO boxTrigger_toolsvo = gson.fromJson(boxTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>boxTrigger_tools_map = new HashMap<String, Object>();
		boxTrigger_tools_map.put("ID", UUID.randomUUID().toString());
		boxTrigger_tools_map.put("pid", boxtrigger_id);
		boxTrigger_tools_map.put("touchCount", boxTrigger_toolsvo.getTouchCount());
		boxTrigger_tools_map.put("toolUseCount", boxTrigger_toolsvo.getToolUseCount());
		boxTrigger_tools_map.put("toolInnerCount", boxTrigger_toolsvo.getToolInnerCount());
		boxTrigger_tools_map.put("toolTouchScore", boxTrigger_toolsvo.getToolTouchScore());
		boxTrigger_tools_map.put("toolViewScore", boxTrigger_toolsvo.getToolViewScore());
		boxTrigger_tools_map.put("maxScore", boxTrigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(boxTrigger_tools_map);
	}
	
	@Transactional
	private void InsertSphenoidCellsRemoval(String parsing_str, String pid, String oper_name) throws Exception 
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertSphenoidCellsRemoval(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertSellaDuramater(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertSellaDuramater(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
		
	@Transactional
	private void InsertTransclivalDrilling(String parsing_str, String pid, String oper_name) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertTransclivalDrilling(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertTumorRemoval(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertTumorRemoval(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertUncinectomy(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertUncinectomy(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertAnteriorEthmoidectomy(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertAnteriorEthmoidectomy(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertAnteriorSinus(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertAnteriorSinus(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertAnteriorEthmoidalAirCellRemoval(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertAnteriorEthmoidalAirCellRemoval(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	@Transactional
	private void InsertPosteriorAirCellRemoval(String parsing_str, String pid, String oper_name) throws Exception // Volume Trigger
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement volumeTriggerElement = parser.parse(parsing_str).getAsJsonObject().get(oper_name);
		VolumeTriggerVO volume_trigger_vo = gson.fromJson(volumeTriggerElement, VolumeTriggerVO.class);
		HashMap<String, Object> volume_trigger_map = new HashMap<String, Object>();
		String volume_trigger_id = UUID.randomUUID().toString();
		volume_trigger_map.put("ID", volume_trigger_id);
		volume_trigger_map.put("pid", pid);
		volume_trigger_map.put("stepScore", volume_trigger_vo.getStepScore());
		volume_trigger_map.put("maxScore", volume_trigger_vo.getMaxScore());
		volume_trigger_map.put("score", volume_trigger_vo.getScore());
		volume_trigger_map.put("note", volume_trigger_vo.getNote());
		volume_trigger_map.put("position", Arrays.toString(volume_trigger_vo.getPosition()));
		volume_trigger_map.put("rotation", Arrays.toString(volume_trigger_vo.getRotation()));
		volume_trigger_map.put("localcale", Arrays.toString(volume_trigger_vo.getLocalcale()));
		volume_trigger_map.put("pinCount", Arrays.toString(volume_trigger_vo.getPinCount()));
		volume_trigger_map.put("pins", Arrays.toString(volume_trigger_vo.getPins()));
		volume_trigger_map.put("targetPins", Arrays.toString(volume_trigger_vo.getTargetPins()));
		tsa_eval_service.insertPosteriorAirCellRemoval(volume_trigger_map);
		
		JsonElement volumeTriggerToolsElement = volumeTriggerElement.getAsJsonObject().get("tools");
		ToolsVO volume_trigger_toolsvo = gson.fromJson(volumeTriggerToolsElement, ToolsVO.class);
		HashMap<String, Object>volume_trigger_tools_map = new HashMap<String, Object>();
		volume_trigger_tools_map.put("ID", UUID.randomUUID().toString());
		volume_trigger_tools_map.put("pid", volume_trigger_id);
		volume_trigger_tools_map.put("touchCount", volume_trigger_toolsvo.getTouchCount());
		volume_trigger_tools_map.put("toolUseCount", volume_trigger_toolsvo.getToolUseCount());
		volume_trigger_tools_map.put("toolInnerCount", volume_trigger_toolsvo.getToolInnerCount());
		volume_trigger_tools_map.put("toolTouchScore", volume_trigger_toolsvo.getToolTouchScore());
		volume_trigger_tools_map.put("toolViewScore", volume_trigger_toolsvo.getToolViewScore());
		volume_trigger_tools_map.put("maxScore", volume_trigger_toolsvo.getMaxScore());
		tsa_eval_service.insertTools(volume_trigger_tools_map);
		
		int volume_trigger_points_array_cnt = volume_trigger_vo.getPoints().length;
		for(int i=0; i<volume_trigger_points_array_cnt; i++)
		{
			HashMap<String, Object> map_volume_trigger_point = new HashMap<String, Object>();
			map_volume_trigger_point.put("id", UUID.randomUUID().toString());
			map_volume_trigger_point.put("pid", volume_trigger_id);
			map_volume_trigger_point.put("deduction", volume_trigger_vo.getPoints()[i].getDeduction());
			map_volume_trigger_point.put("failure", volume_trigger_vo.getPoints()[i].getFailure());
			map_volume_trigger_point.put("name", volume_trigger_vo.getPoints()[i].getName());
			tsa_eval_service.insertPointTrigger(map_volume_trigger_point);
		}
	}
	
	// ent 5 단계 수술 점수 단계의 통계를 리턴
	@Transactional
	@PostMapping(value="/restful/ent_stats")
	public ResponseEntity<Object> ent_stats(@RequestParam("uid")String uid) throws Exception
	{
		AuthTokenVO atvo = ValidAuthToken(uid);
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		
		HashMap<String, Object>param_map = new HashMap<String, Object>();
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		param_map.put("min", 0);
		param_map.put("max", 20);
		int cnt_0to20 = tsa_eval_service.getEntTsaScoreRange(param_map);
		param_map.put("min", 21);
		param_map.put("max", 40);
		int cnt_21to40 = tsa_eval_service.getEntTsaScoreRange(param_map);
		param_map.put("min", 41);
		param_map.put("max", 60);
		int cnt_41to60 = tsa_eval_service.getEntTsaScoreRange(param_map);
		param_map.put("min", 61);
		param_map.put("max", 80);
		int cnt_61to80 = tsa_eval_service.getEntTsaScoreRange(param_map);
		param_map.put("min", 81);
		param_map.put("max", 100);
		int cnt_81to100 = tsa_eval_service.getEntTsaScoreRange(param_map);
		ret_map.put("tsa_0to20", cnt_0to20);
		ret_map.put("tsa_21to40", cnt_21to40);
		ret_map.put("tsa_41to60", cnt_41to60);
		ret_map.put("tsa_61to80", cnt_61to80);
		ret_map.put("tsa_81to100", cnt_81to100);
		
		param_map.put("min", 0);
		param_map.put("max", 20);
		int transclival_approach_cnt_0to20 = tsa_eval_service.getEntTransclivalApproachScoreRange(param_map);
		param_map.put("min", 21);
		param_map.put("max", 40);
		int transclival_approach_cnt_21to40 = tsa_eval_service.getEntTransclivalApproachScoreRange(param_map);
		param_map.put("min", 41);
		param_map.put("max", 60);
		int transclival_approach_cnt_41to60 = tsa_eval_service.getEntTransclivalApproachScoreRange(param_map);
		param_map.put("min", 61);
		param_map.put("max", 80);
		int transclival_approach_cnt_61to80 = tsa_eval_service.getEntTransclivalApproachScoreRange(param_map);
		param_map.put("min", 81);
		param_map.put("max", 100);
		int transclival_approach_cnt_81to100 = tsa_eval_service.getEntTransclivalApproachScoreRange(param_map);
		ret_map.put("transclival_approach_0to20", transclival_approach_cnt_0to20);
		ret_map.put("transclival_approach_21to40", transclival_approach_cnt_21to40);
		ret_map.put("transclival_approach_41to60", transclival_approach_cnt_41to60);
		ret_map.put("transclival_approach_61to80", transclival_approach_cnt_61to80);
		ret_map.put("transclival_approach_81to100", transclival_approach_cnt_81to100);
		
		param_map.put("min", 0);
		param_map.put("max", 20);
		int acidosis_maxillary_sinus_cnt_0to20 = tsa_eval_service.getEntAcidosisMaxillarySinusScoreRange(param_map);
		param_map.put("min", 21);
		param_map.put("max", 40);
		int acidosis_maxillary_sinus_cnt_21to40 = tsa_eval_service.getEntAcidosisMaxillarySinusScoreRange(param_map);
		param_map.put("min", 41);
		param_map.put("max", 60);
		int acidosis_maxillary_sinus_cnt_41to60 = tsa_eval_service.getEntAcidosisMaxillarySinusScoreRange(param_map);
		param_map.put("min", 61);
		param_map.put("max", 80);
		int acidosis_maxillary_sinus_cnt_61to80 = tsa_eval_service.getEntAcidosisMaxillarySinusScoreRange(param_map);
		param_map.put("min", 81);
		param_map.put("max", 100);
		int acidosis_maxillary_sinus_cnt_81to100 = tsa_eval_service.getEntAcidosisMaxillarySinusScoreRange(param_map);
		ret_map.put("acidosis_maxillary_sinus_0to20", acidosis_maxillary_sinus_cnt_0to20);
		ret_map.put("acidosis_maxillary_sinus_21to40", acidosis_maxillary_sinus_cnt_21to40);
		ret_map.put("acidosis_maxillary_sinus_41to60", acidosis_maxillary_sinus_cnt_41to60);
		ret_map.put("acidosis_maxillary_sinus_61to80", acidosis_maxillary_sinus_cnt_61to80);
		ret_map.put("acidosis_maxillary_sinus_81to100", acidosis_maxillary_sinus_cnt_81to100);
		
		param_map.put("min", 0);
		param_map.put("max", 20);
		int acidosis_frontal_sinus_cnt_0to20 = tsa_eval_service.getEntAcidosisFrontalSinusScoreRange(param_map);
		param_map.put("min", 21);
		param_map.put("max", 40);
		int acidosis_frontal_sinus_cnt_21to40 = tsa_eval_service.getEntAcidosisFrontalSinusScoreRange(param_map);
		param_map.put("min", 41);
		param_map.put("max", 60);
		int acidosis_frontal_sinus_cnt_41to60 = tsa_eval_service.getEntAcidosisFrontalSinusScoreRange(param_map);
		param_map.put("min", 61);
		param_map.put("max", 80);
		int acidosis_frontal_sinus_cnt_61to80 = tsa_eval_service.getEntAcidosisFrontalSinusScoreRange(param_map);
		param_map.put("min", 81);
		param_map.put("max", 100);
		int acidosis_frontal_sinus_cnt_81to100 = tsa_eval_service.getEntAcidosisFrontalSinusScoreRange(param_map);
		ret_map.put("acidosis_frontal_sinus_0to20", acidosis_frontal_sinus_cnt_0to20);
		ret_map.put("acidosis_frontal_sinus_21to40", acidosis_frontal_sinus_cnt_21to40);
		ret_map.put("acidosis_frontal_sinus_41to60", acidosis_frontal_sinus_cnt_41to60);
		ret_map.put("acidosis_frontal_sinus_61to80", acidosis_frontal_sinus_cnt_61to80);
		ret_map.put("acidosis_frontal_sinus_81to100", acidosis_frontal_sinus_cnt_81to100);
		
		param_map.put("min", 0);
		param_map.put("max", 20);
		int acidosis_ethmoidal_sinus_cnt_0to20 = tsa_eval_service.getEntAcidosisEthmoidalSinusScoreRange(param_map);
		param_map.put("min", 21);
		param_map.put("max", 40);
		int acidosis_ethmoidal_sinus_cnt_21to40 = tsa_eval_service.getEntAcidosisEthmoidalSinusScoreRange(param_map);
		param_map.put("min", 41);
		param_map.put("max", 60);
		int acidosis_ethmoidal_sinus_cnt_41to60 = tsa_eval_service.getEntAcidosisEthmoidalSinusScoreRange(param_map);
		param_map.put("min", 61);
		param_map.put("max", 80);
		int acidosis_ethmoidal_sinus_cnt_61to80 = tsa_eval_service.getEntAcidosisEthmoidalSinusScoreRange(param_map);
		param_map.put("min", 81);
		param_map.put("max", 100);
		int acidosis_ethmoidal_sinus_cnt_81to100 = tsa_eval_service.getEntAcidosisEthmoidalSinusScoreRange(param_map);
		ret_map.put("acidosis_ethmoidal_sinus_0to20", acidosis_ethmoidal_sinus_cnt_0to20);
		ret_map.put("acidosis_ethmoidal_sinus_21to40", acidosis_ethmoidal_sinus_cnt_21to40);
		ret_map.put("acidosis_ethmoidal_sinus_41to60", acidosis_ethmoidal_sinus_cnt_41to60);
		ret_map.put("acidosis_ethmoidal_sinus_61to80", acidosis_ethmoidal_sinus_cnt_61to80);
		ret_map.put("acidosis_ethmoidal_sinus_81to100", acidosis_ethmoidal_sinus_cnt_81to100);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
	
	// 2019.01.04 수정 5단계를 하나로 넣는거에서 개별로 분할
	// ent_tas 수술
	@Transactional
	@PostMapping(value="/restful/upd_ent_tsa", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_ent_tsa(@RequestParam("ent_tsa")String ent_tsa) throws Exception
	{
		// ent_common 에 들어간 user_id를 ent_tsa에서 빼옴
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement entCommonElement = parser.parse(ent_tsa).getAsJsonObject().get("entCommon");
		EntCommonVO entcommonvo = gson.fromJson(entCommonElement, EntCommonVO.class); // pid는 아래에서 생성된 ent_total 거를 채워넣음
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(entcommonvo.getUID());
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		// ent_total 의 삽입
		EntTotalVO enttotalvo = new EntTotalVO();
		String total_id = UUID.randomUUID().toString();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		HashMap<String, Object>ent_total_map = new HashMap<String, Object>();
		ent_total_map.put("user_id", user_id);
		ent_total_map.put("date", ts);
		ent_total_map.put("ID", total_id);
		ent_total_map.put("oper_name", "ent_tsa");
		tsa_eval_service.insertEntTotal(ent_total_map);
		
		// 1. ent tsa
		String ent_tsa_id = UUID.randomUUID().toString();
		HashMap<String, Object>ent_tsa_map = new HashMap<String, Object>();
		ent_tsa_map.put("ID", ent_tsa_id);
		ent_tsa_map.put("pid", total_id);
		ent_tsa_map.put("totalScore", entcommonvo.getTotalScore());
		tsa_eval_service.insertEntTsa(ent_tsa_map);
		InsertEntCommon(ent_tsa_id, entcommonvo, ts); // ent common 삽입
		InsertTools(ent_tsa, ent_tsa_id); // tools 삽입
		InsertOuterBreak(ent_tsa, ent_tsa_id, "a1_OuterBreak");
		InsertSeptalFlap(ent_tsa, ent_tsa_id, "a2_Septal_Flap");
		InsertSuperiorTurbinate(ent_tsa, ent_tsa_id, "a3_Superior_Turbinate");
		InsertSellaDuramater(ent_tsa, ent_tsa_id, "a4_Sella_Duramater");
		InsertTumorRemoval(ent_tsa, ent_tsa_id, "a5_Tumor_Removal");
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	// ent transclival approach 수술
	@Transactional
	@PostMapping(value="/restful/upd_ent_transclival_approach", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_ent_transclival_approach(@RequestParam("ent_transclival_approach")String ent_transclival_approach) throws Exception
	{
		// ent_common 에 들어간 user_id를 ent_tsa에서 빼옴
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement entCommonElement = parser.parse(ent_transclival_approach).getAsJsonObject().get("entCommon");
		EntCommonVO entcommonvo = gson.fromJson(entCommonElement, EntCommonVO.class); // pid는 아래에서 생성된 ent_total 거를 채워넣음
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(entcommonvo.getUID());
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		// ent_total 의 삽입
		EntTotalVO enttotalvo = new EntTotalVO();
		String total_id = UUID.randomUUID().toString();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		HashMap<String, Object>ent_total_map = new HashMap<String, Object>();
		ent_total_map.put("user_id", user_id);
		ent_total_map.put("date", ts);
		ent_total_map.put("ID", total_id);
		ent_total_map.put("oper_name", "ent_transclival_approach");
		tsa_eval_service.insertEntTotal(ent_total_map);
		
		// 2. ent transclival approach
		String ent_transclival_approach_id = UUID.randomUUID().toString();
		HashMap<String, Object>ent_transclival_approach_map = new HashMap<String, Object>();
		JsonElement entTransClivalApproachCommonElement = parser.parse(ent_transclival_approach).getAsJsonObject().get("entCommon");
		EntCommonVO entTransClivalApproachcommonvo = gson.fromJson(entTransClivalApproachCommonElement, EntCommonVO.class); 
		ent_transclival_approach_map.put("ID", ent_transclival_approach_id);
		ent_transclival_approach_map.put("pid", total_id);
		ent_transclival_approach_map.put("totalScore", entTransClivalApproachcommonvo.getTotalScore());
		tsa_eval_service.insertEntTransclivalApproach(ent_transclival_approach_map);
		InsertEntCommon(ent_transclival_approach_id, entTransClivalApproachcommonvo, ts);
		InsertTools(ent_transclival_approach, ent_transclival_approach_id);
		InsertOuterBreak(ent_transclival_approach, ent_transclival_approach_id, "a1_OuterBreak");
		InsertSeptalFlap(ent_transclival_approach, ent_transclival_approach_id, "a2_Septal_Flap");
		InsertSphenoidCellsRemoval(ent_transclival_approach, ent_transclival_approach_id, "a3_Sphenoid_cells_removal");
		InsertTransclivalDrilling(ent_transclival_approach, ent_transclival_approach_id, "a4_Transclival_drilling");

		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value="/restful/upd_ent_acidosis_maxillary_sinus", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_ent_acidosis_maxillary_sinus(@RequestParam("ent_acidosis_maxillary_sinus")String ent_acidosis_maxillary_sinus) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement entCommonElement = parser.parse(ent_acidosis_maxillary_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entcommonvo = gson.fromJson(entCommonElement, EntCommonVO.class); // pid는 아래에서 생성된 ent_total 거를 채워넣음
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(entcommonvo.getUID());
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		EntTotalVO enttotalvo = new EntTotalVO();
		String total_id = UUID.randomUUID().toString();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		HashMap<String, Object>ent_total_map = new HashMap<String, Object>();
		ent_total_map.put("user_id", user_id);
		ent_total_map.put("date", ts);
		ent_total_map.put("ID", total_id);
		ent_total_map.put("oper_name", "ent_acidosis_maxillary_sinus");
		tsa_eval_service.insertEntTotal(ent_total_map);
		
		// 3. ent acidosis maxillary sinus
		String ent_acidosis_maxillary_sinus_id = UUID.randomUUID().toString();
		HashMap<String, Object>ent_acidosis_maxillary_sinus_map = new HashMap<String, Object>();
		JsonElement entAcidosisMaxillarySinusCommonElement = parser.parse(ent_acidosis_maxillary_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entAcidosisMaxillarySinuscommonvo = gson.fromJson(entAcidosisMaxillarySinusCommonElement, EntCommonVO.class); 
		ent_acidosis_maxillary_sinus_map.put("ID", ent_acidosis_maxillary_sinus_id);
		ent_acidosis_maxillary_sinus_map.put("pid", total_id);
		ent_acidosis_maxillary_sinus_map.put("totalScore", entAcidosisMaxillarySinuscommonvo.getTotalScore());
		tsa_eval_service.insertEntAcidosisMaxillarySinus(ent_acidosis_maxillary_sinus_map);
		InsertEntCommon(ent_acidosis_maxillary_sinus_id, entAcidosisMaxillarySinuscommonvo, ts);
		InsertTools(ent_acidosis_maxillary_sinus, ent_acidosis_maxillary_sinus_id);
		InsertOuterBreak(ent_acidosis_maxillary_sinus, ent_acidosis_maxillary_sinus_id, "a1_OuterBreak");
		InsertUncinectomy(ent_acidosis_maxillary_sinus, ent_acidosis_maxillary_sinus_id, "a2_Uncinectomy");
		InsertSuperiorTurbinate(ent_acidosis_maxillary_sinus, ent_acidosis_maxillary_sinus_id, "a3_Superior_Turbinate");
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value="/restful/upd_ent_acidosis_frontal_sinus", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_ent_acidosis_frontal_sinus(@RequestParam("ent_acidosis_frontal_sinus")String ent_acidosis_frontal_sinus) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement entCommonElement = parser.parse(ent_acidosis_frontal_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entcommonvo = gson.fromJson(entCommonElement, EntCommonVO.class); 
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(entcommonvo.getUID());
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		EntTotalVO enttotalvo = new EntTotalVO();
		String total_id = UUID.randomUUID().toString();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		HashMap<String, Object>ent_total_map = new HashMap<String, Object>();
		ent_total_map.put("user_id", user_id);
		ent_total_map.put("date", ts);
		ent_total_map.put("ID", total_id);
		ent_total_map.put("oper_name", "ent_acidosis_frontal_sinus");
		tsa_eval_service.insertEntTotal(ent_total_map);
		
		// 4. ent acidosis frontal sinus
		String ent_acidosis_frontal_sinus_id = UUID.randomUUID().toString();
		HashMap<String, Object>ent_acidosis_frontal_sinus_map = new HashMap<String, Object>();
		JsonElement entAcidosisFrontalSinusCommonElement = parser.parse(ent_acidosis_frontal_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entAcidosisFrontalSinuscommonvo = gson.fromJson(entAcidosisFrontalSinusCommonElement, EntCommonVO.class); 
		ent_acidosis_frontal_sinus_map.put("ID", ent_acidosis_frontal_sinus_id);
		ent_acidosis_frontal_sinus_map.put("pid", total_id);
		ent_acidosis_frontal_sinus_map.put("totalScore", entAcidosisFrontalSinuscommonvo.getTotalScore());
		tsa_eval_service.insertEntAcidosisFrontalSinus(ent_acidosis_frontal_sinus_map);
		InsertEntCommon(ent_acidosis_frontal_sinus_id, entAcidosisFrontalSinuscommonvo, ts);
		InsertTools(ent_acidosis_frontal_sinus, ent_acidosis_frontal_sinus_id);
		InsertOuterBreak(ent_acidosis_frontal_sinus, ent_acidosis_frontal_sinus_id, "a1_OuterBreak");
		InsertUncinectomy(ent_acidosis_frontal_sinus, ent_acidosis_frontal_sinus_id, "a2_Uncinectomy");
		InsertAnteriorEthmoidectomy(ent_acidosis_frontal_sinus, ent_acidosis_frontal_sinus_id, "a3_Anterior_ethmoidectomy");
		InsertAnteriorSinus(ent_acidosis_frontal_sinus, ent_acidosis_frontal_sinus_id, "a4_Anterior_sinus");
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	@Transactional
	@PostMapping(value="/restful/upd_ent_acidosis_ethmoidal_sinus", produces="text/plain;charset=utf-8")
	public ResponseEntity<Object> upd_ent_acidosis_ethmoidal_sinus(@RequestParam("ent_acidosis_ethmoidal_sinus")String ent_acidosis_ethmoidal_sinus) throws Exception
	{
		Gson gson = new Gson();
		JsonParser parser = new JsonParser();
		JsonElement entCommonElement = parser.parse(ent_acidosis_ethmoidal_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entcommonvo = gson.fromJson(entCommonElement, EntCommonVO.class); 
		
		String user_id;
		AuthTokenVO atvo = ValidAuthToken(entcommonvo.getUID());
		if(atvo == null) {
			return new ResponseEntity<Object>("session expiration", HttpStatus.OK);
		}
		else {
			user_id = atvo.getUserId();
		}
		
		EntTotalVO enttotalvo = new EntTotalVO();
		String total_id = UUID.randomUUID().toString();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = date.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		HashMap<String, Object>ent_total_map = new HashMap<String, Object>();
		ent_total_map.put("user_id", user_id);
		ent_total_map.put("date", ts);
		ent_total_map.put("ID", total_id);
		ent_total_map.put("oper_name", "ent_acidosis_ethmoidal_sinus");
		tsa_eval_service.insertEntTotal(ent_total_map);
		
		// 5. ent acidosis ethmoidal sinus
		String ent_acidosis_ethmoidal_sinus_id = UUID.randomUUID().toString();
		HashMap<String, Object>ent_acidosis_ethmoidal_sinus_map = new HashMap<String, Object>();
		JsonElement entAcidosisEthmoidalSinusCommonElement = parser.parse(ent_acidosis_ethmoidal_sinus).getAsJsonObject().get("entCommon");
		EntCommonVO entAcidosisEthmoidalSinuscommonvo = gson.fromJson(entAcidosisEthmoidalSinusCommonElement, EntCommonVO.class); 
		ent_acidosis_ethmoidal_sinus_map.put("ID", ent_acidosis_ethmoidal_sinus_id);
		ent_acidosis_ethmoidal_sinus_map.put("pid", total_id);
		ent_acidosis_ethmoidal_sinus_map.put("totalScore", entAcidosisEthmoidalSinuscommonvo.getTotalScore());
		tsa_eval_service.insertEntAcidosisEthmoidalSinus(ent_acidosis_ethmoidal_sinus_map);
		InsertEntCommon(ent_acidosis_ethmoidal_sinus_id, entAcidosisEthmoidalSinuscommonvo, ts);
		InsertTools(ent_acidosis_ethmoidal_sinus, ent_acidosis_ethmoidal_sinus_id);
		InsertOuterBreak(ent_acidosis_ethmoidal_sinus, ent_acidosis_ethmoidal_sinus_id, "a1_OuterBreak");
		InsertUncinectomy(ent_acidosis_ethmoidal_sinus, ent_acidosis_ethmoidal_sinus_id, "a2_Uncinectomy");
		InsertAnteriorEthmoidalAirCellRemoval(ent_acidosis_ethmoidal_sinus, ent_acidosis_ethmoidal_sinus_id, "a3_Anterior_ethmoidal_air_cell_removal");
		InsertPosteriorAirCellRemoval(ent_acidosis_ethmoidal_sinus, ent_acidosis_ethmoidal_sinus_id, "a4_Posterior_air_cell_removal");
		
		return new ResponseEntity<Object>("success", HttpStatus.OK);
	}
	
	// tsa 수술 통계
	@GetMapping(value="/restful/tsa_stats")
	public ResponseEntity<Object> tsa_stats() throws Exception
	{
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		
		HashMap<String, Object>score_range_map = new HashMap<String, Object>();
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTSA();
		score_range_map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		score_range_map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		score_range_map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		score_range_map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		score_range_map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		score_range_map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		ret_map.put("Score_Range", score_range_map);
		
		// 각 단위 수술 유저 평균
		HashMap<String, Object>user_average_map = new HashMap<String, Object>();
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		user_average_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		user_average_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_superior_turbinate = tsa_eval_service.getAverScoreSuperiorTurbinate();
		user_average_map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		int aver_sella_duramater = tsa_eval_service.getAverScoreSellaDuramater();
		user_average_map.put("aver_sc_sella_duramater", aver_sella_duramater);
		int aver_tumor_removal = tsa_eval_service.getAverScoreTumorRemoval();
		user_average_map.put("aver_sc_tumor_removal", aver_tumor_removal);
		ret_map.put("User_Average", user_average_map);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
	
	// transclival approach 수술 통계
	@GetMapping(value="/restful/transcliaval_approach_stats")
	public ResponseEntity<Object> transcliaval_approach_stats() throws Exception
	{
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		
		HashMap<String, Object>score_range_map = new HashMap<String, Object>();
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngTransclivalApproach();
		score_range_map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		score_range_map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		score_range_map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		score_range_map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		score_range_map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		score_range_map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		ret_map.put("Score_Range", score_range_map);
		
		// 각 단위 수술 유저 평균
		HashMap<String, Object>user_average_map = new HashMap<String, Object>();
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		user_average_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_septal_flap = tsa_eval_service.getAverScoreSeptalFlap();
		user_average_map.put("aver_sc_septal_flap", aver_septal_flap);
		int aver_sphenoid_cells_removal = tsa_eval_service.getAverScoreSphenoidCellsRemoval();
		user_average_map.put("aver_sc_sphenoid_cells_removal", aver_sphenoid_cells_removal);
		int aver_transclival_drilling = tsa_eval_service.getAverScoreTransclivalDrilling();
		user_average_map.put("aver_sc_transclival_drilling", aver_transclival_drilling);
		ret_map.put("User_Average", user_average_map);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
	
	// acidosis maxillary sinus 수술 통계
	@GetMapping(value="/restful/acidosis_maxillary_sinus_stats")
	public ResponseEntity<Object> acidosis_maxillary_sinus_stats() throws Exception
	{
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		HashMap<String, Object>score_range_map = new HashMap<String, Object>();
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisMaxillarySinus();
		score_range_map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		score_range_map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		score_range_map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		score_range_map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		score_range_map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		score_range_map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		ret_map.put("Score_Range", score_range_map);
		
		// 각 단위 수술 유저 평균
		HashMap<String, Object>user_average_map = new HashMap<String, Object>();
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		user_average_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverUncinectomy();
		user_average_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_superior_turbinate = tsa_eval_service.getAverSuperiorTurbinate();
		user_average_map.put("aver_sc_superior_turbinate", aver_superior_turbinate);
		ret_map.put("User_Average", user_average_map);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
	
	// acidosis frontal sinus 수술 통계
	@GetMapping(value="/restful/acidosis_frontal_sinus_stats")
	public ResponseEntity<Object> acidosis_frontal_sinus_stats() throws Exception
	{
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		HashMap<String, Object>score_range_map = new HashMap<String, Object>();
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisFrontalSinus();
		score_range_map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		score_range_map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		score_range_map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		score_range_map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		score_range_map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		score_range_map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		ret_map.put("Score_Range", score_range_map);
		
		// 각 단위 수술 유저 평균
		HashMap<String, Object>user_average_map = new HashMap<String, Object>();
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		user_average_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		user_average_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidectomy = tsa_eval_service.getAverAnteriorEthmoidectomy();
		user_average_map.put("aver_sc_aver_anterior_ethmoidectomy", aver_anterior_ethmoidectomy);
		int aver_anterior_sinus = tsa_eval_service.getAverScoreAnteriorSinus();
		user_average_map.put("aver_sc_anterior_sinus", aver_anterior_sinus);
		ret_map.put("User_Average", user_average_map);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
	
	// acidosis ethmoidal sinus 수술 통계
	@GetMapping(value="/restful/acidosis_ethmoidal_sinus_stats")
	public ResponseEntity<Object> acidosis_ethmoidal_sinus_stats() throws Exception
	{
		HashMap<String, Object>ret_map = new HashMap<String, Object>();
		HashMap<String, Object>score_range_map = new HashMap<String, Object>();
		RangeScoreVO rnscore_vo = tsa_eval_service.getRngAcidosisEthmoidalSinus();
		score_range_map.put("Rn0_to_50", rnscore_vo.getRn0_to_50());
		score_range_map.put("Rn51_to_60", rnscore_vo.getRn51_to_60());
		score_range_map.put("Rn61_to_70", rnscore_vo.getRn61_to_70());
		score_range_map.put("Rn71_to_80", rnscore_vo.getRn71_to_80());
		score_range_map.put("Rn81_to_90", rnscore_vo.getRn81_to_90());
		score_range_map.put("Rn91_to_100", rnscore_vo.getRn91_to_100());
		ret_map.put("Score_Range", score_range_map);
		
		// 각 단위 수술 유저 평균
		HashMap<String, Object>user_average_map = new HashMap<String, Object>();
		int aver_outer_break = tsa_eval_service.getAverScoreOuterBreak();
		user_average_map.put("aver_sc_outer_break", aver_outer_break);
		int aver_uncinectomy = tsa_eval_service.getAverScoreUncinectomy();
		user_average_map.put("aver_sc_uncinectomy", aver_uncinectomy);
		int aver_anterior_ethmoidal_air_cell_removal = tsa_eval_service.getAverScoreAnteriorEthmoidalAirCellRemoval();
		user_average_map.put("aver_sc_anterior_ethmoidal_air_cell_removal", aver_anterior_ethmoidal_air_cell_removal);
		int aver_posterior_air_cell_removal = tsa_eval_service.getAverScorePosteriorAirCellRemoval();
		user_average_map.put("aver_sc_posterior_air_cell_removal", aver_posterior_air_cell_removal);		
		ret_map.put("User_Average", user_average_map);
		
		return new ResponseEntity<Object>(ret_map, HttpStatus.OK);
	}
}
