import java.awt.CardLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class Demo1 extends JPanel 
{
    private Dimension screenSize;

    private JButton jcomp1;
    private JPanel contentPane;

    public Demo1(JPanel panel) 
    {   
        contentPane = panel;
    	screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        setOpaque(true);
        setBackground(Color.GREEN.darker().darker());
        setPreferredSize(new Dimension(1920, 1080));

        //construct components
        jcomp1 = new JButton ("Back");
        jcomp1.addActionListener( (ActionEvent e) -> {
        	
        	CardLayout cardLayout = (CardLayout) contentPane.getLayout();
        	cardLayout.next(contentPane);
        });

        add(jcomp1);
    }


}