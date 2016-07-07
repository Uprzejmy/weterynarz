package weterynarz.View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class RegistrationBox implements ItemListener
{
	private JFrame frame;
	private JPanel cards;
    private JLabel label;
    private JPasswordField passwordField1, passwordField2;
    private JButton zatwierdz = new JButton("ZatwierdŸ");
    private JPanel comboBoxPane;
    private JComboBox cb;
    private JPanel card2;
    private String comboBoxItems[] = {"Pacjent", "Lekarz"};
    private JTextField[] PersonalData= new JTextField[6];
    
    public RegistrationBox()
    {
    	
        frame = new JFrame("Rejestracja");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentToPane(frame.getContentPane());
       
        frame.setSize(290,330);
        frame.setResizable(false);
        frame.setVisible(false);
    }

     
    public void addComponentToPane(Container pane) 
    {
      
        comboBoxPane = new JPanel();
        comboBoxPane.setLayout(new BorderLayout());
        cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
                  
        card2 = new JPanel();
        card2.setBackground(new Color(220, 236, 237));
        passwordField1 = new JPasswordField(10);
        JLabel label1 = new JLabel("Podaj has³o: ");
        label1.setLabelFor(passwordField1);
         
        passwordField2 = new JPasswordField(10);
        JLabel label2 = new JLabel("PotwierdŸ has³o: ");
        label2.setLabelFor(passwordField2);
         
        label = new JLabel("Proszê wprowadzic dane osobowe");
        card2.add(label);
        card2.add(PersonalData[0] = new JTextField("Imiê", 20));
        card2.add(PersonalData[1] = new JTextField("Nazwisko", 20));
        card2.add(PersonalData[2] = new JTextField("Ulica", 20));
        card2.add(PersonalData[3] = new JTextField("Nr domu", 5));
        card2.add(PersonalData[4] = new JTextField("Telefon", 9));
        card2.add(PersonalData[5] = new JTextField("Adres e-mail", 20));
     
        card2.add(label1);
        card2.add(passwordField1);
        card2.add(label2);
        card2.add(passwordField2);
        card2.add(zatwierdz);
        

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
    
    public JButton getButton()
    {
        return zatwierdz;
    }
    
    public int get_id()
    {
    	if(cb.getSelectedItem().equals(comboBoxItems[0]))
    		return 0;
    	else
    		return 1;
    			
    }
    
    public String getPersonalData(int x)
    {
    	if(x == 0)
    		return PersonalData[0].getText();
    	else if(x == 1)
    		return PersonalData[1].getText();
    	else if(x == 2)
    		return PersonalData[2].getText();
    	else if(x ==3)
    		return PersonalData[3].getText();
    	else if(x ==4)
    		return PersonalData[4].getText();
    	else if(x ==5)
    		return PersonalData[5].getText();
    	
		return null;
    	
    }
    
    public char[] getPassword()
    {
    	return passwordField1.getPassword();
    }
     
    public char[] getConfirmation()
    {
    	return passwordField2.getPassword();
    }
   
     

    private static void createAndShow() 
    {
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
       // frame.setVisible(true);
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