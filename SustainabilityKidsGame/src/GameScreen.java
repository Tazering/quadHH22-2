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
	private int temps;
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
		temps = credits;
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		// construct components

		final ImageIcon icon = new ImageIcon("sizedClouds.jpg");
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
		JScrollPane temp = new JScrollPane(text);
		temp.setBounds(0, 0, 1920, 1080);
		
		
		
		creditAmountLabel = new JLabel("Credits: " + credits);
		creditAmountLabel.setBounds(565, 10, 400, 50);
		creditAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditAmountLabel.setForeground(Color.BLACK);
		creditAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		add(creditAmountLabel);

		titleLabel = new JLabel("This is the game screen");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(460, 200, 1000, 100);

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

		createCostLabel(treeAmountCostLabel, 1, "20");
		createCostLabel(moreVeggiesCostLabel, 2, "5");
		createCostLabel(cleanOceanCostLabel, 3, "10");
		createCostLabel(saveEnergyCostLabel, 4, "25");
		createCostLabel(recycleCostLabel, 5, "5");
		createCostLabel(compostCostLabel, 6, "10");
		createCostLabel(carpoolCostLabel, 7, "10");
		createCostLabel(solarPanelCostLabel, 8, "50");
		createCostLabel(nationalParkCostLabel, 9, "30");
		createCostLabel(turbineCostLabel, 10, "50");

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

		recycleAmountLabel = new JLabel(treeAmount + "/3");
		recycleAmountLabel.setBounds(1125, 5 * 50, 150, 50);
		recycleAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		recycleAmountLabel.setForeground(Color.BLACK);
		recycleAmountLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
		add(recycleAmountLabel);

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
			if (treeAmount < 5 && temps >= 20) {
				treeAmount++;
				temps -= 20;
				treeAmountAmountLabel.setText(treeAmount + "/5");
				creditAmountLabel.setText("Credits: " + temps);
			}
			
		});
		add(treeAmountButton);

		moreVeggiesButton = new JButton("Eat More Veggies");
		moreVeggiesButton.setBounds(975, 100, 150, 50);
		moreVeggiesButton.setBackground(Color.BLUE);
		moreVeggiesButton.setForeground(Color.WHITE);
		moreVeggiesButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		moreVeggiesButton.addActionListener((ActionEvent e) -> {
			if (moreVeggies < 5 && temps >= 5) {
				moreVeggies++;
				temps -= 5;
				moreVeggiesAmountLabel.setText(moreVeggies + "/5");
				creditAmountLabel.setText("Credits: " + temps);
			}
		});
		add(moreVeggiesButton);

		cleanOceanButton = new JButton("Ocean Clean Up");
		cleanOceanButton.setBounds(975, 150, 150, 50);
		cleanOceanButton.setBackground(Color.BLUE);
		cleanOceanButton.setForeground(Color.WHITE);
		cleanOceanButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		cleanOceanButton.addActionListener((ActionEvent e) -> {
			if (cleanOcean < 5 && temps >= 10) {
				cleanOcean++;
				temps -= 10;
				cleanOceanAmountLabel.setText(cleanOcean + "/5");
				creditAmountLabel.setText("Credits: " + temps);
			}
		});
		add(cleanOceanButton);

		saveEnergyButton = new JButton("Save Energy");
		saveEnergyButton.setBounds(975, 200, 150, 50);
		saveEnergyButton.setBackground(Color.BLUE);
		saveEnergyButton.setForeground(Color.WHITE);
		saveEnergyButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		saveEnergyButton.addActionListener((ActionEvent e) -> {
			if (saveEnergy < 3 && temps >= 25) {
				saveEnergy++;
				temps -= 25;
				saveEnergyAmountLabel.setText(saveEnergy + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}});
		add(saveEnergyButton);

		recycleButton = new JButton("Recycle");
		recycleButton.setBounds(975, 250, 150, 50);
		recycleButton.setBackground(Color.BLUE);
		recycleButton.setForeground(Color.WHITE);
		recycleButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		recycleButton.addActionListener((ActionEvent e) -> {
			if (recycle < 3 && temps >= 5) {
				recycle++;
				temps -= 5;
				recycleAmountLabel.setText(recycle + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}
		});
		add(recycleButton);

		compostButton = new JButton("Compost");
		compostButton.setBounds(975, 300, 150, 50);
		compostButton.setBackground(Color.BLUE);
		compostButton.setForeground(Color.WHITE);
		compostButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		compostButton.addActionListener((ActionEvent e) -> {
			if (compost < 3 && temps >= 10) {
				compost++;
				temps -= 10;
				compostAmountLabel.setText(compost + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}
		});
		add(compostButton);

		carpoolButton = new JButton("Carpool");
		carpoolButton.setBounds(975, 350, 150, 50);
		carpoolButton.setBackground(Color.BLUE);
		carpoolButton.setForeground(Color.WHITE);
		carpoolButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		carpoolButton.addActionListener((ActionEvent e) -> {
			if (carpool < 3 && temps >= 10) {
				carpool++;
				temps -= 10;
				carpoolAmountLabel.setText(carpool + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}
		});
		add(carpoolButton);

		solarPanelButton = new JButton("Solar Panels");
		solarPanelButton.setBounds(975, 400, 150, 50);
		solarPanelButton.setBackground(Color.BLUE);
		solarPanelButton.setForeground(Color.WHITE);
		solarPanelButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		solarPanelButton.addActionListener((ActionEvent e) -> {
			if (solarPanel < 3 && temps >= 50) {
				solarPanel++;
				temps -= 50;
				solarPanelAmountLabel.setText(solarPanel + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}
		});
		add(solarPanelButton);

		nationalParkButton = new JButton("National Parks");
		nationalParkButton.setBounds(975, 450, 150, 50);
		nationalParkButton.setBackground(Color.BLUE);
		nationalParkButton.setForeground(Color.WHITE);
		nationalParkButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		nationalParkButton.addActionListener((ActionEvent e) -> {
			if (nationalPark < 3 && temps >= 30) {
				nationalPark++;
				temps -= 30;
				nationalParkAmountLabel.setText(nationalPark + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
		}
		});
		add(nationalParkButton);

		turbineButton = new JButton("Wind Turbines");
		turbineButton.setBounds(975, 500, 150, 50);
		turbineButton.setBackground(Color.BLUE);
		turbineButton.setForeground(Color.WHITE);
		turbineButton.setFont(new Font("Comic Sans", Font.BOLD, 13));
		turbineButton.addActionListener((ActionEvent e) -> {
			if (turbine < 3 && temps >= 50) {
				turbine++;
				temps -= 50;
				turbineAmountLabel.setText(turbine + "/3");
				creditAmountLabel.setText("Credits: " + temps);
		
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
			Stats yearlyStats = new Stats(contentPane, currentYear, credits, happinessValue, scenarios, modules);
			contentPane.add(yearlyStats);
			cardLayout.next(contentPane);
		});

		add(titleLabel);
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