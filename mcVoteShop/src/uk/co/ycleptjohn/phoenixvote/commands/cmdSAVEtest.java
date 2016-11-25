package uk.co.ycleptjohn.phoenixvote.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.ycleptjohn.phoenixvote.configuration.Config;
import uk.co.ycleptjohn.phoenixvote.configuration.ConfigHandler;

public class cmdSAVEtest implements CommandExecutor {
	
	public int i = 0;
	
	@Override
	public boolean onCommand(CommandSender cmdP, Command cmd, String cmdLbl, String[] args) {
		ConfigHandler cf = new ConfigHandler();
		for(Config c : cf.getConfigsMap().values()) {
			c.getYamlConf().createSection(i + "");					System.out.println("l21");
			c.getYamlConf().createSection((i*2) + "");				System.out.println("l22");
			c.getYamlConf().set(i + "", "test"); 						System.out.println("l23");
			c.save();														System.out.println("l24");
			i++;															System.out.println("l25");
		}
		
		return true;
	}
}
