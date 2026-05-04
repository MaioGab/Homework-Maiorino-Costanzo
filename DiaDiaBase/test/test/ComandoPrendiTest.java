package test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.IO;

import it.uniroma3.diadia.generale.Partita;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ComandoPrendiTest {
	private Attrezzo attrezzo;
	private Comando prendi;
	private Partita p;
	private IO io;

	
	@BeforeEach
	void setup() {
		prendi = new ComandoPrendi("torcia");
		p = new Partita();
		attrezzo = new Attrezzo("torcia", 1);
		io= new IOConsole();
		prendi.setIo(io);
	}


	@Test
	void ComandoPrendiNonPosseduto() {
		// Eseguo il comando
		prendi.esegui(p);
		// La borsa DEVE restare VUOTA, aggiungendo un attrezzo non presente nella stanza
		assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
	}


	@Test
	void ComandoPrendiConSuccesso() {
        // Aggiungo l'oggetto alla stanza
        p.getStanzaCorrente().addAttrezzo(attrezzo);       

        // Eseguo il comando
        prendi.esegui(p);     

        // Verifiche:
        // L'oggetto DEVE essere nella nella borsa
        assertTrue(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
        // L'oggetto NON DEVE più essere nella stanza
        assertFalse(p.getStanzaCorrente().hasAttrezzo("torcia"));
	}

	@Test
	void ComandoPrendiStanzaPiena() {
        p.getStanzaCorrente().addAttrezzo(attrezzo);
        
        // Riempio la borsa fittiziamente fino al suo limite massimo
        // (Assumo che la borsa tenga al massimo 10 oggetti)
        for (int i = 0; i < 10; i++) {
        	p.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("zavorra" + 1, 1));
        }
        // Eseguo il comando
        prendi.esegui(p);
        
        // Verifiche:
        // L'oggetto NON DEVE essere stato aggiunto alla borsa
        assertFalse(p.getGiocatore().getBorsa().hasAttrezzo("torcia"));
        // L'oggetto DEVE essere rimasto nella stanza corrente
        assertTrue(p.getStanzaCorrente().hasAttrezzo("torcia"));
	}
}
