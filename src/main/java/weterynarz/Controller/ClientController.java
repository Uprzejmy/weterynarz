package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.View.PatientWelcomeBox;
import weterynarz.View.TestWelcomeBox;
import weterynarz.View.View;

public class ClientController {
	
	private Model model;
	private PatientWelcomeBox welcomeView;
	
	private ActionListener exampleListener;
	
	public ClientController(Model model)
	{
		this.model = model;
		this.welcomeView = new PatientWelcomeBox();
		this.welcomeView.setVisibility(true);
	}
    
	
    private void exampleAction()
    {             
    	//example
    }

    
    public void configure()
	{        
    	exampleListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  exampleAction();
              }
        };                
        welcomeView.seeAnimal().addActionListener(exampleListener);   
    }
}
