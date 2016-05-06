package weterynarz.model;

public class Doctor {
	private String _name;
	private String _surname;
	
	public Doctor(String name, String surname)
	{
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
		return _name + " " + _surname;
	}

}
