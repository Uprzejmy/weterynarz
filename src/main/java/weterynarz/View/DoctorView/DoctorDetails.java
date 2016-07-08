package weterynarz.View.DoctorView;

import java.awt.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class DoctorDetails {
	
	private JFrame frame;
    private JLabel label;
    private JButton backToWelcomeButton;
    
    List<JLabel> dataLabels;

    public DoctorDetails()
    {
        frame = new JFrame("Twoje dane osobowe");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        backToWelcomeButton = new JButton("Wroc");
        frame.add(backToWelcomeButton);
        
        dataLabels = new ArrayList<JLabel>();
        for(int i=0;i<4;i++)
        {
        	dataLabels.add(new JLabel());
        	frame.add(dataLabels.get(i));
        }
       
        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(true);
    }
    
    public void setDetails(String name, String surname, String address, String phone)
    {
    	dataLabels.get(0).setText(name);
    	dataLabels.get(1).setText(surname);
    	dataLabels.get(2).setText(address);
    	dataLabels.get(3).setText(phone);
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
    
    
    public void setText(String text)
    {
        label.setText(text);
    }


    
	
}
