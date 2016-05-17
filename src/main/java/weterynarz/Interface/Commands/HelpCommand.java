package weterynarz.Interface.Commands;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;

public class HelpCommand extends Command implements ICommand{
	public boolean execute() 
	{
		System.out.println("Aby dokonac interakcji nalezy podac jedna z nastepujacych komend: ");
		System.out.println("INFO - informacja o zwierzeciu");
		System.out.println("SPIS - spis dostepnych lekarzy");
		System.out.println("LECZNICE - informacje o wybranej lecznicy");
		System.out.println("EXIT - wyjscie z programu");
		
		return false;
	}
}