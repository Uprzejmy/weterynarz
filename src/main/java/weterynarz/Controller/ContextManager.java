package weterynarz.Controller;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;

public class ContextManager {
	private static Model model;
	private static UserController userController;
	private static ClientController clientController;
	private static DoctorController doctorController;
	private static ContextManager contextManager;
	
	private ContextManager()
	{
	}
	
	public static ContextManager getInstance()
	{
		if(contextManager == null)
			contextManager = new ContextManager();
		
		return contextManager;
	}
	
	public static void changeContext(User user,String type)//user jest wazny ze wzgledu na kontekst, powinien byc wstrzykniety do kontrolerow
	{
		if(type.equals("client"))
		{
			clientController = new ClientController(model);
			//clientController.configure(); 
		}
		else if(type.equals("doctor"))
		{
			doctorController = new DoctorController(model);
			//doctorController.configure(); 
		}
		else
		{
			throw new RuntimeException("Failed to switch the context");
		}
			
	}
	
	public void run()
	{
		model = new Model();
		//userController = new UserController(model); //default context
		//clientController.configure(); 
	}

}
