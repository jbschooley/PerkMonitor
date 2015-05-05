package perkmonitor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class App extends JFrame {
	private static final long serialVersionUID = 1401798330812386993L;
	private JPanel pmain = new JPanel();
	private JLabel lbPoints = new JLabel("0", SwingConstants.RIGHT);
	JButton btRefresh = new JButton("Refresh");
	
	public App() {
		
		// Main panel and layout
		pmain.setLayout(new BoxLayout(pmain, BoxLayout.Y_AXIS));
		pmain.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		setResizable(false);
		add(pmain);
		
		// Refresh button
		btRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				update();
			}
		});
		pmain.add(btRefresh);
		
		// Points display
		//lbPoints.set
		//lbPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
		pmain.add(lbPoints);
		
		pack();
		setSize(new Dimension(200, getHeight()));
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
			lbPoints.setText(GetPoints.getPoints(uid, token));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new App();
	}
}
