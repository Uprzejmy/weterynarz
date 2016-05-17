package weterynarz.Interface.Commands;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;

public class ExitCommand extends Command implements ICommand{
	public boolean execute() 
	{
		System.out.println("Ending...");
		return true;
	}
}
