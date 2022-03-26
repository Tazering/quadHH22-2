import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class homeScreen extends JPanel {
	private JButton nextButton;
	private JButton demoButton;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JLabel blackBox;

	public homeScreen(JPanel panel) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		// construct components

		final ImageIcon icon = new ImageIcon("sizedClouds.jpg");
		JTextArea text = new JTextArea() {
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
		titleLabel.setBounds(560, 200, 800, 100);

		blackBox = new JLabel();
		blackBox.setBackground(Color.GRAY);
		blackBox.setOpaque(true);
		blackBox.setBounds(560, 300, 800, 800);

		nextButton = new JButton("Next");
		nextButton.setBounds(585, 550, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
		});

		demoButton = new JButton("Demo");
		demoButton.setBounds(585, 675, 750, 100);
		demoButton.setBackground(Color.BLUE);
		demoButton.setForeground(Color.WHITE);
		demoButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		demoButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.next(contentPane);

		});

		add(demoButton);
		add(nextButton);
		add(titleLabel);
		add(blackBox);
		add(temp);
	}
}
