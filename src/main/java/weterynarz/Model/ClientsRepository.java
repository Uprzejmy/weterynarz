package weterynarz.Model;

import weterynarz.Data.Database;

public class ClientsRepository implements IClientsRepository{
	
	private Database _data = Database.getInstance();
	
	public void add(Client client)
	{
		_data.clients.add(client);
	}

	public void remove(Client client) 
	{
		_data.doctors.remove(client);
	}
	
	public Client findById(int id)
	{
		for(Client client : _data.clients)
		{
			if(client.getId() == id)
				return client;
		}
		
		throw new NullPointerException("Nie odnaleziono lekarza o id: "+id);
	}
		
	public Client findByNameAndSurname(String name, String surname)
	{
		for(Client client : _data.clients)
		{
			if(client.getName().equals(name) && client.getSurname().equals(surname))
				return client;
		}
		
		//ten exception ponizej dziala, ale lepiej zrobic wlasna obsluge (to na pozniej)
		throw new NullPointerException("Nie odnaleziono lekarza o imieniu: " + name + " i nazwisku: " + surname);
	}
	
	
	
	

}
