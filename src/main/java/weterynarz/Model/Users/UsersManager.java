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
	    user.setHashedPassword(getHash(password+user.getSalt()));
	    
	    _unitOfWork.getSession().save(user);
	}
	
	public User login(String email, String password)
	{
		//Criteria c2 = _unitOfWork.getSession().createCriteria(Product.class);
		//c2.add(Restrictions.like("name", "INC"));
		//c2.add(Restrictions.like("description","%Transport%"));
		User user = _unitOfWork.getSession().byNaturalId(User.class).using("_email",email).load();
		if(isPasswordValid(user,password))
			return user;
		
		return null;
		//Query<User> query = _unitOfWork.getSession().createQuery("from users where _email = :email ",User.class);
		//query.setParameter("email", email);
		//User user = query.uniqueResult();
		//List<User> list = query.list();
		//User user = list.get(0);
		//_unitOfWork.getSession().
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
			md.update(Base64.getDecoder().decode(str));
			aMessageDigest = md.digest();

			return Base64.getEncoder().encodeToString(aMessageDigest);
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
