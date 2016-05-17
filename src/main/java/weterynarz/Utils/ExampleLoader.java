package weterynarz.Utils;

import weterynarz.Model.Doctor;
import weterynarz.Model.DoctorsRepository;
import weterynarz.Model.Animals;
import weterynarz.Model.AnimalsRepository;

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
	
	public static void loadWholeDataAnim(AnimalsRepository animals)
	{
		loadAnimalsData(animals);
	}
	
	public static void loadAnimalsData(AnimalsRepository animals)
	{
		animals.add(new Animals("pies","rottweiler", "czarny", 4));
		animals.add(new Animals("pies","basset", "bialo-brazowy", 4));
		animals.add(new Animals("kot","brytyjski", "szary", 4));
		animals.add(new Animals("waz","gniewosz plamisty", "zielony", 0));
		animals.add(new Animals("papuga","nimfa", "szara", 2));
	}
}
