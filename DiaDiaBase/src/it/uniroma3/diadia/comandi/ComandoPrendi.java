package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private IOConsole io;
	
	public ComandoPrendi(String nomeAttrezzo) {
		   this.nomeAttrezzo = nomeAttrezzo;
		}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio("Cosa vuoi prendere?\n");
		     return;
		     }
		Stanza stanzaCorrente = partita.getStanzaCorrente();
	    Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	io.mostraMessaggio("Attrezzo non presente nella stanza\n");
	    	return;
	    }
	    
	    boolean aggiunto= partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	    
	    if(aggiunto) {
	    	stanzaCorrente.removeAttrezzo(attrezzo);
	    	io.mostraMessaggio("Hai preso: " + attrezzo + "\n");
	    }
	    else {
	    	io.mostraMessaggio("Borsa piena!\n");
	    }
	}
	
	
	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo=parametro;
	}
	
	
	@Override
	public void setIo(IOConsole io) {
	       this.io = io;
	}
}
