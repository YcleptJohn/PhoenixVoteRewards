package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import uk.co.ycleptjohn.voteshop.VoteShop;

public class cmdReload implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		if (VoteShop.getPlugin().getConfig() == null) {
			VoteShop.getPlugin().saveDefaultConfig();
		}
		VoteShop.getPlugin().reloadConfig();
		return true;
	}

}
