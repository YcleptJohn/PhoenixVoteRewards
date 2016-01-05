package uk.co.ycleptjohn.phoenixvote.configuration;

import java.io.File;

public class Config {
	private String name;
	private File file;
	private String defaultResourcePath;
	
	public Config(String configName, File configFile, String defaultResourcePath) {
		name = configName;
		file = configFile;
		this.defaultResourcePath = defaultResourcePath;
	}
	
	public String getName() {
		return name;
	}
	
	public File getFile() {
		return file;
	}
	
	public String getDefaultResourcePath() {
		return defaultResourcePath;
	}
	
	public void save() {
		//TODO
	}
	
	public void reset() {
		//TODO
	}
	
}
