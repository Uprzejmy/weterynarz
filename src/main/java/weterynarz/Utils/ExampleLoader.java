package weterynarz.Utils;

import weterynarz.Model.Client;
import weterynarz.Model.ClientsRepository;
import weterynarz.Model.Doctor;
import weterynarz.Model.DoctorsRepository;
import weterynarz.Model.Animals;
import weterynarz.Model.AnimalsRepository;

public class ExampleLoader {
	public static void loadWholeData()
	{
		loadDoctorsData(new DoctorsRepository());
		loadAnimalsData(new AnimalsRepository());
		loadClientsData(new ClientsRepository());
	}
	
	public static void loadDoctorsData(DoctorsRepository doctors)
	{
		doctors.add(new Doctor("Ferdynand","Kiepski"));
		doctors.add(new Doctor("Waldemar","Kiepski"));
		doctors.add(new Doctor("Arnold","Boczek"));
		doctors.add(new Doctor("Marian","Pazdzioch"));
		doctors.add(new Doctor("Halina","Kiepska"));
	}
	
	public static void loadAnimalsData(AnimalsRepository animals)
	{
		animals.add(new Animals("pies","rottweiler", "czarny", 4));
		animals.add(new Animals("pies","basset", "bialo-brazowy", 4));
		animals.add(new Animals("kot","brytyjski", "szary", 4));
		animals.add(new Animals("waz","gniewosz plamisty", "zielony", 0));
		animals.add(new Animals("papuga","nimfa", "szara", 2));
	}	

	public static void loadClientsData(ClientsRepository clients)
	{
		clients.add(new Client("Harry","Potter", "Privet Drive 4", "123456789"));
		clients.add(new Client("Syriusz","Black", "Grimmauld Place 12", "456724192"));
		clients.add(new Client("Ronald","Weasly", "Nora", "123443312"));
		clients.add(new Client("Severus","Snape", "Spinner's End", "789423902"));
		clients.add(new Client("Aberforth","Dumbledore", "The Hog's Head, Hogsmeade", "700345723"));

	}
}
