package weterynarz.Model.Clients;

import weterynarz.Model.Item;

public class Client extends Item{
	private static int _idCounter;
	private String _name;
	private String _surname;
	private String _adress;
	private String _phone;
	private String _email;
	
	public Client(String name, String surname, String adress, String phone, String email)
	{
		_id = _idCounter++;
		_name = name;
		_surname = surname;
		_adress = adress;
		_phone = phone;
		_email = email;
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

	public String getAdress()
	{
		return _adress;
	}
	
	public void setAdress(String adress)
	{
		_adress = adress;
	}

	public String getPhone()
	{
		return _phone;
	}
	
	public void setPhone(String phone)
	{
		_phone = phone;
	}
	
	public String getEmail()
	{
		return _email;
	}
	
	public void setEmail(String email)
	{
		_email = email;
	}
	
	public boolean compareEmail(String email)
	{
		return _email.equals(email);
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " "+
				_adress + " "+
				_phone + " "+
				_email + " ";
	}

}