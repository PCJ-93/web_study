package com.app.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;
import com.app.service.user.UserService;

@Controller
public class AdminController { // 어드민 컨트롤러 만들어서 관리자만 사용하는것
	
	@Autowired
	RoomService roomService; //어드민은 룸서비스랑 유저서비스 둘다 쓸수있게해줌
	
	@Autowired
	UserService userService;
	
	// 객실 등록
	@GetMapping("/admin/registerRoom")
	public String registerRoom() {
		return "admin/registerRoom";
	}
	
	@PostMapping("/admin/registerRoom")
	public String registerRoomAction(Room room) {
		//값넘어온것 확인
		//System.out.println(room.toString());
		//등록
		
		return "admin/registerRoom";
	}
	
	// 고객 관리/등록

}
