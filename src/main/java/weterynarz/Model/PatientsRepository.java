package weterynarz.Model;

import weterynarz.Data.Database;

public class PatientsRepository implements IPatientsRepository{
	
	private Database _data = Database.getInstance();
	
	public void add(Patient patient)
	{
		_data.patients.add(patient);
	}

	public void remove(Patient patient) 
	{
		_data.patients.remove(patient);
	}
	
	public Patient findById(int id)
	{
		for(Patient patient : _data.patients)
		{
			if(patient.getId() == id)
				return patient;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o id: "+id);
	}
		
	public Patient findByName(String name)
	{
		for(Patient patient : _data.patients)
		{
			if(patient.getName().equals(name))
				return patient;
		}
		
		//ten exception ponizej dziala, ale lepiej zrobic wlasna obsluge (to na pozniej)
		throw new NullPointerException("Nie odnaleziono pacjenta o imieniu: " + name);
	}

	public Client findByNameA(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
