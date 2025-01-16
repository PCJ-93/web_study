package com.app.controller.study;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.dto.study.DrinkItem;
import com.app.dto.study.Request1;
import com.app.dto.study.ResponseItem;

@Controller
@RequestMapping("/quiz/quiz05")
public class Quiz05Controller {
	
	@RequestMapping("/request1-1")
	public String request1_1(HttpServletRequest request) {
		System.out.println("1-1");
		System.out.println(request.getParameter("category"));
		System.out.println(request.getParameter("product"));
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-2")
	public String request1_2(@RequestParam String category, @RequestParam String product) {
		System.out.println("1-2");
		System.out.println(category);
		System.out.println(product);
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-3")
	public String request1_3(@ModelAttribute Request1 request1) {
		System.out.println("1-3");
		System.out.println(request1.getCategory());
		System.out.println(request1.getProduct());
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/request1-4")
	public String request1_4(@RequestParam Map<String, String> paramMap) {
		System.out.println("1-4");
		System.out.println(paramMap.get("category"));
		System.out.println(paramMap.get("product"));
		System.out.println(paramMap.get("productt"));
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/response1-1")
	public String response1_1(HttpServletRequest request) {
		request.setAttribute("response001", "아");
		request.setAttribute("response099", "무");
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/response1-2")
	public String response1_2(Model model) {
		model.addAttribute("response001", "거");
		model.addAttribute("response099", "나");
		return "quiz/quiz05/request1";
	}
	
	@RequestMapping("/response1-3")
	public ModelAndView response1_3() {
		ModelAndView mav = new ModelAndView("quiz/quiz05/request1");
		mav.addObject("response001","아무");
		mav.addObject("response099","거나");
		return mav;
	}
	
	@RequestMapping("/response1-4") //@ModelAttribute 는생략해도 작동한다
	public String response1_4(@ModelAttribute ResponseItem responseItem) {
		responseItem.setResponse001("001");
		responseItem.setResponse099("099");
		return "quiz/quiz05/request1";
	}
	
}













