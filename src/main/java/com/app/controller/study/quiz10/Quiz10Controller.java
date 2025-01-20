package com.app.controller.study.quiz10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Quiz10Controller {

	@Autowired
	AddNewCustomer addNewCustomer;

	@Autowired
	AddNewRoom addNewRoom;

	@GetMapping("/quiz/cr")
	public String fullOrder() {
		System.out.println("고객명 : " + addNewCustomer.customer.name);
		System.out.println("예약한 방번호 : " + addNewRoom.room.roomNumber);

		return "quiz/quiz09/orderBean";
	}

}
