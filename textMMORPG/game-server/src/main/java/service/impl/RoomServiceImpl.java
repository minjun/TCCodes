package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.Room;
import repo.RoomRepository;
import service.RoomService;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepo;
	
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

}
