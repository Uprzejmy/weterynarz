package weterynarz.Model.Entities.Patients;

import java.util.List;

import weterynarz.Model.IRepository;
import weterynarz.Model.Entities.Clients.Client;
import weterynarz.Model.Entities.Doctors.Doctor;

public interface IPatientsRepository extends IRepository<Patient>{
	public List<Patient> findByOwner(Client client);
	public List<Patient> findByDoctor(Doctor doctor);
}