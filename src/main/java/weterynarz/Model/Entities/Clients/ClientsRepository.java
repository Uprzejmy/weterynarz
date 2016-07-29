package weterynarz.Model.Entities.Clients;

import org.hibernate.Session;
import weterynarz.Model.Entities.Users.User;

public class ClientsRepository implements IClientsRepository{
	
	Session _session;
	
	public ClientsRepository(Session session)
	{
		_session = session;
	}
	
	public void add(Client client)
	{
		_session.save(client);
	}

	public void remove(Client client) 
	{
		_session.delete(client);
	}
	
	public void update(Client client) 
	{
		_session.update(client);
	}
	
	public Client findById(int id)
	{
		return _session.get(Client.class, id);
	}
	
	public Client findByUser(User user)
	{
		return _session.byNaturalId(Client.class).using("_user",user).load();
	}

}
