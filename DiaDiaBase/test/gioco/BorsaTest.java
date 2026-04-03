package gioco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
class BorsaTest {

	private Borsa borsa;
	
	@BeforeEach
	void setup() {
		this.borsa= new Borsa();
	}
	
	@Test
	void addAttrezzo_PesoNonMax() {
		Attrezzo martello= new Attrezzo("martello", 12);
		assertFalse(this.borsa.addAttrezzo(martello));
	}
	
	
	@Test
	void addAttrezzo_NUmeroAttrezziNonMassimo() {
		Attrezzo spada= new Attrezzo("spada", 8);
		assertTrue(this.borsa.addAttrezzo(spada));
	}
	
	@Test
	void addAttrezzo_NUmeroAttrezziMassimo() {
		for (int i = 0; i < 10; i++) {
	        this.borsa.addAttrezzo(new Attrezzo("Attrezzo" + i, i));
	    }
		boolean risultato = this.borsa.addAttrezzo(new Attrezzo("Extra", 5));

	    // Verifico che NON venga aggiunto
	    assertFalse(risultato);
	}
	
	@Test
	void testHasAttrezzo_Trovato() {
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    borsa.addAttrezzo(spada);

	    assertTrue(borsa.hasAttrezzo("Spada"));
	}
	
	@Test
	void testHasAttrezzo_NonTrovato() {
	    Attrezzo spada = new Attrezzo("Spada", 5);
	    borsa.addAttrezzo(spada);

	    assertFalse(borsa.hasAttrezzo("Martello"));
	}
	
	@Test
	void testHasAttrezzo_BorsaVuota() {
	    Borsa borsa = new Borsa();

	    assertFalse(borsa.hasAttrezzo("Spada"));
	}
}
