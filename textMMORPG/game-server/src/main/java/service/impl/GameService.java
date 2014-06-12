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
		String msg = worldService.getWorld().getProperties("welcome");
		return msg;
	}

	public String logout() {
		return "byebye\n";
	}
	private boolean isResitering(String id) {

		Player player = playerService.getPlayer(command);
		// player doesn't exist, goto register process
		if (player == null || player.getStatus(command)) {
			return register(command);
		}
		
	}
	private String register(String id) {
		if (playerService.(id)) {
			
		}
		if (!playerService.isValidPlayerID(id)) {
			return worldService.getWorld().getProperties("msg_invalidid");
		}
		return worldService.getWorld().getProperties("input_password");
	}

	public String process(String command) {
		if (command.equals(""))
			return "";
		boolean isRgistering = 
		logger.info("command:" + command);
		return "did you say " + command + "?";
	}
}
