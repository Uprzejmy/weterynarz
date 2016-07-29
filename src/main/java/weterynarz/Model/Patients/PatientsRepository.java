package weterynarz.Model.Patients;

import java.util.List;

import org.hibernate.Session;
import weterynarz.Model.UnitOfWork;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Doctors.Doctor;

public class PatientsRepository implements IPatientsRepository{
	
	Session _session;
	
	public PatientsRepository(Session session)
	{
		_session = session;
	}
	
	public void add(Patient patient)
	{
		_session.save(patient);
	}

	public void remove(Patient patient) 
	{
		_session.delete(patient);
	}
	
	public Patient findById(int id)
	{
		return _session.get(Patient.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> findByOwner(Client client)
	{
		return _session.createQuery("select p from Patient p where _owner: ownerId").setParameter("ownerId",client.getId()).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Patient> findByDoctor(Doctor doctor)
	{
		return _session.createQuery("select p from Patient p where _doctor: doctorId").setParameter("doctorId",doctor.getId()).getResultList();
	}
}
