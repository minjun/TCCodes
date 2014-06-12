package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.map.Exit;
import domain.player.Player;
import repo.PlayerRepository;
import service.PlayerService;
import service.RoomService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
	final static int ID_MINLEN = 4;
	Map<String, Player> players = new HashMap<String, Player>();
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	RoomService roomService;

	@Override
	public void savePlayers(List<Player> players) {
		playerRepo.save(players);
	}

	@Override
	public Player getPlayer(String id) {
		return playerRepo.findOne(id);
	}

	@Override
	public void savePlayer(Player player) {
		playerRepo.save(player);
	}

	@Override
	public void removePlayser(Player player) {
	}

	@Override
	public void move(Player player, String roomId) {
		player.setRoomId(roomId);
		roomService.findRoom(roomId).addPlayer(player);
	}

	@Override
	public void go(Player player, Exit.DIR dir) {

	}

	@Override
	public String look(Player player) {
		return roomService.findRoom(player.getRoomId()).getMessage(false);
	}

	@Override
	public boolean isValidPlayerID(String id) {
		return id.length() >= ID_MINLEN;
	}

	public Player.PSTATUS getRegisterStatus(String id) {
		Player player = players.get(id);
		if (player == null)
			return Player.PSTATUS.NOTEXIST;
		else
			return player.getStatus();
	}

	@Override
	public void setRegisterStatus(String id,Player.PSTATUS status) {
		Player player = players.get(id);
		if (player == null)
			player= new Player(id,null,null);
		player.setStatus(status);
		players.put(id, player);
	}
}
