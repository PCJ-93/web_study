package com.app.controller.study;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {

	@RequestMapping("/re/re1")
	public String re1() {
		
		return "re/re1";
	}
	
	@RequestMapping("/re/re2")
	public String re2(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));

		//request.setAttribute("msg", "덮어쓱디"); // redirect,forward 해도 덮어쓰기당함
		
		return "re/re2";
	}
	
	@RequestMapping("/re/re3")
	public String re3(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		return "re/re3";
	}
	
	@RequestMapping("/re/re4")
	public String re4(HttpServletRequest request, RedirectAttributes ra) {
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re4 redirect msg"); //redirect 시 안넘어간다
		ra.addAttribute("msg", "re4 ra msg");			// RedirectAttributes쓴거는 넘어감(파라미터 넘기기)
		//return "re/re2";  // 바로 view 경로에 re2로 보내는거
		return "redirect:/re/re2";  // re2 경로로 다시요청
		//return "redirect:/re/re2?msg=re4 redirect msg";
		
		// return "/WEB-INF/views/re/re2.jsp"; 
		// return "redirect:/re/re2";
	}
	
	@RequestMapping("/re/re5")
	public String re5(HttpServletRequest request) {
		System.out.println(request.getParameter("msg"));
		
		request.setAttribute("msg", "re5 forward msg");
		
		return "forward:/re/re2";
		
	}
}
