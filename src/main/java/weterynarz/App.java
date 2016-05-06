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
		
		System.out.println("Powinny sie wyswietlic dwa wpisy");
		doctors.printAll();
		
		doctors.remove(doctor);
		System.out.println("Powinien sie wyswietlic jeden wpis");
		doctors.printAll();
		
		doctors.add(new Doctor("Waldemar","Kiepski"));
		doctors.add(new Doctor("Arnold","Boczek"));
		doctors.printAll();
	}

}
