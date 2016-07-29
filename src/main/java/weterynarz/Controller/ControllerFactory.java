package weterynarz.Controller;

import weterynarz.Context;
import weterynarz.Model.Client.ClientModel;
import weterynarz.Model.Doctor.DoctorModel;
import weterynarz.Model.User.UserModel;

public final class ControllerFactory {
	//important, "static" class
	private ControllerFactory()
	{
	}
	
	public static IController createController(Context context)
	{
		switch(context.getType())
		{
			case USER: return new UserController(new UserModel());
			case DOCTOR: return new DoctorController(new DoctorModel(),context);
			case CLIENT: return new ClientController(new ClientModel(),context);
			default:
				throw new RuntimeException("Failed to switch the context, unsupported type");
		}
	}
}
