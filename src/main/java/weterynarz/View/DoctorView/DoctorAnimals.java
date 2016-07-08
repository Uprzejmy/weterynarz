package weterynarz.View.DoctorView;

import java.awt.*;

import javax.swing.*;

import weterynarz.Model.Patients.Patient;

import java.util.ArrayList;
import java.util.List;


public class DoctorAnimals {
	
	private JFrame frame;
    private JLabel label;
    private JButton button1;
    private JButton backToWelcomeButton;

   

    public DoctorAnimals(List<Patient> patients)
    {
        frame = new JFrame("Zwierzete pod opieka");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        button1 = new JButton("Pobierz dane");
        backToWelcomeButton = new JButton("Wroc");
        frame.add(button1);
        frame.add(backToWelcomeButton);
        
        List<JLabel> labels = new ArrayList<JLabel>();
        for(Patient patient : patients)
        {
        	labels.add(new JLabel(patient.toString()));
        }
        
        for(JLabel label : labels)
        {
        	frame.add(label);
        }
        
        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(false);
    }
    
   
    public JButton getButton1()
    {
        return button1;
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    
    public void setText(String text)
    {
        label.setText(text);
    }


    
	
}
