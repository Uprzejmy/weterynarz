package weterynarz.Model.Users;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

import weterynarz.Model.UnitOfWork;

public class UsersManager implements IUsersManager
{
	UnitOfWork _unitOfWork;
	
	public UsersManager(UnitOfWork unitOfWork)
	{
		_unitOfWork = unitOfWork;
	}
	
	public User register(String email, String password)
	{
		User user = _unitOfWork.getSession().byNaturalId(User.class).using("_email",email).load();
		
		if(user != null) //when user with such email already exists
			return null; //don't allow any registration
		
		//otherwise let him register and keep logged
	    user = new User(email);
	    user.setSalt(generateSalt());
	    user.setHashedPassword(getHash(password+user.getSalt()));
	     
	    _unitOfWork.getSession().save(user);
	    
	    return user;
	}
	
	public User login(String email, String password)
	{
		User user = _unitOfWork.getSession().byNaturalId(User.class).using("_email",email).load();
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
