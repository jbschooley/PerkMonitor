package perkmonitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private final JMenuItem mntmMin = new JMenuItem("1 min");
	private final JMenuItem mntmMin_1 = new JMenuItem("5 min");
	private final JMenuItem mntmMin_2 = new JMenuItem("10 min");
	private final JMenuItem mntmMin_3 = new JMenuItem("15 min");
	private final JMenuItem mntmMin_4 = new JMenuItem("30 min");
	private final JSeparator separator = new JSeparator();
	private final JMenu mnLogInterval = new JMenu("Log Interval");
	private final JMenuItem mntmMin_5 = new JMenuItem("1 min");
	private final JMenuItem mntmMin_6 = new JMenuItem("5 min");
	private final JMenuItem mntmMin_7 = new JMenuItem("10 min");
	private final JMenuItem mntmMin_8 = new JMenuItem("15 min");
	private final JMenuItem mntmMin_9 = new JMenuItem("30 min");
	private final JMenuItem mntmMin_10 = new JMenuItem("60 min");
	private final JMenuItem mntmMin_11 = new JMenuItem("120 min");
	private final JSeparator separator_1 = new JSeparator();
	private final JMenuItem mntmAuthentication = new JMenuItem("Authentication...");
	private final JCheckBoxMenuItem chckbxmntmLog = new JCheckBoxMenuItem("Log");
	
	public App() {
		pmain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
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
		
		//setSize(new Dimension(187, 122));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Points");
		//setIconImage(new ImageIcon(getClass().getResource("/8ball/32.png")).getImage());
		setLocationRelativeTo(null);
		
		setJMenuBar(menuBar);
		
		menuBar.add(mnSettings);
		
		mnSettings.add(mntmAuthentication);
		
		mnSettings.add(separator_1);
		
		mnSettings.add(chckbxmntmAutoRefresh);
		
		mnSettings.add(mnInterval);
		
		mnInterval.add(mntmMin);
		
		mnInterval.add(mntmMin_1);
		
		mnInterval.add(mntmMin_2);
		
		mnInterval.add(mntmMin_3);
		
		mnInterval.add(mntmMin_4);
		
		mnSettings.add(separator);
		
		mnSettings.add(chckbxmntmLog);
		
		mnSettings.add(mnLogInterval);
		
		mnLogInterval.add(mntmMin_5);
		
		mnLogInterval.add(mntmMin_6);
		
		mnLogInterval.add(mntmMin_7);
		
		mnLogInterval.add(mntmMin_8);
		
		mnLogInterval.add(mntmMin_9);
		
		mnLogInterval.add(mntmMin_10);
		
		mnLogInterval.add(mntmMin_11);
		pack();
		setVisible(true);
	}
	
	public void update() {
		String uid = "1710404";
		String token = "99cfad4eba00c309409e38e5002bee7d6df75698";
		try {
			lbPoints.setText(GetPoints.getPoints(uid, token));
		} catch (Exception e) {
			e.printStackTrace();
		}
		pack();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App();
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
