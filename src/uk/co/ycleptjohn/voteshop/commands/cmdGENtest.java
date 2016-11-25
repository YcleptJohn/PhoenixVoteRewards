package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import uk.co.ycleptjohn.voteshop.configuration.ConfigHandler;

public class cmdGENtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler cf = new ConfigHandler();
		cf.regenerateAllConfigs();
		return true;
	}

}
