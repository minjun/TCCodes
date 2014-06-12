package service;

import java.util.List;

import domain.map.Exit;
import domain.player.Player;

public interface PlayerService {
	// store related player actions
	void savePlayersToStore(List<Player> players);

	void savePlayerToStore(Player player);

	void removePlayserFromStore(Player player);

	Player getPlayerFromStore(String id);

	// memory related player actions
	Player getPlayer(String clientId);

	void updatePlayer(String clientId, Player player);

	void removePlayer(String clientId);

	// commands
	void move(Player player, String roomId);

	void go(Player player, Exit.DIR dir);

	String look(Player player);

	// register
	boolean isValidPlayerID(String id);

	boolean isValidPassword(String pwd);

	boolean isValidName(String name);
}
