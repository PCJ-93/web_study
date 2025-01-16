package com.app.controller.study;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.util.MyCookieUtil;

@Controller
public class CookieController {
	//session = 서버쪽에 저장관리
	//cookie = 사용자 브라우저에 저장관리
	
	@GetMapping("/save-cookie")
	public String saveCookie(HttpServletResponse response) {
		//서버에서 쿠키생성 - >  사용자
		//					(쿠키 저장)
		Cookie ck1 = new Cookie("weather","snowing");
		ck1.setMaxAge(3600); // 쿠키의 수명 (초단위)
		response.addCookie(ck1);
		
		//띄어쓰기 - > URLEncode 처리
		String tempValue;
		try {
			tempValue = URLEncoder.encode("temp cookie value", "UTF-8");
			
			Cookie ck2 = new Cookie("temp", tempValue);
			response.addCookie(ck2);
			
			Cookie ck3 = new Cookie("temp2",MyCookieUtil.encodeCookieValue("22 value test"));
			
			Cookie ck4 = MyCookieUtil.createCookie("ckName", "ckValue");
			response.addCookie(ck4);
			
			Cookie ck5 = MyCookieUtil.createCookie("ck5name", "ck5Value", 120);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "cookie/save-cookie";
	}
	
	@GetMapping("/remove-cookie")
	public String removeCookie(HttpServletResponse response) {
		Cookie ck1 = new Cookie("temp", "value");
		ck1.setMaxAge(0);
		
		response.addCookie(ck1);
		
		return "cookie/save-cookie";
	}
	
	@GetMapping("/read-cookie")
	public String readCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		
//		for(Cookie ck : cookies) {
//			System.out.println(ck.getName() + " " + ck.getValue());
//			
//			if(ck.getName().equals("weather")) {
//				request.setAttribute("weather", ck.getValue());
//			}
//		}
		
		String weather = MyCookieUtil.getCookie(cookies, "weather");
		if(weather != null) {
			System.out.println(weather);
		}
		
		String tmep = MyCookieUtil.getCookie(request, "temp");
		
		
		return "cookie/read-cookie";
	}
	
	@GetMapping("/read-cookie2")
	public String readCookie2(@CookieValue String weather, @CookieValue String temp) {
		
		System.out.println(weather);
		System.out.println(temp);
		
		String decodeTemp;
		try {
			decodeTemp = URLDecoder.decode(temp,"UTF-8");
			System.out.println(decodeTemp);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return "cookie/read-cookie";
	}
	
	@GetMapping("/id-cookie")
	public String idCookie(HttpServletRequest request) {
		String remember = MyCookieUtil.getCookie(request, "remember");
		
		if(remember != null) {
			request.setAttribute("remember", remember);
		}
		
		return "cookie/id-cookie";
	}
	
	@PostMapping("/id-cookie")
	public String idCookieAction(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("remember"));
		String remember = request.getParameter("remember");
		String id = request.getParameter("id");
		// id pw < --비교-- > DB에 저장된 데이터
		// 로그인 성공 - 메인이나 마이페이지등으로 이동(여기선 리드쿠키2페이지)
		//return "redirect:/read-cookie2";  //read-cookie2 브라우저경로로 넘긴다
		
		// 아이디 기억 체크 -> 쿠키에 저장 해두자~
		if(remember != null) {
			if(remember.equals("true")) {
				Cookie ck = MyCookieUtil.createCookie("remember", id);
				response.addCookie(ck);
			}
		}else {
	        Cookie ck = MyCookieUtil.createCookie("remember", "value");
	        ck.setMaxAge(0); // 유효기간을 0으로 설정하여 쿠키 삭제
	        response.addCookie(ck);
	    }
		
		
		// 로그인 실패
		// 다시 로그인하는 화면
		
		return "cookie/id-cookie";
	}

}
