package com.app.side;

import java.util.HashMap;
import java.util.Map;

public class SessionConcept { //HttpSession 내부작동 방식
	public static void main(String[] args) {
		// jsessionid 쿠키값 => 내session 영역 접근 => session.setAttribute
		
		//key:jsessionid 값, value:저장공간(storage)
		Map<String, SessionStorage> sessionMap = new HashMap<String, SessionStorage>();
		
		sessionMap.put("123A123", new SessionStorage());
		
		SessionStorage session = sessionMap.get("123A123");
		session.setAttribute("sessionMsg", "여기다 세션 메시지");
		
		sessionMap.put("BBB222", new SessionStorage());
		
		sessionMap.get("123A123");
		sessionMap.get("BBB222");
	}
}

class SessionStorage{
	
	Map<String,String> storage;
	
	public SessionStorage() {
		storage = new HashMap<String,String>();
	}
	
	public void setAttribute(String key, String value) {
		storage.put(key, value);
	}
	
	public void removeAttribute(String key) {
		storage.remove(key);
	}
	
	public void invalidate() {
		storage.clear();
	}
	
}
