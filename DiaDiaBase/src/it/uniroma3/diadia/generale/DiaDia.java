package it.uniroma3.diadia.generale;


import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia() {
		this.partita = new Partita();
	    this.io= new IOConsole();
		
	}

	public void gioca() {
		String istruzione;

		this.io.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		
		do		
			istruzione = this.io.leggiRiga();
		while (!processaIstruzione(istruzione));
		}   

	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire;
		FabbricaDiComandi factory = new FabbricaDiComandi()
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())

		System.out.println("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())

		System.out.println("Hai esaurito i CFU...");

		return this.partita.isFinita();
		}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			this.io.mostraMessaggio(elencoComandi[i] +" ");
		this.io.mostraMessaggio("\n");
	}
	
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		this.io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	
	/**
	 * Comando "Prendi".
	 */
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			this.io.mostraMessaggio("Cosa vuoi prendere?\n");
		     return;
		     }
		Stanza stanzaCorrente = this.partita.getStanzaCorrente();
	    Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	this.io.mostraMessaggio("Attrezzo non presente nella stanza\n");
	    	return;
	    }
	    
	    boolean aggiunto=this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	    
	    if(aggiunto) {
	    	stanzaCorrente.removeAttrezzo(attrezzo);
	    	this.io.mostraMessaggio("Hai preso: " + attrezzo + "\n");
	    }
	    else {
	    	this.io.mostraMessaggio("Borsa piena!\n");
	    }
	}
	
	
	/**
	 * Comando "Posa".
	 */
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			this.io.mostraMessaggio("Cosa vuoi prendere?\n");
		     return;
		     }
		Borsa borsa = this.partita.getGiocatore().getBorsa();
	    Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	this.io.mostraMessaggio("Non hai questo attrezzo\n");
	    	return;
	    }
	    
	    boolean aggiunto = this.partita.getStanzaCorrente().addAttrezzo(attrezzo);

	    if (aggiunto) {
	        borsa.removeAttrezzo(nomeAttrezzo);
	        this.io.mostraMessaggio("Hai posato: " + attrezzo + "\n");
	    } else {
	    	this.io.mostraMessaggio("La stanza è piena!\n");
	    }
	}
	

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		gioco.gioca();
	}
}