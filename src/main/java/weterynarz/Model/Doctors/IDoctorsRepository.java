package weterynarz.Model.Doctors;

import java.util.List;

import weterynarz.Model.IRepository;

public interface IDoctorsRepository extends IRepository<Doctor>{
	public List<Doctor> findAll();
}
