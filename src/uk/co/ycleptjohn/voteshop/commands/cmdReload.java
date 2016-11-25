package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import uk.co.ycleptjohn.voteshop.PhoenixVote;

public class cmdReload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		if (PhoenixVote.getPlugin().getConfig() == null) {
			PhoenixVote.getPlugin().saveDefaultConfig();
		}
		PhoenixVote.getPlugin().reloadConfig();
		return true;
	}

}
