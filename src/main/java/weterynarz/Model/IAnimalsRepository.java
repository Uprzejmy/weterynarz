package weterynarz.Model;

public interface IAnimalsRepository extends IRepository<Animals>{
	Animals findBySpecies(String species);
	Animals findByColour(String colour);
	Animals findByNumberofPaws(Integer numofPaws);
	Animals[] findByOwnerId(int ownerId);
	Animals[] findAll();
}
