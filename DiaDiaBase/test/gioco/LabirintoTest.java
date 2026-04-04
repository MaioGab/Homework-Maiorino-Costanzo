package gioco;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {
	private Labirinto labirinto;
	
	@BeforeEach
	void setup() {
		this.labirinto = new Labirinto(); // Unico set up necessario in ogni test
	}
	
	// INIZIO TEST SU GET STANZA INIZIALE 
	
	// Implementiamo il PRIMO TEST di GET STANZA INIZIALE
	@Test
	void testGetStanzaIniziale_Sbagliato() {
		assertNotEquals("Biblioteca", labirinto.getStanzaIniziale().getNome()); 
		// Verifico che se metto come stanza iniziale BIBLIOTECA il test mi dà FALSO
	}
	
	// Implementiamo il SECONDO TEST di GET STANZA INIZIALE
	@Test
	void testGetStanzaIniziale_Corretto() {
		assertEquals("Atrio", labirinto.getStanzaIniziale().getNome());
		// Verifico che se metto come stanza iniziale ATRIO il test mi dà VERO
	}
	
	// Implementiamo il TERZO TEST di GET STANZA INIZIALE
	@Test
	void testGetStanzaIniziale_Esistente() {
		assertNotNull(labirinto.getStanzaIniziale());
		// Verifico se effettivamente esiste la stanza iniziale ed è diversa da NULL
	}
	
	// INIZIO TEST SU GET STANZA FINALE
	
	//Implementiamo il PRIMO TEST di GET STANZA FINALE
	@Test
	void testGetStanzaFinale_Sbagliato() {
		assertNotEquals("Biblioteca", labirinto.getStanzaFinale().getNome()); 
		// Verifico che se metto come stanza finale BIBLIOTECA il test mi dà FALSO
	}
	
	// Implementiamo il SECONDO TEST di GET STANZA INIZIALE
	@Test
	void testGetStanzaFinale_Corretto() {
		assertEquals("Atrio", labirinto.getStanzaFinale().getNome());
		// Verifico che se metto come stanza finale ATRIO il test mi dà VERO
	}
	
	// Implementiamo il TERZO TEST di GET STANZA INIZIALE
	@Test
	void testGetStanzaFinale_Esistente() {
		assertNotNull(labirinto.getStanzaFinale());
		// Verifico se effettivamente esiste la stanza finale ed è diversa da NULL
	}
	
	
	
	
}
