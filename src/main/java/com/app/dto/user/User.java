package com.app.dto.user;

import lombok.Data;

@Data
public class User {
	//이것들은 common에 넣어서 관리하면 편하다~
//	public static final String USERTYPE_CUSTOMER = "CUS";
//	public static final String USERTYPE_ADMIN = "ADM";

	String id;
	String pw;
	String name;
	String userType;  // CUS(Customer)   ADM(Admin)
	
}
