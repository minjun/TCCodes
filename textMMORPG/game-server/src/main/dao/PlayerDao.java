package dao;

import domain.Player;

public interface PlayerDao {
    Player getPlayer(String id);
    void storePlayer(Player player);
}
