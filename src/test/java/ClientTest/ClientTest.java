package ClientTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import weterynarz.Model.Clients.Client;

public class ClientTest {

	Client client;

	@Before
	public void setUp() throws Exception {
		client = new Client("Mateusz", "Ziemniak", "Grobowa 33", "12345");
	}


	@Test
	public void testGetAddress() {
		String adres = client.getAddress();
		assertEquals("Grobowa 33", adres);
	}

}
