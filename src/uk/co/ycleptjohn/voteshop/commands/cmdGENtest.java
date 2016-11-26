package uk.co.ycleptjohn.voteshop.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import uk.co.ycleptjohn.voteshop.configuration.Config;
import uk.co.ycleptjohn.voteshop.configuration.ConfigFile;
import uk.co.ycleptjohn.voteshop.configuration.ConfigHandler;

public class cmdGENtest implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler ch = new ConfigHandler();
		//cf.regenerateAllConfigs();
		ch.regenerateAllConfigsIfMissing();
		
		ConfigFile perks = ch.get(Config.PERKS);
		System.out.println(perks.toString());
		System.out.println(perks.contains("name"));
		System.out.println(perks.get("name"));
		System.out.println(perks);
		System.out.println(perks.getCurrentPath());
		
		
		
		//yml.createSection("name.test.p");
		
		return true;
	}

}
