package com.app.dto.user;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	//이것들은 common에 넣어서 관리하면 편하다~
//	public static final String USERTYPE_CUSTOMER = "CUS";
//	public static final String USERTYPE_ADMIN = "ADM";

	@NotBlank(message="이거 필수입력해")
	String id;
	
	@NotBlank
	@Size(min = 8, max = 12, message="8자리 이상 12자리 이하만 가능")
	String pw;
	
	@NotBlank
	String name;
	
	@NotBlank
	String userType;  // CUS(Customer)   ADM(Admin)
	
//	@Email
//	String email;
}
