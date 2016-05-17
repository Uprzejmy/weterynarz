package weterynarz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weterynarz.Interface.ICommand;
import weterynarz.Interface.Parser;
import weterynarz.Model.Doctor;
import weterynarz.Model.DoctorsRepository;
import weterynarz.Utils.ExampleLoader;

public class App {

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Centrum weterynaryjne \"Najladniejsze kotki internetu\"");

		boolean exit = false;
		String cmd= "";
	    while(exit == false)
	    {
	    	System.out.println("Enter command (help to display help): ");
	    	try 
	    	{
				cmd = reader.readLine();
			} 
	    	catch (IOException e) 
	    	{
				System.out.println("Error reading command");
			}
	    	
	    	ICommand command = Parser.Parse(cmd);
	        exit = command.execute();
	    	
	    }
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

}
