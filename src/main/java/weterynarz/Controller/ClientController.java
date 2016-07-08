package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;
import weterynarz.View.ClientView.ClientAddAnimalBox;
import weterynarz.View.ClientView.ClientSeeAnimalBox;
import weterynarz.View.ClientView.ClientWelcomeBox;


public class ClientController {
	private User user;
	private Model model;
	private ClientWelcomeBox welcomeView;
	private ClientAddAnimalBox addAnimal;
	private ClientSeeAnimalBox seeAnimal;
	
	
	private ActionListener changeToSeeAnimalListener;
	private ActionListener changeToAddAnimalListener;
	
	public ClientController(Model model,User user)
	{
		this.model = model;
		this.user = user;
		this.welcomeView = new ClientWelcomeBox();
		this.welcomeView.setVisibility(true);
		this.addAnimal = new ClientAddAnimalBox();
		this.addAnimal.setVisibility(false);
		this.seeAnimal = new ClientSeeAnimalBox(null);
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
