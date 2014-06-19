package service.impl;

import static utils.Utils.getFullId;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.charactor.Player;
import domain.command.Command;
import domain.command.impl.*;
import domain.map.Exit;
import static utils.InputMapper.*;

@Service("commandService")
public class CommandServiceImpl {
	@Autowired
	PlayerServiceImpl playerService;
	@Autowired
	RoomServiceImpl roomService;
	@Autowired
	WorldServiceImpl worldService;

	public PlayerServiceImpl getPlayerService() {
		return playerService;
	}

	public RoomServiceImpl getRoomService() {
		return roomService;
	}

	public WorldServiceImpl getWorldService() {
		return worldService;
	}

	Map<String, Command> commandMapper = new HashMap<String, Command>();

	@PostConstruct
	private void buildCommandMapper() {
		commandMapper.put("look", new Look());
		commandMapper.put("hp", new Hp());
	}

	private static final Logger logger = LoggerFactory.getLogger(PlayerServiceImpl.class);

	public String go(Player player, String dir) {
		Map<String, String> exits = roomService.findRoom(player.getRoomId()).getExits();
		String roomId = exits.get(dir);
		if (roomId != null) {
			roomId = getFullId(roomId, player.getRoomId());
			return playerService.move(player, roomId);
		}
		return worldService.getWorld().getProperties("msg.nosuchexit");
	}

	public String command(String commandId, String clientId) {
		Player player = playerService.getPlayer(clientId);
		Command command;
		if (player == null) {
			logger.error("can't find player from " + clientId);
			return "";
		}
		String[] cmds = commandId.split(" ");
		commandId = getInputMap(commandId);
		if (Exit.isValidExit(commandId)) {
			return go(player, commandId);
		} else if ((command = commandMapper.get(getInputMap(cmds[0]))) != null) {
			return command.execute(this, cmds, player);
		} else {
			return worldService.getWorld().getProperties("msg.unknowncmd");
		}
	}
}
