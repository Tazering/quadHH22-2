import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main
{
    private JPanel contentPane;
    private homeScreen homeScreen;
    private Demo1 demo1;
    private Demo2 demo2;
    private Year year;
    private GameScreen gameScreen;
    private Stats yearlyStats;
    private NewsUpdate newsUpdate;
    private WinScreen winScreen;
    private LoseScreen loseScreen;
    private Resource resourceScreen;


    private Dimension screenSize;
    
    private void displayGUI()
    {
    	screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    	
        JFrame frame = new JFrame("Card Layout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // frame.setSize(screenSize.width, screenSize.height);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(
            BorderFactory.createEmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new CardLayout());
        
        homeScreen = new homeScreen(contentPane);
        demo1 = new Demo1(contentPane);
        demo2 = new Demo2(contentPane);
        year = new Year(contentPane);
        gameScreen = new GameScreen(contentPane);
        yearlyStats = new Stats(contentPane);
        newsUpdate = new NewsUpdate(contentPane);
        winScreen = new WinScreen(contentPane);
        loseScreen = new LoseScreen(contentPane);
        resourceScreen = new Resource(contentPane);

        
        contentPane.add(homeScreen); 
        contentPane.add(demo1); 
        contentPane.add(demo2); 
        contentPane.add(year); 
        contentPane.add(gameScreen); 
        contentPane.add(yearlyStats); 
        contentPane.add(newsUpdate); 
        contentPane.add(winScreen); 
        contentPane.add(loseScreen); 
        contentPane.add(resourceScreen); 

        
        frame.setContentPane(contentPane);
        frame.pack();   
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().displayGUI();
            }
        });
    }
    
}



