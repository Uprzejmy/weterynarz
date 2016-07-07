package weterynarz.View;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class LoginBox implements ItemListener
{
    JPanel cards, card;
    JLabel label, label2, label1;
    JTextField login;
    JPasswordField passwordField1;
    JFrame frame;
    JButton zaloguj;
    JButton rejestruj;
    static String ZALOGUJ = "zaloguj";

    public LoginBox()
    {
    	//Create and set up the window.
        frame = new JFrame("Zaloguj");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        addComponentToPane(frame.getContentPane());
       
        //Display the window.
        //frame.pack();
        frame.setSize(290,330);
        frame.setResizable(false);
      //  frame.setVisible(false);
    }
     
    public void addComponentToPane(Container pane) 
    {
      
              
        card = new JPanel();
        card.setBackground(new Color(220, 236, 237));
        //card.setLayout(new BorderLayout());
        passwordField1 = new JPasswordField(10);
        JLabel label1 = new JLabel("   Podaj has³o: ");
        label1.setLabelFor(passwordField1);
        passwordField1.setActionCommand(ZALOGUJ);
               
        login = new JTextField(20);
        JLabel label2 = new JLabel("Podaj login: ");
        label2.setLabelFor(login);
        
        
        
   
        zaloguj = new JButton("Zaloguj");
        rejestruj = new JButton("Zarejestruj");
                  
        label = new JLabel("Uprzejmie"
        		+ " proszê wprowadziæ dane logowania.");
        card.add(label);
        card.add(label2);
        card.add(login);
        card.add(label1);
        card.add(passwordField1);
        card.add(zaloguj);
        card.add(rejestruj);
        
        
       // Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card);
         
        pane.add(card, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) 
    {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    
     

    private static void createAndShow() {
        //Create and set up the window.
        JFrame frame = new JFrame("Zaloguj");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        LoginBox demo = new LoginBox();
        demo.addComponentToPane(frame.getContentPane());
       
         
        //Display the window.
        //frame.pack();
        frame.setSize(290,330);
        frame.setResizable(false);
      //  frame.setVisible(true);
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
     
    public JButton logowanie()
    {
    	return zaloguj;
    }
    
    public JButton rejestracja()
    {
    	return rejestruj;
    }
    
    public String getEmail()
    {
    	return login.getText();
    }
    
  
	public String getPassword()//powinno operowac na char[], ale dla ulatwienia zostawiamy jako string
    {
    	return new String(passwordField1.getPassword());
    }
    
	public void addLabel()
    {
    	
    	label2 = new JLabel();
    	label2.setText("<html>Couldn't login user<br>email and password mismatch</html>");
  	  	
    	card.add(label2);
    	frame.revalidate();
    	
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
