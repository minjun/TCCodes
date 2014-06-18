package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Player;

@Service("loginService")
public class LoginServiceImpl {

	@Autowired
	PlayerServiceImpl playerService;
	@Autowired
	WorldServiceImpl worldService;
	@Autowired
	RoomServiceImpl roomService;

	public String login(String input, String clientId) {
		Player player = playerService.getPlayer(clientId);
		Player.PSTATUS status = Player.PSTATUS.END;
		if (player != null)
			status = player.getStatus();
		if (status == Player.PSTATUS.END) {
			if (!playerService.isValidPlayerID(input)) {
				return worldService.getWorld().getProperties("msg.invalidid");
			} else {
				player = playerService.getPlayerFromStore(input);
				if (player == null) {
					player = new Player(input, null, null);
					player.setStatus(Player.PSTATUS.IDINPUT);
					playerService.updatePlayer(clientId, player);
					return worldService.getWorld().getProperties("msg.confirmnewid");
				} else {
					player.setStatus(Player.PSTATUS.NAMEINPUT);
					playerService.updatePlayer(clientId, player);
					return worldService.getWorld().getProperties("msg.inputpwd");
				}
			}
		} else if (status == Player.PSTATUS.IDINPUT) {
			if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")) {
				player.setStatus(Player.PSTATUS.IDCONFIRMED);
				playerService.updatePlayer(clientId, player);
				return worldService.getWorld().getProperties("msg.inputname");
			} else {
				player.setStatus(Player.PSTATUS.END);
				playerService.updatePlayer(clientId, player);
				return worldService.getWorld().getProperties("msg.inputid");
			}
		} else if (status == Player.PSTATUS.IDCONFIRMED) {
			if (!playerService.isValidName(input)) {
				return worldService.getWorld().getProperties("msg.invalidname");
			} else {
				player.setName(input);
				player.setStatus(Player.PSTATUS.NAMEINPUT);
				playerService.updatePlayer(clientId, player);
				return worldService.getWorld().getProperties("msg.inputpwd");
			}
		} else if (status == Player.PSTATUS.NAMEINPUT) {
			if (!playerService.isValidPassword(input)) {
				return worldService.getWorld().getProperties("msg.invalidpwd");
			} else {
				if (player.isInStore() && !player.getPassword().equalsIgnoreCase(input)) {
					return worldService.getWorld().getProperties("msg.wrongpwd");
				} else if (!player.isInStore()) {
					player.born();
				}
				player.setPassword(input);
				player.setStatus(Player.PSTATUS.NORMAL);
				playerService.updatePlayer(clientId, player);
				playerService.savePlayerToStore(player);
				String msg = playerService.move(player, player.getRoomId());
				return worldService.getWorld().getProperties("msg.loginok") + msg;
			}
		} else {
			return null;
		}
	}

	public String logout(String clientId) {
		Player player = playerService.getPlayer(clientId);
		if (player != null && player.needSave()) {
			playerService.savePlayerToStore(player);
			playerService.removePlayer(clientId);
		}
		return worldService.getWorld().getProperties("msg.logout");
	}

}
