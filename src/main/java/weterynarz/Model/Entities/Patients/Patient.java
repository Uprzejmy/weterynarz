package weterynarz.Model.Entities.Patients;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import weterynarz.Model.Entities.Clients.Client;
import weterynarz.Model.Entities.Doctors.Doctor;

@Entity
@SequenceGenerator(initialValue = 1, allocationSize=1, name = "patients_ids", sequenceName = "patients_ids")
@Table(name="patients")
public class Patient
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "patients_ids")
	@Column(name = "id")
	private int _id;
	
	@Column(name = "name")
	private String _name;
	
	@Column(name = "species")
	private String _species;
	
	@Column(name = "breed")
	private String _breed;
	
	@Column(name = "paws_number")
	private int _pawsNumber;
	
	@Column(name = "colour")
	private String _colour;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Client _owner;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id")
	private Doctor _doctor;

	public Patient()
	{
	}
	
	public Patient(String name,String species, String breed, int pawsNumber, String colour)
	{
		_name = name;
		_species = species;
		_breed = breed;
		_pawsNumber = pawsNumber;
		_colour = colour;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public void setName(String name)
	{
		_name = name;
	}
	
	public String getSpecies()
	{
		return _species;
	}
	
	public void setSpecies(String species)
	{
		_species = species;
	}
	
	public String getBreed()
	{
		return _breed;
	}
	
	public void setBreed(String breed)
	{
		_breed = breed;
	}
	
	public String getColour()
	{
		return _colour;
	}
	
	public void setColour(String colour)
	{
		_colour = colour;
	}
	
	public int getPawNumber()
	{
		return _pawsNumber;
	}
	
	public void setPawNumber(int pawsNumber)
	{
		_pawsNumber = pawsNumber;
	}
	
	public Client getOwner()
	{
		return _owner;
	}
	
	public void setOwner(Client owner)
	{
		_owner = owner;
	}
	
	public Doctor getDoctor() {
		return _doctor;
	}

	public void setDoctor(Doctor doctor) {
		_doctor = doctor;
	}
	
	public String toString()
	{
		return 
				Integer.toString(_id) + " " + 
				"name: "+ _name + " " +
				"species: "+ _species + " " +
				"breed: "+ _breed + " " +
				"colour: "+ _colour + " " +
				"number of paws : "+ _pawsNumber + " ";
	}
	
	
}
