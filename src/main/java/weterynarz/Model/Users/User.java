package weterynarz.Model.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User 
{
	@Id @GeneratedValue
	@Column(name = "id")
	protected int _id;
	
	@Column(name = "email",length=128)//,unique=true
	protected String _email;
	
	@Column(name = "salt",length=64)
	protected String _salt;
	
	@Column(name = "password",length=128)
	protected String _hashedPassword;
	
	
	public User()
	{
		
	}
	
	public User(String email)
	{
		_email = email;
	}
	
	public int getId() 
	{
	      return _id;
	}
	  
	public void setId( int id ) 
	{
	      _id = id;
	}
	
	public String getEmail() 
	{
	      return _email;
	}
	  
	public void setEmail( String email ) 
	{
	      _email = email;
	}
	
	public String getHashedPassword() 
	{
	      return _hashedPassword;
	}
	  
	public void setHashedPassword( String hashedPassword ) 
	{
		_hashedPassword = hashedPassword;
	}
	
	public String getSalt() 
	{
	      return _salt;
	}
	  
	public void setSalt( String salt ) 
	{
	      _salt = salt;
	}
	
	public String toString()
	{
		return 
				"User: " +
				"id: " + Integer.toString(_id) + " " + 
				"email: " + _email + " "
				;
		
	}
	
}