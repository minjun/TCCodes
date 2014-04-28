package service;

import domain.player.Player;



public interface LoginService {
	Player login(String id, String password);
	void logout(Player player);
}
