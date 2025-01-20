package com.app.service.room;

import java.util.List;

import com.app.dto.room.Room;

public interface RoomService { // 인터페이스
	
	List<Room> findRoomList();
	
	int saveRoom(Room room);

}
