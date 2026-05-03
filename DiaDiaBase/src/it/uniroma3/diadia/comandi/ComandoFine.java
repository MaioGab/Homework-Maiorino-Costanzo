package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;

public class ComandoFine implements Comando{
	private IOConsole io;
	private final static String nome = "fine";
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
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