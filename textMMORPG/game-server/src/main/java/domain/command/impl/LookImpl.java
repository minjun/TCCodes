package domain.command.impl;

import domain.charactor.Player;
import domain.command.Command;
import service.impl.CommandServiceImpl;

public class LookImpl implements Command {
	
	@Override
	public String execute(CommandServiceImpl commandService, String cmdId, Player player) {
		return commandService.getRoomService().getRoomDesc(player.getRoomId(), false);
	}

}
