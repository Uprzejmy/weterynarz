package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.View.LoginBox;
import weterynarz.View.RegistrationBox;
import weterynarz.View.View;

public class UserController {
	
	private Model model;
	private LoginBox loginView;
	private RegistrationBox registrationView;
	
	private ActionListener loginActionListener;
	private ActionListener registerActionListener;
	
	public UserController(Model model)
	{
		this.model = model;
		this.loginView = new LoginBox();
		this.registrationView = new RegistrationBox();
		
		this.registrationView.setVisibility(false);
		this.loginView.setVisibility(true);
		//this.loginView.logowanie().addActionListener(loginActionListener);
		//this.loginView.rejestracja().addActionListener(registerActionListener);
		
	}
    
	
    private void registerAction()
    {             
    	this.loginView.setVisibility(false);
    	this.registrationView.setVisibility(true);
    	
    }
	
    private void loginAction()
    {      
    	String login = this.loginView.get_login();
    	char[] haslo = this.loginView.get_pass();
    	this.model.loginUser();
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
        
        registerActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) 
            {                  
          	  registerAction();
            }
      };  
      loginView.rejestracja().addActionListener(registerActionListener);
        
        ///registerActionListener = new ActionListener() {
        //      public void actionPerformed(ActionEvent actionEvent) 
        //      {                  
        //    	  registerAction();
        //      }
       // };                
        //registrationView.getButton().addActionListener(registerActionListener);   
    }
}
