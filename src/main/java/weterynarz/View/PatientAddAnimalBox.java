package weterynarz.View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class PatientAddAnimalBox implements ItemListener
{
    JPanel cards;
    JLabel label, label2, label1;

     
    public void addComponentToPane(Container pane) 
    {
      
                        
        JPanel card = new JPanel();
        card.setBackground(new Color(220, 236, 237));

        JButton zatwierdz = new JButton("Dodaj zwierzê");
                       
        label = new JLabel("Proszê wprowadzic dane zwierzêcia");
        card.add(label);
        card.add(new JTextField("Imiê", 10));
        card.add(new JTextField("Rasa", 10));
        card.add(new JTextField("Liczba ³ap", 10));
        card.add(new JTextField("Kolor", 10));
     
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
     

    private static void createAndShow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Rejestracja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        PatientAddAnimalBox demo = new PatientAddAnimalBox();
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