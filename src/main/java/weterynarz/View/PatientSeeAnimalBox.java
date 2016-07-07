package weterynarz.View;

import java.awt.*;

import javax.swing.*;


public class PatientSeeAnimalBox {
	
	private JFrame frame;
    private JLabel label;
    private JButton button1;

   

    public PatientSeeAnimalBox(String[] text)
    {
        frame = new JFrame("Twoje zwierzêta");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        button1 = new JButton("Pobierz dane");
        frame.add(button1);
        
        JLabel[] labels = new JLabel[text.length];
        for (int i = 0; i < text.length; i++)
        {
            labels[i] = new JLabel(text[i]);
        }
        for (int i = 0; i < labels.length; i++)
        {

        	frame.add(labels[i]);
        	
        }
       
       
        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(true);
    }
    
   
    public JButton getButton1()
    {
        return button1;
    }
    
    public void setText(String text)
    {
        label.setText(text);
    }


    
	
}

