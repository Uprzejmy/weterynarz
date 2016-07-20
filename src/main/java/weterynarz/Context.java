package weterynarz;

import weterynarz.Model.Users.User;

public class Context {
	private User user;
	private EContexts type;

	public Context()
	{
		this.user = null;
		this.type = EContexts.USER;
	}

	public Context(User user, EContexts type)
	{
		this.user = user;
		this.type = type;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public EContexts getType() {
		return type;
	}

	public void setContext(EContexts type) {
		this.type = type;
	}

}
