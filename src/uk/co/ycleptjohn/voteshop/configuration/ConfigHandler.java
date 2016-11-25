package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;
import java.util.Map;

import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.VoteShop;

public class ConfigHandler {
	private ConfigList configs = new ConfigList();
	private Plugin plugin = VoteShop.getPlugin();
	
	public ConfigHandler() {
		configs.add("general", new Config(new File(plugin.getDataFolder(), "general.yml"), "general.yml"));
		configs.add("messages", new Config(new File(plugin.getDataFolder(), "messages.yml"), "messages.yml"));
		configs.add("perks", new Config(new File(plugin.getDataFolder(), "perks.yml"), "perks.yml"));
	}
	
	/**
	 * Gets a config from the current list
	 * @param configToGet config name to retrieve
	 * @return Config obj of this config or null if it doesn't exist
	 */
	public Config get(Configs config) {
		return configs.getConfig(config);
		
	}
	
	public File getFile(String configToGet) {
		return configs.getConfig(configToGet).getFile();
	}
	
	public ConfigList getConfigList() {
		return configs;
	}
	
	public String getConfigListAsString() {
		return configs.toString();
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
