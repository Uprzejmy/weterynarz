package weterynarz;

import weterynarz.Controller.UserController;
import weterynarz.Model.Model;

public class App {
	
	/* --------------- v1.0 ----------------
	public static void main(String[] args) {
		ExampleLoader.loadWholeData();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Centrum weterynaryjne \"Najladniejsze kotki internetu\"");

		boolean exit = false;
		String cmd= "";
	    while(exit == false)
	    {
	    	System.out.println("Enter command (help to display help): ");
	    	try 
	    	{
				cmd = reader.readLine();
			} 
	    	catch (IOException e) 
	    	{
				System.out.println("Error reading command");
			}
	    	
	    	ICommand command = Parser.Parse(cmd);
	        exit = command.execute();
	    	
	    }

	}
	*/
	
	// --------------- v2.0 ----------------
	public static void main(String[] args) {
		//View view = new View("Weterynarz");
		Model model = new Model();

		//wait for fully initialized model and view
		
		UserController controller = new UserController(model);
		controller.configure();
	}
	
}
