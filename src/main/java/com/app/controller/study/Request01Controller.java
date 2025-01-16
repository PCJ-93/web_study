package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Request01Controller {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	// 요청 주소별로 맵핑
	@RequestMapping("/url1") // 괄호안에 명시된 주소로 요청이 왔을때 아래메소드 실행
	public String url1() {
		return "url1"; // 그이름을 가지고 있는 view 파일을 명시
		// /WEB-INF/views/ + return한view이름 + .jsp => suvlet-context에서 도와준다
	}

	@RequestMapping("/url3")
	public String url3() {
		return "url3";
	}

	@RequestMapping("/url4") // views폴더안에 url폴더안에 url4.jsp 접근
	public String url4() {
		return "url/url4"; // views폴더안에 url폴더안에 url4.jsp 접근
	}

	
	// HTTP 통신 Method = GET/ POST / DELETE / PUT / PATCH.. 등의 방식이 있다(프론트랑 주고받는 방식).  메소드를 명시 안하면 get, post 둘다 받는다
	@RequestMapping(value = "/url5", method = RequestMethod.GET)  // get요청만 받는다 (인터넷브라우저 주소창에 입력하는 방식)
	public String url5() {
		return "url/url4";
	}

	@RequestMapping(value = "/url6", method = RequestMethod.POST)  // post요청만 받는다 (프론트에서 form 에서 받는 정보를 보내는것을 받을때 주로사용한다)
	public String url6() {  // post 쓰려면 화면이 있어야한다
		return "url/url4";
	}

	
	@GetMapping("/url7")  // 이렇게 쓰는 방법도 있다~ GET
	public String url7() {
		return "url/url4";
	}
	@PostMapping("/url8")  // 이렇게 쓰는 방법도 있다~ POST
	public String url8() {
		return "url/url4";
	}

	
}
