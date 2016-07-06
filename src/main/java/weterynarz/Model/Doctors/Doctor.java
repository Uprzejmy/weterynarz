package weterynarz.Model.Doctors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="doctors")

public class Doctor
{
	@Id @GeneratedValue
	@Column(name = "id")
	private int _id;
	
	@Column(name = "name")
	private String _name;
	
	@Column(name = "surname")
	private String _surname;
	
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
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " ";
		
	}

}
