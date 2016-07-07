package weterynarz.View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class RegistrationBox implements ItemListener
{
	JFrame frame;
    JPanel cards;
    JLabel label, label2, label1;
    JPasswordField passwordField1, passwordField2;
    
    public RegistrationBox()
    {
    	//Create and set up the window.
        frame = new JFrame("Rejestracja");
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
      
        JPanel comboBoxPane = new JPanel();
        comboBoxPane.setLayout(new BorderLayout());
        String comboBoxItems[] = {"Pacjent", "Lekarz"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
                  
        JPanel card2 = new JPanel();
        card2.setBackground(new Color(220, 236, 237));
        passwordField1 = new JPasswordField(10);
        JLabel label1 = new JLabel("Podaj has³o: ");
        label1.setLabelFor(passwordField1);
         
        
        passwordField2 = new JPasswordField(10);
        JLabel label2 = new JLabel("PotwierdŸ has³o: ");
        label2.setLabelFor(passwordField2);
        
        
        JButton zatwierdz = new JButton("ZatwierdŸ");
        

        
                  
        label = new JLabel("Proszê wprowadzic dane osobowe");
        card2.add(label);
        card2.add(new JTextField("Imiê", 20));
        card2.add(new JTextField("Nazwisko", 20));
        card2.add(new JTextField("Ulica", 20));
        card2.add(new JTextField("Nr domu", 5));
        card2.add(new JTextField("Telefon", 9));
        card2.add(new JTextField("Adres e-mail", 20));
     
        card2.add(label1);
        card2.add(passwordField1);
        card2.add(label2);
        card2.add(passwordField2);
        card2.add(zatwierdz);
        
       // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card2);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
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
     

    private static void createAndShow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Rejestracja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        RegistrationBox demo = new RegistrationBox();
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