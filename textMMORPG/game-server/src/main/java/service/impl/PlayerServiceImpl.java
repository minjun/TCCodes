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
	Map<String, Player> map = new HashMap<String, Player>();
	@Autowired
	PlayerRepository playerRepo;
	@Autowired
	RoomService roomService;

	@Override
	public void savePlayers(List<Player> players) {
		// TODO Auto-generated method stub
		playerRepo.save(players);
	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return playerRepo.findOne(id);
	}

	@Override
	public void savePlayer(Player player) {
		// TODO Auto-generated method stub
		playerRepo.save(player);
	}

	@Override
	public void removePlayser(Player player) {
		// TODO Auto-generated method stub
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
}
