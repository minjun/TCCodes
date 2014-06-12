package service;

import java.util.List;

import domain.map.Exit;
import domain.player.Player;



public interface PlayerService {
    void savePlayers(List<Player> players);
    void savePlayer(Player player);
    void removePlayser(Player player);
    Player getPlayer(String id);
    void move(Player player, String roomId);
    void go(Player player, Exit.DIR dir);
    String look(Player player);
    // register
    boolean isValidPlayerID(String id);
    boolean isValidPassword(String pwd);
    boolean isValidName(String name);
    Player.PSTATUS getRegisterStatus(String id);
    void setRegisterStatus(String id,Player.PSTATUS status);
}
