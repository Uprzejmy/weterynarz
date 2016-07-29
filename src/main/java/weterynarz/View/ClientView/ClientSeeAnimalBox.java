package weterynarz.View.ClientView;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import weterynarz.Model.Entities.Patients.Patient;


public class ClientSeeAnimalBox {
	
	private JFrame frame;
    private JButton backToWelcomeButton;
    
    List<JLabel> labels = new ArrayList<JLabel>();
    

    public ClientSeeAnimalBox()
    {
        frame = new JFrame("Twoje zwierz�ta");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        backToWelcomeButton = new JButton("Wroc");
        frame.add(backToWelcomeButton);

        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(false);
    }

    public void updatePatients(List<Patient> patients)
    {
    	this.resetFrame();
    	
        for(Patient patient : patients)
        {
        	JLabel label = new JLabel(patient.toString());
        	frame.add(label);
        }
    }
    
    public void setVisibility(boolean visibility)
    {
    	this.frame.setVisible(visibility);
    }
    
    public JButton getBackToWelcomeButton()
    {
        return backToWelcomeButton;
    }
    
    private void resetFrame()
    {
    	frame = new JFrame("Twoje zwierz�ta");                                                                            
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new GridLayout(10,0));
        frame.add(backToWelcomeButton);

        frame.getContentPane().setBackground(new Color(220, 236, 237));    
        frame.setResizable(false);
        frame.setSize(290,330);        
        frame.setVisible(false);
    }
}

