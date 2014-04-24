package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.PlayerRepository;
import domain.Player;
import service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {
    
    @Autowired
    PlayerRepository playerDao;
    @Override
    public void savePlayers(List<Player> players) {
	// TODO Auto-generated method stub
	playerDao.save(players);
    }

    @Override
    public Player getPlayer(String id) {
	// TODO Auto-generated method stub
	return playerDao.findOne(id);
    }

}
