package weterynarz.Model;

public class Patient extends Animals{
	private static int _idCounter;
	private String _name;
	
	public Patient(String name,String species, String breed, String colour, Integer numPaws)
	{
		super(species, breed, colour, numPaws);
		_id = _idCounter++;
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
	
	
}
