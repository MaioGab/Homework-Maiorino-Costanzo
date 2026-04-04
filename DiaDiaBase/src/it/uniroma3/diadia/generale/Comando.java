package it.uniroma3.diadia.generale;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;
    private String parametro;
    private IOConsole io;

    public Comando(String istruzione) {

		// prima parola: nome del comando
		
			this.nome = this.io.leggiRiga(); 

		// seconda parola: eventuale parametro
			this.parametro = this.io.leggiRiga();

    }

    public String getNome() {
        return this.nome;
    }

    public String getParametro() {
        return this.parametro;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}