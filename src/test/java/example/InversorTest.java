package example;

import org.junit.*;
import static org.junit.Assert.*;

public class InversorTest {
	// On déclare les objets nécessaires aux tests

	Inversor inversor;

	@BeforeClass
	public static void setUpClass() {
		// Ce code sera exécuté 1 seule fois, avant tous les tests
	}

	@AfterClass
	public static void tearDownClass() {
		// Ce code sera exécuté 1 seule fois, après tous les tests
	}

	@Before
	public void setUp() {
		// Ce code sera exécuté avant CHAQUE test
		// On initialise les objets nécessaires aux tests
		inversor = new Inversor();
	}

	@After
	public void tearDown() {
		// Ce code sera exécuté après CHAQUE test
		inversor = null;
	}

	@Test
	public void testInverse() {
		assertEquals("editsaB", inversor.inverse("Bastide"));
	}

	@Test
	public void testForExceptionV1() {
		try {
			inversor.inverse(null); // Cette ligne doit lever une exception
			// Si on arrive ici, c'est qu'on n'a pas eu d'exception -> le test doit échouer
			fail();
		} catch (IllegalArgumentException e) {
			// Si on arrive ici c'est normal, le test doit réussir
		}
	}

	// On documente l'exception attendue
	@Test(expected = IllegalArgumentException.class)
	public void testForExceptionV2() {
		inversor.inverse(null); // Cette ligne doit lever une exception
	}
}
