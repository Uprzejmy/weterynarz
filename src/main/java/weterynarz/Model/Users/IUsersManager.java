package weterynarz.Model.Users;

import weterynarz.EContexts;

public interface IUsersManager {
	public User register(String email, String password);
	public User login(String email, String password);
	public EContexts getUserType(User user);
}
