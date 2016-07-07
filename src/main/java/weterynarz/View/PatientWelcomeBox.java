package weterynarz.View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class PatientWelcomeBox
{
	JPanel card;
    JLabel label, label2, label1;
     
    public void addComponentToPane(Container pane) 
    {
      
              
        card = new JPanel();
        card.setBackground(new Color(220, 236, 237));
        //card.setLayout(new BorderLayout());
        JButton see = new JButton("Moje zwierz�tka");
        JButton add = new JButton("Dodaj zwierzaka");
                  
        label = new JLabel("Witamy"
        		+ " na stronie g��wnej.          ");
        
        card.add(label);
        card.add(see);
        card.add(add);
        
        
       // Create the panel that contains the "cards".
       
        pane.add(card, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) 
    {
        CardLayout cl = (CardLayout)(card.getLayout());
        cl.show(card, (String)evt.getItem());
    }
     

    private static void createAndShow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Witaj!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //Create and set up the content pane.
        PatientWelcomeBox demo = new PatientWelcomeBox();
        demo.addComponentToPane(frame.getContentPane());
       
         
        //Display the window.
        //frame.pack();
        
                
        frame.setSize(290,330);
        frame.setResizable(false);
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShow();
            }
        });
    }
	

}
