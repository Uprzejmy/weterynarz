package weterynarz.Model.Animals;

import java.util.ArrayList;

import weterynarz.Data.Database;

public class AnimalsRepository implements IAnimalsRepository{

	private Database _data = Database.getInstance();
	
	public void add(Animal animal)
	{
		_data.animals.add(animal);
	}

	public void remove(Animal animal) 
	{
		_data.animals.remove(animal);
	}
	
	public Animal findById(int id)
	{
		for(Animal animal : _data.animals)
		{
			if(animal.getId() == id)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o id: "+id);
	}
	
	public Animal findBySpecies(String species)
	{
		for(Animal animal : _data.animals)
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

	public Animal findByColour(String colour)
	{
		for(Animal animal : _data.animals)
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

	public Animal findByNumberofPaws(Integer numofPaws)
	{
		for(Animal animal : _data.animals)
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
	public Animal[] findByOwnerId(int ownerId)
	{
		ArrayList<Animal> animals = new ArrayList<Animal>();
		for(Animal animal : _data.animals)
		{
			if(animal.getOwnerId() == ownerId)
				animals.add(animal);
		}
		
		return animals.toArray(new Animal[animals.size()]);
	}
	
	public Animal[] findAll()
	{
		return _data.animals.toArray(new Animal[_data.animals.size()]);
	}
	
}