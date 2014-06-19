package domain.command.impl;

import domain.charactor.Player;
import domain.command.Command;
import service.impl.CommandServiceImpl;

public class Look implements Command {

	@Override
	public String execute(CommandServiceImpl commandService, String[] cmd, Player player) {
		if (cmd.length == 1)
			return commandService.getRoomService().getRoomDesc(player.getRoomId(), false);
		else {
			return "";
		}
	}

}
