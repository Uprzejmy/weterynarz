package weterynarz.Model;

import weterynarz.Data.Database;

public class AnimalsRepository implements IAnimalsRepository{

	private Database _data = Database.getInstance();
	
	public void add(Animals animal)
	{
		_data.animals.add(animal);
	}

	public void remove(Animals animal) 
	{
		_data.animals.remove(animal);
	}
	
	public Animals findById(int id)
	{
		for(Animals animal : _data.animals)
		{
			if(animal.getId() == id)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o id: "+id);
	}
	
	public Animals findBySpecies(String species)
	{
		for(Animals animal : _data.animals)
		{
			if(animal.getSpecies() == species)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o gatunku: "+ species);
		/*try
		{
			for(Animals animal : _data.animals)
			{
				if(animal.getSpecies() == species)
					return animal;
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("Nie odnaleziono zwierzecia o gatunku: " + species);
		}*/
	}

	public Animals findByColour(String colour)
	{
		for(Animals animal : _data.animals)
		{
			if(animal.getColour() == colour)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o takim kolorze jak: "+ colour);
		/*try
		{
			for(Animals animal : _data.animals)
			{
				if(animal.getSpecies() == species)
					return animal;
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("Nie odnaleziono zwierzecia o kolorze : " + colour);
		}*/
	}

	public Animals findByNumberofPaws(Integer numofPaws)
	{
		for(Animals animal : _data.animals)
		{
			if(animal.getNumberofPaws() == numofPaws)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia, ktore ma liczbe lap rowna "+ numofPaws);
		/*try
		{
			for(Animals animal : _data.animals)
			{
				if(animal.getNumberofPaws() == numofPaws)
					return animal;
			}
		}
		catch (NullPointerException e)
		{
			System.out.println("Nie odnaleziono zwierzecia, ktore ma liczbe lap rowna "+ numofPaws);
		}*/
	}
	
}
