package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Context;
import weterynarz.Model.Model;
import weterynarz.View.ClientView.ClientAddAnimalBox;
import weterynarz.View.ClientView.ClientSeeAnimalBox;
import weterynarz.View.ClientView.ClientWelcomeBox;


public class ClientController implements IController{
	private Context context;
	private Model model;
	private ClientWelcomeBox welcomeView;
	private ClientAddAnimalBox addAnimal;
	private ClientSeeAnimalBox seeAnimal;
	
	
	private ActionListener changeToSeeAnimalListener;
	private ActionListener changeToAddAnimalListener;
	private ActionListener backToWelcomeListener;
	private ActionListener addAnimalListener;
	
	public ClientController(Model model,Context context)
	{
		this.model = model;
		this.context = context;
		this.welcomeView = new ClientWelcomeBox();
		this.addAnimal = new ClientAddAnimalBox();
		this.seeAnimal = new ClientSeeAnimalBox();

		this.welcomeView.setVisibility(true);
		this.addAnimal.setVisibility(false);
		this.seeAnimal.setVisibility(false);
	}
    
	
    private void changeToSeeAnimalAction()
    {   
    	this.seeAnimal.updatePatients(this.model.findPatientsByUser(this.context.getUser()));
    	this.welcomeView.setVisibility(false);
    	this.seeAnimal.setVisibility(true);
    }
    
    private void changeToAddAnimalAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.addAnimal.setVisibility(true);
    }
    
    private void changeToWelcomeAction()
    {
    	this.addAnimal.setVisibility(false);
    	this.seeAnimal.setVisibility(false);
    	this.welcomeView.setVisibility(true);
    }
    
    private void addPatientAction()
    {      
        String name = this.addAnimal.getAnimalData(0);
        String breed = this.addAnimal.getAnimalData(1);
        String pawsNumber = this.addAnimal.getAnimalData(2);
        String color = this.addAnimal.getAnimalData(3);
    	
        model.createPatient(this.context.getUser(),name,breed,pawsNumber,color);
    	this.addAnimal.setVisibility(false);
    	this.welcomeView.setVisibility(true);
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
	    
	    
	    backToWelcomeListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  changeToWelcomeAction();
              }
        };                
        this.addAnimal.getBackToWelcomeButton().addActionListener(backToWelcomeListener);   
        this.seeAnimal.getBackToWelcomeButton().addActionListener(backToWelcomeListener);
        
        addAnimalListener = new ActionListener() 
	    {
	          public void actionPerformed(ActionEvent actionEvent) 
	          {                  
	        	  addPatientAction();
	          }
	    };                
	    this.addAnimal.getAddAnimalButton().addActionListener(addAnimalListener);  
	}
}
