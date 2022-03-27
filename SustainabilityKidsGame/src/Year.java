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

class Year extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JButton nextButton;
	private JLabel creditLabel;
	private JLabel happinessLabel;
	private JLabel scenarioLabel;
	private int tempCredits, tempHappiness;

	public Year(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios, boolean[] modules) {
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

		if (modules[5]) {
			tempHappiness -= 25;
			happinessLabel = new JLabel("-25 Happiness");
		}

		if (modules[10]) {
			tempHappiness -= 20;
			happinessLabel = new JLabel("-20 Happiness");
		}
		if (modules[14]) {
			tempHappiness -= 20;
			happinessLabel = new JLabel("-20 Happiness");
		}
		if (modules[11]) {
			tempHappiness -= 20;
			happinessLabel = new JLabel("-20 Happiness");
		}

		if (modules[6]) {
			tempHappiness -= 25;
			happinessLabel = new JLabel("-25 Happiness");
		}

		if (modules[8]) {
			tempHappiness -= 30;
			happinessLabel = new JLabel("-30 Happiness");
		}

		if (modules[9]) {
			creditLabel = new JLabel("+ 50 Credits");
			tempCredits -= 50;
		}

		if (modules[0]) {
			creditLabel = new JLabel("+ 130 Credits");
			tempCredits += 30;
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
			GameScreen gameScreen = new GameScreen(contentPane, currentYear, tempCredits, tempHappiness, scenarios,
					modules);
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