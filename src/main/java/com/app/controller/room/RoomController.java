package com.app.controller.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.dto.room.Room;
import com.app.service.room.RoomService;

@Controller
public class RoomController {
	
	@Autowired  // roomservice에알아서집어넣는다.. roomService.findRoomList(); 이렇게쓸수있다
	RoomService roomService;
	
	@GetMapping("/rooms") //접속했을때 보유한 모든 호실 정보 보여주는 페이지
	public String rooms(Model model) {
		
	
		
		//호실정보 준비
		List<Room> roomList = roomService.findRoomList();
		
		//화면에 전달
		model.addAttribute("roomList",roomList);
		
		//화면 연결
		return "room/rooms";
	}
	
}
