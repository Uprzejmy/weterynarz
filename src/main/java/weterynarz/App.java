package weterynarz;

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
		
		Doctor doctor;
		doctor = new Doctor("Marian","Pazdzioch");
		
		doctors.add(doctor);
		doctors.add(new Doctor("Ferdynand","Kiepski"));
		doctors.add(new Doctor("Waldemar","Kiepski"));
		doctors.add(new Doctor("Arnold","Boczek"));
		doctors.printAll();
		
		
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
		
		
	}

}
