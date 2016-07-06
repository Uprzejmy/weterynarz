package weterynarz.Model.Users;

public interface IUsersManager {
	public void register(String email, String password);
	public void login(String email, String password);
}
