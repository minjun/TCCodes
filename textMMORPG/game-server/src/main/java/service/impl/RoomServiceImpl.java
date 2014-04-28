package service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import domain.map.Room;
import repo.RoomRepository;
import service.MapService;

public class RoomServiceImpl implements MapService {

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
