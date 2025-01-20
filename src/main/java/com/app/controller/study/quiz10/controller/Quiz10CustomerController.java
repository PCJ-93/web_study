package com.app.controller.study.quiz10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.controller.study.quiz10.dto.Quiz10Customer;
import com.app.controller.study.quiz10.service.Quiz10CustomerService;

import lombok.Getter;

@Controller
public class Quiz10CustomerController {
	
	//Quiz10CustomerService 가저다 쓰고싶다~ 오토와이어드로연결
	@Autowired
	Quiz10CustomerService quiz10CustomerService;
	
	
	//등록페이지 -> GET
	@GetMapping("/quiz10registerCustomer")
	public String quiz10registerCustomer() {
		return "quiz/quiz10/quiz10registerCustomer";
	}
	
	//등록 페이지에서 입력 후 등록 요청 -> Post
	@PostMapping("/quiz10registerCustomer")
	public String quiz10registerCustomerAction(Quiz10Customer quiz10Customer) {//객체형식으로 파라미터 받아온다
		// 등록할 화면 입력한 값 을 받아야해(폼태그안에있는것들)
		
		// 유효성 검증 ~~
		
		// 서비스에게 등록 요청.(하청주듯이)
		int result = quiz10CustomerService.saveCustomer(quiz10Customer);
		// 보여줄 페이지 
		if(result > 0) {//저장성공
			//성공시 보여줄페이지
			return "quiz/quiz10/quiz10registerCustomer";
		}else {//저장 실패
			//실패시 보여줄 페이지
			return "quiz/quiz10/quiz10registerCustomer";
		}
	}
	
}
