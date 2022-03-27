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

class LoseScreen extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;

	public LoseScreen(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios,
			int scenario) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		setPreferredSize(new Dimension(1920, 1080));

		final ImageIcon icon = new ImageIcon("gameOver.jpg");
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
		text.setBounds(200, 200, 20, 20);
		JScrollPane temp = new JScrollPane(text);
		temp.setBounds(0, 0, 1920, 1080);

		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		setPreferredSize(new Dimension(1920, 1080));

		// construct components
		jcomp1 = new JButton("Play Again");
		jcomp1.setBounds(390, 700, 750, 100);
		jcomp1.setBackground(Color.BLUE);
		jcomp1.setForeground(Color.WHITE);
		jcomp1.setFont(new Font("Comic Sans", Font.BOLD, 30));
		jcomp1.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			HomeScreen homeScreen = new HomeScreen(contentPane, 1, 100, 0, scenarios, scenario);
			contentPane.add(homeScreen);
			cardLayout.next(contentPane);
		});

		add(jcomp1);
		add(temp);
	}

}
