package uk.co.ycleptjohn.phoenixvote.configuration;

import java.io.File;

public class Config {
	private File file;
	private String defaultResourcePath;
	
	public Config(File configFile, String defaultResourcePath) {
		file = configFile;
		this.defaultResourcePath = defaultResourcePath;
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
