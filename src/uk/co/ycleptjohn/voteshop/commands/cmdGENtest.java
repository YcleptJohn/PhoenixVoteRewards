package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.ycleptjohn.voteshop.configuration.Config;
import uk.co.ycleptjohn.voteshop.configuration.ConfigHandler;
import uk.co.ycleptjohn.voteshop.configuration.Configs;

public class cmdGENtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler ch = new ConfigHandler();
		//cf.regenerateAllConfigs();
		ch.regenerateAllConfigsIfMissing();
		
		Config perks = ch.get(Configs.GENERAL);
		perks.test();
		
		//yml.createSection("name.test.p");
		
		
		
		
		
		return true;
	}

}
