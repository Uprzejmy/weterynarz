package weterynarz.Model;

import java.util.List;

import weterynarz.Context;
import weterynarz.EContexts;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Clients.IClientsRepository;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Doctors.IDoctorsRepository;
import weterynarz.Model.Patients.IPatientsRepository;
import weterynarz.Model.Patients.Patient;
import weterynarz.Model.Patients.PatientsRepository;
import weterynarz.Model.Users.IUsersManager;
import weterynarz.Model.Users.User;
import weterynarz.Model.Users.UsersManager;

public class Model {

	public Context registerUser(String email, String password,String name,String surname,String address,String phone,EContexts type)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IUsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.register(email,password);
		
		switch(type)
		{
			case DOCTOR:
			{
				System.out.println("Registering doctor");
				IDoctorsRepository doctorsRepository = new DoctorsRepository(unitOfWork);
				Doctor doctor = new Doctor(name,surname,address,phone);
				doctor.setUser(user);
				doctorsRepository.add(doctor);
				break;
			}
			case CLIENT:
			{
				System.out.println("Registering client");
				IClientsRepository clientsRepository = new ClientsRepository(unitOfWork);
				Client client = new Client(name,surname,address,phone);
				client.setUser(user);
				clientsRepository.add(client);
				break;
			}
			default:
			{
				unitOfWork.discardChanges();
				throw new RuntimeException("Unsupported user type");
			}
				
		}

		unitOfWork.saveChanges();
		//registration is done, now login part
		
		if(user != null)
		{
			System.out.println("Registration successful");
			return new Context(user,type);
		}
			
		System.out.println("Couldn't register user, try different email");
		return null;
	}
	
	public Context loginUser(String email, String password)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IUsersManager usersManager = new UsersManager(unitOfWork);
		User user = usersManager.login(email,password);
		
		if(user != null)
    	{
			System.out.println("User logged in correctly");
			EContexts type = usersManager.getUserType(user);
			unitOfWork.saveChanges();
    		return new Context(user,type);
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
	
	public List<Patient> findPatientsByUser(User user)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IClientsRepository clientsRepository = new ClientsRepository(unitOfWork);
		Client client = clientsRepository.findByUser(user);
		List<Patient> patients = client.getPatients();

		unitOfWork.saveChanges();
		
		return patients;
	}
	
	public void createPatient(User user,String name, String breed,String pawsNumber,String color)
	{
		UnitOfWork unitOfWork = new UnitOfWork();
		
		unitOfWork.beginTransaction();
		
		IClientsRepository clientsRepository = new ClientsRepository(unitOfWork);
		Client client = clientsRepository.findByUser(user);
		
		Patient patient = new Patient(name,breed,breed,Integer.parseInt(pawsNumber),color);
		patient.setOwner(client);
		client.addPatient(patient);
		
		IPatientsRepository patientsRepository = new PatientsRepository(unitOfWork);
		patientsRepository.add(patient);
		
		clientsRepository.update(client);
		
		unitOfWork.saveChanges();
	}
}
