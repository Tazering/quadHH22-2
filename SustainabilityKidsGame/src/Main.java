import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	public static int happinessValue = 10;
	public static int credits = 0;

	public static Scenario[] scenarios = new Scenario[15];
	private int scenario = -1;
	public static final String[] scenarioText = {
			"The world’s countries have recognized your efforts,\n" + "and have given you an extra 30 credits.",
			"Woah! Scientists have discovered a new tree species\n"
					+ "that grows incredibly fast! You can now plant twice\n" + "as many trees.",
			"Engineers have found a way to make solar panels\n" + "cheaper! The cost of creating solar panels is now\n"
					+ "only 30 credits.",
			"You are given permission by the world’s countries\n" + "to create national parks. You can create up to 3\n"
					+ "parks for 20 credits each!",
			"Engineers have created a new invention: the Wind\n" + "Turbine. You can now build up to 4 wind turbines\n+"
					+ "for 50 credits each!",
			"Uh oh! A fire has broken out in the Northern Hemi-\n"
					+ "sphere. Your Earth’s happiness has dropped by 25.",
			"Uh oh! A fire has broken out in the Southern Hemi-\n"
					+ "sphere. Your Earth’s happiness has dropped by 25.",
			"Tree workers have gone on strike! It now costs 40\n" + "credits to plant trees.",
			"An oil tanker crashes in the ocean, causing millions\n"
					+ "of gallons of oil to pollutethe Atlantic. Your\n" + "Earth’s happiness has dropped by 30.",
			"It has been a rough time for the world’s economy,\n" + "and so you have been given only 50 credits to\n+"
					+ "spend.",
			"Oh no! A new coal mine has been built. Your Earth’s\n" + "happiness has dropped by 20.",
			"Oh no! Less and less people have been carpooling\n" + "to school because of a flu outbreak. Your Earth’s\n"
					+ "happiness has dropped by 20.",
			"Uh oh! There is a shortage of recycling bins, so\n" + "you can no longer recycle.",
			"Uh oh! There is a shortage of composting bins, so\n" + "you can no longer compost.",
			"Oh no! A new lumber company has cut down\n" + "thousands of trees. Your Earth’s happiness has\n"
					+ "dropped by 20!" };

	public static Function[] functions = new Function[10];
	/*
	 * Index: Module: 0 1 2 3 4 5 6 7 8 9
	 * 
	 */

	public int currentYear = 1;

	public static HomeScreen homeScreen;

	private Dimension screenSize;

	private void init() {
		initializeScenarios();
		initializeFunctions();
		displayGUI();
	}

	private void initializeScenarios() {
		for (int i = 0; i < scenarioText.length; i++) {
			scenarios[i] = new Scenario(scenarioText[i], i);
		}
	}

	private void initializeFunctions() {
		// private enum
		// FunctionTypes{TREE,VEGGIE,OCEAN,ENERGY,RECYCLE,COMPOST,CARPOOL,SOLAR,PARK,TURBINE};
		functions[0] = new Function(FunctionTypes.TREE, "Plant Trees", 20, 6, 5, 0, true);
		functions[1] = new Function(FunctionTypes.VEGGIES, "Eat More Veggies", 5, 1, 5, 0, true);
		functions[2] = new Function(FunctionTypes.OCEAN, "Ocean Clean Up", 10, 1, 5, 0, true);
		functions[3] = new Function(FunctionTypes.ENERGY, "Save Energy", 25, 10, 3, 0, true);
		functions[4] = new Function(FunctionTypes.RECYCLE, "Recycle", 5, 1, 3, 0, true);
		functions[5] = new Function(FunctionTypes.COMPOST, "Compost", 10, 2, 3, 0, true);
		functions[6] = new Function(FunctionTypes.CARPOOL, "Carpool", 10, 2, 3, 0, true);
		functions[7] = new Function(FunctionTypes.SOLAR, "Solar Panels", 50, 20, 3, 0, true);
		functions[8] = new Function(FunctionTypes.PARK, "National Parks", 20, 10, 0, 0, false);
		functions[9] = new Function(FunctionTypes.TURBINE, "Wind Turbines", 50, 20, 0, 0, false);
	}

	private void displayGUI() {
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JFrame frame = new JFrame("Sustainability Game");
		frame.setSize(screenSize.width, screenSize.height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new CardLayout());

		homeScreen = new HomeScreen(contentPane, currentYear, credits, happinessValue, scenarios, scenario);

		contentPane.add(homeScreen);

		frame.setContentPane(contentPane);
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}

	public static void main(String... args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main().init();
			}
		});
	}

	public static void setHappiness(int newHappiness) {
		happinessValue = newHappiness;
	}

	public static HomeScreen getHomeScreen() {
		return homeScreen;
	}

}
