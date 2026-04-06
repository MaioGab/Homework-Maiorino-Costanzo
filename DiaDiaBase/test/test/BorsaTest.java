package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.jupiter.api.BeforeEach;
class BorsaTest {

	private Borsa borsa;
	private Attrezzo martello;
	
	@BeforeEach
	void setup() {
		// Creo una borsa e un attrezzo disponibili per l'utilizzo di ogni singolo test
		this.borsa= new Borsa();
		this.martello = new Attrezzo("Martello", 5);
	}
	
		// INIZIO TEST PER ADD ATTREZZO
	
	// Implementiamo ora il PRIMO TEST di ADD ATTREZZO
	@Test
	void addAttrezzo_PesoMaxSuperato() {
		Attrezzo martello= new Attrezzo("martello", 12);
		assertFalse(this.borsa.addAttrezzo(martello));
	}
	
	// Implementiamo ora il SECONDO TEST di ADD ATTREZZO
	@Test
	void addAttrezzo_NumeroAttrezziNonMassimo() {
		Attrezzo spada= new Attrezzo("spada", 8);
		assertTrue(this.borsa.addAttrezzo(spada));
	}
	
	// Implementiamo ora il TERZO TEST di ADD ATTREZZO
	@Test
	void addAttrezzo_NumeroAttrezziMassimo() {
		for (int i = 0; i < 10; i++) {
	        this.borsa.addAttrezzo(new Attrezzo("Attrezzo" + i, i));
	    }
		boolean risultato = this.borsa.addAttrezzo(new Attrezzo("Extra", 5));

	    // Verifico che NON venga aggiunto
	    assertFalse(risultato);
	}
	
		// INZIO TEST PER HAS ATTREZZO
	
	// Implementiamo ora il PRIMO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_Trovato() {
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    borsa.addAttrezzo(spada);

	    assertTrue(borsa.hasAttrezzo("Spada"));
	}
	
	// Implementiamo ora il SECONDO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_NonTrovato() {
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    borsa.addAttrezzo(spada);

	    assertFalse(borsa.hasAttrezzo("Martello"));
	}
	
	// Implementiamo ora il TERZO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_BorsaVuota() {
	    Borsa borsa = new Borsa();

	    assertFalse(borsa.hasAttrezzo("Spada"));
	}
	
		// INZIO TEST PER REMOVE ATTREZZO
	
	// Implementiamo ora il PRIMO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_Cancellato() {
		// Aggiungo l'attrezzo all'interno della borsa
		this.borsa.addAttrezzo(martello);
		// Verifico che svolgendo REMOVE ATTREZZO (martello) effettivamente io stia eliminando il martello
		assertEquals(this.martello, this.borsa.removeAttrezzo("Martello"));
		// Verifico che il martello non sia più presente nella borsa
		assertFalse(this.borsa.hasAttrezzo("Martello"));
		// Infine verifico che il peso nella borsa effettivamente sia diminuito
		assertEquals(0, this.borsa.getPeso());
	}
	
	
	// Implementiamo ora il SECONDO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_Inesistente() {
		// Aggiungo il martello dentro la borsa per assicurarci che il test sia posto nelle giuste condizioni
		this.borsa.addAttrezzo(martello);
		// Verifico che rimuovendo lo scalpello dalla borsa il risultato sia null, poiché non esiste
		assertNull(this.borsa.removeAttrezzo("Scalpello"));
	}
	
	
	// Implementiamo ora il TERZO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_MantieneGliAltriAttrezzi() {
		// Creo 3 attrezzi
		Attrezzo sparachiodi = new Attrezzo("Sparachiodi", 1);
		Attrezzo cacciavite = new Attrezzo("Cacciavite", 2);
		// Li metto dentro la borsa
		this.borsa.addAttrezzo(sparachiodi);
		this.borsa.addAttrezzo(cacciavite);
		this.borsa.addAttrezzo(martello);
		// Rimuovo il martello
		this.borsa.removeAttrezzo("Martello");
		// Verifico che gli altri 2 ci siano ancora 
		assertTrue(this.borsa.hasAttrezzo("Sparachiodi"));
		assertTrue(this.borsa.hasAttrezzo("Cacciavite"));
		// Verifico invece che l'attrezzo "Martello" non sia più presente nella borsa
		assertFalse(this.borsa.hasAttrezzo("Martello"));
	}
}
