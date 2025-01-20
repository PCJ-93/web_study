package com.app.dao.room.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;


// DATA 나 APIServiceRepository데이터를 읽어오는 역할 DB접근역할 하는애를  DAO,Repository 라고 부른다 (어노테이션에는 Repository)
@Repository //Bean 등록 Annotation
public class RoomDAOImpl implements RoomDAO {

	@Override
	public List<Room> findRoomList() {
		System.out.println("룸다오");
		//db연결 조회
		
		return null;
	}

	@Override
	public int saveRoom(Room room) {
		
		return 0;
	}
	
	

}
