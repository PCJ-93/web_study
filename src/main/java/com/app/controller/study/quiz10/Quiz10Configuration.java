package com.app.controller.study.quiz10;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Quiz10Configuration {

	@Bean
	public Customer customer() {
		
		Customer customer = new Customer();
		customer.setName("김상식");
		
		return customer;
	}
	
	@Bean
	public AddNewCustomer addNewCustomer(Customer customer) {
		return new AddNewCustomer(customer);
	}
	
	@Bean
	public Room room() {
		Room room = new Room();
		room.setRoomNumber("101호");
		return room;
	}
	
	@Bean
	AddNewRoom addNewRoom(Room room) {
		AddNewRoom addNewRoom = new AddNewRoom();
		addNewRoom.addNewRoom(room);
		return addNewRoom;
	}
	
}
