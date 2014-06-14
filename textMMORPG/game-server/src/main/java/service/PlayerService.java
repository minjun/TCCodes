package service;

import java.util.List;

import domain.charactor.Player;

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
	String move(Player player, String roomId);

	String go(Player player, String exit);

	String look(Player player);

	String command(String commandId, String clientId);

	// register
	boolean isValidPlayerID(String id);

	boolean isValidPassword(String pwd);

	boolean isValidName(String name);
}
