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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class NewsUpdate extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;
	private JLabel titleLabel;
	private JButton nextButton;

	public NewsUpdate(JPanel panel, int currentYear, int credits, int happinessValue) {
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

		titleLabel = new JLabel("This is the news update screen");
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
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
			cardLayout.next(contentPane);
		});

		add(titleLabel);
		add(nextButton);
		add(temp);
	}

}