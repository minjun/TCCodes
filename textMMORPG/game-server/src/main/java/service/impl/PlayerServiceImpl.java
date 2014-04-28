package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.player.Player;
import repo.PlayerRepository;
import service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	PlayerRepository playerRepo;
	
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

}
