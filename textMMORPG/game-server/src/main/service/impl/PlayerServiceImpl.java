package service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Player;
import service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    @Override
    public void savePlayers(List<Player> players) {
	// TODO Auto-generated method stub
	for (Player player:players) {
	    
	}
    }

    @Override
    public Player getPlayer(String id) {
	// TODO Auto-generated method stub
	return null;
    }

}
