package test;
import it.uniroma3.diadia.ambienti.StanzaBuia;

import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StanzaBuiaTest {
	private StanzaBuia cantina;
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	@BeforeEach
	void setup() {
		cantina = new StanzaBuia("cantina", "lanterna");
	}
	
	@Test
	void testStanzaBuiaVuota() {
		// Ritorna VERO se e solo se non c'è l'elemento nella stanza 
		assertFalse(cantina.hasAttrezzo("lanterna"));
	}
	
	@Test
	void testOggettoPresente() {
		// Genero la lanterna da mettere nella stanza
		lanterna = new Attrezzo("lanterna", 1);
		// Inserisco la lanterna nella stanza 
		cantina.addAttrezzo(lanterna);
		// Ritorna VERO se e solo se c'è l'elemento nella stanza 
		assertTrue(cantina.hasAttrezzo("lanterna"));
	}
	
	@Test
	void testOggettoSbagliato() {
		// Genero un attrezzo per non controllare una stanza vuota
		osso = new Attrezzo("osso", 1);
		// Inserisco l'osso dentro la stanza 
		cantina.addAttrezzo(osso);
		//
		assertEquals("Qui c'è un buio pesto\n", cantina.getDescrizione());
	}
}
