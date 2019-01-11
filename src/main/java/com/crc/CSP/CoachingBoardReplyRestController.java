package com.crc.CSP;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crc.CSP.bean.CoachingBoardReplyVO;
import com.crc.CSP.service.CoachingBoardReplyService;

@RestController
public class CoachingBoardReplyRestController {

	private static final Logger logger = LoggerFactory.getLogger(CoachingBoardReplyRestController.class);
	
	@Autowired
	CoachingBoardReplyService replyService;
	
	@PostMapping(value = "/insertCoaching")
	public String insertCoaching(@RequestParam("bno")int bno, @RequestParam("replytext")String replytext,
			@RequestParam("writer")String writer, @RequestParam("replyer")String replyer, 
			@RequestParam("fileName")String fileName, @RequestParam("content_type")String content_type) throws Exception
	{
		logger.info("**************");
		logger.info("평가 bno=>{}", bno);
		logger.info("평가 replytext=>{}", replytext);
		logger.info("평가 writer=>{}", writer);
		logger.info("평가 replyer=>{}", replyer);
		logger.info("평가 fileName=>{}", fileName);
		logger.info("평가 content_type=>{}", content_type);
		logger.info("**************");
		HashMap<String, String>eval_map = new HashMap<String, String>();
		eval_map.put("bno", Integer.toString(bno));
		eval_map.put("replytext", replytext);
		eval_map.put("writer", writer);
		eval_map.put("replyer", replyer);
		eval_map.put("fileName", fileName);
		eval_map.put("content_type", content_type);
		replyService.insertCoaching(eval_map);
		
		//return "redirect:/CoachingBoard/TCoachingBoardList";
		return HttpStatus.OK.toString();
	}
	
	@GetMapping(value = "/RecentScoreSix")
	public List<CoachingBoardReplyVO> RecentScoreSix(@RequestParam("content_type")String content_type, @RequestParam("user_id")String user_id) throws Exception
	{
		List<CoachingBoardReplyVO> list = replyService.recent_score_six(content_type, user_id);
		return list;
	} 
	
}
