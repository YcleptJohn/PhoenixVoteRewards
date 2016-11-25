package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.PhoenixVote;

public class Config {
	private File file;
	private YamlConfiguration ymlConfig;
	private Plugin plugin = PhoenixVote.getPlugin();
	private String defaultConfigResourcePath;
	
	public Config(File configFile, String defaultConfigResourcePath) {
		file = configFile;
		ymlConfig = YamlConfiguration.loadConfiguration(configFile);
		this.defaultConfigResourcePath = defaultConfigResourcePath;
	}
	
	public File getFile() {
		return file;
	}
	
	public YamlConfiguration getYamlConf() {
		return ymlConfig;
	}
	
	
	public void reset() {
		generateDefault();
	}
	
	public void save() {
		try {
			ymlConfig.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateDefaultIfMissing() {
		plugin.saveResource(defaultConfigResourcePath, false);
	}
	
	public void generateDefault() {
		plugin.saveResource(defaultConfigResourcePath, true);
	}
}
