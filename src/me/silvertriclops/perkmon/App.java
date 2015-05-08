package me.silvertriclops.perkmon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;

public class App extends JFrame {
	private static final long serialVersionUID = 1401798330812386993L;
	private JPanel pmain = new JPanel();
	private JLabel lbPoints = new JLabel("0", SwingConstants.RIGHT);
	JButton btRefresh = new JButton("");
	private final Component horizontalStrut = Box.createHorizontalStrut(10);
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnSettings = new JMenu("Settings");
	private final JCheckBoxMenuItem chckbxmntmAutoRefresh = new JCheckBoxMenuItem("Auto Refresh");
	private final JMenu mnInterval = new JMenu("Refresh Interval");
	private final JMenuItem mntmRe1 = new JMenuItem("1 min");
	private final JMenuItem mntmRe5 = new JMenuItem("5 min");
	private final JMenuItem mntmRe10 = new JMenuItem("10 min");
	private final JMenuItem mntmRe30 = new JMenuItem("30 min");
	private final JSeparator separator = new JSeparator();
	private final JMenu mnLogInterval = new JMenu("Log Interval");
	private final JMenuItem mntmLog1 = new JMenuItem("1 min");
	private final JMenuItem mntmLog5 = new JMenuItem("5 min");
	private final JMenuItem mntmLog10 = new JMenuItem("10 min");
	private final JMenuItem mntmLog30 = new JMenuItem("30 min");
	private final JMenuItem mntmLog60 = new JMenuItem("60 min");
	private final JMenuItem mntmLog120 = new JMenuItem("120 min");
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmAuth = new JMenuItem("Authentication...");
	private final JCheckBoxMenuItem chckbxmntmLog = new JCheckBoxMenuItem("Log");
	
	public App() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(App.class.getResource("/img/perk.png")));
		pmain.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		setResizable(false);
		getContentPane().add(pmain, BorderLayout.CENTER);
		btRefresh.setIcon(new ImageIcon(App.class.getResource("/img/refresh24.png")));
		btRefresh.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		// Refresh button
		btRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
		});
		pmain.setLayout(new BoxLayout(pmain, BoxLayout.X_AXIS));
		pmain.add(btRefresh);
		
		pmain.add(horizontalStrut);
		lbPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
		lbPoints.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		// Points display
		pmain.add(lbPoints);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnSettings);
		
		mnSettings.add(mntmAuth);
		mntmAuth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Auth();
			}
		});
		
		mnSettings.add(separator_1);
		
		mnSettings.add(chckbxmntmAutoRefresh);
		
		mnSettings.add(mnInterval);
		
		mnInterval.add(mntmRe1);
		
		mnInterval.add(mntmRe5);
		
		mnInterval.add(mntmRe10);
		
		mnInterval.add(mntmRe30);
		
		mnSettings.add(separator);
		
		mnSettings.add(chckbxmntmLog);
		
		mnSettings.add(mnLogInterval);
		
		mnLogInterval.add(mntmLog1);
		
		mnLogInterval.add(mntmLog5);
		
		mnLogInterval.add(mntmLog10);
		
		mnLogInterval.add(mntmLog30);
		
		mnLogInterval.add(mntmLog60);
		
		mnLogInterval.add(mntmLog120);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Points");
		//setIconImage(new ImageIcon(getClass().getResource("/8ball/32.png")).getImage());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void update() {
		String uid = "1710404";
		String token = "99cfad4eba00c309409e38e5002bee7d6df75698";
		try {
			lbPoints.setText(GetPoints.getPoints(uid, token)[2]);
		} catch (Exception e) {
			e.printStackTrace();
		}
		pack();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App();
	}
}
