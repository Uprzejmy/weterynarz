package weterynarz.View.DoctorView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

 
public class DoctorClinic implements ItemListener
{
    JPanel cards;
    JLabel label, label1;
    JFrame frame;
    private JButton backToWelcomeButton;
    
    public DoctorClinic()
    {
    	//Create and set up the window.
        frame = new JFrame("Kliniki");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        addComponentToPane(frame.getContentPane());
       
         
        //Display the window.
        //frame.pack();
        frame.setSize(420,420);
        frame.setResizable(false);
        frame.setVisible(false);
    }

     
    public void addComponentToPane(Container pane) 
    {
      
             
        JPanel card = new JPanel();
        card.setBackground(new Color(220, 236, 237));
                       
        label = new JLabel("<html><br><h3>KLINIKA 1:</h3> Zdrowe Lapki -> Oddzial Chorob konczyn -> Nieduza 12<br>"
        		+ "<br><h3>KLINIKA 2:</h3> Lecznicowo -> Oddzial Glowny -> Duza 17<br>"
        		+ "<br><h3>KLINIKA 3:</h3> Zdrowie Zwierzat -> Oddzial Chorob zakaznych -> Mala 28<br>"
        		+ "<br><h3>KLINIKA 4:</h3> Nasz Krewniak -> Oddzial Chorob dziedzicznych -> Wielka 42<br>"
        		+ "<br><h3>KLINIKA 4:</h3> Zrosniete Kosci -> Oddzial Urazow -> Ogromna 33<br> </html>");
        
        card.add(label);
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
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
}
