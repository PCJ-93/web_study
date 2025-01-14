package com.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dto.Member;



@Controller
public class Practice02Controller {
	
	@RequestMapping("/jstl/listTest")
	public String listTest(@RequestParam String type, Model model) {
		model.addAttribute("type",type);
		
		List<Member> memberList = new ArrayList<Member>();
		for(int i=1; i<=5; i++) {
			memberList.add(new Member("아이디"+i, "비번"+i, "이름"+i));
		}
		model.addAttribute("memberList",memberList);
		
		return "jstl/listTest";
	}
	
	
	

}
