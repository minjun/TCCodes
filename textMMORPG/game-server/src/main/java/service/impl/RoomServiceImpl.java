package service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Npc;
import domain.item.Item;
import domain.map.Room;
import repo.RoomRepository;
import utils.Utils;
import static utils.Utils.NEWLINE;

@Service("roomService")
public final class RoomServiceImpl {

	private static final Logger logger = LoggerFactory.getLogger(RoomServiceImpl.class);
	final Map<String, Room> rooms = new HashMap<String, Room>();
	@Autowired
	RoomRepository roomRepo;
	@Autowired
	WorldServiceImpl worldService;
	@Autowired
	NpcServiceImpl npcService;
	@Autowired
	ItemServiceImpl itemService;

	public void saveRoom(Room room) {
		roomRepo.save(room);
	}

	public Room getRoom(String id) {
		return roomRepo.findOne(id);
	}

	private void loadObj(Map<String, String> objs, Room room) {
		Iterator<Map.Entry<String, String>> iter = objs.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
			String id = Utils.getFullId(entry.getKey(), room.getId());
			int number = Integer.parseInt(entry.getValue());
			Npc npc;
			Item item;
			if ((npc = npcService.load(id)) != null) {
				logger.info("Loading npc " + id + " successful!");
				while (number > 0) {
					npc.setNumberInRoom(number);
					room.addNpc(npc);
					number--;
				}
			} else if ((item = itemService.load(id)) != null) {
				logger.info("Loading item " + id + " successful!");
				while (number > 0) {
					item.setNumberInRoom(number);
					room.addItem(item);
					number--;
				}
			} else {
				logger.error("Loading " + id + " failed!");
			}
		}
	}

	public Room findRoom(String roomId) {
		Room room = rooms.get(roomId);
		if (room == null) {
			room = roomRepo.findOne(roomId);
			if (room != null) {
				rooms.put(roomId, room);
				loadObj(room.getObjs(), room);
				logger.info("Loading room:" + roomId + " successful!");
			} else {
				logger.error("Loading room:" + roomId + " failed!");
			}
		}
		return room;
	}

	private String getObjDesc(Room room, boolean brief) {
		Map<String, Npc> map = room.getNpcs();
		StringBuffer sb = new StringBuffer();
		Iterator<Npc> iter = map.values().iterator();
		while (iter.hasNext()) {
			Npc npc = iter.next();
			String title = Utils.nullStringtoEmpty(npc.getSet("title"), true);
			sb.append(title).append(npc.getName()).append('(').append(npc.getNpcId()).append(')').append(Utils.NEWLINE);
		}
		return sb.toString();
	}

	public String getRoomDesc(String roomId, boolean brief) {
		Room room = findRoom(roomId);
		if (room == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append(" - " + room.getSets("short"));
		sb.append(" [").append(room.getId()).append("]");
		sb.append(NEWLINE);
		if (!brief) {
			sb.append(room.getSets("long"));
		}
		sb.append(NEWLINE);
		Map<String, String> exits = room.getExits();
		if (!exits.isEmpty()) {
			sb.append(worldService.getWorld().getProperties("msg.exit"));
			Iterator<String> iter = exits.keySet().iterator();
			while (iter.hasNext()) {
				sb.append(iter.next()).append('¡¢');
			}
			sb.setCharAt(sb.length() - 1, '¡£');
		} else {
			sb.append(worldService.getWorld().getProperties("msg.noexits"));
		}
		sb.append(NEWLINE);
		sb.append(getObjDesc(room, brief));
		return sb.toString();
	}
}
