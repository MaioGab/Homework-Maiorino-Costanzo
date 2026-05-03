package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.generale.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica fabbrica;

    @BeforeEach
    public void setUp() {
        fabbrica = new FabbricaDiComandiFisarmonica(new IOConsole());
    }

    // comando valido semplice
    @Test
    public void testComandoVaiRiconosciuto() {
        Comando comando = fabbrica.costruisciComando("vai");

        assertNotNull(comando);
    }

    // comando valido con parametro
    @Test
    public void testComandoConParametro() {
        Comando comando = fabbrica.costruisciComando("vai nord");

        assertNotNull(comando);
    }

    // comando non valido
    @Test
    public void testComandoNonValido() {
        Comando comando = fabbrica.costruisciComando("vola");

        assertNotNull(comando);
    }
}