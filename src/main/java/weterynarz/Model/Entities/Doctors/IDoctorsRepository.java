package weterynarz.Model.Entities.Doctors;

import java.util.List;

import weterynarz.Model.IRepository;
import weterynarz.Model.Entities.Users.User;

public interface IDoctorsRepository extends IRepository<Doctor>{
	public Doctor findByUser(User user);
	public List<Doctor> findAll();
}
