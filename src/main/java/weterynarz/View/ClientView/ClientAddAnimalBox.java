package weterynarz.View.ClientView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class ClientAddAnimalBox implements ItemListener
{
    private JPanel cards;
    private JLabel label;
    private JButton zatwierdz;
    private JTextField[] AnimalData = new JTextField[4];
    
    JFrame frame;

    public ClientAddAnimalBox()
    {
    	
        frame = new JFrame("Dodaj zwierzaka");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentToPane(frame.getContentPane());
       
        frame.setSize(290,330);
        frame.setResizable(false);
        frame.setVisible(false);
    }
    
    public void addComponentToPane(Container pane) 
    {
      
                        
        JPanel card = new JPanel();
        card.setBackground(new Color(220, 236, 237));

        zatwierdz = new JButton("Dodaj zwierzê");
                       
        label = new JLabel("Proszê wprowadzic dane zwierzêcia");
        card.add(label);
        card.add(AnimalData[0] = new JTextField("Imiê", 10));
        card.add(AnimalData[1] = new JTextField("Rasa", 10));
        card.add(AnimalData[2] = new JTextField("Liczba ³ap", 10));
        card.add(AnimalData[3] = new JTextField("Kolor", 10));
     
        card.add(zatwierdz);
        
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
    
    public String getAnimalData(int x)
    {
    	if(x == 0)
    		return AnimalData[0].getText();
    	else if(x == 1)
    		return AnimalData[1].getText();
    	else if(x == 2)
    		return AnimalData[2].getText();
    	else if(x ==3)
    		return AnimalData[3].getText();
    	
		return null;
    	
    }

    public JButton zatwierdzenie()
    {
    	return zatwierdz;
    }

    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
}