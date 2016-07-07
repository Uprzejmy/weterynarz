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
	
	public UserController(Model model, View view)
	{
		this.model = model;
		this.loginView = new LoginBox();
		this.registrationView = new RegistrationBox();
		
		this.registrationView.setVisibility(false);
		this.loginView.setVisibility(true);
	}
    
	
    private void registerAction()
    {             
    	//registrationView.setText("Rejestrujê u¿ytkownika...");
    	//registrationView.setText(model.registerUser());
    }
	
    private void loginAction()
    {             
    	//loginView.setText("Logowanie...");
    	//loginView.setText(model.loginUser());
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
        //loginView.getLoginSubmitButton().addActionListener(loginActionListener);   
        
        registerActionListener = new ActionListener() {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  registerAction();
              }
        };                
        //registrationView.getButton().addActionListener(registerActionListener);   
    }
}
