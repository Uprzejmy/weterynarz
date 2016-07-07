package weterynarz.Model.Doctors;

import java.util.List;

import weterynarz.Model.UnitOfWork;

public class DoctorsRepository implements IDoctorsRepository{
	
	UnitOfWork _unitOfWork;
	
	public DoctorsRepository(UnitOfWork unitOfWork)
	{
		_unitOfWork = unitOfWork;
	}
	
	public void add(Doctor doctor)
	{
	    _unitOfWork.getSession().save(doctor);
	}

	public void remove(Doctor doctor) 
	{
		 _unitOfWork.getSession().delete(doctor);
	}
	
	public Doctor findById(int id)
	{
		return _unitOfWork.getSession().get(Doctor.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> findAll()
	{
		List<Doctor> doctors = _unitOfWork.getSession().createQuery("select d from Doctor d").getResultList();
		return doctors;
	}
}
