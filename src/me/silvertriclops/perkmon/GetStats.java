package me.silvertriclops.perkmon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class GetStats {

	public static void main(String[] args) throws Exception {
		String uid = "1710404";
		String token = "99cfad4eba00c309409e38e5002bee7d6df75698";
		
		System.out.println(getStats(uid, token));
	}
	
	public static String[] getStats(String u, String t) {
		String[] points = new String[4];
		try {
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
			
			JSONObject stuff = new JSONObject(output);
			
			if (stuff.has("error")) {
				points[0] = "1";
				return points;
			}
			
			JSONObject userperks = stuff.getJSONObject("userperks");
			
			points[0] = "0";
			points[1] = userperks.getString("availableperks");
			points[2] = userperks.getString("lifetimeperks");
			points[3] = userperks.getString("availabletokens");
		} catch (IOException | JSONException e) {
			points[0] = "2";
			return points;
		}
		return points;
	}

}
