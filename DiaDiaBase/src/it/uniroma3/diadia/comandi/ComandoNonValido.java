package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;

public class ComandoNonValido implements Comando {
	private IOConsole io;

    @Override
    public void esegui(Partita partita) {
    	io.mostraMessaggio("Comando non valido!");
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