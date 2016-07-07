package weterynarz.Model;

import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Users.UsersManager;

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
	
	public void registerUser()
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		
		unitOfWork.start();
		
		UsersManager usersManager = new UsersManager(unitOfWork);
		usersManager.register("test@test.test","demo1234");
		
		unitOfWork.finalize();
	}
}
