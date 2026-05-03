package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;

public class ComandoFine implements Comando{
	private IOConsole io;
	
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
	public void setIo(IOConsole io) {
	    this.io = io;
	}
}