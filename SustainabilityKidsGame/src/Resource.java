import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

class Resource extends JPanel {
	private Dimension screenSize;

	private JButton jcomp1;
	private JPanel contentPane;

	public Resource(JPanel panel, int currentYear, int credits, int happinessValue, String[] scenarios, int[] modules) {
		contentPane = panel;
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setOpaque(true);
		setBackground(Color.GREEN.darker().darker());

		// construct components
		jcomp1 = new JButton("Back");
		jcomp1.addActionListener((ActionEvent e) -> {

			CardLayout cardLayout = (CardLayout) contentPane.getLayout();
			cardLayout.next(contentPane);
		});

		add(jcomp1);
	}

}