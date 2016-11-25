package uk.co.ycleptjohn.voteshop.configuration;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.ycleptjohn.voteshop.VoteShop;

public class Config extends YamlConfiguration {
	private File file;
	private Plugin plugin = VoteShop.getPlugin();
	private String defaultConfigResourcePath;
	
	public Config(File configFile, String defaultConfigResourcePath) {
		file = configFile;
		try {
			this.load(getFile());
		} catch (IOException | InvalidConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.defaultConfigResourcePath = defaultConfigResourcePath;
	}
	
	public File getFile() {
		return file;
	}
	
	
	public void test() {
		System.out.println(this.get("name"));
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
