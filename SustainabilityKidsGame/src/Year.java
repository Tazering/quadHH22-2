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

	public Year(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios, int[] modules) {
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
		creditLabel = new JLabel("+ 100 Credits");
		creditLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		creditLabel.setHorizontalAlignment(SwingConstants.CENTER);
		creditLabel.setBounds(460, 300, 1000, 100);

		happinessLabel = new JLabel("+ 10 Hapiness");
		happinessLabel.setFont(new Font("Comic Sans", Font.BOLD, 54));
		happinessLabel.setHorizontalAlignment(SwingConstants.CENTER);
		happinessLabel.setBounds(460, 400, 1000, 100);

		JScrollPane temp = new JScrollPane(text);
		temp.setBounds(0, 0, 1920, 1080);

		titleLabel = new JLabel("Year " + currentYear);
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(560, 200, 800, 100);

		// construct components
		nextButton = new JButton("Next");
		nextButton.setBounds(585, 900, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			GameScreen gameScreen = new GameScreen(contentPane, currentYear, credits, happinessValue, scenarios,
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