package weterynarz.Interface.Commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import weterynarz.Interface.Command;
import weterynarz.Interface.ICommand;
import weterynarz.Model.Animals.Animal;
import weterynarz.Model.Animals.AnimalsRepository;
import weterynarz.Model.Clients.Client;
import weterynarz.Model.Clients.ClientsRepository;

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
			
			System.out.println("Twoje zwierzeta to: ");
			AnimalsRepository animalsRepo = new AnimalsRepository();
			for(Animal animal : animalsRepo.findByOwnerId(client.getId()))
			{
				System.out.println(animal.toString());
			}
			
		} 
    	catch (IOException e) 
    	{
			System.out.println("Nie mozna pobrac email");
		}
		catch (NullPointerException e) 
    	{
			System.out.println("Nie znaleziono uzytkownika o podanym adresie email");
		}
		
		
		return false;
	}
	
	
	
}
