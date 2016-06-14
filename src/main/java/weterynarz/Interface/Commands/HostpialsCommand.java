package weterynarz.Interface.Commands;



import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;
import weterynarz.Model.Hospitals.Hospital;
import weterynarz.Model.Hospitals.HospitalRepository;





public class HostpialsCommand extends Command implements ICommand{
	public boolean execute() 
	{
		HospitalRepository hocRepo = new HospitalRepository();
		for(Hospital hospital : hocRepo.findAll())
		{
			System.out.println(hospital.toString());
		}
		return false;
	}

}