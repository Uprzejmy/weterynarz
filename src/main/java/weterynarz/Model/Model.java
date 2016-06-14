package weterynarz.Model;

import weterynarz.Model.Doctors.DoctorsRepository;

public class Model {
	
	public String getData1()
	{
		return "weterynarz";
	}
	
	public String getData2()
	{
		return "test";
	}
	
	public String getDoctorData()
	{
		DoctorsRepository drepo = new DoctorsRepository();
		return drepo.repositoryTest();
	}
}
