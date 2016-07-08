package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;
import weterynarz.View.PatientView.PatientAddAnimalBox;
import weterynarz.View.PatientView.PatientSeeAnimalBox;
import weterynarz.View.PatientView.PatientWelcomeBox;


public class ClientController {
	private User user;
	private Model model;
	private PatientWelcomeBox welcomeView;
	private PatientAddAnimalBox addAnimal;
	private PatientSeeAnimalBox seeAnimal;
	
	
	private ActionListener changeToSeeAnimalListener;
	private ActionListener changeToAddAnimalListener;
	
	public ClientController(Model model,User user)
	{
		this.model = model;
		this.user = user;
		this.welcomeView = new PatientWelcomeBox();
		this.welcomeView.setVisibility(true);
		this.addAnimal = new PatientAddAnimalBox();
		this.addAnimal.setVisibility(false);
		this.seeAnimal = new PatientSeeAnimalBox(null);
		this.seeAnimal.setVisibility(false);
	}
    
	
    private void changeToSeeAnimalAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.seeAnimal.setVisibility(true);
    	
    }
    
    private void changeToAddAnimalAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.addAnimal.setVisibility(true);
    	
    }


    
    public void configure()
	{        
    	changeToSeeAnimalListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  changeToSeeAnimalAction();
              }
        };                
        welcomeView.seeAnimal().addActionListener(changeToSeeAnimalListener);   
    
    
    changeToAddAnimalListener = new ActionListener() 
    {
          public void actionPerformed(ActionEvent actionEvent) 
          {                  
        	  changeToAddAnimalAction();
          }
    };                
    welcomeView.addAnimal().addActionListener(changeToAddAnimalListener);   
	}
}
