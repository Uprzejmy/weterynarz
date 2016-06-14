package weterynarz.Interface.Commands;



import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;
import weterynarz.Model.Doctors.Doctor;
import weterynarz.Model.Doctors.DoctorsRepository;





public class SpisCommand extends Command implements ICommand{
	public boolean execute() 
	{
		DoctorsRepository docRepo = new DoctorsRepository();
		for(Doctor doctor : docRepo.findAll())
		{
			System.out.println(doctor.toString());
		}
		return false;
	}

}