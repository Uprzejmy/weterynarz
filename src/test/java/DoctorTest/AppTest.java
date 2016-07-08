package DoctorTest;

import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;

import weterynarz.Model.Doctors.Doctor;

public class AppTest {
	
	private Doctor doctor;

	
	@Before
	public void setUp() throws Exception {
		
		doctor = new Doctor("Lizzie", "Lavsie", "Miodowa 45", "456789012");
		
	}
	

	@Test
	public void testGetName() {
		
		String name = doctor.getName();
		
		assertEquals("Lizzie", name);
	}
		
}
	
