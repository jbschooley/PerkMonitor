package me.silvertriclops.perkmon;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONObject;

public class ConfigFile {
	static File configfile = new File("perkmon.config/config.json");
	
	public static boolean createNew() {
		try {
			configfile.createNewFile();
			configfile.setWritable(true);
			PrintWriter out = new PrintWriter(configfile);
			out.println("{\"loggedin\":true,\"auth\":{\"uid\":\"0\",\"token\":\"0\"},\"stats\":{\"points\":\"0\",\"lifetimepoints\":\"0\",\"tokens\":\"0\"},\"settings\":{\"autoRefresh\":false,\"autoRefreshInterval\":1,\"log\":false,\"logInterval\":10}}");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public static void write(JSONObject updated) {
		try {
			FileWriter file = new FileWriter("perkmon.config/config.json");
			file.write(updated.toString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}