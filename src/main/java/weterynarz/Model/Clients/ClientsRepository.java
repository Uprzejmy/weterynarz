package weterynarz.Model.Clients;

import java.util.List;

import weterynarz.Model.UnitOfWork;
import weterynarz.Model.Doctors.Doctor;

public class ClientsRepository implements IClientsRepository{
	
	UnitOfWork _unitOfWork;
	
	public ClientsRepository(UnitOfWork unitOfWork)
	{
		_unitOfWork = unitOfWork;
	}
	
	public void add(Client client)
	{
	    _unitOfWork.getSession().save(client);
	}

	public void remove(Client client) 
	{
		 _unitOfWork.getSession().delete(client);
	}
	
	public Client findById(int id)
	{
		return _unitOfWork.getSession().get(Client.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> findAll()
	{
		List<Doctor> clients = _unitOfWork.getSession().createQuery("select c from Client c").getResultList();
		return clients;
	}

}
