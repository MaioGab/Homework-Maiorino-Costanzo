package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.generale.DiaDia;
import it.uniroma3.diadia.generale.IOSimulator;

class IOSimulatorTest {
	
	@Test
	void testPartitaFinita() {
		
		String comandi[]= {"vai est", "posa lanterna", "fine"};
		
		IOSimulator io= new IOSimulator(comandi);
		DiaDia diadia = new DiaDia(io);
		
		diadia.gioca();
		String output[]= io.getOutput();
		
		boolean trovato = false;
		

		for (int i = 0; i < output.length; i++) {
		    if (output[i] != null && output[i].equals("Grazie di aver giocato!\n")) {
		        trovato = true;
		    }
		}

		assertTrue(trovato);
	}



    @Test
    void testPartitaVinta() {
	
	    String comandi[]= {"vai nord", "prendi osso", "fine"};
	
	    IOSimulator io= new IOSimulator(comandi);
	    DiaDia diadia = new DiaDia(io);
	
	    diadia.gioca();
	    String output[]= io.getOutput();
	
	    boolean trovato = false;
	

	    for (int i = 0; i < output.length; i++) {
	        if (output[i] != null && output[i].equals("Hai vinto!")) {
	            trovato = true;
	        }
	    }

	assertTrue(trovato);
    }
    
    
    @Test
    void testPartitaAncoraInCorso() {
	
	    String comandi[]= {"vai sud", "prendi lanterna", "vai est", "fine"};
	
	    IOSimulator io= new IOSimulator(comandi);
	    DiaDia diadia = new DiaDia(io);
	
	    diadia.gioca();
	    String output[]= io.getOutput();
	
	    boolean trovato = false;
	    					

	    for (int i = 0; i < output.length; i++) {
	        if (output[i] != null && output[i].equals("Hai preso: lanterna (3kg)\n")) {
	            trovato = true;
	        }
	    }

	assertTrue(trovato);
    }

}