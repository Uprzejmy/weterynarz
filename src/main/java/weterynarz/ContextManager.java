package weterynarz;

import weterynarz.Controller.ControllerFactory;
import weterynarz.Controller.IController;
public class ContextManager {
	private static ContextManager contextManager;
	private static IController currentController;
	
	private ContextManager()
	{
		changeContext(new Context());
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
		currentController = ControllerFactory.createController(context);
		currentController.configure();
			
	}

}
