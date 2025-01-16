package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request02")  // 이거로 통째로 감싸면 안에있는게 @RequestMapping 앞에 붙어서 시작한다
public class Request02Controller {
	
	@RequestMapping("/url02")  // ... /request02/url02
	public String url02() {
		return "url1";
	}
	
	@RequestMapping("/url03")
	public String url03() {
		return "url1";
	}

}
