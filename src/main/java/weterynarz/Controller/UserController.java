package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;
import weterynarz.View.LoginBox;
import weterynarz.View.RegistrationBox;

public class UserController {
	
	private Model model;
	private LoginBox loginView;
	private RegistrationBox registrationView;
	
	private ActionListener loginActionListener;
	private ActionListener changeViewToRegisterActionListener;
	private ActionListener registerActionListener;
	
	public UserController(Model model)
	{
		this.model = model;
		this.loginView = new LoginBox();
		this.registrationView = new RegistrationBox();
		
		this.registrationView.setVisibility(false);
		this.loginView.setVisibility(true);
	}
	
    private void changeViewToRegisterAction()
    {             
    	this.loginView.setVisibility(false);
    	this.registrationView.setVisibility(true);
    }
	
    private void loginAction()
    {      
    	String email = this.loginView.getEmail();
    	String haslo = this.loginView.getPassword();
    	
    	User user = this.model.loginUser(email,haslo);
    	if(user != null)
    	{
    		this.loginView.setVisibility(false);
    		ContextManager.changeContext(user,"client");
    	}
    }  
    
    private void registerAction()
    {             
    	this.loginView.setVisibility(false);
    	this.registrationView.setVisibility(true);
    	/*
    	User user = this.model.loginUser(login,new String(haslo));
    	if(user != null)
    	{
    		this.loginView.setVisibility(false);
    		ContextManager.changeContext(user,"client");
    	}*/
    }
	
    
    public void configure()
	{        
        loginActionListener = new ActionListener() 
        {
			public void actionPerformed(ActionEvent actionEvent) 
            {     
				loginAction();
            }
        };                
        loginView.logowanie().addActionListener(loginActionListener); 
        
        registerActionListener = new ActionListener() 
        {
        	public void actionPerformed(ActionEvent actionEvent) 
            {                  
        		registerAction();
            }
        };  
        registrationView.getButton().addActionListener(registerActionListener);
      
        
        changeViewToRegisterActionListener = new ActionListener() 
        {
            public void actionPerformed(ActionEvent actionEvent) 
            {                  
            	changeViewToRegisterAction();
            }
        };                
        loginView.rejestracja().addActionListener(changeViewToRegisterActionListener);   
    }
}
