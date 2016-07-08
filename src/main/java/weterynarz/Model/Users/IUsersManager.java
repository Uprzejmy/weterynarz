package weterynarz.Model.Users;

public interface IUsersManager {
	public User register(String email, String password);
	public User login(String email, String password);
}
