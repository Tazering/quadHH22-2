import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

class GameScreen extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel, actionLabel, amountLabel, costLabel, creditAmountLabel;
	private JButton nextButton;
	private JLabel happinessBar, happinessBarBack, happinessBarScale1, happinessBarScale2, happinessTitle;
	private int tempCredits, tempHappiness;
	private int treeAmount = 0, moreVeggies = 0, cleanOcean = 0, saveEnergy = 0, recycle = 0, compost = 0, carpool = 0,
			solarPanel = 0, nationalPark = 0, turbine = 0;
	private JButton treeAmountButton, moreVeggiesButton, cleanOceanButton, saveEnergyButton, recycleButton,
			compostButton, carpoolButton, solarPanelButton, nationalParkButton, turbineButton;
	private JLabel treeAmountAmountLabel, moreVeggiesAmountLabel, cleanOceanAmountLabel, saveEnergyAmountLabel,
			recycleAmountLabel, compostAmountLabel, carpoolAmountLabel, solarPanelAmountLabel, nationalParkAmountLabel,
			turbineAmountLabel;

	private JLabel treeAmountCostLabel, moreVeggiesCostLabel, cleanOceanCostLabel, saveEnergyCostLabel,
			recycleCostLabel, compostCostLabel, carpoolCostLabel, solarPanelCostLabel, nationalParkCostLabel,
			turbineCostLabel;

	public GameScreen(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios,
			boolean[] modules) {
		tempCredits = credits;
		tempHappiness = happinessValue;
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.gray);
		// construct components

		final ImageIcon icon = new ImageIcon("sweating.jpg");
		JLabel text = new JLabel() {
			Image img = icon.getImage();
			{
				setOpaque(false);
			}

			public void paintComponent(Graphics graphics) {
				graphics.drawImage(img, 0, 0, this);
				super.paintComponent(graphics);
			}
		};
		text.setBounds(200, 200, 400, 400);
		JScrollPane temp = new JScrollPane(text);
		temp.setBounds(350, 175, 400, 400);

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

		creditAmountLabel = new JLabel("Credits: " + credits);
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

		if (modules[7])
			createCostLabel(treeAmountCostLabel, 1, "40");
		else
			createCostLabel(treeAmountCostLabel, 1, "20");
		createCostLabel(moreVeggiesCostLabel, 2, "5");
		createCostLabel(cleanOceanCostLabel, 3, "10");
		createCostLabel(saveEnergyCostLabel, 4, "25");
		createCostLabel(recycleCostLabel, 5, "5");
		createCostLabel(compostCostLabel, 6, "10");
		createCostLabel(carpoolCostLabel, 7, "10");
		if (modules[2])
			createCostLabel(solarPanelCostLabel, 8, "30");
		else
			createCostLabel(solarPanelCostLabel, 8, "50");
		if (modules[3])
			createCostLabel(nationalParkCostLabel, 9, "20");
		else
			createCostLabel(nationalParkCostLabel, 9, "30");
		createCostLabel(turbineCostLabel, 10, "50");

		if (modules[1]) {
			treeAmountAmountLabel = new JLabel(treeAmount + "/10");
		} else
			treeAmountAmountLabel = new JLabel(treeAmount + "/5");
		treeAmountAmountLabel.setBounds(1125, 1 * 50, 150, 50);
		treeAmountAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		treeAmountAmountLabel.setForeground(Color.BLACK);
		treeAmountAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(treeAmountAmountLabel);

		moreVeggiesAmountLabel = new JLabel(treeAmount + "/5");
		moreVeggiesAmountLabel.setBounds(1125, 2 * 50, 150, 50);
		moreVeggiesAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		moreVeggiesAmountLabel.setForeground(Color.BLACK);
		moreVeggiesAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(moreVeggiesAmountLabel);

		cleanOceanAmountLabel = new JLabel(treeAmount + "/5");
		cleanOceanAmountLabel.setBounds(1125, 3 * 50, 150, 50);
		cleanOceanAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cleanOceanAmountLabel.setForeground(Color.BLACK);
		cleanOceanAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(cleanOceanAmountLabel);

		saveEnergyAmountLabel = new JLabel(treeAmount + "/5");
		saveEnergyAmountLabel.setBounds(1125, 4 * 50, 150, 50);
		saveEnergyAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		saveEnergyAmountLabel.setForeground(Color.BLACK);
		saveEnergyAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(saveEnergyAmountLabel);

		if (modules[12])
			recycleAmountLabel = new JLabel(treeAmount + "/0");
		else
			recycleAmountLabel = new JLabel(treeAmount + "/3");
		recycleAmountLabel.setBounds(1125, 5 * 50, 150, 50);
		recycleAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recycleAmountLabel.setForeground(Color.BLACK);
		recycleAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(recycleAmountLabel);

		if (modules[13])
			compostAmountLabel = new JLabel(treeAmount + "/0");
		else
			compostAmountLabel = new JLabel(treeAmount + "/3");
		compostAmountLabel.setBounds(1125, 6 * 50, 150, 50);
		compostAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		compostAmountLabel.setForeground(Color.BLACK);
		compostAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(compostAmountLabel);

		carpoolAmountLabel = new JLabel(treeAmount + "/3");
		carpoolAmountLabel.setBounds(1125, 7 * 50, 150, 50);
		carpoolAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		carpoolAmountLabel.setForeground(Color.BLACK);
		carpoolAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(carpoolAmountLabel);

		solarPanelAmountLabel = new JLabel(treeAmount + "/3");
		solarPanelAmountLabel.setBounds(1125, 8 * 50, 150, 50);
		solarPanelAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		solarPanelAmountLabel.setForeground(Color.BLACK);
		solarPanelAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(solarPanelAmountLabel);

		nationalParkAmountLabel = new JLabel(treeAmount + "/3");
		nationalParkAmountLabel.setBounds(1125, 9 * 50, 150, 50);
		nationalParkAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nationalParkAmountLabel.setForeground(Color.BLACK);
		nationalParkAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(nationalParkAmountLabel);

		if (modules[4]) {
			turbineAmountLabel = new JLabel(treeAmount + "/4");
		} else
			turbineAmountLabel = new JLabel(treeAmount + "/3");
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
			if (modules[1]) {
				if (treeAmount < 10 && tempCredits >= 20) {
					treeAmount++;
					tempCredits -= 20;
					tempHappiness += 6;
					treeAmountAmountLabel.setText(treeAmount + "/10");
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			} else {
				if (treeAmount < 5 && tempCredits >= 20) {
					treeAmount++;
					tempCredits -= 20;
					tempHappiness += 6;
					treeAmountAmountLabel.setText(treeAmount + "/5");
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			}

		});
		add(treeAmountButton);

		moreVeggiesButton = new JButton("Eat More Veggies");
		moreVeggiesButton.setBounds(975, 100, 150, 50);
		moreVeggiesButton.setBackground(Color.BLUE);
		moreVeggiesButton.setForeground(Color.WHITE);
		moreVeggiesButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		moreVeggiesButton.addActionListener((ActionEvent e) -> {
			if (moreVeggies < 5 && tempCredits >= 5) {
				moreVeggies++;
				tempCredits -= 5;
				tempHappiness++;
				moreVeggiesAmountLabel.setText(moreVeggies + "/5");
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
			if (cleanOcean < 5 && tempCredits >= 10) {
				cleanOcean++;
				tempCredits -= 10;
				tempHappiness++;
				cleanOceanAmountLabel.setText(cleanOcean + "/5");
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
			if (saveEnergy < 3 && tempCredits >= 25) {
				saveEnergy++;
				tempCredits -= 25;
				tempHappiness += 10;
				saveEnergyAmountLabel.setText(saveEnergy + "/3");
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
			if (!modules[12]) {
				if (recycle < 3 && tempCredits >= 5) {
					recycle++;
					tempCredits -= 5;
					tempHappiness += 1;
					recycleAmountLabel.setText(recycle + "/3");
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
			if (!modules[13]) {
				if (compost < 3 && tempCredits >= 10) {
					compost++;
					tempCredits -= 10;
					tempHappiness += 2;
					compostAmountLabel.setText(compost + "/3");
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
			if (carpool < 3 && tempCredits >= 10) {
				carpool++;
				tempCredits -= 10;
				tempHappiness += 2;
				carpoolAmountLabel.setText(carpool + "/3");
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
			if (modules[2]) {
				if (solarPanel < 3 && tempCredits >= 30) {
					solarPanel++;
					tempCredits -= 30;
					tempHappiness += 20;
					solarPanelAmountLabel.setText(solarPanel + "/3");
					creditAmountLabel.setText("Credits: " + tempCredits);

				}
			} else {
				if (solarPanel < 3 && tempCredits >= 50) {
					solarPanel++;
					tempCredits -= 50;
					tempHappiness += 20;
					solarPanelAmountLabel.setText(solarPanel + "/3");
					creditAmountLabel.setText("Credits: " + tempCredits);

				}
			}
		});
		add(solarPanelButton);

		nationalParkButton = new JButton("National Parks");
		nationalParkButton.setBounds(975, 450, 150, 50);
		nationalParkButton.setBackground(Color.BLUE);
		nationalParkButton.setForeground(Color.WHITE);
		nationalParkButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		nationalParkButton.addActionListener((ActionEvent e) -> {
			if (modules[3]) {
				if (nationalPark < 3 && tempCredits >= 20) {
					nationalPark++;
					tempCredits -= 20;
					tempHappiness += 10;
					nationalParkAmountLabel.setText(nationalPark + "/3");
					creditAmountLabel.setText("Credits: " + tempCredits);
				}

			} else {
				if (nationalPark < 3 && tempCredits >= 30) {
					nationalPark++;
					tempCredits -= 30;
					tempHappiness += 10;
					nationalParkAmountLabel.setText(nationalPark + "/3");
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
			if (modules[4]) {
				if (turbine < 4 && tempCredits >= 50) {
					turbine++;
					tempCredits -= 50;
					tempHappiness += 20;
					turbineAmountLabel.setText(turbine + "/4");
					creditAmountLabel.setText("Credits: " + tempCredits);
				}
			} else {
				if (turbine < 3 && tempCredits >= 50) {
					turbine++;
					tempCredits -= 50;
					tempHappiness += 20;
					turbineAmountLabel.setText(turbine + "/3");
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
			Stats yearlyStats = new Stats(contentPane, currentYear, tempCredits, tempHappiness, scenarios, modules);
			contentPane.add(yearlyStats);
			cardLayout.next(contentPane);
		});

		add(nextButton);
		// add(treeAmountButton);
		add(temp);
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