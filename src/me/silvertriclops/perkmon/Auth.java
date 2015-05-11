package me.silvertriclops.perkmon;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Auth extends JDialog {
	private static final long serialVersionUID = 1405569341259083187L;
	private JTextField tfUID;
	private JTextField tfToken;
	
	public Auth() {
		setResizable(false);
		setModal(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Auth.class.getResource("/img/perk.png")));
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel pmain = new JPanel();
		pmain.setBorder(new EmptyBorder(10, 10, 5, 10));
		getContentPane().add(pmain);
		pmain.setLayout(new BoxLayout(pmain, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		pmain.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lbUID = new JLabel("User ID");
		GridBagConstraints gbc_lbUID = new GridBagConstraints();
		gbc_lbUID.anchor = GridBagConstraints.EAST;
		gbc_lbUID.insets = new Insets(0, 0, 5, 5);
		gbc_lbUID.gridx = 0;
		gbc_lbUID.gridy = 0;
		panel.add(lbUID, gbc_lbUID);
		
		tfUID = new JTextField();
		GridBagConstraints gbc_tfUID = new GridBagConstraints();
		gbc_tfUID.insets = new Insets(0, 0, 5, 0);
		gbc_tfUID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUID.gridx = 1;
		gbc_tfUID.gridy = 0;
		panel.add(tfUID, gbc_tfUID);
		tfUID.setColumns(25);
		
		JLabel lbToken = new JLabel("Access Token");
		GridBagConstraints gbc_lbToken = new GridBagConstraints();
		gbc_lbToken.anchor = GridBagConstraints.EAST;
		gbc_lbToken.insets = new Insets(0, 0, 0, 5);
		gbc_lbToken.gridx = 0;
		gbc_lbToken.gridy = 1;
		panel.add(lbToken, gbc_lbToken);
		
		tfToken = new JPasswordField();
		GridBagConstraints gbc_tfToken = new GridBagConstraints();
		gbc_tfToken.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfToken.gridx = 1;
		gbc_tfToken.gridy = 1;
		panel.add(tfToken, gbc_tfToken);
		tfToken.setColumns(10);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		pmain.add(verticalStrut);
		
		JPanel panel_1 = new JPanel();
		pmain.add(panel_1);
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(ok);
		panel_1.add(btnOK);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.addActionListener(help);
		panel_1.add(btnHelp);
		
		pack();
		setTitle("Authentication");
		//setIconImage(new ImageIcon(getClass().getResource("/8ball/32.png")).getImage());
		
		try {
			File configfile = new File("perkmon.config/config.json");
			JSONObject config = new JSONObject(FileUtils.readFileToString(configfile));
			tfUID.setText(config.getJSONObject("auth").getString("uid"));
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			updateconfig(tfUID.getText(), tfToken.getText());
			dispose();
		}
	};
	
	ActionListener help = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
				openWebpage(new URL("https://www.reddit.com/r/perktv/comments/2a26iu/perktv_tracker_v12/cir6onk"));
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	};
	
	public void updateconfig(String uid, String token) {
		try {
			File configfile = new File("perkmon.config/config.json");
			JSONObject config = new JSONObject(FileUtils.readFileToString(configfile));
			config.getJSONObject("auth").put("uid", uid);
			config.getJSONObject("auth").put("token", token);
			ConfigFile.write(config);
		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void openWebpage(URI uri) {
		Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
		if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			try {
				desktop.browse(uri);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void openWebpage(URL url) {
		try {
			openWebpage(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
