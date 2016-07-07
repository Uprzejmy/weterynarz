package weterynarz.Model;

import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Users.IUsersManager;
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
	
	public String registerUser()
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		
		unitOfWork.beginTransaction();
		
		IUsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.register("test2@test.test","demo1234");

		unitOfWork.saveChanges();
		
		if(user != null)
		{
			System.out.println("zarejestrowano");
			return user.toString();
		}
			
		System.out.println("nie zarejestrowano");
		return "Couldn't register user, try different email";
		
	}
	
	public User loginUser(String email, String password)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IUsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.login(email,password);
		
		unitOfWork.saveChanges();
		
		if(user != null)
		{
			System.out.println("User logged in correctly");
			return user;
		}
			
		System.out.println("Couldn't log in, incorrect email or password");
		return null;
	}
}
