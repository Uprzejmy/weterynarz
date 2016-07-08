package weterynarz.Model.Patients;

import java.util.List;

import weterynarz.Model.UnitOfWork;
import weterynarz.Model.Clients.Client;

public class PatientsRepository implements IPatientsRepository{
	
	UnitOfWork _unitOfWork;
	
	public PatientsRepository(UnitOfWork unitOfWork)
	{
		_unitOfWork = unitOfWork;
	}
	
	public void add(Patient patient)
	{
	    _unitOfWork.getSession().save(patient);
	}

	public void remove(Patient patient) 
	{
		 _unitOfWork.getSession().delete(patient);
	}
	
	public Patient findById(int id)
	{
		return _unitOfWork.getSession().get(Patient.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> findByOwner(Client client)
	{
		return _unitOfWork.getSession().createQuery("select p from Patient p where _owner: ownerId").setParameter("ownerId",client.getId()).getResultList();
	}
}
