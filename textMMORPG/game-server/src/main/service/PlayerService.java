package service;

import java.util.List;
import domain.Player;

public interface PlayerService {
    void savePlayers(List<Player> players);
    Player getPlayer(String id);
}
