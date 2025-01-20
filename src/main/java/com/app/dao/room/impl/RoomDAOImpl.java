package com.app.dao.room.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.room.RoomDAO;
import com.app.dto.room.Room;


// DATA 나 APIServiceRepository데이터를 읽어오는 역할 DB접근역할 하는애를  DAO,Repository 라고 부른다 (어노테이션에는 Repository)
@Repository //Bean 등록 Annotation
public class RoomDAOImpl implements RoomDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<Room> findRoomList() {
		System.out.println("룸다오");
		//db연결 조회
		
		return null;
	}

	@Override
	public int saveRoom(Room room) {
		// DB 에 전달받은 Room 객체에 들어있는 데이터를 잘 저장~
		
		int result = sqlSessionTemplate.insert("room_mapper.saveRoom", room);
		
		return result;
	}
	
	

}
