package weterynarz.View.DoctorView;

import java.awt.*;

import javax.swing.*;

import weterynarz.Model.Patients.Patient;

import java.util.ArrayList;
import java.util.List;


public class DoctorAnimals {
	
	private JFrame frame;
    private JButton backToWelcomeButton;
    
    List<JLabel> labels = new ArrayList<JLabel>();

    public DoctorAnimals()
    {
        frame = new JFrame("Zwierzete pod opieka");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        backToWelcomeButton = new JButton("Wroc");
        frame.add(backToWelcomeButton);
        
        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(false);
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public void updateAnimals(List<Patient> patients)
    {
    	for(Patient patient : patients)
        {
        	JLabel label = new JLabel(patient.toString());
        	frame.add(label);
        }
    }
    
    
    public void resetFrame()
    {
    	frame.dispose();
    	
    	frame = new JFrame("Zwierzete pod opieka");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        frame.add(backToWelcomeButton);
        
        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(false);
    }
}
