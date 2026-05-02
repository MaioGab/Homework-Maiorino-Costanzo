package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.generale.Partita;

public class ComandoNonValido implements Comando {

    @Override
    public void esegui(Partita partita) {
        System.out.println("Comando non valido!");
    }

    @Override
    public void setParametro(String parametro) {
        // non serve per questo comando
    }
}