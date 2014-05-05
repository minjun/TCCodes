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
		// TODO Auto-generated method stub
		String msg = worldService.getWorld().getProperties("welcome");
		msg = new String("测试".getBytes("UTF-8"), "GBK");
		return msg;
	}

	public String logout() {
		// TODO Auto-generated method stub
		return "byebye\n";
	}

	public String process(String command) {
		// TODO Auto-generated method stub
		if (command.equals(""))
			return "";
		logger.info("command:" + command);
		return "did you say " + command + "?";
	}
}
