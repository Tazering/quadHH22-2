import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	public int happinessValue = 10;
	public static int credits = 10000;
	public static final String[] scenarios = {"The world’s countries have recognized your efforts, and have given you an extra 30 credits.",
												"Woah! Scientists have discovered a new tree species that grows incredibly fast!\nYou can now plant a maximum of 10,000 trees.",
												"Engineers have found a way to make solar panels cheaper! The cost of creating\nsolar panels is now only 30 credits.",
												"You are given permission by the world’s countries to create national parks.\nYou can create up to 3 parks for 30 credits each!",
												"Engineers have created a new invention: the Wind Turbine. You can now build up\nto 3 wind turbines for 50 credits each!",
												"Uh oh! A fire has broken out in the Northern Hemisphere. Your Earth’s happiness\nhas dropped by 25.",
												"Uh oh! A fire has broken out in the Southern Hemisphere. Your Earth’s happiness\nhas dropped by 25.",
												"Tree workers have gone on strike! It now costs 40 credits to plant trees.",
												"An oil tanker crashes in the ocean, causing millions of gallons of oil to pollute\nthe Atlantic. Your Earth’s happiness has dropped by 30.",
												"It has been a rough time for the world’s economy, and so you have been given \nonly 50 credits to spend.",
												"Oh no! A new coal mine has been built. Your Earth’s happiness has dropped by 20.",
												"Oh no! Less and less people have been carpooling to school because of a flu \noutbreak. Your Earth’s happiness has dropped by 20.",
												"Uh oh! There is a shortage of recycling bins, so you can no longer recycle.",
												"Uh oh! There is a shortage of composting bins, so you can no longer compost.",
												"Oh no! A new lumber company has cut down thousands of trees. Your Earth’s\nhappiness has dropped by 20!"};
	public final boolean[] modules = new boolean[15];

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
