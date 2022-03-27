import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class GameScreen extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel, actionLabel, amountLabel, costLabel, creditAmountLabel;
	private JButton nextButton;
	private JLabel happinessBar, happinessBarBack, happinessBarScale1, happinessBarScale2, happinessTitle;
	public static int tempCredits, tempHappiness;

	private JButton treeAmountButton, moreVeggiesButton, cleanOceanButton, saveEnergyButton, recycleButton,
			compostButton, carpoolButton, solarPanelButton, nationalParkButton, turbineButton;

	private JLabel treeAmountLabel, moreVeggiesAmountLabel, cleanOceanAmountLabel, saveEnergyAmountLabel,
			recycleAmountLabel, compostAmountLabel, carpoolAmountLabel, solarPanelAmountLabel, nationalParkAmountLabel,
			turbineAmountLabel;

	private JLabel treeAmountCostLabel, moreVeggiesCostLabel, cleanOceanCostLabel, saveEnergyCostLabel,
			recycleCostLabel, compostCostLabel, carpoolCostLabel, solarPanelCostLabel, nationalParkCostLabel,
			turbineCostLabel;

	private BufferedImage image;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 150, 20, null);
	}

	public GameScreen(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios,
			int scenario) {
		tempCredits = credits;
		tempHappiness = happinessValue;
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.gray);
		// construct components

		if (happinessValue <= 20) {
			try {
				image = ImageIO.read(new File("furious.png"));
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else if (happinessValue > 20 && happinessValue <= 40) {
			try {
				image = ImageIO.read(new File("angry.png"));
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else if (happinessValue > 40 && happinessValue <= 60) {
			try {
				image = ImageIO.read(new File("sweating.png"));
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else if (happinessValue > 60 && happinessValue <= 80) {
			try {
				image = ImageIO.read(new File("cool.png"));
			} catch (IOException e) {
				System.out.println("Error");
			}
		} else {
			try {
				image = ImageIO.read(new File("happy.png"));
			} catch (IOException e) {
				System.out.println("Error");
			}
		}

		happinessTitle = new JLabel("Happy-Meter");
		happinessTitle.setFont(new Font("Comic Sans", Font.BOLD, 54));
		happinessTitle.setBounds(20, 0, 350, 100);

		add(happinessTitle);

		happinessBarBack = new JLabel("");
		happinessBarBack.setOpaque(true);
		happinessBarBack.setBackground(Color.black);
		happinessBarBack.setBounds(140, 100, 100, 650 - (int) (tempHappiness * 6.5));

		happinessBar = new JLabel("");
		happinessBar.setOpaque(true);
		happinessBar.setBackground(Color.green.darker().darker());
		happinessBar.setHorizontalAlignment(SwingConstants.CENTER);
		happinessBar.setVerticalAlignment(SwingConstants.BOTTOM);
		happinessBar.setFont(new Font("Comic Sans", Font.BOLD, 54));
		happinessBar.setText(tempHappiness + "");
		happinessBar.setForeground(Color.black);
		happinessBar.setBounds(140, 750 - (int) (tempHappiness * 6.5), 100, (int) (tempHappiness * 6.5));
		add(happinessBarBack);
		add(happinessBar);

		happinessBarScale1 = new JLabel("0");
		happinessBarScale1.setVerticalAlignment(SwingConstants.TOP);
		happinessBarScale1.setFont(new Font("Comic Sans", Font.BOLD, 20));
		happinessBarScale1.setBounds(245, 735, 100, 100);
		add(happinessBarScale1);

		happinessBarScale2 = new JLabel("100");
		happinessBarScale2.setVerticalAlignment(SwingConstants.TOP);
		happinessBarScale2.setFont(new Font("Comic Sans", Font.BOLD, 20));
		happinessBarScale2.setBounds(245, 90, 100, 100);
		add(happinessBarScale2);

		creditAmountLabel = new JLabel("Credits: " + tempCredits);
		creditAmountLabel.setBounds(565, 10, 400, 50);
		creditAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditAmountLabel.setForeground(Color.BLACK);
		creditAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		add(creditAmountLabel);

		actionLabel = new JLabel("Action");
		actionLabel.setBounds(975, 10, 150, 50);
		actionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		actionLabel.setForeground(Color.BLACK);
		actionLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(actionLabel);

		amountLabel = new JLabel("Amount");
		amountLabel.setBounds(1125, 10, 150, 50);
		amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		amountLabel.setForeground(Color.BLACK);
		amountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(amountLabel);

		costLabel = new JLabel("Cost");
		costLabel.setBounds(1275, 10, 150, 50);
		costLabel.setHorizontalAlignment(SwingConstants.CENTER);
		costLabel.setForeground(Color.BLACK);
		costLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(costLabel);

		createCostLabel(treeAmountCostLabel, 1,
				Integer.toString(Main.functions[FunctionTypes.TREE.ordinal()].getCost()));
		createCostLabel(moreVeggiesCostLabel, 2,
				Integer.toString(Main.functions[FunctionTypes.VEGGIES.ordinal()].getCost()));
		createCostLabel(cleanOceanCostLabel, 3,
				Integer.toString(Main.functions[FunctionTypes.OCEAN.ordinal()].getCost()));
		createCostLabel(saveEnergyCostLabel, 4,
				Integer.toString(Main.functions[FunctionTypes.ENERGY.ordinal()].getCost()));
		createCostLabel(recycleCostLabel, 5,
				Integer.toString(Main.functions[FunctionTypes.RECYCLE.ordinal()].getCost()));
		createCostLabel(compostCostLabel, 6,
				Integer.toString(Main.functions[FunctionTypes.COMPOST.ordinal()].getCost()));
		createCostLabel(carpoolCostLabel, 7,
				Integer.toString(Main.functions[FunctionTypes.CARPOOL.ordinal()].getCost()));
		createCostLabel(solarPanelCostLabel, 8,
				Integer.toString(Main.functions[FunctionTypes.SOLAR.ordinal()].getCost()));
		createCostLabel(nationalParkCostLabel, 9,
				Integer.toString(Main.functions[FunctionTypes.PARK.ordinal()].getCost()));
		createCostLabel(turbineCostLabel, 10,
				Integer.toString(Main.functions[FunctionTypes.TURBINE.ordinal()].getCost()));

		treeAmountLabel = new JLabel(Main.functions[FunctionTypes.TREE.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.TREE.ordinal()].getMaxAmount());
		treeAmountLabel.setBounds(1125, 1 * 50, 150, 50);
		treeAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		treeAmountLabel.setForeground(Color.BLACK);
		treeAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(treeAmountLabel);

		moreVeggiesAmountLabel = new JLabel(Main.functions[FunctionTypes.VEGGIES.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.VEGGIES.ordinal()].getMaxAmount());
		moreVeggiesAmountLabel.setBounds(1125, 2 * 50, 150, 50);
		moreVeggiesAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moreVeggiesAmountLabel.setForeground(Color.BLACK);
		moreVeggiesAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(moreVeggiesAmountLabel);

		cleanOceanAmountLabel = new JLabel(Main.functions[FunctionTypes.OCEAN.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.OCEAN.ordinal()].getMaxAmount());
		cleanOceanAmountLabel.setBounds(1125, 3 * 50, 150, 50);
		cleanOceanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cleanOceanAmountLabel.setForeground(Color.BLACK);
		cleanOceanAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(cleanOceanAmountLabel);

		saveEnergyAmountLabel = new JLabel(Main.functions[FunctionTypes.ENERGY.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.ENERGY.ordinal()].getMaxAmount());
		saveEnergyAmountLabel.setBounds(1125, 4 * 50, 150, 50);
		saveEnergyAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveEnergyAmountLabel.setForeground(Color.BLACK);
		saveEnergyAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(saveEnergyAmountLabel);

		recycleAmountLabel = new JLabel(Main.functions[FunctionTypes.RECYCLE.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.RECYCLE.ordinal()].getMaxAmount());
		recycleAmountLabel.setBounds(1125, 5 * 50, 150, 50);
		recycleAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recycleAmountLabel.setForeground(Color.BLACK);
		recycleAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(recycleAmountLabel);

		compostAmountLabel = new JLabel(Main.functions[FunctionTypes.COMPOST.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.COMPOST.ordinal()].getMaxAmount());
		compostAmountLabel.setBounds(1125, 6 * 50, 150, 50);
		compostAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compostAmountLabel.setForeground(Color.BLACK);
		compostAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(compostAmountLabel);

		carpoolAmountLabel = new JLabel(Main.functions[FunctionTypes.CARPOOL.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.CARPOOL.ordinal()].getMaxAmount());
		carpoolAmountLabel.setBounds(1125, 7 * 50, 150, 50);
		carpoolAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carpoolAmountLabel.setForeground(Color.BLACK);
		carpoolAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(carpoolAmountLabel);

		solarPanelAmountLabel = new JLabel(Main.functions[FunctionTypes.SOLAR.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.SOLAR.ordinal()].getMaxAmount());
		solarPanelAmountLabel.setBounds(1125, 8 * 50, 150, 50);
		solarPanelAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		solarPanelAmountLabel.setForeground(Color.BLACK);
		solarPanelAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(solarPanelAmountLabel);

		nationalParkAmountLabel = new JLabel(Main.functions[FunctionTypes.PARK.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.PARK.ordinal()].getMaxAmount());
		nationalParkAmountLabel.setBounds(1125, 9 * 50, 150, 50);
		nationalParkAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nationalParkAmountLabel.setForeground(Color.BLACK);
		nationalParkAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(nationalParkAmountLabel);

		turbineAmountLabel = new JLabel(Main.functions[FunctionTypes.TURBINE.ordinal()].getUsedAmount() + "/"
				+ Main.functions[FunctionTypes.TURBINE.ordinal()].getMaxAmount());
		turbineAmountLabel.setBounds(1125, 10 * 50, 150, 50);
		turbineAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		turbineAmountLabel.setForeground(Color.BLACK);
		turbineAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(turbineAmountLabel);

		treeAmountButton = new JButton("Plant Trees");
		treeAmountButton.setBounds(975, 50, 150, 50);
		treeAmountButton.setBackground(Color.BLUE);
		treeAmountButton.setForeground(Color.WHITE);
		treeAmountButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		treeAmountButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.TREE.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.TREE.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.TREE.ordinal()].getCost()) {
				Main.functions[FunctionTypes.TREE.ordinal()].affectEarth();
				treeAmountLabel.setText(Main.functions[FunctionTypes.TREE.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.TREE.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(treeAmountButton);

		moreVeggiesButton = new JButton("Eat More Veggies");
		moreVeggiesButton.setBounds(975, 100, 150, 50);
		moreVeggiesButton.setBackground(Color.BLUE);
		moreVeggiesButton.setForeground(Color.WHITE);
		moreVeggiesButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		moreVeggiesButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.VEGGIES.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.VEGGIES.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.VEGGIES.ordinal()].getCost()) {
				Main.functions[FunctionTypes.VEGGIES.ordinal()].affectEarth();
				moreVeggiesAmountLabel.setText(Main.functions[FunctionTypes.VEGGIES.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.VEGGIES.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(moreVeggiesButton);

		cleanOceanButton = new JButton("Ocean Clean Up");
		cleanOceanButton.setBounds(975, 150, 150, 50);
		cleanOceanButton.setBackground(Color.BLUE);
		cleanOceanButton.setForeground(Color.WHITE);
		cleanOceanButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		cleanOceanButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.OCEAN.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.OCEAN.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.OCEAN.ordinal()].getCost()) {
				Main.functions[FunctionTypes.OCEAN.ordinal()].affectEarth();
				cleanOceanAmountLabel.setText(Main.functions[FunctionTypes.OCEAN.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.OCEAN.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(cleanOceanButton);

		saveEnergyButton = new JButton("Save Energy");
		saveEnergyButton.setBounds(975, 200, 150, 50);
		saveEnergyButton.setBackground(Color.BLUE);
		saveEnergyButton.setForeground(Color.WHITE);
		saveEnergyButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		saveEnergyButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.ENERGY.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.ENERGY.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.ENERGY.ordinal()].getCost()) {
				Main.functions[FunctionTypes.ENERGY.ordinal()].affectEarth();
				saveEnergyAmountLabel.setText(Main.functions[FunctionTypes.ENERGY.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.ENERGY.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(saveEnergyButton);

		recycleButton = new JButton("Recycle");
		recycleButton.setBounds(975, 250, 150, 50);
		recycleButton.setBackground(Color.BLUE);
		recycleButton.setForeground(Color.WHITE);
		recycleButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		recycleButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.RECYCLE.ordinal()].isEnabled()) {
				if (Main.functions[FunctionTypes.RECYCLE.ordinal()]
						.getUsedAmount() < Main.functions[FunctionTypes.RECYCLE.ordinal()].getMaxAmount()
						&& tempCredits >= Main.functions[FunctionTypes.RECYCLE.ordinal()].getCost()) {
					Main.functions[FunctionTypes.RECYCLE.ordinal()].affectEarth();
					recycleAmountLabel.setText(Main.functions[FunctionTypes.RECYCLE.ordinal()].getUsedAmount() + "/"
							+ Main.functions[FunctionTypes.RECYCLE.ordinal()].getMaxAmount());
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			}
		});
		add(recycleButton);

		compostButton = new JButton("Compost");
		compostButton.setBounds(975, 300, 150, 50);
		compostButton.setBackground(Color.BLUE);
		compostButton.setForeground(Color.WHITE);
		compostButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		compostButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.COMPOST.ordinal()].isEnabled()) {
				if (Main.functions[FunctionTypes.COMPOST.ordinal()]
						.getUsedAmount() < Main.functions[FunctionTypes.COMPOST.ordinal()].getMaxAmount()
						&& tempCredits >= Main.functions[FunctionTypes.COMPOST.ordinal()].getCost()) {
					Main.functions[FunctionTypes.COMPOST.ordinal()].affectEarth();
					compostAmountLabel.setText(Main.functions[FunctionTypes.COMPOST.ordinal()].getUsedAmount() + "/"
							+ Main.functions[FunctionTypes.COMPOST.ordinal()].getMaxAmount());
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			}
		});
		add(compostButton);

		carpoolButton = new JButton("Carpool");
		carpoolButton.setBounds(975, 350, 150, 50);
		carpoolButton.setBackground(Color.BLUE);
		carpoolButton.setForeground(Color.WHITE);
		carpoolButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		carpoolButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.CARPOOL.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.CARPOOL.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.CARPOOL.ordinal()].getCost()) {
				Main.functions[FunctionTypes.CARPOOL.ordinal()].affectEarth();
				carpoolAmountLabel.setText(Main.functions[FunctionTypes.CARPOOL.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.CARPOOL.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(carpoolButton);

		solarPanelButton = new JButton("Solar Panels");
		solarPanelButton.setBounds(975, 400, 150, 50);
		solarPanelButton.setBackground(Color.BLUE);
		solarPanelButton.setForeground(Color.WHITE);
		solarPanelButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		solarPanelButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.SOLAR.ordinal()]
					.getUsedAmount() < Main.functions[FunctionTypes.SOLAR.ordinal()].getMaxAmount()
					&& tempCredits >= Main.functions[FunctionTypes.SOLAR.ordinal()].getCost()) {
				Main.functions[FunctionTypes.SOLAR.ordinal()].affectEarth();
				solarPanelAmountLabel.setText(Main.functions[FunctionTypes.SOLAR.ordinal()].getUsedAmount() + "/"
						+ Main.functions[FunctionTypes.SOLAR.ordinal()].getMaxAmount());
				creditAmountLabel.setText("Credits: " + tempCredits);
			}
		});
		add(solarPanelButton);

		nationalParkButton = new JButton("National Parks");
		nationalParkButton.setBounds(975, 450, 150, 50);
		nationalParkButton.setBackground(Color.BLUE);
		nationalParkButton.setForeground(Color.WHITE);
		nationalParkButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		nationalParkButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.PARK.ordinal()].isEnabled()) {
				if (Main.functions[FunctionTypes.PARK.ordinal()]
						.getUsedAmount() < Main.functions[FunctionTypes.PARK.ordinal()].getMaxAmount()
						&& tempCredits >= Main.functions[FunctionTypes.PARK.ordinal()].getCost()) {
					Main.functions[FunctionTypes.PARK.ordinal()].affectEarth();
					nationalParkAmountLabel.setText(Main.functions[FunctionTypes.PARK.ordinal()].getUsedAmount() + "/"
							+ Main.functions[FunctionTypes.PARK.ordinal()].getMaxAmount());
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			}
		});
		add(nationalParkButton);

		turbineButton = new JButton("Wind Turbines");
		turbineButton.setBounds(975, 500, 150, 50);
		turbineButton.setBackground(Color.BLUE);
		turbineButton.setForeground(Color.WHITE);
		turbineButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		turbineButton.addActionListener((ActionEvent e) -> {
			if (Main.functions[FunctionTypes.TURBINE.ordinal()].isEnabled()) {
				if (Main.functions[FunctionTypes.TURBINE.ordinal()]
						.getUsedAmount() < Main.functions[FunctionTypes.TURBINE.ordinal()].getMaxAmount()
						&& tempCredits >= Main.functions[FunctionTypes.TURBINE.ordinal()].getCost()) {
					Main.functions[FunctionTypes.TURBINE.ordinal()].affectEarth();
					turbineAmountLabel.setText(Main.functions[FunctionTypes.TURBINE.ordinal()].getUsedAmount() + "/"
							+ Main.functions[FunctionTypes.TURBINE.ordinal()].getMaxAmount());
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			}
		});
		add(turbineButton);

		nextButton = new JButton("Next");
		nextButton.setBounds(390, 700, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));

		nextButton.addActionListener((ActionEvent e) -> {
			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			Stats yearlyStats = new Stats(contentPane, currentYear, tempCredits, tempHappiness, scenarios, scenario);
			contentPane.add(yearlyStats);
			cardLayout.next(contentPane);
			for (Function function : Main.functions) {
				function.setUsedAmount(0);
			}

		});

		add(nextButton);
		// add(treeAmountButton);
		// add(temp);
	}

	public void createCostLabel(JLabel label, int pos, String cost) {

		label = new JLabel(cost);
		label.setBounds(1275, pos * 50, 150, 50);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(label);

	}
}