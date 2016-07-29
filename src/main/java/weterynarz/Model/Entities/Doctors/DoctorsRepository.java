package weterynarz.Model.Entities.Doctors;

import java.util.List;

import org.hibernate.Session;
import weterynarz.Model.Entities.Users.User;

public class DoctorsRepository implements IDoctorsRepository{

	Session _session;
	
	public DoctorsRepository(Session session)
	{
		_session = session;
	}
	
	public void add(Doctor doctor)
	{
		_session.save(doctor);
	}

	public void remove(Doctor doctor) 
	{
		_session.delete(doctor);
	}
	
	public Doctor findById(int id)
	{
		return _session.get(Doctor.class, id);
	}
	
	public Doctor findByUser(User user)
	{
		return _session.byNaturalId(Doctor.class).using("_user",user).load();
	}
	
	@SuppressWarnings("unchecked")
	public List<Doctor> findAll()
	{
		List<Doctor> doctors = _session.createQuery("select d from Doctor d").getResultList();
		return doctors;
	}
}
