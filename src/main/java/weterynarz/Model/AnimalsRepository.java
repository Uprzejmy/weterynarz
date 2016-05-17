package weterynarz.Model;

import java.util.ArrayList;

public class AnimalsRepository implements IAnimalsRepository{

	private ArrayList<Animals> animals = new ArrayList<Animals>();
	
	public void add(Animals animal)
	{
		animals.add(animal);
	}

	public void remove(Animals animal) 
	{
		animals.remove(animal);
	}
	

	public Animals findBySpecies(String species)
	{
		for(Animals animal : animals)
		{
			if(animal.getSpecies() == species)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o gatunku: "+ species);
		/*try
		{
			for(Animals animal : animals)
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
		for(Animals animal : animals)
		{
			if(animal.getColour() == colour)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia o takim kolorze jak: "+ colour);
		/*try
		{
			for(Animals animal : animals)
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
		for(Animals animal : animals)
		{
			if(animal.getNumberofPaws() == numofPaws)
				return animal;
		}
		
		throw new NullPointerException("Nie odnaleziono zwierzecia, ktore ma liczbe lap rowna "+ numofPaws);
		/*try
		{
			for(Animals animal : animals)
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
