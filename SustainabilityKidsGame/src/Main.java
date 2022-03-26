import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	public int happinessValue = 10;
	public int credits = 100;
	public final String[] scenarios = new String[10];
	public final int[] modules = new int[10];

	/*
	 * Index: Module: 0 1 2 3 4 5 6 7 8 9
	 * 
	 */

	public int currentYear = 1;

	private homeScreen homeScreen;

	private Dimension screenSize;

	private void displayGUI() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JFrame frame = new JFrame("Sustainability Game");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(screenSize.width, screenSize.height);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());

		homeScreen = new homeScreen(contentPane, currentYear, credits, happinessValue, scenarios, modules);
		// loseScreen = new LoseScreen(contentPane, currentYear, credits,
		// happinessValue, scenarios, modules);
		// resourceScreen = new Resource(contentPane, currentYear, credits,
		// happinessValue, scenarios, modules);

		contentPane.add(homeScreen);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().displayGUI();
			}
		});
	}

}
