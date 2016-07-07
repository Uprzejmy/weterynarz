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
	private ActionListener loginToRegisterActionListener;
	private ActionListener registerActionListener;
	
	public UserController(Model model)
	{
		this.model = model;
		this.loginView = new LoginBox();
		this.registrationView = new RegistrationBox();
		
		this.registrationView.setVisibility(false);
		this.loginView.setVisibility(true);


		
	}
    
	
    private void loginToRegisterAction()
    {             
    	this.loginView.setVisibility(false);
    	this.registrationView.setVisibility(true);
    	
    }
	
    private void loginAction()
    {      
    	String login = this.loginView.get_login();
    	char[] haslo = this.loginView.get_pass();
    	User user = this.model.loginUser(login,new String(haslo));
    	if(user != null)
    		ContextManager.changeContext(user,"client");
    }  
    
    private void registerAction()
    {             
    	this.loginView.setVisibility(false);
    	this.registrationView.setVisibility(true);
    	
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
      registrationView.getButton().addActionListener(registerActionListener);
      
        
      loginToRegisterActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) 
              {                  
            		loginToRegisterAction();
             }
        };                
        loginView.rejestracja().addActionListener(registerActionListener);   
    }
}
