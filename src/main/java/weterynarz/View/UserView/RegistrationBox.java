package weterynarz.View.UserView;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
 
public class RegistrationBox implements ItemListener
{
	private JFrame frame;
	private JPanel cards;
    private JLabel label, label2;
    private JPasswordField passwordField1, passwordField2;
    private JButton zatwierdz = new JButton("ZatwierdŸ");
    private JPanel comboBoxPane;
    @SuppressWarnings("rawtypes")
	private JComboBox cb;
    private JPanel card2;
    private String comboBoxItems[] = {"Klient", "Lekarz"};
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

     
    @SuppressWarnings({ "unchecked", "rawtypes" })
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
        card2.add(PersonalData[2] = new JTextField("Adres", 20));
        card2.add(PersonalData[3] = new JTextField("Telefon", 9));
        card2.add(PersonalData[4] = new JTextField("Adres e-mail", 20));
     
        card2.add(label1);
        card2.add(passwordField1);
        card2.add(label2);
        card2.add(passwordField2);
        card2.add(zatwierdz);
        card2.add(new JLabel("<html>           <br><br><br><br><br></html>"));
        

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
    
    public String getType()
    {
    	if(cb.getSelectedItem().equals(comboBoxItems[0]))
    		return "client";
    	else
    		return "doctor";	
    }
    
    public String getPersonalData(int x)
    {
    	if(x>=0 && x<5)
    		return PersonalData[x].getText();
    	
		return "";
    }
    
    public char[] getPassword()
    {
    	return passwordField1.getPassword();
    }
     
    public char[] getConfirmation()
    {
    	return passwordField2.getPassword();
    }
   
    public void addLabel()
    {
    	
    	label2 = new JLabel();

    	label2.setText("<html>Something went wrong<br>Check your data :(</html>");
    	
    	card2.add(label2);
    	frame.revalidate();
    }
}