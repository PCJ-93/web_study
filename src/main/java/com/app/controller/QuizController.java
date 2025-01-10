package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz")
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
	
}
