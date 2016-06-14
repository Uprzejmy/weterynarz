package weterynarz.Utils;

import weterynarz.Model.Animals.Animal;
import weterynarz.Model.Animals.AnimalsRepository;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Hospitals.Hospital;
import weterynarz.Model.Hospitals.HospitalRepository;

public class ExampleLoader {
	public static void loadWholeData()
	{
		loadDoctorsData(new DoctorsRepository());
		loadAnimalsData(new AnimalsRepository());
		loadClientsData(new ClientsRepository());
		loadHospitalsData(new HospitalRepository());
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
		animals.add(new Animal("pies","rottweiler", "czarny", 4, 0));
		animals.add(new Animal("pies","basset", "bialo-brazowy", 4, 0));
		animals.add(new Animal("kot","brytyjski", "szary", 4, 1));
		animals.add(new Animal("waz","gniewosz plamisty", "zielony", 0, 1));
		animals.add(new Animal("papuga","nimfa", "szara", 2, 2));
	}	

	public static void loadClientsData(ClientsRepository clients)
	{
		clients.add(new Client("Harry","Potter", "Privet Drive 4", "123456789", "harry@potter.pl"));
		clients.add(new Client("Syriusz","Black", "Grimmauld Place 12", "456724192", "syriusz@black.pl"));
		clients.add(new Client("Ronald","Weasly", "Nora", "123443312", "ronald@weasly.pl"));
		clients.add(new Client("Severus","Snape", "Spinner's End", "789423902", "severus@snape.pl"));
		clients.add(new Client("Aberforth","Dumbledore", "The Hog's Head, Hogsmeade", "700345723", "aberforth@dumbledore.pl"));

	}
	public static void loadHospitalsData(HospitalRepository hospitals)
	{
		hospitals.add(new Hospital("Zdrowe Lapki","Oddzial Chorob konczyn","Nieduza 12"));
		hospitals.add(new Hospital("Lecznicowo","Oddzial Glowny","Duza 17"));
		hospitals.add(new Hospital("Zdrowie Zwierzat","Oddzial Chorob zakaznych","Mala 28"));
		hospitals.add(new Hospital("Nasz Krewniak","Oddzial Chorob dziedzicznych","Wielka 42"));
		hospitals.add(new Hospital("Zrosniete Kosci","Oddzial Urazow","Ogromna 33"));
	}
}
