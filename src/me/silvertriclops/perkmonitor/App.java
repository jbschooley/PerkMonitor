package me.silvertriclops.perkmonitor;

import java.awt.Dimension;

import javax.swing.*;

public class App extends JFrame {
	private JPanel pmain = new JPanel();
	private JLabel lbPoints = new JLabel("0", SwingConstants.CENTER);
	JButton btRefresh = new JButton("Refresh");
	
	public App() {
		
		// Main panel and layout
		pmain.setLayout(new BoxLayout(pmain, BoxLayout.Y_AXIS));
		pmain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setResizable(false);
		add(pmain);
		
		// Refresh button
		pmain.add(btRefresh);
		
		// Points display
		//lbPoints.set
		pmain.add(lbPoints);
		
		pack();
		setMinimumSize(getSize());
		setSize(new Dimension(100, getHeight()));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Points");
		//setIconImage(new ImageIcon(getClass().getResource("/8ball/32.png")).getImage());
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App();
	}
}
