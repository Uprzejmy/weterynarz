package weterynarz.Model.Clients;

import weterynarz.Model.IRepository;
import weterynarz.Model.Users.User;

public interface IClientsRepository extends IRepository<Client>{
	public Client findByUser(User user);
	public void update(Client client);
}
