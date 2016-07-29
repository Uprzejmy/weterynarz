package weterynarz.Controller;

import weterynarz.Context;
import weterynarz.ContextManager;
import weterynarz.EContexts;
import weterynarz.Model.User.IUserModel;
import weterynarz.View.UserView.LoginBox;
import weterynarz.View.UserView.RegistrationBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserController implements IController {
	
	private IUserModel model;
	private LoginBox loginView;
	private RegistrationBox registrationView;
	
	private ActionListener loginActionListener;
	private ActionListener changeViewToRegisterActionListener;
	private ActionListener registerActionListener;
	
	public UserController(IUserModel model)
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
    	String password = this.loginView.getPassword();
    	
    	Context context = this.model.loginUser(email,password);
    	if(context != null)
    	{
    		this.loginView.setVisibility(false);
    		ContextManager.changeContext(context);
    		return;
    	}
    	
    	this.loginView.addLabel();
    	System.out.println("Couldn't login user, email and password mismatch");
		return;
    }  
    
    private void registerAction()
    {             
    	String name = this.registrationView.getPersonalData(0);
    	String surname = this.registrationView.getPersonalData(1);
    	String address = this.registrationView.getPersonalData(2);
    	String phone = this.registrationView.getPersonalData(3);
    	String email = this.registrationView.getPersonalData(4);
    	String password = new String(this.registrationView.getPassword());
    	String password2 = new String(this.registrationView.getConfirmation());
    	EContexts type = this.registrationView.getType();
    	
    	if(!password.equals(password2))
    	{
    		System.out.println("Passwords mismatch");
    		this.registrationView.addLabel();
    		return;
    	}
    	
    	Context context = this.model.registerUser(email,password,name,surname,address,phone,type);
    	if(context != null)
    	{
    		this.registrationView.setVisibility(false);
    		ContextManager.changeContext(context);
    		return;
    	}
    	
    	this.registrationView.addLabel();
    	System.out.println("Couldn't register user, try different email");
		return;
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
