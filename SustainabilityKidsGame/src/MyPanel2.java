import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

class MyPanel2 extends JPanel 
{

    private JButton jcomp1;
    private JPanel contentPane;

    public MyPanel2(JPanel panel) 
    {   
        contentPane = panel;

        setOpaque(true);
        setBackground(Color.GREEN.darker().darker());

        //construct components
        jcomp1 = new JButton ("Back");
        jcomp1.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                CardLayout cardLayout = (CardLayout) contentPane.getLayout();
                cardLayout.next(contentPane);
            }
        });

        add(jcomp1);
    }

    @Override
    public Dimension getPreferredSize()
    {
        return (new Dimension(500, 500));
    }
}