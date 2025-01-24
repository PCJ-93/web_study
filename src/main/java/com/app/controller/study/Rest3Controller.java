package com.app.controller.study;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.common.ApiCommonCode;
import com.app.common.CommonCode;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.study.api.ApiParamDTO;
import com.app.dto.user.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class Rest3Controller {
	
	@GetMapping("/rest/param1")
	public String param1(@RequestParam String menu) {
		
		System.out.println(menu);
		
		return "param1 ok";
	}

	
	// Client     <->      Server
	//        <-json-
	//       -parameter->
	//		   -json->
	
	@GetMapping("/rest/param2")
	public String param2(@RequestBody String bodyText) {
		
		System.out.println(bodyText); //{"id":"user1212","name":"1212"}
		
		// json 포맷 string 으로 온 요청을 -> 파싱 후 활용
		
		//json-simple 방식
		try {
			JSONParser parser = new JSONParser();
			JSONObject obj = (JSONObject)parser.parse(bodyText);
			
			System.out.println(obj.get("id"));
			System.out.println(obj.get("name"));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return "param2 ok";
	}
	
	
	@GetMapping("/rest/param3")
	public String param3(@RequestBody String bodyText) {
		
		//jackson 방식
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			ApiParamDTO apDTO = mapper.readValue(bodyText, ApiParamDTO.class);
			
			System.out.println(apDTO);
			System.out.println(apDTO.getId());
			System.out.println(apDTO.getName());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "param3 ok";
	}
		
		
	@GetMapping("/rest/param4")
	public String param4(@RequestBody ApiParamDTO apDTO) {
		
		System.out.println(apDTO);
		
		return "param4 ok";
	}
	
	
	@GetMapping("/rest/param5")
	public ApiResponseHeader param5(@RequestBody ApiParamDTO apDTO) {
		
		System.out.println(apDTO);
		//DB 조회 비교
		ApiResponseHeader header = new ApiResponseHeader();
		if(!(apDTO.getId().equals("user1212"))) {
			
			header.setResultCode(ApiCommonCode.API_RESULT_NO_DATA);
			header.setResultMessage(ApiCommonCode.API_RESULT_NO_DATA_MSG);
			return header;
		}
		
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		
		return header;
	}
		
	@GetMapping("/rest/param6")
	public ApiResponse<User> param6(@RequestBody ApiParamDTO apDTO) {
		
		System.out.println(apDTO);
		//DB 조회 비교
		ApiResponse<User> res = new ApiResponse<User>();
		ApiResponseHeader header = new ApiResponseHeader();
		if(!(apDTO.getId().equals("user1212"))) {
			
			header.setResultCode(ApiCommonCode.API_RESULT_NO_DATA);
			header.setResultMessage(ApiCommonCode.API_RESULT_NO_DATA_MSG);
			
			res.setHeader(header);
			
			return res;
		}
		
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS);
		header.setResultCode(ApiCommonCode.API_RESULT_SUCCESS_MSG);
		res.setHeader(header);
		
		User user = new User();
		user.setId("abc");
		user.setName("abc이름");
		user.setPw("비밀");
		user.setUserType(CommonCode.USER_USERTYPE_CUSTOMER);

		res.setBody(user);

		return res;
	}
	
	
	
	
	
	
	
	
	
}










