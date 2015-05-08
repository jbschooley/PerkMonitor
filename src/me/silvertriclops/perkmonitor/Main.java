package me.silvertriclops.perkmonitor;

import java.io.File;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		File configdir = new File("perkmon.config");
		File configfile = new File("perkmon.config/config.json");
		
		if (!configdir.exists()) {
			if (!configdir.mkdir()) {
				new Dialog("Couldn't create config folder. Try moving the app to a folder that you can write to.");
				System.exit(2);
			}
		}
		if (!configfile.exists()) {
			if (!FileUtils.copyURLToFile(getClass().getResource("/res/config/config.json"), configfile));
		}
	}

}
