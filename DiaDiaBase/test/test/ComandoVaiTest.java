package test;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.generale.IOConsole;
import it.uniroma3.diadia.generale.Partita;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComandoVaiTest {

    private Stanza s1;
    private Stanza s2;
    private Comando vai;
    private Partita p;

    @BeforeEach
    public void setUp() {
        s1 = new Stanza("aula 1");
        s2 = new Stanza("aula 2");
        vai = new ComandoVai();
        p = new Partita();
        vai.setIo(new IOConsole());
    }

    @Test
    public void testVaiNull() {
        p.setStanzaCorrente(s1);
        vai.esegui(p);
        assertEquals(s1, p.getStanzaCorrente());
    }

    @Test
    public void testVaiDirezioneEsistente() {
        p.setStanzaCorrente(s1);
        s1.impostaStanzaAdiacente("sud-ovest", s2);
        vai.setParametro("sud-ovest");
        vai.esegui(p);
        assertEquals(s2, p.getStanzaCorrente());
    }

    @Test
    public void testVaiDirezioneInesistente() {
        p.setStanzaCorrente(s1);
        s1.impostaStanzaAdiacente("sud-ovest", s2);
        vai.setParametro("in fondo a destra");
        vai.esegui(p);
        assertNotEquals(s2, p.getStanzaCorrente());
    }

}
