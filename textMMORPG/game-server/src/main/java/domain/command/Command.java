package domain.command;

import domain.charactor.Player;
import service.impl.CommandServiceImpl;

public interface Command {
	String execute(CommandServiceImpl commandService, String[] cmd, Player player);
}
