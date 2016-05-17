package weterynarz.Interface.Commands;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;

public class DoSomethingCommand extends Command implements ICommand{
	public boolean execute() 
	{
		System.out.println("Ojojoj");
		return true;
	}
}