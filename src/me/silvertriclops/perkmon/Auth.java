package me.silvertriclops.perkmon;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Auth extends JDialog {
	private static final long serialVersionUID = 1405569341259083187L;
	private JTextField tfUID;
	private JTextField tfToken;
	public Auth() {
		setResizable(false);
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
		
		tfToken = new JTextField();
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
		panel_1.add(btnOK);
		
		JButton btnHelp = new JButton("Help");
		panel_1.add(btnHelp);
		
		pack();
		setTitle("Authentication");
		//setIconImage(new ImageIcon(getClass().getResource("/8ball/32.png")).getImage());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	};
	
	public static Boolean authtest() {
		
		return true;
	}

}