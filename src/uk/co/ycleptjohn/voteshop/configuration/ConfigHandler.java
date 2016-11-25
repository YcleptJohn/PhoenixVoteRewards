package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;

public class ConfigHandler {
	//private Plugin plugin = VoteShop.getPlugin();
	
	public ConfigHandler() {
	}
	
	public ConfigFile get(Config config) {
		return config.getConfigFile();
	}
	
	public File getFile(Config config) {
		return config.getConfigFile().getFile();
	}
	

	public void regenerateConfig(Config configToReset) {
		configToReset.getConfigFile().generateDefault();
	}
	
	public void regenerateAllConfigs() {
		for(Config c : Config.values()) {
			c.getConfigFile().generateDefault();
		}
	}
	
	public void regenerateAllConfigsIfMissing() {
		for(Config c : Config.values()) {
			c.getConfigFile().generateDefault();
		}
	}
	
	//TODO Get all config fields based on config name param
	//TODO flesh out functional methods; save etc
	
}
