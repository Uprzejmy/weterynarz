package weterynarz.Interface.Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;

import weterynarz.Model.Client;
import weterynarz.Model.ClientsRepository;

public class LoginCommand extends Command implements ICommand{
	public boolean execute()
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Podaj swój email: ");
		
		try 
    	{
			String email = reader.readLine();
			ClientsRepository clients = new ClientsRepository();
			Client client = clients.findByEmail(email);
			System.out.println("Twoje dane to: "+ client.toString());
		} 
    	catch (IOException e) 
    	{
			System.out.println("Nie znaleziono uzytkownika o podanym adresie email");
		}
		
		
		return false;
	}
	
	
	
}
