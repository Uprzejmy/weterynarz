package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Users.User;
import weterynarz.View.UserView.LoginBox;
import weterynarz.View.UserView.RegistrationBox;

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
    	Doctor doctor = this.model.findDoctorByUser(user); //probuje znalezc doktora z takim id jak user
    	if(user != null)
    	{
    		this.loginView.setVisibility(false);
    		if(doctor == null) //jezeli znaleziono
    			ContextManager.changeContext(user,"client"); //to znaczy ze zalogowany user byl doktorem
    		else //jezeli nie znaleziono
    			ContextManager.changeContext(user,"doctor"); //to znaczy ze zalogowany user byl klientem
    		
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
    	String type = this.registrationView.getType();
    	
    	if(!password.equals(password2))
    	{
    		System.out.println("Passwords mismatch");
    		this.registrationView.addLabel();
    		return;
    	}
    	
    	User user = this.model.registerUser(email,password,name,surname,address,phone,type);
    	if(user != null)
    	{
    		this.registrationView.setVisibility(false);
    		ContextManager.changeContext(user,type);
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
