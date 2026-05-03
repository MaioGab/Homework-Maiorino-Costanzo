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

    // ✅ Test 1: comando valido semplice
    @Test
    public void testComandoVaiRiconosciuto() {
        Comando comando = fabbrica.costruisciComando("vai");

        assertNotNull(comando);
    }

    // ✅ Test 2: comando valido con parametro
    @Test
    public void testComandoConParametro() {
        Comando comando = fabbrica.costruisciComando("vai nord");

        assertNotNull(comando);
    }

    // ✅ Test 3: comando non valido
    @Test
    public void testComandoNonValido() {
        Comando comando = fabbrica.costruisciComando("vola");

        assertNotNull(comando);
    }
}