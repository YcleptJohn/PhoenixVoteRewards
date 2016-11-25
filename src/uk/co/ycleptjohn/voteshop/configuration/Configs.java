package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;

import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.VoteShop;

public enum Configs {
	GENERAL("general", "general.yml"),
	PERKS("perks", "perks.yml"),
	MESSAGES("messages", "messages.yml");
	
	private Plugin plugin = VoteShop.getPlugin();
	private String name;
	private Config conf;
	
	Configs(String configName, String fileName) {
		name = configName;
		conf = new Config(new File(plugin.getDataFolder(), fileName), fileName);
	}
	
	public Config getConfig() {
		return conf;
	}
	
	public String getName() {
		return name;
	}
}
