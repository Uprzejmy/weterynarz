package weterynarz.Model.Doctors;

import weterynarz.Model.Item;

public class Doctor extends Item{
	private static int _idCounter;
	private String _name;
	private String _surname;
	
	public Doctor(String name, String surname)
	{
		_id = _idCounter++;
		_name = name;
		_surname = surname;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String getSurname()
	{
		return _surname;
	}
	
	public void setSurname(String surname)
	{
		_surname = surname;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " ";
		
	}

}
