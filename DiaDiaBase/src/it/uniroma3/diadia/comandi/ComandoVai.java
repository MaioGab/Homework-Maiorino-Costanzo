package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.generale.Partita;
import it.uniroma3.diadia.generale.IOConsole;

public class ComandoVai implements Comando {
   private String direzione;
   private IOConsole io;
   
   public ComandoVai() {
   }

   public ComandoVai(String direzione) {
      this.direzione = direzione;
}

/**
* esecuzione del comando
*/
   @Override
   public void esegui(Partita partita) {

      Stanza stanzaCorrente = partita.getStanzaCorrente();
      Stanza prossimaStanza = null;
      
      if (direzione == null) {
    	  this.io.mostraMessaggio("Dove vuoi andare?\nDevi specificare una direzione");
          return;
      }

      prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

      if (prossimaStanza == null) {
    	  this.io.mostraMessaggio("Direzione inesistente");
          return;
      }

      partita.setStanzaCorrente(prossimaStanza);
      this.io.mostraMessaggio(partita.getStanzaCorrente().getNome());

      partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
   }

   @Override
   public void setParametro(String parametro) {
	  this.direzione=parametro;
   }
   
   @Override
   public void setIo(IOConsole io) {
       this.io = io;
   }
}