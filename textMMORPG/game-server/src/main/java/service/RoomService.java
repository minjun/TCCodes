package service;

import domain.map.Room;

public interface RoomService {
	void saveRoom(Room room);
	Room getRoom(String id);
}
