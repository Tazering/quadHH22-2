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

class Demo1 extends JPanel {
	private JPanel contentPane;
	private JLabel titleLabel;
	private JButton nextButton;
	private JTextArea demoText, demoText2, demoText3, demoText4;

	public Demo1(JPanel panel, int currentYear, int credits, int happinessValue, Scenario[] scenarios, int scenario) {
		contentPane = panel;
		setLayout(null);
		setOpaque(true);
		setBackground(Color.BLACK);
		// construct components

		final ImageIcon icon = new ImageIcon("scroll.jpg");
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
		text.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
		JScrollPane temp = new JScrollPane(text);
		temp.setBorder(javax.swing.BorderFactory.createLineBorder(Color.black));
		temp.setBounds(382, 0, 766, 860);

		demoText = new JTextArea(
				"Welcome to Climate Hero!\n\n" + "For this game, your goal is to make environmentally\n"
						+ "friendly decisions to make the earth feel happier");
		demoText.setFont(new Font("Comic Sans", Font.BOLD, 20));
		demoText.setOpaque(false);
		demoText.setEditable(false);
		demoText.setForeground(Color.BLACK);
		// scenarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		demoText.setBounds(535, 200, 1000, 100);
		add(demoText);

		demoText2 = new JTextArea("You will be given credits (Your Money) at the beginning\n"
				+ "of each year. You will also be given a random News\n" + "Scenario at the beginning of each year");
		demoText2.setFont(new Font("Comic Sans", Font.BOLD, 20));
		demoText2.setOpaque(false);
		demoText2.setEditable(false);
		demoText2.setForeground(Color.BLACK);
		// scenarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		demoText2.setBounds(525, 335, 1000, 100);
		add(demoText2);

		demoText3 = new JTextArea("Your mission is to make environmentally friendly\n"
				+ "purchases using your credits to improve the happiness\n" + "of the Earth");
		demoText3.setFont(new Font("Comic Sans", Font.BOLD, 20));
		demoText3.setOpaque(false);
		demoText3.setEditable(false);
		demoText3.setForeground(Color.BLACK);
		// scenarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		demoText3.setBounds(500, 450, 1000, 100);
		add(demoText3);

		demoText4 = new JTextArea("To win your earth must reach a happiness score of 100!\n"
				+ "\nBeware! If your earth reaches a happiness score of 0\n" + "you will lose!");
		demoText4.setFont(new Font("Comic Sans", Font.BOLD, 20));
		demoText4.setOpaque(false);
		demoText4.setEditable(false);
		demoText4.setForeground(Color.BLACK);
		// scenarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		demoText4.setBounds(475, 550, 1000, 100);
		add(demoText4);

		// construct components
		nextButton = new JButton("Next");
		nextButton.setBounds(390, 700, 750, 100);
		nextButton.setBackground(Color.BLUE);
		nextButton.setForeground(Color.WHITE);
		nextButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
		nextButton.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			Year year = new Year(contentPane, currentYear, credits, happinessValue, scenarios, scenario);
			contentPane.add(year);
			cardLayout.next(contentPane);
		});

		add(nextButton);
		add(temp);
	}

}