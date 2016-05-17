package weterynarz.Model;

public interface IDoctorsRepository extends IRepository<Doctor>{
	Doctor findByNameAndSurname(String name, String surname);
}
