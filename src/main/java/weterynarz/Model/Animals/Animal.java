package weterynarz.Model.Animals;

public class Animal{
	private int _id;
	private String _species; // gatunek
	private String _breed; // rasa
	private int _numPaws; // liczba lap
	private String _colour; // kolor 
	private int _ownerId;
	
	public Animal(String species, String breed, String colour, Integer numPaws, int ownerId)
	{
		_id = 0;
		_species = species;
		_breed = breed;
		_colour = colour;
		_numPaws = numPaws;
		_ownerId = ownerId;
	}
	
	public int getId() 
	{
	      return _id;
	}
	  
	public void setId( int id ) 
	{
	      _id = id;
	}
	
	public String getSpecies()
	{
		return _species;
	}
	
	public void setSpecies(String species)
	{
		_species = species;
	}
	
	public String getBreed()
	{
		return _breed;
	}
	
	public void setBreed(String breed)
	{
		_breed = breed;
	}
	
	public String getColour()
	{
		return _colour;
	}
	
	public void setColour(String colour)
	{
		_colour = colour;
	}
	
	public Integer getNumberofPaws()
	{
		return _numPaws;
	}
	
	public void setNumberofPaws(Integer numPaws)
	{
		_numPaws = numPaws;
	}
	
	public int getOwnerId()
	{
		return _ownerId;
	}
	
	public void setOwnerId(int ownerId)
	{
		_ownerId = ownerId;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_species+ ": " + 
				_breed + " " 
				+ Integer.toString(_numPaws) + 
				", colour: " + _colour + " " +
				"owner's id: " + _ownerId;
	}
	
}
