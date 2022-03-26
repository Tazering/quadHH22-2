import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	public int happinessValue = 0;
	public int credits = 100;
	public final String[] scenarios = new String[10];
	public final int[] modules = new int[10];

	/*
	 * Index: Module: 0 1 2 3 4 5 6 7 8 9
	 * 
	 */

	public static int currentYear = 1;

	private JPanel contentPane;
	private homeScreen homeScreen;
	private Demo1 demo1;
	private Demo2 demo2;
	private Year year;
	private GameScreen gameScreen;
	private Stats yearlyStats;
	private NewsUpdate newsUpdate;
	private WinScreen winScreen;
	private LoseScreen loseScreen;
	private Resource resourceScreen;

	private Dimension screenSize;

	private void displayGUI() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JFrame frame = new JFrame("Card Layout Example");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(screenSize.width, screenSize.height);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());

		homeScreen = new homeScreen(contentPane);
		demo1 = new Demo1(contentPane);
		demo2 = new Demo2(contentPane);
		year = new Year(contentPane, currentYear);
		gameScreen = new GameScreen(contentPane, credits, happinessValue);
		yearlyStats = new Stats(contentPane, currentYear, credits, happinessValue);
		newsUpdate = new NewsUpdate(contentPane, currentYear, credits, happinessValue);
		winScreen = new WinScreen(contentPane);
		loseScreen = new LoseScreen(contentPane);
		resourceScreen = new Resource(contentPane);

		contentPane.add(homeScreen);
		contentPane.add(demo1);
		contentPane.add(demo2);
		contentPane.add(year);
		contentPane.add(gameScreen);
		contentPane.add(yearlyStats);
		contentPane.add(newsUpdate);
		contentPane.add(winScreen);
		contentPane.add(loseScreen);
		contentPane.add(resourceScreen);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public void setYear(int currentYear) {
		this.currentYear = currentYear;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public void setHappinessValue(int happinessValue) {
		this.happinessValue = happinessValue;
	}

	public int getYear() {
		return this.currentYear;
	}

	public int getCredits() {
		return this.credits;
	}

	public int getHappinessValue() {
		return this.happinessValue = happinessValue;
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().displayGUI();
			}
		});
	}

}
