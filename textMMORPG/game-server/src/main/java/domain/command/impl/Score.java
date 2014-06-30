package domain.command.impl;

import service.impl.CommandServiceImpl;
import domain.charactor.Player;
import domain.command.Command;

public class Score implements Command {

	@Override
	public String execute(CommandServiceImpl commandService, String[] cmd, Player player) {
		if (cmd.length == 1 || cmd[1].equals(player.getId())) {
			return player.score();
		} else {
			return "";
		}
	}

}
