package uk.co.ycleptjohn.phoenixvote.configuration;

import java.util.HashMap;
import java.util.Map;

public class ConfigList {
	private static Map<String, Config> configs;
	//String = config name; Config = config object;
	
	public ConfigList() {
		configs = new HashMap<String, Config>();
	}
	
	public static Map<String, Config> getConfigMap() {
		return configs;
	}
	
	public void add(String configName, Config configToAdd) {
		configs.put(configName, configToAdd);
	}
}
