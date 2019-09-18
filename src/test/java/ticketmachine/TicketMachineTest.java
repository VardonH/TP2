package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance()); // Les montants ont été correctement additionnés               
	}

        @Test
        //S3 : on n’imprime pas le ticket si le montant inséré est insuffisant
        public void insertPriceNotSufficientForPrint() {
            machine.insertMoney(30);
            assertFalse("L'impression s'effectue malgré le fait que le montant est insuffisant",machine.printTicket());// l'impression ne s'est pas effectué
        }
        
        @Test
        //S4 : on imprime le ticket si le montant inséré est suffisant
        public void insertPriceSufficientForPrint() {
            machine.insertMoney(51);
            assertTrue("L'impression ne s'effectue pas malgré le fait que le montant est suffisant",machine.printTicket());//l'impression s'est effectué
        }
        
        @Test
        //S5 : Quand on imprime un ticket la balance est décrémentée du prix du ticket
        public void printPriceDecrementation() {
            machine.insertMoney(62);
            machine.printTicket();
            assertEquals("La balance n'a pas correctement été décrémentée du prix du ticket imprimé",62-PRICE,machine.getBalance());
        }
        
        @Test
        //S6 : le montant collecté est à jour quand on imprime un ticket (pas avant)
        public void correctBalanceChangeAfterPrint() {
            machine.insertMoney(72);
            machine.printTicket();
            assertEquals("Le montant collecté n'est pas à jour après impréssion du ticket",PRICE,machine.getTotal());//montant collecté à jour
        }
        
        @Test
        //S7 : refund() rend correctement la monnaie
        public void workingRefund() {
            machine.insertMoney(55);
            assertEquals("refund ne fonctionne pas correctement",0,machine.refund());//refund() rend correctement la monnaie
        }
        
        @Test
        // S8 : refund() remet la balance à zéro
        public void refundResetBalance() {
            machine.insertMoney(55);
            assertEquals("la fonction refund() ne rend pas correctement la monnaie",0,machine.refund());//refund() reset bien la balance
        }
        
        @Test (expected=IllegalArgumentException.class)
        //S9 : on ne peut pas insérer un montant négatif
        public void noNegatifInsert() {
            machine.insertMoney(-5);
        }
        
        @Test (expected=IllegalArgumentException.class)
        //S10 : on ne peut pas créer de machine qui délivre des tickets dont le prix est négatif
        public void noNegativePricePrint() {
            TicketMachine newMachine = new TicketMachine(-5);
        }
}
