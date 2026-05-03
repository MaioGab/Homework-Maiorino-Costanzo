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

    // comando "vai" riconosciuto correttamente
    @Test
    public void testComandoVaiNome() {
        Comando comando = fabbrica.costruisciComando("vai");

        assertEquals("vai", comando.getNome());
        assertNull(comando.getParametro());
    }

    // comando con parametro
    @Test
    public void testComandoVaiConParametro() {
        Comando comando = fabbrica.costruisciComando("vai nord");

        assertEquals("vai", comando.getNome());
        assertEquals("nord", comando.getParametro());
    }

    // comando non valido
    @Test
    public void testComandoNonValido() {
        Comando comando = fabbrica.costruisciComando("vola");

        assertEquals("non valido", comando.getNome());
        assertNull(comando.getParametro());
    }
}