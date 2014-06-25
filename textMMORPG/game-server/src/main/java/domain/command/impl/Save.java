package domain.command.impl;

import service.impl.CommandServiceImpl;
import domain.charactor.Player;
import domain.command.Command;

public class Save implements Command {

	@Override
	public String execute(CommandServiceImpl commandService, String[] cmd, Player player) {
		// TODO Auto-generated method stub
		commandService.getPlayerService().savePlayerToStore(player);
		return commandService.getWorldService().getWorld().getProperties("msg.saveok");
	}

}
