package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.Exit;
import domain.player.Player;
import domain.player.Player.PSTATUS;
import repo.PlayerRepository;
import service.PlayerService;
import service.RoomService;
import service.WorldService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	final static int ID_MINLEN = 4;
	final static int PWD_MINLEN = 4;
	final static int NAME_MINLEN = 4;
	Map<String, Player> players = new HashMap<String, Player>();
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	WorldService worldService;
	@Autowired
	RoomService roomService;
	private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

	@Override
	public void savePlayersToStore(List<Player> players) {
		playerRepo.save(players);
	}

	@Override
	public void savePlayerToStore(Player player) {
		if (player.needSave())
			playerRepo.save(player);
	}

	@Override
	public void removePlayserFromStore(Player player) {
		player.setStatus(PSTATUS.DELETED);
		playerRepo.save(player);
	}

	@Override
	public Player getPlayerFromStore(String id) {
		Player player = playerRepo.findOne(Player.PREFIX + id);
		if (player != null)
			player.setInStore(true);
		return player;
	}

	@Override
	public boolean isValidPassword(String pwd) {
		return pwd.length() >= PWD_MINLEN;
	}

	@Override
	public boolean isValidPlayerID(String id) {
		return id.length() >= ID_MINLEN;
	}

	@Override
	public boolean isValidName(String name) {
		return name.length() >= NAME_MINLEN;
	}

	@Override
	public Player getPlayer(String clientId) {
		return players.get(clientId);
	}

	@Override
	public void updatePlayer(String clientId, Player player) {
		logger.info("player updated:" + player.toString());
		players.put(clientId, player);
	}

	@Override
	public void removePlayer(String clientId) {
		Player player = getPlayer(clientId);
		if (player == null)
			logger.warn("remove player failed:can't find player!");
		else
			roomService.findRoom(player.getRoomId()).removePlayer(player);
		players.remove(clientId);
	}

	@Override
	public String move(Player player, String roomId) {
		roomService.findRoom(player.getRoomId()).removePlayer(player);
		player.setRoomId(roomId);
		roomService.findRoom(player.getRoomId()).addPlayer(player);
		return roomService.findRoom(player.getRoomId()).getMessage(player.getSettings(Player.SET_BRIEF) != null);
	}

	@Override
	public String go(Player player, String dir) {
		logger.info("dir=" + dir);
		List<Exit> exits = roomService.findRoom(player.getRoomId()).getExits();
		for (Exit ex : exits) {
			logger.info(String.format("exit = %s[%s-%s]", ex.getDir(), ex.getCountryId(), ex.getRoomId()));
			if (dir.equals(ex.getDir().toString())) {
				return move(player, ex.getCountryId()+"_"+ex.getRoomId());
			}
		}
		return worldService.getWorld().getProperties("msg.noexits");
	}

	@Override
	public String look(Player player) {
		return roomService.findRoom(player.getRoomId()).getMessage(false);
	}

	@Override
	public String command(String commandId, String clientId) {
		Player player = players.get(clientId);
		String rsp = null;
		if (player == null) {
			logger.error("can't find player from " + clientId);
			return "";
		}
		if (commandId.equalsIgnoreCase("look") || commandId.equalsIgnoreCase("l")) {
			return look(player);
		} else if ((rsp = Exit.getExit(commandId)) != null) {
			return go(player, rsp);
		} else {
			return worldService.getWorld().getProperties("msg.unknowncmd");
		}
	}
}
