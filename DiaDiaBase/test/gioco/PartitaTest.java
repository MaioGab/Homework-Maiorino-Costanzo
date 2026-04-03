package gioco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PartitaTest {
	private Partita partitaFinita;
	private Partita partitaNonFinita;
	
	@BeforeEach
	
	void setup() {
		this.partitaFinita = new Partita(); // Creiamo una partita
		partitaFinita.setStanzaCorrente(partitaFinita.getLabirinto().getStanzaFinale());
		// Faccio arrivare la stanza corrente alla stanza finale 
		partitaFinita.getGiocatore().setCfu(5);
		
		this.partitaNonFinita = new Partita(); // Creiamo una partita
		partitaNonFinita.setStanzaCorrente(partitaFinita.getLabirinto().getStanzaIniziale());
		// Faccio arrivare la stanza corrente alla stanza finale 
		partitaNonFinita.getGiocatore().setCfu(5);

		
		
	}
	
	// INIZIO TEST PARTITA
	// Implementiamo il primo test per IS FINITA
	@Test
	void testIsFinita_Vinta() { // La partita è finita perchè il giocatore ha vinto
		assertTrue(partitaFinita.isFinita());
	}
	
	@Test
	void testIsFinita_NonFinita() { // La partita non è finita
		
		assertFalse(partitaNonFinita.isFinita());
	}
	
	@Test
	void testIsFinita_CfuEsauriti() { // I cfu non sono =0
		partitaFinita.getGiocatore().setCfu(0);
	    assertTrue(partitaFinita.isFinita());
	}
}
