package weterynarz.Data;

import java.util.HashSet;

import weterynarz.Model.Client;
import weterynarz.Model.Doctor;
import weterynarz.Model.Hospital;
import weterynarz.Model.Animals;
import weterynarz.Model.Patient;


public class Database {
	
	/*
	 * @param Integer - unique doctor's id
	 * @param Doctor - doctor's object
	 */
	public HashSet<Doctor> doctors = new HashSet<Doctor>();
	public HashSet<Client> clients = new HashSet<Client>();
	public HashSet<Hospital> hospitals = new HashSet<Hospital>();
	public HashSet<Animals> animals = new HashSet<Animals>();
	public HashSet<Patient> patients = new HashSet<Patient>();
	//add other data sets here
	
	
	private static Database _database;
	
	
	//important!
	private Database(){};
	
	public static Database getInstance()
	{
		if(_database == null)
		{
			_database = new Database();
		}
		
		return _database;
	}
	
	
}
