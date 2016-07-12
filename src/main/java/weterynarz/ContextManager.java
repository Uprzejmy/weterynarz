package weterynarz;

import weterynarz.Controller.ControllerFactory;
import weterynarz.Controller.IController;
import weterynarz.Model.Model;

public class ContextManager {
	private static Model model;
	private static ContextManager contextManager;
	private static IController currentController;
	
	private ContextManager()
	{
	}
	
	public static ContextManager getInstance()
	{
		if(contextManager == null)
			contextManager = new ContextManager();
		
		return contextManager;
	}
	
	public static void changeContext(Context context)//user jest wazny ze wzgledu na kontekst, powinien byc wstrzykniety do kontrolerow
	{
		currentController = null; // potencjalnie bardzo niebezpieczne! powinienem najpierw odrejestrowac listenery, zwolnic view? jest takie cos?
		currentController = ControllerFactory.createController(model,context);
		currentController.configure();
			
	}
	
	public void run()
	{
		model = new Model();
		Context context = new Context(null,EContexts.USER); // nie podoba mi siê, pomyslec nad tym
		changeContext(context);
	}

}
