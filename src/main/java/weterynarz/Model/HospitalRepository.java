package weterynarz.Model;

import weterynarz.Data.Database;

public class HospitalRepository implements IHospitalRepository{
	
	private Database _data = Database.getInstance();
	
	public void add(Hospital hospital)
	{
		_data.hospitals.add(hospital);
	}

	public void remove(Hospital hospital) 
	{
		_data.hospitals.remove(hospital);
	}
	
	public Hospital findById(int id)
	{
		for(Hospital hospital : _data.hospitals)
		{
			if(hospital.getId() == id)
				return hospital;
		}
		
		throw new NullPointerException("Nie odnaleziono lecznicy o id: "+id);
	}
		
	public Hospital findBySpec(String spec)
	{
		for(Hospital hospital : _data.hospitals)
		{
			if(hospital.getSpec().equals(spec))
				return hospital;
		}
		
		//ten exception ponizej dziala, ale lepiej zrobic wlasna obsluge (to na pozniej)
		throw new NullPointerException("Nie odnaleziono lecznicy o specjalizacji: " + spec);
	}
	
	
	
	

}
