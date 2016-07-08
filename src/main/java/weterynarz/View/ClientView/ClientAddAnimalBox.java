package weterynarz.View.ClientView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class ClientAddAnimalBox implements ItemListener
{
    private JPanel cards;
    private JLabel label;
    private JButton addAnimalButton;
    private JTextField[] AnimalData = new JTextField[4];
    private JButton backToWelcomeButton;
    
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
        backToWelcomeButton = new JButton("Wroc");
        card.add(backToWelcomeButton);

        addAnimalButton = new JButton("Dodaj zwierz�");
                       
        label = new JLabel("Prosz� wprowadzic dane zwierz�cia");
        card.add(label);
        card.add(AnimalData[0] = new JTextField("Imi�", 10));
        card.add(AnimalData[1] = new JTextField("Rasa", 10));
        card.add(AnimalData[2] = new JTextField("Liczba �ap", 10));
        card.add(AnimalData[3] = new JTextField("Kolor", 10));
     
        card.add(addAnimalButton);
        
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
    	if(x>=0 && x<4)
    		return AnimalData[x].getText();
    	
		return "";
    	
    }

    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
    
    public JButton getAddAnimalButton()
    {
        return addAnimalButton;
    }
    
}