package com.app.common;

public interface ApiCommonCode {
	
	String API_RESULT_SUCCESS = "10";  // 정상 
	String API_RESULT_TEMP_ERROR = "20"; // 일시적 문제
	String API_RESULT_FAIL_AUTH = "30"; // 인증불가
	String API_RESULT_NO_DATA = "40"; // 데이터 없음
	
	String API_RESULT_SUCCESS_MSG = "정상";  // 정상 
	String API_RESULT_TEMP_ERROR_MSG = "일시적인문제"; // 일시적 문제
	String API_RESULT_FAIL_AUTH_MSG = "인증불가"; // 인증불가
	String API_RESULT_NO_DATA_MSG = "데이터없음"; // 데이터 없음

}
