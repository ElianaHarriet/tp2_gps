package edu.fiuba.algo3.GPS;

import edu.fiuba.algo3.GPS.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PruebasPartida {

    @Test
    public void prueba01SeInicializaUnaPartidaDeFormaCorrecta() {
        Partida partida = new Partida(10, 10);
        assertEquals(0, partida.cantMovimientos());
        assertFalse(partida.terminada());
    }

    @Test
    public void prueba02SeIniciaEnLaPosicionCorrecta() {
        Partida partida = new Partida(10, 10);
        //assertEquals(partida.posicionActual().columna, 'A');
        //assertTrue(0 <= partida.posicionActual().fila <= 9);
    }

    @Test
    public void prueba03ElDestinoEstaEnLaPosicionCorrecta() {
        Partida partida = new Partida(10, 10);
        //assertEquals(partida.destino().columna, 'J');
        //assertTrue(0 <= partida.destino().fila <= 9);
    }


}
