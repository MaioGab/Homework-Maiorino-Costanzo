package test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StanzaBloccataTest {
	private Stanza stanzaAdiacente;
	private Stanza stanzaCorrente;
	
	@BeforeEach
	void setup() {
		stanzaCorrente = new Stanza("Atrio");
		stanzaAdiacente = new Stanza(stanzaAdiacente);
	}
}
