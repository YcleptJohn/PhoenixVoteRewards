package uk.co.ycleptjohn.voteshop.configuration;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public class ConfigList {
	private static Map<String, Config> configs;
	//String = config name; Config = config object;
	
	public ConfigList() {
		configs = new HashMap<String, Config>();
	}
	
	public Map<String, Config> getConfigMap() {
		return configs;
	}
	
	public Config getConfig(String configName) {
		return configs.get(configName);
	}
	
	public Config getConfig(Config config) {
		return configs.get(config.getName());
	}
	
	public void add(String configName, Config configToAdd) {
		configs.put(configName, configToAdd);
	}
	
	public void remove(String configName) {
		configs.remove(configName);
	}
	
	public void clear() {
		configs.clear();
	}
	
	public String toString() {
		Iterator<Entry<String, Config>> it = configs.entrySet().iterator();
		String resultString = "{";
		while(it.hasNext()) {
			Map.Entry<String, Config> pair = it.next();
			resultString += pair.getKey();
			resultString += ":";
			resultString += pair.getValue();
			if(it.hasNext()) {
				resultString += ", ";
			}
		}
		resultString += "}";
		return resultString;
	}
}