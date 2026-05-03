package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{
	private String nomeAttrezzo;
	private IOConsole io;
	private final static String nome = "posa";
	
	public ComandoPosa() {
	   }
	
	public ComandoPosa(String nomeAttrezzo) {
		   this.nomeAttrezzo = nomeAttrezzo;
		}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			io.mostraMessaggio(nomeAttrezzo);
		     return;
		     }
		Borsa borsa = partita.getGiocatore().getBorsa();
	    Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
	    
	    if(attrezzo==null) {
	    	io.mostraMessaggio("Non hai questo attrezzo\n");
	    	return;
	    }
	    
	    boolean aggiunto = partita.getStanzaCorrente().addAttrezzo(attrezzo);

	    if (aggiunto) {
	        borsa.removeAttrezzo(nomeAttrezzo);
	        io.mostraMessaggio("Hai posato: " + attrezzo + "\n");
	    } else {
	    	io.mostraMessaggio("La stanza è piena!\n");
	    }
	}
	
	@Override
	public void setParametro(String parametro) {
	    this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public void setIo(IOConsole io) {
		this.io = io;
		
	}
	
	@Override
	public String getNome() {
		return nome;
	}
}
