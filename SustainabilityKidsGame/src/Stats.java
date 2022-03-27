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

class Stats extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel creditLabel;
	private JLabel happinessLabel;
	private JButton nextButton;
	private JLabel blackBox;
	private int currentYear;

	public Stats(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios, int scenario) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		// construct components
		this.currentYear = currentYear;
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

		titleLabel = new JLabel("YOUR STATS FOR YEAR " + currentYear);
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(265, 50, 1000, 100);

		creditLabel = new JLabel("Credits: " + credits);
		creditLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setBounds(265, 150, 1000, 100);

		happinessLabel = new JLabel("Happiness: " + happinessValue);
		happinessLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		happinessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		happinessLabel.setBounds(265, 250, 1000, 100);

		blackBox = new JLabel();
		blackBox.setBackground(Color.GRAY);
		blackBox.setOpaque(true);
		blackBox.setBounds(365, 150, 800, 800);

		nextButton = new JButton("Next");
		nextButton.setBounds(390, 700, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();

			if (currentYear >= 10 || happinessValue >= 100) {
				WinScreen winScreen = new WinScreen(contentPane, currentYear, credits, happinessValue, scenarios,
						scenario);
				contentPane.add(winScreen);
				cardLayout.next(contentPane);
			} else if (happinessValue < 0) {
				LoseScreen loseScreen = new LoseScreen(contentPane, currentYear, credits, happinessValue, scenarios,
						scenario);
				contentPane.add(loseScreen);
				cardLayout.next(contentPane);

			} else {

				NewsUpdate newsUpdate = new NewsUpdate(contentPane, currentYear + 1, credits, happinessValue, scenarios,
						scenario);
				contentPane.add(newsUpdate);
				cardLayout.next(contentPane);
			}
		});

		add(happinessLabel);
		add(creditLabel);
		add(nextButton);
		add(titleLabel);
		add(blackBox);
		add(temp);
	}

}