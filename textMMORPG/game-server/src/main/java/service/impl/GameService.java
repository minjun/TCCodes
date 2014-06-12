package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		return worldService.getWorld().getProperties("msg.welcome")
				+ worldService.getWorld().getProperties("msg.inputid");
	}

	public String logout(String clientId) {
		return loginService.logout(clientId);
	}

	public String process(String command, String clientId) {
		if (command.equals(""))
			return "";
		logger.info(clientId + ":" + command);
		String registered = loginService.login(command, clientId);
		if (registered != null) {
			return registered;
		}
		return "did you say " + command + "?";
	}
}
