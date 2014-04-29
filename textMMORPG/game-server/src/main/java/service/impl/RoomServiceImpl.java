package service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.Room;
import repo.RoomRepository;
import service.RoomService;

@Service("roomService")
public final class RoomServiceImpl implements RoomService {

	final Map<String, Room> rooms = new HashMap<String, Room>();
	@Autowired
	RoomRepository roomRepo;

	@PostConstruct
	public void init() {
		rooms.put("kezhan.c", getRoom("kezhan.c"));
	}

	@Override
	public void saveRoom(Room room) {
		// TODO Auto-generated method stub
		roomRepo.save(room);
	}

	@Override
	public Room getRoom(String id) {
		// TODO Auto-generated method stub
		return roomRepo.findOne(id);
	}

	@Override
	public Room findRoom(String roomId) {
		// TODO Auto-generated method stub
		System.out.println("rooms="+rooms.keySet().size());
		return rooms.get(roomId);
	}
}
