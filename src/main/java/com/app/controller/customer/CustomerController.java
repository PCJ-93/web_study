package com.app.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.user.User;
import com.app.service.user.UserService;

import oracle.jdbc.proxy.annotation.Post;

@Controller
public class CustomerController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/customer/signup")
	public String signup() {
		return "customer/signup";
	}
	
	@PostMapping("/customer/signup")
	public String signupAction(User user) {
		user.setUserType("CUS");
		int result = userService.saveUser(user);
		if(result==1) {
			System.out.println("정상처리됨");
			return "redirect:/main";
		}else {
			System.out.println("저장실패");
			return "customer/signup";
		}
	}
}
