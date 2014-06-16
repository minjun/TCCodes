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
import service.WorldService;

@Service("roomService")
public final class RoomServiceImpl implements RoomService {

	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	final Map<String, Room> rooms = new HashMap<String, Room>();
	final static String NEWLINE = "\r\n";
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	WorldService worldService;

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

	@Override
	public String getRoomDesc(String roomId, boolean brief) {
		Room room = findRoom(roomId);
		if (room == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" - " + room.getSets("short"));
		sb.append(NEWLINE);
		if (!brief) {
			sb.append(room.getSets("long"));
		}
		sb.append(NEWLINE);
//		List<Exit> exs = room.getExits();
//		if (exs.size() > 0) {
//			sb.append(worldService.getWorld().getProperties("msg.exit"));
//			for (Exit ex : exs) {
//				sb.append(ex.getDir().toString()).append('¡¢');
//			}
//			sb.setCharAt(sb.length() - 1, '¡£');
//		} else {
//			sb.append(worldService.getWorld().getProperties("msg.noexits"));
//		}
		sb.append(NEWLINE);
		return sb.toString();
	}
}
