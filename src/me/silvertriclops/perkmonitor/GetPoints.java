package me.silvertriclops.perkmonitor;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONObject;

public class GetPoints {

	public static void main(String[] args) throws Exception {
		String uid = "1710404";
		String token = "99cfad4eba00c309409e38e5002bee7d6df75698";
		 
		System.out.println(getPoints(uid, token));
	}
	
	public static String getPoints(String u, String t) throws Exception {
		String httpsURL = "https://api.perk.com/api/usercurrencyinformation?user_id="
				+ u
				+ "&access_token="
				+ t
				+ "&device_type=web_browser";
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
		String output = in.readLine();
		in.close();
		
		String points = new JSONObject(output).getJSONObject("userperks").get("availableperks").toString();
		return points;
	}

}
