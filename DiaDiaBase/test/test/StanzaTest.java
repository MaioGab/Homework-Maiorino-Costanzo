package test; // SEMPRE IL PACKAGE ALL'INIZIO
				// Dichiara che questa classe appartiene a un gruppo chiamato "gioco"

// Queste importazioni invece avvisano Java che utilizzerai strumenti provenienti da
// librerie esterne come appunto JUnit 5

import static org.junit.jupiter.api.Assertions.*; 
// * = importa tutti i metodi Assertions

import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 	
// Queste ultime due servono per le annotazioni che 
// spiegano a JUnit 5 come comportarsi

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class StanzaTest { // In JUnit 5 la classe non deve essere necessariamente "PUBLIC"
	
	// Ora creiamo la struttura principale del test nei metodi richiesti
	private Stanza stanzaIsolata;
	private Stanza stanzaConUnaUscita;
	private Stanza stanzaAdiacente;
	private Attrezzo spada;
	// Le scriviamo fuori dai metodi test affinchè tutti possano usare queste stanze
	// Stiamo rappresentando lo scenario di test = FIXTURE
	
	@BeforeEach // In JUnit 4 si chiama solo Before 
				// Dice a JUnit di eseguire questo "setup" prima di ogni test in questo
				// modo tutti partiranno dalla stessa identica situazione 
	void setup() {
		// Creiamo gli oggetti e li colleghiamo tra loro prima di testarli
		this.stanzaIsolata = new Stanza("Stanza Isolata");
		this.stanzaConUnaUscita = new Stanza("Stanza Base");
		this.stanzaAdiacente = new Stanza("Stanza Adiacente Nord");
		// Per la stanza con un'uscita diciamo, al test, la stanza collegata (NORD)
		this.stanzaConUnaUscita.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		this.spada = new Attrezzo("Spada", 10);
	}
	
		// INIZIO TEST PER IMPOSTA STANZA 
	
	// Ora implementiamo il PRIMO TEST di IMPOSTA STANZA
	@Test
	// TEST CHE VERIFICA SE IL COLLEGAMENTO CREATO IN SET UP FUNZIONA CORRETTAMENTE
	void testImpostaStanzaAdiacente_DirezioneEsistente() {
		assertEquals(this.stanzaAdiacente, this.stanzaConUnaUscita.getStanzaAdiacente("nord"));
	// Sta dicendo che il test dà VERO (VERDE) se quando chiedo a StanzaConUnaUscita
	// che stanza c'è a NORD, devo trovarmi StanzaAdiacente, altrimenti mi darà 
	// FALSO (ROSSO)
	}
	
	// Ora implementiamo il SECONDO TEST di IMPOSTA STANZA
	@Test
	// TEST CHE VERIFICA COSA SUCCEDE QUANDO VIENE CHIESTA UNA STANZA INESISTENTE
	void testImpostaStanzaAdiacente_DirezioneInesistente() {
		assertNull(this.stanzaConUnaUscita.getStanzaAdiacente("sud"));
	// Sta dicendo che il test dà VERO (VERO) se, quando cerco StanzaAdiacente in
	// una direzione inesistente di stanzaConUnaUscita, il valore risultante è NULL,
	// altrimenti mi darà FALSO (ROSSO)
	}
	
	// Ora implementiamo il TERZO TEST di IMPOSTA STANZA
	@Test
	// TEST CHE VERIFICA COSA SUCCEDE LA STANZA ADIACENTE AD UNA STANZA SENZA USCITE
	void testImpostaStanzaAdiacente_StanzaIsolata() {
		assertNull(this.stanzaIsolata.getStanzaAdiacente("nord"));
	// Sta dicendo che il test dà VERO (VERDE) se, quando cerco StanzaAdiacente di
	// una StanzaVuota in una qualsiasi direzione il valore risultante è NULL, 
	// altrimenti mi darà FALSO (ROSSO)
	}
	
		// INIZIO TEST PER HAS ATTREZZO
	
	// Ora implementiamo il PRIMO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_Trovato() {
		this.stanzaConUnaUscita.addAttrezzo(spada);
		assertTrue(this.stanzaConUnaUscita.hasAttrezzo("Spada"));
	}
	
	// Ora implementiamo il SECONDO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_Diverso() {
		this.stanzaConUnaUscita.addAttrezzo(spada);
		assertFalse(this.stanzaConUnaUscita.hasAttrezzo("Martello"));
	}

	// Ora implementiamo il TERZO TEST di HAS ATTREZZO
	@Test
	void testHasAttrezzo_NumeroMassimoSuperato() {
	    // Riempio la stanza fino al massimo
	    for (int i = 0; i < 10; i++) {
	        this.stanzaConUnaUscita.addAttrezzo(new Attrezzo("Attrezzo" + i, i));
	    }

	    // Provo ad aggiungere un attrezzo in più
	    boolean risultato = this.stanzaConUnaUscita.addAttrezzo(new Attrezzo("Extra", 5));

	    // Verifico che NON venga aggiunto
	    assertFalse(risultato);

	}
		// INIZIO TEST PER REMOVE ATTREZZO
	
	// Ora implementiamo il PRIMO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_Rimosso() {
		// Aggiungo alla stanza un attrezzo
		this.stanzaConUnaUscita.addAttrezzo(spada);
		// Rimuovo l'oggetto dalla stanza e verifico di averlo eliminato
		assertTrue(this.stanzaConUnaUscita.removeAttrezzo(spada)); // DEVE DARMI TRUE SE LO HA FATTO
		// Controllo se l'oggetto esiste ancora nella stanza
		assertFalse(this.stanzaConUnaUscita.hasAttrezzo("Spada")); // DEVE DARMI FALSE SE LO HA FATTO
	}
	
	// Ora implementiamo il SECONDO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_RimozioneImpossibile() {
		// Creiamo un oggetto senza inserirlo in nessuna stanza
		Attrezzo ascia = new Attrezzo("Ascia", 7);
		// Per far girare meglio il codice inserisco SPADA nella stanza che si vuole testare
		// Questo attrezzo non sarà mai richiesto dal test REMOVE ATTREZZO
		this.stanzaConUnaUscita.addAttrezzo(spada);
		// Verifico che il test mi dia falso se provo a eliminare l'oggetto ascia non presente nella stanza
		assertFalse(this.stanzaConUnaUscita.removeAttrezzo(ascia));
	}
	
	// Ora implementiamo il TERZO TEST di REMOVE ATTREZZO
	@Test
	void testRemoveAttrezzo_MantieneGliAltriAttrezzi() {
		// Creiamo 3 attrezzi  
		Attrezzo attrezzo1 = new Attrezzo("Attrezzo1", 5);
		Attrezzo attrezzo2 = new Attrezzo("Attrezzo2", 5);
		Attrezzo attrezzo3 = new Attrezzo("Attrezzo3", 5);
		// Inseriamoli nella stanza
		this.stanzaConUnaUscita.addAttrezzo(attrezzo1);
		this.stanzaConUnaUscita.addAttrezzo(attrezzo2);
		this.stanzaConUnaUscita.addAttrezzo(attrezzo3);
		// Eliminiamo il secondo
		this.stanzaConUnaUscita.removeAttrezzo(attrezzo2);
		// Controlliamo che gli altri 2 attrezzi ci siano senza problemi interni
		assertTrue(this.stanzaConUnaUscita.hasAttrezzo("Attrezzo1"));
		assertTrue(this.stanzaConUnaUscita.hasAttrezzo("Attrezzo3"));
		// Controlliamo che il secondo invece sia stato effettivamente rimosso
		assertFalse(this.stanzaConUnaUscita.hasAttrezzo("Attrezzo2"));
	}
	 
}