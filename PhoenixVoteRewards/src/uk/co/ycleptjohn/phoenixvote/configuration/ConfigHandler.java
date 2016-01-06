package uk.co.ycleptjohn.phoenixvote.configuration;

import java.io.File;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class ConfigHandler {
	private ConfigList configs = new ConfigList();
	
	public ConfigHandler() {
		configs.add("general", new Config(new File("general.yml"), "not/sure/yet!"));
		// Add other configs ofc
		
	}
	
	/**
	 * Saves config files - Or generates if non-existant
	 */
	public void saveConfigs() {
		for(Config c : configs.getConfigMap().values()) {
			c.save();
		}
	}
	
	public void saveConfig(String configToSave) {
		configs.getConfig(configToSave).save();
	}
	
	public YamlConfiguration getConfig(String configToGet) {
		return YamlConfiguration.loadConfiguration(configs.getConfig(configToGet).getFile());
	}
	
	public File getConfigFile(String configToGet) {
		return configs.getConfig(configToGet).getFile();
	}
	
	
	public void regenerateConfig(String configToReset) {
		//TODO Selective resets
	}
	
	public void regenerateAllConfigs() {
		Plugin p = PhoenixVote.getPlugin();
		p.saveResource("general.yml", true);
		
	}
	
	//TODO Get all config fields based on config name param
	//TODO flesh out functional methods; save etc
	
}
