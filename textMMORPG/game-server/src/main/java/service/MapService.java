package service;

import domain.map.Room;

public interface MapService {
	void saveRoom(Room room);
	Room getRoom(String id);
}
