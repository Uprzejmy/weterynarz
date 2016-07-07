package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.View.TestWelcomeBox;
import weterynarz.View.View;

public class ClientController {
	private Model model;
	private TestWelcomeBox welcomeView;
	
	private ActionListener exampleListener;
	
	public ClientController(Model model, View view)
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
