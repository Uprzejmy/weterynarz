package weterynarz.Data;

import java.util.HashSet;

import weterynarz.Model.Clients.Client;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Hospitals.Hospital;
import weterynarz.Model.Patients.Patient;


public class Database {
	
	/*
	 * @param Integer - unique doctor's id
	 * @param Doctor - doctor's object
	 */
	public HashSet<Doctor> doctors = new HashSet<Doctor>();
	public HashSet<Client> clients = new HashSet<Client>();
	public HashSet<Hospital> hospitals = new HashSet<Hospital>();
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
