package weterynarz.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import weterynarz.View.PatientView.PatientWelcomeBox;

public class TestWelcomeBox 
{
	JPanel card;
    JLabel label, label2, label1;
    JButton showAnimalsButton;
    JFrame frame;
    
    public TestWelcomeBox()
    {
    	frame = new JFrame("Witaj!");
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
      
              
        card = new JPanel();
        card.setBackground(new Color(220, 236, 237));
        //card.setLayout(new BorderLayout());
        showAnimalsButton = new JButton("Moje zwierz¹tka");
        JButton add = new JButton("Dodaj zwierzaka");
                  
        label = new JLabel("Witamy"
        		+ " na stronie g³ównej.          ");
        
        card.add(label);
        card.add(showAnimalsButton);
        card.add(add);
        
        
       // Create the panel that contains the "cards".
       
        pane.add(card, BorderLayout.CENTER);
    }
     
    public void itemStateChanged(ItemEvent evt) 
    {
        CardLayout cl = (CardLayout)(card.getLayout());
        cl.show(card, (String)evt.getItem());
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public void setText(String text)
    {
    	this.label.setText(text);
    }
    
    public JButton getExampleButton()
    {
    	return showAnimalsButton;
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
