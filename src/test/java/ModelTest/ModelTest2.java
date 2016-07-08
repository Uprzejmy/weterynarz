package ModelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import weterynarz.Model.Model;
import weterynarz.Model.Users.User;

public class ModelTest2 {

	
	Model model;
	
	@Before
	public void setUp() throws Exception {
	
		model = new Model();
	}

	

	@Test
	public void testLoginUser() {
		User testuser = model.loginUser("dyzio@lipna.lipa", "1234");
		assertEquals(testuser, null);
	}

}
