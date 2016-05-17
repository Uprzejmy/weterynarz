package weterynarz.Data;

import java.util.HashSet;

import weterynarz.Model.Client;
import weterynarz.Model.Doctor;

public class Database {
	
	/*
	 * @param Integer - unique doctor's id
	 * @param Doctor - doctor's object
	 */
	public HashSet<Doctor> doctors = new HashSet<Doctor>();
	public HashSet<Client> clients = new HashSet<Client>();
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
