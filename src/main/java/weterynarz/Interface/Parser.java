package weterynarz.Interface;

import java.util.ArrayList;
import java.util.Arrays;

import weterynarz.Interface.ECommands;
import weterynarz.Interface.Commands.*;

//static class
public final class Parser {
	
	//important
	private Parser(){};
	
	public static ICommand Parse(String commandString) 
	{ 
        // Parse your string and create Command object
        ArrayList<String> commandParts = new ArrayList<String>(Arrays.asList(commandString.split("\\s+")));
        String commandName = commandParts.get(0).toUpperCase();
        commandParts.remove(0);
        switch(ECommands.valueOf(commandName))
        {
            // Create command based on CommandName (and maybe arguments)
            case EXIT: return new ExitCommand();
            case SOMETHING: return new DoSomethingCommand();
            default: return new DoNothingCommand();
        }
   }
	
}
