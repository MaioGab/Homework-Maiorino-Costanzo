package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	
	public ComandoPosa(String nomeAttrezzo) {
		   this.nomeAttrezzo = nomeAttrezzo;
		}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			System.out.println("Cosa vuoi prendere?\n");
		     return;
		     }
		Borsa borsa = partita.getGiocatore().getBorsa();
	    Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	System.out.println("Non hai questo attrezzo\n");
	    	return;
	    }
	    
	    boolean aggiunto = partita.getStanzaCorrente().addAttrezzo(attrezzo);

	    if (aggiunto) {
	        borsa.removeAttrezzo(nomeAttrezzo);
	        System.out.println("Hai posato: " + attrezzo + "\n");
	    } else {
	    	System.out.println("La stanza è piena!\n");
	    }
	}
	
	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo=parametro;
	}
}
