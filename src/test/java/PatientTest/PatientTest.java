package PatientTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import weterynarz.Model.Patients.Patient;

public class PatientTest {

	Patient patient;

	@Before
	public void setUp() throws Exception {
		
		patient = new Patient("Reksio", "Pies", "Pudel", 3, "czarny");
	}



	@Test
	public void testSetBreed() {
		Patient testpatient = new Patient("Azor", "Pies", "Owczarek niemiecki", 4, "zloty");
		testpatient.setBreed("Pudel");
		assertEquals(patient.getBreed(), testpatient.getBreed());
		
	}

}
