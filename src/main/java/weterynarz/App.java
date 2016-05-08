package weterynarz;

import weterynarz.Utils.ExampleLoader;
import weterynarz.model.Doctor;
import weterynarz.model.DoctorsRepository;

public class App {

	public static void main(String[] args) {
		System.out.println("Centrum weterynaryjne \"Najladniejsze kotki internetu\"");
		
		doctorsTest();
	}
	
	public static void doctorsTest()
	{
		DoctorsRepository doctors = new DoctorsRepository();
		
		ExampleLoader.loadWholeData(doctors);
		doctors.printAll();
		
		Doctor doctor;
		
		try 
		{
			doctor = doctors.findById(6);
			System.out.println(doctor.toString());
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			doctor = doctors.findById(1);
			System.out.println(doctor.toString());
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		/*
		try 
		{
			doctor = doctors.findByNameAndSurname("Marian","Pazdzioch");
			System.out.println(doctor.toString());
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		
		try 
		{
			doctor = doctors.findByNameAndSurname("Mietek","Zul");
			System.out.println(doctor.toString());
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		*/
		
		
	}

}
