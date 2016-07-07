package weterynarz.Controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;
import weterynarz.View.View;

public class Controller {
	private Model model;
	private View view;
	private ActionListener actionListener1;
	private ActionListener actionListener2;
	
	public Controller(Model model, View view)
	{
		this.model = model;
		this.view = view;
	}
	
	public void control()
	{        
        actionListener1 = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  linkBtn1AndLabel();
              }
        };                
        view.getButton1().addActionListener(actionListener1);   
        
        actionListener2 = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
                  linkBtn2AndLabel();
              }
        };                
        view.getButton2().addActionListener(actionListener2);   
    }
    
    private void linkBtn1AndLabel()
    {             
        view.setText("Rejestrujê u¿ytkownika...");
        model.registerUser();
    }    
    
    private void linkBtn2AndLabel()
    {             
        view.setText(model.getDoctorData());
        
    }  
	
    private void loginAction()
    {             
        User user = model.loginUser();
        if(user == null)
        	view.setText("Nie udalo sie zalogowac uzytkownika (nieprawidlowe haslo?)");
        else
        	view.setText(user.toString());
    }  
}
