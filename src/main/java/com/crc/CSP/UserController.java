package com.crc.CSP;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crc.CSP.bean.UserBean;
import com.crc.CSP.service.UserService;

@Controller
public class UserController 
{
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService user_service;
	
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void login(HttpSession session)
	{
		
	}
	
	@RequestMapping(value = "/logoutDo", method=RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response)
	{	
		HttpSession session = request.getSession(false);
		session = request.getSession(false);
		if(session != null) {
			logger.info("start ���ǻ��� is {}.", session);
			session.invalidate();
			logger.info("end ���ǻ��� is {}.", session);
		}
		for(Cookie cookie: request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return "login";
	}
	
	@RequestMapping(value = "/login_success", method=RequestMethod.GET)
	public String login_success(HttpSession session) 
	{
		session.setAttribute("session_login", "session_login");
		logger.info("�α��� ���� is {}.", session);
		return "index";
	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String index(HttpSession session) 
	{
		return "index";
	}
	
	@RequestMapping(value = "/login_fail", method=RequestMethod.GET)
	public String login_fail(HttpServletRequest request) 
	{
		logger.info("�α��ν���");
		return "login";
	}
	
	
	@RequestMapping(value = "/login_duplicate", method=RequestMethod.GET)
	public void login_duplicate() 
	{	
	}
	
	@RequestMapping(value = "/RegistUser", method=RequestMethod.GET)
	public String RegistUser() 
	{
		return "RegistUser";
	}
	
	@RequestMapping(value = "/RegistCommonUser", method=RequestMethod.GET)
	public String RegistCommonUser() 
	{
		return "RegistCommonUser";
	}
	
	// id �� ���� �������� Ȯ��
	@PostMapping(value = "/CheckAdmin")
	public ResponseEntity<Object> CheckAdmin(@RequestParam("id")String id) throws Exception 
	{
		UserBean user_res;
		user_res = user_service.user(id);
		if(user_res != null)
		{
			if(user_res.getAUTHORITY().equals("ROLE_ADMIN")) 
			{	
				return new ResponseEntity<Object>("admin", HttpStatus.OK);
			}
		}
		return new ResponseEntity<Object>("noadmin", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Product", method=RequestMethod.GET)
	public String Product() 
	{
		return "Product";
	}
	
}
