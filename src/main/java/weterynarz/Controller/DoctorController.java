package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.View.TestWelcomeBox;

public class DoctorController {
	private Model model;
	private TestWelcomeBox welcomeView;
	
	private ActionListener exampleListener;
	
	public DoctorController(Model model)
	{
		this.model = model;
		this.welcomeView = new TestWelcomeBox();
		
		this.welcomeView.setVisibility(true);
	}
    
	
    private void exampleAction()
    {             
    	welcomeView.setText("No hej!");
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
        welcomeView.getExampleButton().addActionListener(exampleListener);   
    }
}
