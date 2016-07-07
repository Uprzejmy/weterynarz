package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import weterynarz.Model.Model;
import weterynarz.View.DoctorAnimals;
import weterynarz.View.DoctorClinic;
import weterynarz.View.DoctorSeeAgenda;
import weterynarz.View.DoctorWelcomeBox;
import weterynarz.View.DoctorDetails;



public class DoctorController {
	private Model model;
	private DoctorWelcomeBox welcomeView;
	private DoctorSeeAgenda personalCalendar;
	private DoctorClinic personalClinic;
	private DoctorDetails personalData;
	private DoctorAnimals personalAnimals;
	
	private ActionListener seePersonalCalendarListener;
	private ActionListener seePersonalClinicListener;
	private ActionListener seePersonalDataListener;
	private ActionListener seePersonalAnimalsListener;
	
	public DoctorController(Model model)
	{
		this.model = model;
		this.welcomeView = new DoctorWelcomeBox();
		this.personalCalendar = new DoctorSeeAgenda();
		this.personalClinic = new DoctorClinic();
		this.personalData = new DoctorDetails(null);
		this.personalAnimals = new DoctorAnimals(null);
		
		this.welcomeView.setVisibility(true);
		this.personalCalendar.setVisibility(false);
		this.personalClinic.setVisibility(false);
		this.personalData.setVisibility(false);
		this.personalAnimals.setVisibility(false);
		
	}
    
	
    private void seePersonalCalendarAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.personalCalendar.setVisibility(true);
    }

    private void seePersonalClinicAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.personalClinic.setVisibility(true);
    }
    
    private void seePersonalDataAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.personalData.setVisibility(true);
    }
    
    private void seePersonalAnimalsAction()
    {             
    	this.welcomeView.setVisibility(false);
    	this.personalAnimals.setVisibility(true);
    }
    
    
    
    public void configure()
	{        
    	seePersonalCalendarListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  seePersonalCalendarAction();
              }
        };                
        welcomeView.Calendar().addActionListener(seePersonalCalendarListener);   
        
        seePersonalClinicListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  seePersonalClinicAction();
              }
        };                
        welcomeView.Lecznice().addActionListener(seePersonalClinicListener);   
        
        seePersonalDataListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  seePersonalDataAction();
              }
        };                
        welcomeView.daneOsobowe().addActionListener(seePersonalDataListener);   
        
        seePersonalAnimalsListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  seePersonalAnimalsAction();
              }
        };                
        welcomeView.aListOfAnim().addActionListener(seePersonalAnimalsListener);   
    }
}
