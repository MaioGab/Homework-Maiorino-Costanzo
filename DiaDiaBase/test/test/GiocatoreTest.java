package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

class GiocatoreTest {
	private Giocatore giocatore;
	
	@BeforeEach
	void setup() {
		this.giocatore = new Giocatore();
	}
		// INIZIO TEST DI GET CFU
	
	// Implementiamo il PRIMO TEST di GET CFU
	@Test
	void testGetCfu_CfuIniziali() {
		giocatore.setCfu(10);
		assertEquals(10, giocatore.getCfu());
		// Verifico che vengano letti il numero di CFU positivi corretti
	}

	// Implementiamo il SECONDO TEST di GET CFU
		@Test
		void testGetCfu_CfuNulli() {
			giocatore.setCfu(0);
			assertEquals(0, giocatore.getCfu());
			// Verifico che vengano letti il numero di CFU nulli corretti
		}
	
	// Implementiamo il TERZO TEST di GET CFU
		@Test
		void testGetCfu_CfuNegativi() {
			giocatore.setCfu(-5);
			assertEquals(-5, giocatore.getCfu());
			// Verifico che vengano letti il numero di CFU negativi corretti
		}
	
		// INIZIO TEST DI GET BORSA
		
	// Implementiamo il PRIMO TEST di GET BORSA 
		@Test
		void testGetBorsa_Vuota() {
			assertTrue(giocatore.getBorsa().isEmpty());
			// Verifichiamo che una volta creato il giocatore la borsa sia effettivamente vuota
		}
		
	// Implementiamo il SECONDO TEST di GET BORSA
		@Test
		void testGetBorsa_AggiuntoCorrettamente() {
			Attrezzo spada = new Attrezzo("Spada", 5);
			giocatore.getBorsa().addAttrezzo(spada);
			assertEquals(spada, giocatore.getBorsa().getAttrezzo("Spada"));
			// Verifichiamo se il ponte tra Giocatore e Borsa è corretto
			// Quindi se aggiungo un attrezzo in borsa e lo richiamo deve essere UGUALE
		}
	
	// Implementiamo il TERZO TEST di GET BORSA
		@Test
		void testGetBorsa_CapacitàMassima() {
			Attrezzo incudine = new Attrezzo("Incudine", 80);
			assertFalse(giocatore.getBorsa().addAttrezzo(incudine));
			// Verifichiamo che se viene messo un elemento troppo pesante il test restituisca false
		}
		
		
		
		
		
		
		
		
		
}
