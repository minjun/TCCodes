package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.player.Player;


import service.LoginService;
import service.PlayerService;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	PlayerService playerService;

	@Override
	public Player login(String id, String password) {
		Player player = playerService.getPlayer(id);
		if (player == null || password == null || !password.equals(player.getPassword())) {
			return null;
		}
		return player;
	}

	@Override
	public void logout(Player player) {
		playerService.savePlayer(player);
		playerService.removePlayser(player);
	}

}
