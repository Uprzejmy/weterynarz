package weterynarz.Model.Doctors;

import java.util.List;

import weterynarz.Model.IRepository;
import weterynarz.Model.Users.User;

public interface IDoctorsRepository extends IRepository<Doctor>{
	public Doctor findByUser(User user);
	public List<Doctor> findAll();
}
