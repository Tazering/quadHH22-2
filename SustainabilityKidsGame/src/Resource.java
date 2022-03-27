import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

class Resource extends JPanel {

	private JButton jcomp1;
	private JPanel contentPane;
	private JTextArea resourceText;
	private JLabel titleLabel;

	public Resource(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios,
			int scenario) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(new Color(227, 221, 168));
		// construct components

		titleLabel = new JLabel("Resources");
		titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(365, 50, 800, 100);
		add(titleLabel);

		resourceText = new JTextArea("               https://sustainability.virginia.edu/\n\n"
				+ "\thttps://sdgs.un.org/goals\n\n" + "              https://www.epa.gov/sustainability\n\n"
				+ "https://cfda.com/resources/sustainability-resources");
		resourceText.setFont(new Font("Comic Sans", Font.BOLD, 20));
		resourceText.setOpaque(false);
		resourceText.setEditable(false);
		resourceText.setForeground(Color.BLACK);
		resourceText.setBounds(515, 200, 1000, 300);
		add(resourceText);

		jcomp1 = new JButton("Back");
		jcomp1.setBounds(390, 700, 750, 100);
		jcomp1.setBackground(Color.BLUE);
		jcomp1.setForeground(Color.WHITE);
		jcomp1.setFont(new Font("Comic Sans", Font.BOLD, 30));

		jcomp1.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			HomeScreen homeScreen = new HomeScreen(contentPane, currentYear, credits, happinessValue, scenarios,
					scenario);
			contentPane.add(homeScreen);
			cardLayout.next(contentPane);
		});

		add(jcomp1);
	}

}