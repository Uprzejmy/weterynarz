package weterynarz.Model;

import Data.Database;

public class DoctorsRepository implements IDoctorsRepository{
	
	private Database _data = Database.getInstance();
	
	public void add(Doctor doctor)
	{
		_data.doctors.add(doctor);
	}

	public void remove(Doctor doctor) 
	{
		_data.doctors.remove(doctor);
	}
	
	public Doctor findById(int id)
	{
		for(Doctor doctor : _data.doctors)
		{
			if(doctor.getId() == id)
				return doctor;
		}
		
		//ten exception ponizej dziala, ale lepiej zrobic wlasna obsluge (to na pozniej)
		throw new NullPointerException("Nie odnaleziono lekarza o id: "+id);
	}
		
	public Doctor findByNameAndSurname(String name, String surname)
	{
		for(Doctor doctor : _data.doctors)
		{
			if(doctor.getName().equals(name) && doctor.getSurname().equals(surname))
				return doctor;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o imieniu: " + name + " i nazwisku: " + surname);
	}
	
	
	
	

}
