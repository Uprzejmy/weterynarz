package weterynarz.model;

import java.util.ArrayList;

public class DoctorsRepository implements IDoctorsRepository{
	
	private ArrayList<Doctor> doctors = new ArrayList<Doctor>();
	
	public void add(Doctor doctor)
	{
		doctors.add(doctor);
	}

	public void remove(Doctor doctor) 
	{
		doctors.remove(doctor);
	}
	
	public Doctor findById(int id)
	{
		for(Doctor doctor : doctors)
		{
			if(doctor.getId() == id)
				return doctor;
		}
		
		//ten exception ponizej dziala, ale lepiej zrobic wlasna obsluge (to na pozniej)
		throw new NullPointerException("Nie odnaleziono lekarza o id: "+id);
	}
	
	
	//co z tym foreachem, bo w takiej sytuacji potrzebujê odwo³aæ siê do obiektu Doctor, a nie Item. Rzutowanie w takim miejscu byloby zasobo¿erne
	/*
	public Doctor findByNameAndSurname(String name, String surname)
	{
		for(Doctor doctor : doctors)
		{
			if(doctor.getName().equals(name) && doctor.getSurname().equals(surname))
				return doctor;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o imieniu: " + name + " i nazwisku: " + surname);
	}
	*/
	
	
	

}
