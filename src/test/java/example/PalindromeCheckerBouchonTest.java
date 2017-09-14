package example;

import org.junit.*;
import static org.junit.Assert.*;

/** 
 * Un "bouchon" spécifique pour ce test
 * @author rbastide
 */
class InversorBouchon extends Inversor {
	@Override
	public String inverse(String s) {
		switch (s) {
			case "kayak" :
				return "kayak";
			case "Bastide" :
				return "editsaB";
			default :
				return "Ne se produira pas ici";				
		}
	}	
}

public class PalindromeCheckerBouchonTest {
	// On déclare les objets nécessaires aux tests
	PalindromeCheckerDI checker;
	Inversor inversor;

	@Before
	public void setUp() {
		// On créee le "bouchon"
		inversor = new InversorBouchon();
		// On crée l'objet à tester en utilisant le bouchon
		checker = new PalindromeCheckerDI(inversor);
	}

	@After
	public void tearDown() {
		checker = null;
		inversor = null;
	}

	@Test
	public void testVraiPalindrome() {
		assertTrue(checker.estPalindrome("kayak"));
	}

	@Test
	public void testFauxPalindrome() {
		assertFalse(checker.estPalindrome("Bastide"));
	}

}
