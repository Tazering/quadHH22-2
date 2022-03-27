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

class homeScreen extends JPanel {
	private JButton nextButton;
	private JButton demoButton;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel blackBox;

	public homeScreen(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios,
			boolean[] modules) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		setPreferredSize(new Dimension(1920, 1080));

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

		titleLabel = new JLabel("Climate Hero!!!");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(365, 50, 800, 100);

		blackBox = new JLabel();
		blackBox.setBackground(Color.GRAY);
		blackBox.setOpaque(true);
		blackBox.setBounds(365, 150, 800, 800);

		nextButton = new JButton("Next");
		nextButton.setBounds(390, 400, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));

		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			Year year = new Year(contentPane, currentYear, credits, happinessValue, scenarios, modules);
			contentPane.add(year);
			cardLayout.next(contentPane);
		});

		demoButton = new JButton("Demo");
		demoButton.setBounds(390, 525, 750, 100);
		demoButton.setBackground(Color.BLUE);
		demoButton.setForeground(Color.WHITE);
		demoButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		demoButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			Demo1 demo1 = new Demo1(contentPane, currentYear, credits, happinessValue, scenarios, modules);
			contentPane.add(demo1);
			cardLayout.next(contentPane);

		});

		add(demoButton);
		add(nextButton);
		add(titleLabel);
		add(blackBox);
		add(temp);
	}
}
