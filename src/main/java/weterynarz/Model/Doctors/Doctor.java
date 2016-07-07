package weterynarz.Model.Doctors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import weterynarz.Model.Users.User;


@Entity
@SequenceGenerator(initialValue = 1, allocationSize=1, name = "doctors_ids", sequenceName = "doctors_ids")
@Table(name="doctors")

public class Doctor
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "doctors_ids")
	@Column(name = "id")
	private int _id;
	
	@Column(name = "name")
	private String _name;
	
	@Column(name = "surname")
	private String _surname;
	
	@OneToOne
    @JoinColumn(name = "user_id")
	private User _user;
	
	public Doctor()
	{
		
	}
	
	public Doctor(String name, String surname)
	{
		_name = name;
		_surname = surname;
	}
	
	public int getId() 
	{
	      return _id;
	}
	  
	public void setId( int id ) 
	{
	      _id = id;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String getSurname()
	{
		return _surname;
	}
	
	public void setSurname(String surname)
	{
		_surname = surname;
	}
	
	public User getUser() {
        return _user;
    }

    public void setUser(User user) {
        _user = user;
    }
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " ";
		
	}

}
