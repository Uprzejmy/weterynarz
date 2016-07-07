package weterynarz.Model;

import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Users.User;
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
		
		
		unitOfWork.beginTransaction();
		
		UsersManager usersManager = new UsersManager(unitOfWork);
		usersManager.register("test@test.test","demo1234");
		
		unitOfWork.saveChanges();
	}
	
	public User loginUser()
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		UsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.login("test@test.test","demo1234");
		
		unitOfWork.saveChanges();
		
		return user;
	}
}
