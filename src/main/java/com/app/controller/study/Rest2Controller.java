package com.app.controller.study;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.CommonCode;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Rest2Controller { // restController 붙이면 안에있는거 전부 @ResponseBody 붙인효과난다
	
	@GetMapping("/rest/rest4")
	public String rest4() {
		return "rest/rest4";
	}
	
	@GetMapping("/rest/rest5")
	public String rest5() {
		return "rest5 return text restController";
	}
	
	// 위에는 단순 text 반환한것
	// 아래는 값 넘기는거
	
	@GetMapping("rest/rest6")
	public String rest6() {
		// json 포맷
		/*
		 return abc, qwe, name1, CUS;
		 
		 많은 데이터들을 전달 할때 표현 규칙은 JSON 형식으로 리턴하는거
		 
		 {
		 	"id":"abc",
		 	"pw":"qwe",
		 	"name":"name1",
		 	"userType":"CUS"
		 }
		 */
		
		/*
		  JSON 포맷으로 return 하려면?
		  1) 직접 포맷대로 작성 (단순노가다)
		
		return "{"
				+ "	\"id\":\"abc\","
				+ "	\"pw\":\"qwe\","
				+ "	\"name\":\"name1\","
				+ "	\"userType\":\"CUS\""
				+ " }";
		*/
		/*
		2) json 활용을 도와주는 라이브러리 사용하기
		  	1. json-simple 사용
		 
		JSONObject obj = new JSONObject();
		obj.put("id", "abc");
		obj.put("pw", "qwe");
		obj.put("name", "name1");
		obj.put("userType", "CUS");
		
		System.out.println(obj.toJSONString());
		
		return obj.toJSONString();
		*/
		
		/*
		 	2. jackson 라이브러리 obj.put obj.put obj.put .. 안해도되는거
		 */
		User user = new User();
		user.setId("abc");
		user.setPw("qwe");
		user.setName("name11");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonStr = null;
		try {
			jsonStr = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(jsonStr);
		//jackson라이브러리 활용 해서 객체를 json포맷 string변환 해서 리턴
		return jsonStr;	
	}
	
	
	@GetMapping("rest/rest7")
	public User rest7() { // 주의사항!! - 객체리턴->json포맷 변환 시 사전조건 : pom.xml 디펜던시에 jackson라이브러리가 있어야한다(의존성주입)
		// User 객체를 리턴!
		User user = new User();
		user.setId("abc2");
		user.setPw("qwe2");
		user.setName("name1122");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);
		
		return user;
	}
	
}










