package com.app.controller.study.quiz11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Quiz11RestController {
	
//	@GetMapping("/rest/quiz1")
//	public String quiz1() {
//		return "rest/quiz1";
//	}
	
//	@ResponseBody
//	@GetMapping("/rest/quiz2")
//	public String quiz2() {
//		return "return text quiz2";
//	}
	
//	@ResponseBody
//	@GetMapping("rest/quiz3")
//	public User quiz3ToJason() {
//		User user = new User();
//		user.setId("quizid");
//		user.setPw("secret");
//		user.setName("quiz이름");
//		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
//		
//		return user;
//	}
	
//	@ResponseBody
//	@GetMapping("rest/quiz3")
//	public String quiz3ToString() {
//		User user = new User();
//		user.setId("quizid");
//		user.setPw("secret");
//		user.setName("quiz이름");
//		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
//		
//		ObjectMapper mapper = new ObjectMapper();
//		
//		String jsonStr = null;
//		try {
//			jsonStr = mapper.writeValueAsString(user);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return jsonStr;	
//	}
	
	
	

}
