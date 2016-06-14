package weterynarz.Model.Animals;

import weterynarz.Model.IRepository;

public interface IAnimalsRepository extends IRepository<Animal>{
	Animal findBySpecies(String species);
	Animal findByColour(String colour);
	Animal findByNumberofPaws(Integer numofPaws);
	Animal[] findByOwnerId(int ownerId);
	Animal[] findAll();
}
