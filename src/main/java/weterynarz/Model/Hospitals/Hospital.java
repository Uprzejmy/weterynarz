package weterynarz.Model.Hospitals;

import weterynarz.Model.Item;

public class Hospital extends Item{
	private static int _idCounter;
	private String _name;
	private String _spec;
	private String _address;
	
	public Hospital(String name, String spec, String address)
	{
		_id = _idCounter++;
		_name = name;
		_spec= spec;
		_address=address;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String getSpec()
	{
		return _spec;
	}
	
		public void setSpec(String spec)
	{
		_spec = spec;
	}
	
	public void setAddress(String address)
	{
		_address = address;
	}
	
	public String getAddress()
	{
		return _address;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_spec + " " +
				_address + " ";
	}

}