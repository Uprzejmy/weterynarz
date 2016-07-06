package weterynarz.Model.Users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import weterynarz.Model.UnitOfWork;

public class UsersManager 
{
	UnitOfWork _unitOfWork;
	
	public UsersManager(UnitOfWork unitOfWork)
	{
		_unitOfWork = unitOfWork;
	}
	
	public void register(String email, String password)
	{
	    User user = new User(email);
	    user.setSalt(generateSalt());
	    user.setHashedPassword(getHash(password,user.getSalt()));
	    
	    _unitOfWork.save(user);
	}
	
	public void login(String email, String password)
	{
	}
	
	public String generateSalt()
	{
		final Random random = new SecureRandom();
		byte[] salt = new byte[32];
		random.nextBytes(salt);
		return Base64.getEncoder().encodeToString(salt);
	}
	
	public String getHash(String password, String salt)
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			byte[] aMessageDigest = new byte[32];
			md.update(Base64.getDecoder().decode(password+salt));
			aMessageDigest = md.digest();

			return Base64.getEncoder().encodeToString(aMessageDigest);
		}
		catch (NoSuchAlgorithmException e)
		{
			throw new RuntimeException(e);
		}
	}
}
