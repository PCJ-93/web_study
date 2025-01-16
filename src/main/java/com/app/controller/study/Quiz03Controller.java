package com.app.controller.study;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/quiz03")
public class Quiz03Controller {
	
//	@RequestMapping("/pathA") // 2) Model 활용
//	public  String pathA(Model model) {
//		model.addAttribute("item","원조커피");
//		model.addAttribute("type","커피음료");
//		
//		return "quiz/quiz03/pathA";
//	}
//	
//	@RequestMapping("/pathB") // 2) Model 활용
//	public  String pathB(Model model) {
//		model.addAttribute("item","아메리카노");
//		model.addAttribute("type","커피");
//		
//		return "quiz/quiz03/pathB";
//	}
//	
//	@RequestMapping("/pathCommon/A")
//	public String pathComA(Model model) {
//		model.addAttribute("item","원조커피");
//		model.addAttribute("type","커피음료");
//		return "quiz/quiz03/common";
//	}
//	
//	@RequestMapping("/pathCommon/B")
//	public String pathComB(Model model) {
//		model.addAttribute("item","아메리카노");
//		model.addAttribute("type","커피");
//		return "quiz/quiz03/common";
//	}
	
//	@RequestMapping(value = {"/pathA", "/pathCommon/A"})
//	public  String pathA() {
//		return "quiz/quiz03/pathA";
//	}
//	
//	@RequestMapping(value = {"/pathB","/pathCommon/B"})
//	public  String pathB() {
//		return "quiz/quiz03/pathB";
//	}
	
	@RequestMapping("/pathCommon/{pathName}")
	public String pathCommonA(@PathVariable String pathName,Model model) {
		model.addAttribute("item",pathName);
		return "quiz/quiz03/common";
	}
}
