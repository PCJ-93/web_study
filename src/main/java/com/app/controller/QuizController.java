package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/quiz")
public class QuizController {
	
	@RequestMapping("/main")  //사용자 입장에서 보는 브라우저주소창경로
	public String main() {
		return "quiz/main";  //여기에는 내가가진 파일의 경로명을 써준다
	}
	
	@RequestMapping("/product/mouse")
	public String mouse() {
		return "quiz/product/mouse";
	}
	
	@RequestMapping("/product/keyboard")
	public String keyboard() {
		return "quiz/product/keyboard";
	}
	
	
//	@RequestMapping("/quiz/main")  //사용자 입장에서 보는 브라우저주소창경로
//	public String main() {
//		return "quiz/main";  //여기에는 내가가진 파일의 경로명을 써준다
//	}
//	
//	@RequestMapping("/quiz/product/mouse")
//	public String mouse() {
//		return "quiz/product/mouse";
//	}
//	
//	@RequestMapping("/quiz/product/keyboard")
//	public String keyboard() {
//		return "quiz/product/keyboard";
//	}
	
	
	@GetMapping("/quiz/req1")
	public String reqGet() {
	    System.out.println("/quiz/req1 GET 요청");
	    return "quiz/req1";
	}

	@PostMapping("/quiz/req1")
	public String reqPost() {
	    System.out.println("/quiz/req1 POST 요청");
	    return "quiz/req1";
	}
	
	@RequestMapping("/quiz/req2")
	public String req2(HttpServletRequest request) {
		System.out.println("/quiz/req2 요청");
		System.out.println(request.getParameter("data1"));
		System.out.println(request.getParameter("data2"));
		
		request.setAttribute("data1", request.getParameter("data1"));
		request.setAttribute("data2", request.getParameter("data2"));
		
		return "quiz/req1";
	}

	
}
