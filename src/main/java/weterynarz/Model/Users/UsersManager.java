package weterynarz.Model.Users;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import org.hibernate.Session;
import weterynarz.EContexts;
import weterynarz.Model.UnitOfWork;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;
import weterynarz.Model.Clients.IClientsRepository;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;
import weterynarz.Model.Doctors.IDoctorsRepository;

public class UsersManager implements IUsersManager
{
	Session _session;
	
	public UsersManager(Session session)
	{
		_session = session;
	}
	
	public EContexts getUserType(User user)
	{
		IDoctorsRepository doctorsRepository = new DoctorsRepository(_session);
		Doctor doctor = doctorsRepository.findByUser(user);
		if(doctor!=null)
		{
			return EContexts.DOCTOR;
		}
		
		IClientsRepository clientsRepository = new ClientsRepository(_session);
		Client client = clientsRepository.findByUser(user);
		if(client!=null)
		{
			return EContexts.CLIENT;
		}
		
		throw new RuntimeException("Unsupported user type");
	}
	
	public User register(String email, String password)
	{
		User user = _session.byNaturalId(User.class).using("_email",email).load();
		
		if(user != null) //when user with such email already exists
			return null; //don't allow any registration
		
		//otherwise let him register and keep logged
	    user = new User(email);
	    user.setSalt(generateSalt());
	    user.setHashedPassword(getHash(password+user.getSalt()));

		_session.save(user);
	    
	    return user;
	}
	
	public User login(String email, String password)
	{
		User user = _session.byNaturalId(User.class).using("_email",email).load();
		if(user == null) //can't find user with such email
			return null;
		
		if(!isPasswordValid(user,password)) //password incorrect
			return null;
		
		return user;
	} 
	
	public String generateSalt()
	{
		final Random random = new SecureRandom();
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	public String getHash(String str)
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] aMessageDigest = new byte[32];
			md.update(str.getBytes(StandardCharsets.UTF_8));
			aMessageDigest = md.digest();

			return new String(aMessageDigest,StandardCharsets.UTF_8);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}
	
	private boolean isPasswordValid(User user, String password)
	{
		if(getHash(password+user.getSalt()).equals(user.getHashedPassword()))
			return true;
		
		return false;
	}
}
