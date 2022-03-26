import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class homeScreen extends JPanel 
{
    private JButton jcomp4;
    private JPanel contentPane;
    private JLabel titleLabel;
    
    public homeScreen(JPanel panel) 
    {
        contentPane = panel;
        setLayout(null);
        setOpaque(true);
        setBackground(Color.GREEN.darker().darker());
        //construct components
        titleLabel = new JLabel ("Climate Hero!!!");
        titleLabel.setFont(new Font("Comic Sans", Font.BOLD, 72));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(365, 400, 800, 100);
        jcomp4 = new JButton ("Next");
        jcomp4.setBounds(20,20,200,200);
        jcomp4.addActionListener( (ActionEvent e) -> {
        	
        	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        	cardLayout.next(contentPane);
        	cardLayout.next(contentPane);
        	cardLayout.next(contentPane);
        });
        add(jcomp4);
        add(titleLabel);
    }
}
