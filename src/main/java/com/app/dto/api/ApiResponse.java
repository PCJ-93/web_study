package com.app.dto.api;

import lombok.Data;

@Data
public class ApiResponse<T> {
	// 제네릭 Generic
	ApiResponseHeader header;
	//헤더는 매번똑같은거 사용하지만 바디는 데이터에따라 타입이 바뀌니까 쓰는거	
	T body;
	

}
