package weterynarz.Model.Clients;

import weterynarz.Model.IRepository;

public interface IClientsRepository extends IRepository<Client>{
	Client findByNameAndSurname(String name, String surname);
	Client findByEmail(String email);
}
