package weterynarz.Controller;

import weterynarz.Context;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.IDoctorModel;
import weterynarz.View.DoctorView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DoctorController implements IController {
	private Context context;
	private IDoctorModel model;
	private DoctorWelcomeBox welcomeView;
	private DoctorSeeAgenda personalCalendar;
	private DoctorClinic personalClinic;
	private DoctorDetails personalData;
	private DoctorAnimals personalAnimals;
	
	private ActionListener seePersonalCalendarListener;
	private ActionListener seePersonalClinicListener;
	private ActionListener seePersonalDataListener;
	private ActionListener seePersonalAnimalsListener;
	private ActionListener backToWelcomeListener;
	
	public DoctorController(IDoctorModel model,Context context)
	{
		this.model = model;
		this.context = context;
		this.welcomeView = new DoctorWelcomeBox();
		this.personalCalendar = new DoctorSeeAgenda();
		this.personalClinic = new DoctorClinic();
		this.personalData = new DoctorDetails();
		this.personalAnimals = new DoctorAnimals();
		
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
    	Doctor doctor = this.model.findDoctorByUser(this.context.getUser());
    	this.personalData.setDetails(doctor.getName(), doctor.getSurname(), doctor.getAddress(), doctor.getPhone());
    	this.welcomeView.setVisibility(false);
    	this.personalData.setVisibility(true);
    }
    
    private void seePersonalAnimalsAction()
    {             
    	this.personalAnimals.updateAnimals(this.model.findDoctorByUser(this.context.getUser()).getPatients());
    	this.welcomeView.setVisibility(false);
    	this.personalAnimals.setVisibility(true);
    }
    
    private void seeWelcomeAction()
    {
    	this.personalAnimals.setVisibility(false);
    	this.personalData.setVisibility(false);
    	this.personalClinic.setVisibility(false);
    	this.personalCalendar.setVisibility(false);
    	this.welcomeView.setVisibility(true);
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
        
        backToWelcomeListener = new ActionListener() 
        {
              public void actionPerformed(ActionEvent actionEvent) 
              {                  
            	  seeWelcomeAction();
              }
        };                
        personalAnimals.getBackToWelcomeButton().addActionListener(backToWelcomeListener);   
        personalCalendar.getBackToWelcomeButton().addActionListener(backToWelcomeListener);   
        personalData.getBackToWelcomeButton().addActionListener(backToWelcomeListener);   
        personalClinic.getBackToWelcomeButton().addActionListener(backToWelcomeListener);   
    }
}
