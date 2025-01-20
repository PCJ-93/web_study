package com.app.dto.user;

import lombok.Data;

@Data
public class User {
	
	String id;
	String pw;
	String name;
	String userType;  // CUS:고객  ADM:관리자

}
