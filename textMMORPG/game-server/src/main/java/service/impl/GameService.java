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
		String msg = worldService.getWorld().getProperties("welcome");
		return msg;
	}

	public String logout() {
		return "byebye\n";
	}

	public String process(String command) {
		if (command.equals(""))
			return "";
		logger.info("command:" + command);
		return "did you say " + command + "?";
	}
}
