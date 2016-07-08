package ModelTest;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;

public class ModelTest {

	User user;
	Model model;

	@Before
	public void setUp() throws Exception {
		user = new User();
		model = new Model();
	}

	

	@Test
	public void testRegisterUser() {
		user = model.registerUser("testing@test.test", "kicia12", "Liv", "Montez", "Miodowa 12", "1234", "client");
		User testuser = model.loginUser("testing@test.test", "kicia12");
		assertEquals(testuser.getEmail(), user.getEmail());
	}

}
