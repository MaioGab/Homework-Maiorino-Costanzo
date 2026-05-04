package test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoPosaTest {
	private Attrezzo attrezzo;
	private Comando posa;
	private Partita p;
	
	@BeforeEach
	void setup() {
		posa = new ComandoPosa("torcia");
		p = new Partita();
		attrezzo = new Attrezzo("torcia", 1);
		posa.setIo(new IOConsole());
	}
	
	@Test
	void ComandoPosaNonPosseduto() {
		// Eseguo il comando
		posa.esegui(p);
		// La stanza DEVE restare VUOTA, aggiungendo un attrezzo non presente nella borsa
		assertFalse(this.p.getStanzaCorrente().hasAttrezzo("torcia"));
	}

	@Test
	void ComandoPosaConSuccesso() {
        // Aggiungo l'oggetto alla borsa del giocatore
        p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        
        // Eseguo il comando
        posa.esegui(p);
        
        // Verifiche:
        // L'oggetto DEVE essere nella stanza
        assertTrue(p.getStanzaCorrente().hasAttrezzo("osso"));
        // L'oggetto NON DEVE più essere nella borsa
        assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

	@Test
	void ComandoPosaStanzaPiena() {
        p.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        
        // Riempio la stanza fittiziamente fino al suo limite massimo
        // (Assumo che la stanza tenga al massimo 10 oggetti)
        for (int i = 0; i < 10; i++) {
            p.getStanzaCorrente().addAttrezzo(new Attrezzo("zavorra" + i, 1));
        }
        
        // Eseguo il comando
        posa.esegui(p);

        // Verifiche:
        // L'oggetto NON DEVE essere stato aggiunto alla stanza
        assertFalse(p.getStanzaCorrente().hasAttrezzo("torcia"));
        // L'oggetto DEVE essere rimasto nella borsa del giocatore
        assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
	}
}