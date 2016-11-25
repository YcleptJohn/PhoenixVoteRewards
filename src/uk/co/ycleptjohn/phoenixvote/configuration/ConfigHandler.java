package uk.co.ycleptjohn.phoenixvote.configuration;

import java.io.File;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.phoenixvote.PhoenixVote;

public class ConfigHandler {
	private ConfigList configs = new ConfigList();
	private Plugin plugin = PhoenixVote.getPlugin();
	
	public ConfigHandler() {
		configs.add("general", new Config(new File(plugin.getDataFolder(), "general.yml"), "general.yml"));
		configs.add("messages", new Config(new File(plugin.getDataFolder(), "messages.yml"), "messages.yml"));
		configs.add("perks", new Config(new File(plugin.getDataFolder(), "perks.yml"), "perks.yml"));
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
	
	public ConfigList getConfigList() {
		return configs;
	}
	
	public Map<String, Config> getConfigsMap() {
		return configs.getConfigMap();
	}
	
	public void regenerateConfig(String configToReset) {
		configs.getConfig(configToReset).generateDefault();
	}
	
	public void regenerateAllConfigs() {
		for(Config c : configs.getConfigMap().values()) {
			c.generateDefault();
		}
	}
	
	public void regenerateAllConfigsIfMissing() {
		for(Config c : configs.getConfigMap().values()) {
			c.generateDefaultIfMissing();
		}
	}
	
	//TODO Get all config fields based on config name param
	//TODO flesh out functional methods; save etc
	
}
