package weterynarz.Model;

public interface IClientsRepository extends IRepository<Client>{
	Client findByNameAndSurname(String name, String surname);
}
