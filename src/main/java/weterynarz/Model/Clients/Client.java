package weterynarz.Model.Clients;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

import weterynarz.Model.Patients.Patient;
import weterynarz.Model.Users.User;

@Entity
@SequenceGenerator(initialValue = 1, allocationSize=1, name = "clients_ids", sequenceName = "clients_ids")
@Table(name="clients")
public class Client{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "clients_ids")
	@Column(name = "id")
	private int _id;
	
	@Column(name = "name")
	private String _name;
	
	@Column(name = "surname")
	private String _surname;
	
	@Column(name = "address")
	private String _address;
	
	@Column(name = "phone")
	private String _phone;
	
	@OneToOne
	@NaturalId
    @JoinColumn(name = "user_id")
	private User _user;
	
	@OneToMany(mappedBy = "_owner", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Patient> _patients = new ArrayList<Patient>();
	
	public Client(String name, String surname, String adress, String phone)
	{
		_name = name;
		_surname = surname;
		_address = adress;
		_phone = phone;
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

	public String getAddress()
	{
		return _address;
	}
	
	public void setAddress(String address)
	{
		_address = address;
	}

	public String getPhone()
	{
		return _phone;
	}
	
	public void setPhone(String phone)
	{
		_phone = phone;
	}
	
	public User getUser() {
        return _user;
    }

    public void setUser(User user) {
        _user = user;
    }
    
    public List<Patient> getPatients() {
        return _patients;
    }

    public void addPatient(Patient patient) {
        _patients.add(patient);
        patient.setOwner(this);
    }

    public void removePatient(Patient patient) {
    	_patients.remove( patient );
    	patient.setOwner( null );
    }

	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				_name + " " + 
				_surname + " "+
				_address + " "+
				_phone + " ";
	}

}