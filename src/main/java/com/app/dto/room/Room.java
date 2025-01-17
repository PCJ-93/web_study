package com.app.dto.room;

import lombok.Data;


//@Getter
//@Setter
//@ToString
//@NoArgsConstructor    // 기본생성자
//@AllArgsConstructor  //파라미터 다들어가는 생성자

@Data  // getter, setter , tostring 다가지고 있는애 noarg,allarg는 없다
public class Room {
	
	int roomId;  //primary key
	String buildingNumber;  //동이름 A동 B동...
	int roomNumber; //호실번호 101호 405호
	int floor; // 층 1층 2층 5층..
	int maxGuestCount; //최대숙박인원
	String viewType; // OCN /CTY /MOT .. 오션뷰 시티뷰 마운틴뷰
	
	
	// 뒤늦게 추가된 정보들을 편하게 getter setter tostring 생성자 관리해주는 lombok 라이브러리
	// lombok 없었으면 accomodationId 만들때 다 일일히 만들어줘야댐
	int accomodationId;
	

}
