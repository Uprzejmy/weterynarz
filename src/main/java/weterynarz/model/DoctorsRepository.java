package weterynarz.model;

import java.util.ArrayList;
import java.util.Iterator;

public class DoctorsRepository implements IRepository{
	private ArrayList<Doctor> doctors;
	
	public DoctorsRepository()
	{
		doctors = new ArrayList<Doctor>();
	}
	
	public void add(Object object)
	{
		doctors.add(Doctor.class.cast(object));
	}

	public void remove(Object object) {
		doctors.remove(Doctor.class.cast(object));
	}
	
	public Doctor findById(int id)
	{
		for(Doctor doctor : doctors)
		{
			if(doctor.getId() == id)
				return doctor;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o id: "+id);
	}
	
	public Doctor findByNameAndSurname(String name, String surname)
	{
		for(Doctor doctor : doctors)
		{
			if(doctor.getName().equals(name) && doctor.getSurname().equals(surname))
				return doctor;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o imieniu: " + name + " i nazwisku: " + surname);
	}
	
	public void printAll()
	{
		Iterator<Doctor> i = doctors.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next().toString());
		}
	}
	

}
