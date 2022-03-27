import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Random;

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
	private JLabel creditLabel;
	private JLabel happinessLabel;
	private JTextArea scenarioLabel;

	public NewsUpdate(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios,
			boolean[] modules) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());
		// construct components

		for (int x = 0; x < modules.length; x++)
			modules[x] = false;

		Random rand = new Random();

		if (currentYear > 1) {
			int randScenario = rand.nextInt(0, 15);

			scenarioLabel = new JTextArea(scenarios[randScenario]);
			scenarioLabel.setFont(new Font("Comic Sans", Font.BOLD, 20));
			scenarioLabel.setOpaque(false);
			scenarioLabel.setEditable(false);
			// scenarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
			scenarioLabel.setBounds(265, 400, 1000, 100);
			add(scenarioLabel);
			modules[randScenario] = true;
		}

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

		titleLabel = new JLabel("News Screen");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(265, 50, 1000, 100);

		// construct components
		nextButton = new JButton("Next");
		nextButton.setBounds(390, 700, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			Year year = new Year(contentPane, currentYear, credits, happinessValue, scenarios, modules);
			contentPane.add(year);
			cardLayout.next(contentPane);
		});

		add(titleLabel);
		add(nextButton);
		add(temp);
	}

}