package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Player;
import domain.charactor.Player.PSTATUS;
import domain.map.Room;
import repo.PlayerRepository;

@Service("playerService")
public class PlayerServiceImpl {
	final static int ID_MINLEN = 4;
	final static int PWD_MINLEN = 4;
	final static int NAME_MINLEN = 4;
	Map<String, Player> players = new HashMap<String, Player>();
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	WorldServiceImpl worldService;
	@Autowired
	RoomServiceImpl roomService;
	@Autowired
	ItemServiceImpl itemService;
	private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

	public void savePlayersToStore(List<Player> players) {
		playerRepo.save(players);
	}

	public void savePlayerToStore(Player player) {
		if (player.needSave()) {
			playerRepo.save(player);
		}
	}
	
	public void removePlayserFromStore(Player player) {
		player.setStatus(PSTATUS.DELETED);
		playerRepo.save(player);
	}

	public Player getPlayerFromStore(String id) {
		Player player = playerRepo.findOne(Player.PREFIX + id);
		player.loadRegularItem(itemService);
		if (player != null)
			player.setInStore(true);
		return player;
	}

	public boolean isValidPassword(String pwd) {
		return pwd.length() >= PWD_MINLEN;
	}

	public boolean isValidPlayerID(String id) {
		return id.length() >= ID_MINLEN;
	}

	public boolean isValidName(String name) {
		return name.length() >= NAME_MINLEN;
	}

	public Player getPlayer(String clientId) {
		return players.get(clientId);
	}

	public void updatePlayer(String clientId, Player player) {
		logger.info("player updated:" + player.toString());
		players.put(clientId, player);
	}

	public void removePlayer(String clientId) {
		Player player = getPlayer(clientId);
		if (player == null)
			logger.warn("remove player failed:can't find player!");
		else
			roomService.findRoom(player.getRoomId()).removePlayer(player);
		players.remove(clientId);
	}

	public String move(Player player, String roomId) {
		Room room = roomService.findRoom(roomId);
		if (room != null) {
			roomService.findRoom(player.getRoomId()).removePlayer(player);
			player.setRoomId(roomId);
			room.addPlayer(player);
			return roomService.getRoomDesc(player.getRoomId(), player.getSettings(Player.SET_BRIEF) != null);
		} else {
			logger.error("room:" + roomId + " doesn't exit!");
			return worldService.getWorld().getProperties("msg.noroomexist");
		}
	}
}
