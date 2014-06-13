package service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.Room;
import repo.RoomRepository;
import service.RoomService;

@Service("roomService")
public final class RoomServiceImpl implements RoomService {

	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	final Map<String, Room> rooms = new HashMap<String, Room>();
	@Autowired
	RoomRepository roomRepo;

	/*
	 * @PostConstruct public void init() { rooms.put("kezhan.c",
	 * getRoom("kezhan.c")); }
	 */

	@Override
	public void saveRoom(Room room) {
		roomRepo.save(room);
	}

	@Override
	public Room getRoom(String id) {
		return roomRepo.findOne(id);
	}

	@Override
	public Room findRoom(String roomId) {
		if (!roomId.endsWith(".c")) {
			roomId = roomId + ".c";
		}
		Room room = rooms.get(roomId);
		if (room == null) {
			room = roomRepo.findOne(roomId);
			if (room != null) {
				rooms.put(roomId, room);
				logger.info("Loading room:" + roomId + " successful!");
			} else {
				logger.error("Loading room:" + roomId + " failed!");
			}
		}
		return room;
	}
}
