package weterynarz.Model.Doctors;

import weterynarz.Model.IRepository;

public interface IDoctorsRepository extends IRepository<Doctor>{
	Doctor findByNameAndSurname(String name, String surname);
}
