package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import uk.co.ycleptjohn.voteshop.configuration.Config;
import uk.co.ycleptjohn.voteshop.configuration.ConfigHandler;

public class cmdGENtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler ch = new ConfigHandler();
		//cf.regenerateAllConfigs();
		ch.regenerateAllConfigsIfMissing();
		
		Config perks = ch.getConfig("perks");
		
		
		//yml.createSection("name.test.p");
		
		
		
		
		
		return true;
	}

}
