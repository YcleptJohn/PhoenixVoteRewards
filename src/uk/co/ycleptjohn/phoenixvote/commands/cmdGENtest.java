package uk.co.ycleptjohn.phoenixvote.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import uk.co.ycleptjohn.phoenixvote.configuration.ConfigHandler;

public class cmdGENtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler cf = new ConfigHandler();
		cf.regenerateAllConfigs();
		return true;
	}

}
