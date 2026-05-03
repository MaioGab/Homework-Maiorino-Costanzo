package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IO;
import it.uniroma3.diadia.generale.Partita;

public class ComandoGuarda implements Comando{
	private IO io;
	private final static String nome = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		io.mostraMessaggio(partita.getStanzaCorrente().getDescrizione()+ "\n");
		io.mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU\n");
		io.mostraMessaggio(partita.getGiocatore().getBorsa().toString()+ "\n");
	}
	
	@Override
	public void setParametro(String parametro) {
	    // non serve per questo comando
	}
	
	@Override
	public String getParametro() {
		return null;  // non ci sono parametri
	}

	@Override
	public void setIo(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return nome;
	}
}
