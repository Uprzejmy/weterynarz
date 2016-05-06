package weterynarz.Utils;

import weterynarz.model.Doctor;
import weterynarz.model.DoctorsRepository;

public class ExampleLoader {
	public static void loadWholeData(DoctorsRepository doctors)
	{
		loadDoctorsData(doctors);
	}
	
	public static void loadDoctorsData(DoctorsRepository doctors)
	{
		doctors.add(new Doctor("Ferdynand","Kiepski"));
		doctors.add(new Doctor("Waldemar","Kiepski"));
		doctors.add(new Doctor("Arnold","Boczek"));
		doctors.add(new Doctor("Marian","Pazdzioch"));
		doctors.add(new Doctor("Halina","Kiepska"));
	}
}
