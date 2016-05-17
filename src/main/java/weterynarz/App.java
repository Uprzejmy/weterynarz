package weterynarz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weterynarz.Interface.ICommand;
import weterynarz.Interface.Parser;

import weterynarz.Utils.ExampleLoader;

public class App {

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
	
	
}
