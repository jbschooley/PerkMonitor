package me.silvertriclops.perkmonitor;


import java.net.URL;
import java.io.*;

import javax.net.ssl.HttpsURLConnection;

import org.json.*;
 
public class GetHTTPS {
	public static void main(String[] args) throws Exception {
		String httpsURL = "https://api.perk.com/api/usercurrencyinformation?user_id=1710404&access_token=b3c15eaa360bc9d8f5e9b9b0fcfd18dd1e4b1a92&device_type=web_browser";
		//String httpsURL = "https://www.google.com";
		URL myurl = new URL(httpsURL);
		HttpsURLConnection con = (HttpsURLConnection)myurl.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "*/*");
		con.setUseCaches(false);
		con.setDoInput(true);
		con.setDoOutput(true);
		InputStream ins = con.getInputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		BufferedReader in = new BufferedReader(isr);
		//System.out.println(in.readLine());
		String things = in.readLine();
		in.close();
		
		//System.out.println(things);
		JSONObject obj1 = new JSONObject(things);
		JSONObject obj2 = obj1.getJSONObject("userperks");
		System.out.print(obj2.get("availableperks"));
	}
}