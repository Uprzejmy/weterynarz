package weterynarz.Model.Entities.Clients;

import weterynarz.Model.IRepository;
import weterynarz.Model.Entities.Users.User;

public interface IClientsRepository extends IRepository<Client>{
	public Client findByUser(User user);
	public void update(Client client);
}
