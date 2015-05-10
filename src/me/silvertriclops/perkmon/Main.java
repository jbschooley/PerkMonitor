package me.silvertriclops.perkmon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;


public class Main {
	File configdir = new File("perkmon.config");
	File configfile = new File("perkmon.config/config.json");
	JSONObject config = new JSONObject();
	
	public Main() throws Exception {
		if (!configdir.exists()) {
			if (!configdir.mkdir()) {
				new Dialog("Couldn't create config folder. Try moving the app to a folder that you can write to.", null, null);
				System.exit(0);
			}
		}
		if (!configfile.exists()) {
			if (!ConfigFile.createNew()) {
				new Dialog("Couldn't create config file. Try moving the app to a folder that you can write to.", null, null);
				System.exit(0);
			};
		}
		config = new JSONObject(FileUtils.readFileToString(configfile));
		
		Boolean x = true;
		while (x) {
			String[] stats = GetStats.getStats(config.getJSONObject("auth")
					.getString("uid"),
					config.getJSONObject("auth").getString("token"));
			switch (stats[0]) {
			case "0":
				x = false;
				new App();
				break;
			case "1":
				new Dialog("Authentication failed. Maybe your access token expired?", "Authenticate", new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						new Auth();
					}
				});
				break;
			case "2":
				new Dialog("Please check your internet connection.", null, null);
				break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Main();
	}

}
