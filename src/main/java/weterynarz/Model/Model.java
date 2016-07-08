package weterynarz.Model;

import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Clients.IClientsRepository;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Doctors.IDoctorsRepository;
import weterynarz.Model.Users.IUsersManager;
import weterynarz.Model.Users.User;
import weterynarz.Model.Users.UsersManager;

public class Model {

	public User registerUser(String email, String password,String name,String surname,String address,String phone,String type)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IUsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.register(email,password);
		
		if(type.equals("doctor"))
		{
			System.out.println("Registering doctor");
			IDoctorsRepository doctorsRepository = new DoctorsRepository(unitOfWork);
			Doctor doctor = new Doctor(name,surname,address,phone);
			doctor.setUser(user);
			doctorsRepository.add(doctor);
		}
		else if(type.equals("client"))
		{
			System.out.println("Registering client");
			IClientsRepository clientsRepository = new ClientsRepository(unitOfWork);
			Client client = new Client(name,surname,address,phone);
			client.setUser(user);
			clientsRepository.add(client);
		}
		else
		{
			unitOfWork.discardChanges();
			throw new RuntimeException("Unsupported user type");
		}
		
		unitOfWork.saveChanges();
		
		if(user != null)
		{
			System.out.println("Registration successful");
			return user;
		}
			
		System.out.println("Couldn't register user, try different email");
		return null;
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
	
	public Doctor findDoctorByUser(User user)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IDoctorsRepository doctorsRepository = new DoctorsRepository(unitOfWork);
		Doctor doctor = doctorsRepository.findByUser(user);
		
		unitOfWork.saveChanges();
		
		if(doctor != null)
		{
			System.out.println("Doctor has been found");
			return doctor;
		}
			
		System.out.println("Couldn't find doctor");
		return null;
	}
}
