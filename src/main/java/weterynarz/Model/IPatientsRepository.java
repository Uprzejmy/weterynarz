package weterynarz.Model;

public interface IPatientsRepository extends IRepository<Patient>{
	Client findByNameA(String name);
}