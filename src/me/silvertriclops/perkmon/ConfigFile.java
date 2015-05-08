package me.silvertriclops.perkmon;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigFile {
	static File configfile = new File("perkmon.config/config.json");
	
	public static boolean createNew() {
		try {
			configfile.createNewFile();
			configfile.setWritable(true);
			PrintWriter out = new PrintWriter(configfile);
			out.println("{\n\t\"loggedin\": true,\n\t\"auth\": {\n\t\t\"uid\": \"\",\n\t\t\"token\": \"\"\n\t},\n\t\"stats\": {\n\t\t\"points\": \"0\",\n\t\t\"lifetimepoints\": \"0\",\n\t\t\"tokens\": \"0\"\n\t},\n\t\"settings\": {\n\t\t\"autoRefresh\": false,\n\t\t\"autoRefreshInterval\": 1,\n\t\t\"log\": false,\n\t\t\"logInterval\": 10\n\t}\n}");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
}