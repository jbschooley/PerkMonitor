package me.silvertriclops.perkmon;

import java.io.File;

import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;


public class Main {

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		File configdir = new File("perkmon.config");
		File configfile = new File("perkmon.config/config.json");
		JSONObject config = new JSONObject();
		
		if (!configdir.exists()) {
			if (!configdir.mkdir()) {
				new Dialog("Couldn't create config folder. Try moving the app to a folder that you can write to.");
				System.exit(0);
			}
		}
		if (!configfile.exists()) {
			if (!ConfigFile.createNew()) {
				new Dialog("Couldn't create config file. Try moving the app to a folder that you can write to.");
				System.exit(0);
			};
		}
		config = new JSONObject(FileUtils.readFileToString(configfile));
		String[] stats = GetStats.getStats(config.getJSONObject("auth").getString("uid"), config.getJSONObject("auth").getString("token"));
		switch (stats[1]) {
		case "0":
			
		}
		new App();
		
	}

}
