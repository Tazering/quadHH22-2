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

public class Year extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JButton nextButton;
	public JLabel creditLabel = new JLabel("");
	public JLabel happinessLabel = new JLabel("");
	private JLabel scenarioLabel;
	private int tempCredits, tempHappiness;

	public Year(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios, int scenario) {
		tempCredits = credits + 100;
		tempHappiness = happinessValue;
		contentPane = panel;
		setLayout(null);
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
		happinessLabel = new JLabel("+ 0 Happiness");
		creditLabel = new JLabel("+ 100 Credits");

		if (scenario != -1)
		{
			scenarios[scenario].affectPlayer();
		}
		
		switch (scenario) {
			case 0:
				tempCredits += 30;
				happinessLabel.setText("+130 Credits");
				break;
			case 5:
			case 6:
				tempHappiness -= 25;
				happinessLabel.setText("-25 Happiness");
				break;
			case 8:
				tempHappiness -= 30;
				happinessLabel.setText("-30 Happiness");
				break;
			case 9:
				tempCredits -= 50;
				creditLabel.setText("+50 Credits");
				break;
			case 10:
			case 11:
				tempHappiness -= 20;
				happinessLabel.setText("-20 Happiness");
				break;
			case 14:
				tempHappiness -= 20;
				happinessLabel.setText("-20 Happiness");
				break;
			case -1:
				break;
		}
		
		creditLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setBounds(265, 150, 1000, 100);

		happinessLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		happinessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		happinessLabel.setBounds(265, 250, 1000, 100);

		JScrollPane temp = new JScrollPane(text);
		temp.setBounds(0, 0, 1920, 1080);

		titleLabel = new JLabel("Year " + currentYear);
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(365, 50, 800, 100);

		// construct components
		nextButton = new JButton("Next");
		nextButton.setBounds(390, 700, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			GameScreen gameScreen = new GameScreen(contentPane, currentYear, tempCredits, tempHappiness, scenarios, scenario);
			contentPane.add(gameScreen);
			cardLayout.next(contentPane);
		});

		add(creditLabel);
		add(happinessLabel);
		add(titleLabel);
		add(nextButton);
		add(temp);
	}
}