package service;

import java.util.List;

import domain.player.Player;



public interface PlayerService {
    void savePlayers(List<Player> players);
    void savePlayer(Player player);
    void removePlayser(Player player);
    Player getPlayer(String id);
}
