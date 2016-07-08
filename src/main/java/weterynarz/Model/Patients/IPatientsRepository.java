package weterynarz.Model.Patients;

import java.util.List;

import weterynarz.Model.IRepository;
import weterynarz.Model.Clients.Client;

public interface IPatientsRepository extends IRepository<Patient>{
	public List<Patient> findByOwner(Client client);
}