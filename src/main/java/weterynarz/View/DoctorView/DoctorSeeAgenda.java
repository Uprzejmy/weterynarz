package weterynarz.View.DoctorView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class DoctorSeeAgenda implements ItemListener
{
    JPanel cards;
    JLabel label, label1;
    JFrame frame;
    private JButton backToWelcomeButton;

    public DoctorSeeAgenda()
    {
    	//Create and set up the window.
        frame = new JFrame("Twoj kalendarz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        addComponentToPane(frame.getContentPane());
       
        //Display the window.
        //frame.pack();
        frame.setSize(290,330);
        frame.setResizable(false);
        frame.setVisible(false);
    }
     
    public void addComponentToPane(Container pane) 
    {
      
                        
        JPanel card = new JPanel();
        card.setBackground(new Color(220, 236, 237));
                       
        label = new JLabel("<html><h2>Terminarz</h2><br> <b>  P W  S  Cz  Pi  So  N   </b><br> "
        		+ "<br> <i> 27 28 29 30 </i> 01 02 03 <br> 04 05 06 07 "
        		+ "<FONT COLOR=RED><b>08</b></FONT> 09 10 "
        		+ "<br> 11 12 13 14 15 16 17 <br> 18 19 20 21 22 23 24"
        		+ "<br> 25 26 27 <b><i>28</i></b> 29 30 31</html>");
        
        label1 = new JLabel("<html><br><br><br><b>28 lipca</b>, godzina <b>10.30</b>"
        		+ " - wizyta pana Severusa <br> Snape'a z kotem brytyjskim </html>");
        card.add(label);
        card.add(label1);
        
        backToWelcomeButton = new JButton("Wroc");
        card.add(backToWelcomeButton);
        
       // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card);
         
        pane.add(cards, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) 
    {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
     
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
}
