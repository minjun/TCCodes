package domain.command.impl;

import service.impl.CommandServiceImpl;
import domain.charactor.Player;
import domain.command.Command;

public class HpImpl implements Command {

	@Override
	public String execute(CommandServiceImpl commandService, String cmdId, Player player) {
		return player.getHP();
	}
}
