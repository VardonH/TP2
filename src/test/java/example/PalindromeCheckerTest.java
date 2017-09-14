package example;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class PalindromeCheckerTest {
	// On déclare les objets nécessaires aux tests
	PalindromeCheckerDI checker;
	Inversor inversor;

	@Before
	public void setUp() {
		// On créee le "bouchon"
		inversor = mock(Inversor.class);
		// On définit les résultats que le bouchon doit renvoyer pendant le test
		when(inversor.inverse("kayak")).thenReturn("kayak");
		when(inversor.inverse("Bastide")).thenReturn("editsaB");
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
		// On vérifie les appels de méthode reçus par le bouchon (optionnel)
		verify(inversor).inverse("kayak");
	}

	@Test
	public void testFauxPalindrome() {
		assertFalse(checker.estPalindrome("Bastide"));
		// On vérifie les appels de méthode reçus par le bouchon (optionnel)
		verify(inversor).inverse("Bastide");
	}

}
