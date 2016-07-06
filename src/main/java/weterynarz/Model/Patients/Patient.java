package weterynarz.Model.Patients;

import weterynarz.Model.Animals.Animal;

public class Patient extends Animal{
	private int _id;
	private String _name;
	
	public Patient(String name,String species, String breed, String colour, Integer numPaws, int ownerId)
	{
		super(species, breed, colour, numPaws, ownerId);
		_id = 0;
		_name = name;

	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				"name: "+ _name + " ";
	}
	
	
}
