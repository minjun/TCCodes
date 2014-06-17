package service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl {

	@Autowired
	WorldServiceImpl worldService;
	@Autowired
	PlayerServiceImpl playerService;
	@Autowired
	RoomServiceImpl roomService;
	@Autowired
	LoginServiceImpl loginService;
	private static final Logger logger = LoggerFactory.getLogger(GameServiceImpl.class);

	public String Connected() throws Exception {
		return worldService.getWorld().getProperties("msg.welcome") + worldService.getWorld().getProperties("msg.inputid");
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
		} else {
			return playerService.command(command, clientId);
		}
	}
}