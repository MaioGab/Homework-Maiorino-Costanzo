package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;


public class ComandoAiuto implements Comando{
	private final static String nome = "aiuto";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda"};
	private IOConsole io;
	
	@Override
	public void esegui(Partita partita) {
	for(int i=0; i< elencoComandi.length; i++) 
		io.mostraMessaggio(null);
	io.mostraMessaggio("\n");
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
	public void setIo(IOConsole io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return nome;
	}
}
