package uk.co.ycleptjohn.phoenixvote.configuration;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class ConfigHandler {
	//private HashMap<String, YamlConfiguration> configs;
	
	public ConfigHandler() {
		//saveConfigs(); Clear any non-existing null errors before loading
	}
	
	/**
	 * Saves config files - Or generates if non-existant
	 */
	public void saveConfigs() {
		File datadir = PhoenixVote.getPlugin().getDataFolder();
		YamlConfiguration general = new YamlConfiguration();
		YamlConfiguration messages = new YamlConfiguration();
		YamlConfiguration perks = new YamlConfiguration();
		
		try {
			general.save(datadir.toString() + "general.yml");
			messages.save(datadir.toString() + "messages.yml");
			perks.save(datadir.toString() + "perks.yml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(!datadir.exists()) {
			PhoenixVote.getPlugin().getDataFolder().mkdirs();
		}
		
		
		
		
	}
	
	public YamlConfiguration getConfig(String configToGet) {
		File datadir = PhoenixVote.getPlugin().getDataFolder();
		YamlConfiguration config = new YamlConfiguration();
		
		if (configToGet.equalsIgnoreCase("general")) {
			config = YamlConfiguration.loadConfiguration(new File(datadir, "general.yml"));
		}
		else if (configToGet.equalsIgnoreCase("messages")) {
			config = YamlConfiguration.loadConfiguration(new File(datadir, "messages.yml"));
		}
		else if (configToGet.equalsIgnoreCase("perks")) {
			config = YamlConfiguration.loadConfiguration(new File(datadir, "perks.yml"));
		}
		return config;
	}
	
	
	public void regenerateConfig(String configToReset) {
		//TODO Selective resets
	}
	
	public void regenerateAllConfigs() {
		Plugin p = PhoenixVote.getPlugin();
		p.saveResource("general.yml", true);
		
	}
}
