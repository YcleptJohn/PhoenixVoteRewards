package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.VoteShop;

public class ConfigFile extends YamlConfiguration {
	private File file;
	private Plugin plugin = VoteShop.getPlugin();
	private String defaultConfigResourcePath;
	
	public ConfigFile(File configFile, String defaultConfigResourcePath) {
		file = configFile;
		this.defaultConfigResourcePath = defaultConfigResourcePath;
		try {
			this.load(getFile());
		} catch (FileNotFoundException e) {
			generateDefault();
		}
		catch (IOException | InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public File getFile() {
		return file;
	}
	
	
	public void reset() {
		generateDefault();
	}
	
	
	public void generateDefaultIfMissing() {
		boolean missing = true;
		for(File f : plugin.getDataFolder().listFiles()) {
			if(f.equals(this.getFile())) {
				missing = false;
			}
		}
		
		if(missing) {
			plugin.saveResource(defaultConfigResourcePath, false);
		}
	}
	
	public void generateDefault() {
		plugin.saveResource(defaultConfigResourcePath, true);
	}
}
