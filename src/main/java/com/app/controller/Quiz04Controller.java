package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Quiz04Controller {
	
	@RequestMapping("/quiz04/ask-bmi")
	public String ab() {
		return "quiz/quiz04/ask_bmi";
	}
	
	@RequestMapping("/quiz04/result-bmi")
	public String rb(@RequestParam String name,
			@RequestParam String height,
			@RequestParam String weight,
			Model model) {
		Double heightDb = Double.parseDouble(height);
		Double weightDb = Double.parseDouble(weight);
		
		double bmi = weightDb/ Math.pow(heightDb/100, 2);
		
		model.addAttribute("name",name);
		model.addAttribute("height",height);
		model.addAttribute("weight",weight);
		model.addAttribute("bmi",bmi);
		
		
		return "quiz/quiz04/result_bmi";
	}
}
