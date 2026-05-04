package test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StanzaBloccataTest {
	private Stanza stanzaSud;
	private Stanza stanzaAdiacente;
	private StanzaBloccata stanzaBloccata;
	private Attrezzo osso;
	private Attrezzo passepartout;
	
	@BeforeEach
	void setup() {
		stanzaBloccata = new StanzaBloccata("Biblioteca", "nord", "passepartout");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente);
		stanzaBloccata.impostaStanzaAdiacente("sud", stanzaSud);
	}
	
	@Test
	void testMancanzaAttrezzoAdatto() {
		// Genero un elemento da inserire nella stanza bloccata (diverso da passepartout)
		osso = new Attrezzo("osso", 1);
		// Lo inserisco dentro la stanza
		stanzaBloccata.addAttrezzo(osso);
		// La descrizione di StanzaBloccata deve darmi il messaggio richiesto
		assertEquals("Stanza bloccata nella direzione nord, prendi passepartout e posalo nella stanza ", stanzaBloccata.getDescrizione());
	}

	@Test
	void testPresenzaAttrezzoAdatto() {
		// Genero l'oggetto che mi serve per sbloccare la stanza
		passepartout = new Attrezzo("passepartout", 1);
		// Lo inserisco dentro la stanza
		stanzaBloccata.addAttrezzo(passepartout);
		// Verifico che effettivamente la porta sia aperta
		assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testDirezioneSenzaBlocchi() {
		// Verifico che andando verso sud non ho blocchi
		assertEquals(stanzaAdiacente, stanzaBloccata.getStanzaAdiacente("sud"));
	}
}