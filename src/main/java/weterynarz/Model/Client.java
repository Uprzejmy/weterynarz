package weterynarz.Model;

public class Client extends Item{
	private static int _idCounter;
	private String _name;
	private String _surname;
	private String _adress;
	private Integer _phone;
	
	public Client(String name, String surname, String adress, Integer phone)
	{
		_id = _idCounter++;
		_name = name;
		_surname = surname;
		_adress = adress;
		_phone = phone;
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

	public Integer getPhone()
	{
		return _phone;
	}
	
	public void setPhone(Integer phone)
	{
		_phone = phone;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " "+
				_adress + " "+
				_phone + " ";
	}

}