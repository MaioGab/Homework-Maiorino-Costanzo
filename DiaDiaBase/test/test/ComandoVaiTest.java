package test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.giocatore.Giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoVaiTest {
	private Partita partita;
	private Stanza stanzaAdiacente;
	private Stanza stanzaCorrente;
	
	@BeforeEach
	void setup() {
		this.stanzaCorrente = new Stanza("Stanza Corrente");
		this.stanzaAdiacente = new Stanza("Stanza Adiacente Nord");
		this.stanzaCorrente.impostaStanzaAdiacente("nord", this.stanzaAdiacente);
		this.partita = new Partita();
		this.partita.setStanzaCorrente(this.stanzaCorrente);
	}
	
	@Test
	void ComandoVaiDirezioneNulla() {
		this.comando = new ComandoVai(null);
		this.comando.esegui(this.partita); 
		
	}
	
	@Test
	void ComandoVaiDirezioneInesistente() {
		
	}
	

	@Test
	void ComandoVaiRiuscito() {
		
	}
}
