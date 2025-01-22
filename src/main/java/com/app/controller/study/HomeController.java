package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

//	@RequestMapping("/")  메인컨트롤러에 안겹치게 일단 주석처리했다
	public String home() {
		//return "/WEB-INF/views/home.jsp";
		//return "/WEB-INF/views/mainpage.jsp";

		//--ViewResolver 설정 이후
		return "home";
	}
}