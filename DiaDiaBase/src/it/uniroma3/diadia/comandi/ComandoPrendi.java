package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	
	public ComandoPrendi(String nomeAttrezzo) {
		   this.nomeAttrezzo = nomeAttrezzo;
		}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			System.out.println("Cosa vuoi prendere?\n");
		     return;
		     }
		Stanza stanzaCorrente = partita.getStanzaCorrente();
	    Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	System.out.println("Attrezzo non presente nella stanza\n");
	    	return;
	    }
	    
	    boolean aggiunto= partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
	    
	    if(aggiunto) {
	    	stanzaCorrente.removeAttrezzo(attrezzo);
	    	System.out.println("Hai preso: " + attrezzo + "\n");
	    }
	    else {
	    	System.out.println("Borsa piena!\n");
	    }
	}
	
	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo=parametro;
	}
}
