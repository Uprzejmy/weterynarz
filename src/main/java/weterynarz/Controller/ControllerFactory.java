package weterynarz.Controller;

import weterynarz.Context;
import weterynarz.Model.Model;

public final class ControllerFactory {
	//important, "static" class
	private ControllerFactory()
	{
		
	}
	
	public static IController createController(Model model, Context context)
	{
		switch(context.getType())
		{
			case USER: return new UserController(model);
			case DOCTOR: return new DoctorController(model,context);
			case CLIENT: return new ClientController(model,context);
			default:
				throw new RuntimeException("Failed to switch the context, unsupported type");
		}
	}
}
