package weterynarz;


import weterynarz.Model.Animals;
import weterynarz.Model.AnimalsRepository;
import weterynarz.Model.Doctor;
import weterynarz.Model.DoctorsRepository;
import weterynarz.Utils.ExampleLoader;

public class App {

	public static void main(String[] args) {
		System.out.println("Centrum weterynaryjne \"Najladniejsze kotki internetu\"");
		
		doctorsTest();
		animalsTest();
	}
	
	public static void doctorsTest()
	{
		DoctorsRepository doctors = new DoctorsRepository();
		
		ExampleLoader.loadWholeData(doctors);
		//doctors.printAll();
		
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

	
	public static void animalsTest()
	{
		AnimalsRepository animals = new AnimalsRepository();
		
		ExampleLoader.loadWholeDataAnim(animals);
		//doctors.printAll();
		
		Animals animal;
		
		try 
		{
			animal = animals.findBySpecies("pies");
			System.out.println(animal);
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
		try 
		{
			animal = animals.findByColour("czerwony");
			System.out.println(animal);
		}
		catch(NullPointerException e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
