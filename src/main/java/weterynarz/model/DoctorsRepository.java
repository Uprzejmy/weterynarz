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
	
	public void printAll()
	{
		Iterator<Doctor> i = doctors.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next().toString());
		}
	}
	

}
