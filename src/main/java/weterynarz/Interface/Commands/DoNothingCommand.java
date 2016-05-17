package weterynarz.Interface.Commands;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;

public class DoNothingCommand extends Command implements ICommand{
	public boolean execute() 
	{
		return false;
	}
}