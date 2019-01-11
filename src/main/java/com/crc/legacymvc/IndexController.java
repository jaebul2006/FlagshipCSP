package com.crc.legacymvc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String redirect(){
		
		//return "redirect:/static/site_pro/index.html";
		return "index";
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.GET)
	public void login(HttpSession session){
		
	}
	
	@RequestMapping(value = "/logoutDo", method=RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response){
		
		HttpSession session = request.getSession(false);
		SecurityContextHolder.clearContext();
		session = request.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		for(Cookie cookie: request.getCookies()) {
			cookie.setMaxAge(0);
		}
		return "index";
	}
	
	@RequestMapping(value = "/login_success", method=RequestMethod.GET)
	public String login_success(HttpSession session) {
		session.setAttribute("session_login", "session_login");
		logger.info("로그인 세션 is {}.", session);
		return "index";
	}
	
	@RequestMapping(value = "/login_fail", method=RequestMethod.GET)
	public String login_fail(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value = "/login_duplicate", method=RequestMethod.GET)
	public void login_duplicate() {
		
	}
	
	@RequestMapping(value = "/download_page", method=RequestMethod.GET)
	public void download_page() {
		
	}
	
	
}
