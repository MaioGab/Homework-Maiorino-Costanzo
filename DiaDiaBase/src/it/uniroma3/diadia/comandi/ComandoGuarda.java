package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.Partita;

public class ComandoGuarda implements Comando{
	
	@Override
	public void esegui(Partita partita) {
		partita.getStanzaCorrente().getDescrizione();
		if(partita.isFinita())
			System.out.println("Partita in corso");
		else
			System.out.println("Partita terminata");
	}
	
	@Override
	public void setParametro(String parametro) {
	    // non serve per questo comando
	}
}
