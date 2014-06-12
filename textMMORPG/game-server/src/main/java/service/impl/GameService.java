package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.player.Player;
import service.*;

@Service("gameService")
public class GameService {

	@Autowired
	WorldService worldService;
	@Autowired
	PlayerService playerService;
	@Autowired
	RoomService roomService;
	// @Autowired
	TranslatorService translatorService;
	@Autowired
	LoginService loginService;
	private static final Logger logger = LoggerFactory.getLogger(GameService.class);

	public String Connected() throws Exception {
		return worldService.getWorld().getProperties("msg.welcome") + worldService.getWorld().getProperties("msg.inputid");
	}

	public String logout() {
		return "byebye\n";
	}

	private String register(String idnamepwd) {
		Player player = playerService.getPlayer(idnamepwd);
		Player.PSTATUS status = Player.PSTATUS.END;
		if (player != null)
			status = player.getStatus();
		// player doesn't exist, goto register process
		if (player == null || status == Player.PSTATUS.NOTEXIST) {
			if (!playerService.isValidPlayerID(idnamepwd)) {
				return worldService.getWorld().getProperties("msg.invalidid");
			} else {
				playerService.setRegisterStatus(idnamepwd, Player.PSTATUS.IDINPUT);
				return worldService.getWorld().getProperties("msg.inputname");
			}
		} else if (status == Player.PSTATUS.IDINPUT) {
			if (!playerService.isValidName(idnamepwd)) {
				return worldService.getWorld().getProperties("msg.invalidname");
			} else {
				playerService.setRegisterStatus(idnamepwd, Player.PSTATUS.NAMEINPUT);
				return worldService.getWorld().getProperties("msg.inputpwd");
			}
		} else if (status == Player.PSTATUS.NAMEINPUT) {
			if (!playerService.isValidPassword(idnamepwd)) {
				return worldService.getWorld().getProperties("msg.invalidpwd");
			} else {
				return worldService.getWorld().getProperties("msg.loginok");
			}
		} else {
			return null;
		}
	}

	public String process(String command) {
		if (command.equals(""))
			return "";
		logger.info("command:" + command);
		String registered = register(command);
		if (registered == null) {
		}
		return "did you say " + command + "?";
	}
}
