package weterynarz.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import weterynarz.Context;
import weterynarz.Model.Model;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Patients.Patient;
import weterynarz.View.DoctorView.DoctorAnimals;
import weterynarz.View.DoctorView.DoctorClinic;
import weterynarz.View.DoctorView.DoctorDetails;
import weterynarz.View.DoctorView.DoctorSeeAgenda;
import weterynarz.View.DoctorView.DoctorWelcomeBox;



public class DoctorController implements IController {
	private Context context;
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
	private ActionListener backToWelcomeListener;
	
	public DoctorController(Model model,Context context)
	{
		List<Patient> patients = new ArrayList<Patient>();
		
		this.model = model;
		this.context = context;
		this.welcomeView = new DoctorWelcomeBox();
		this.personalCalendar = new DoctorSeeAgenda();
		this.personalClinic = new DoctorClinic();
		this.personalData = new DoctorDetails();
		this.personalAnimals = new DoctorAnimals(patients);
		
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
