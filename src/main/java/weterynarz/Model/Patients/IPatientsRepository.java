package weterynarz.Model.Patients;

import weterynarz.Model.IRepository;
import weterynarz.Model.Clients.Client;

public interface IPatientsRepository extends IRepository<Patient>{
	Client findByNameA(String name);
}