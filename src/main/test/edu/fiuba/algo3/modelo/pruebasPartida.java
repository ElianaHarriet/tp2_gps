package edu.fiuba.algo3.modelo;

import static org.junit.jupiter.api.Assertions.*;



public class pruebasPartida {
    final int FIL = 0;
    final int COL = 1;

    @test
    public void prueba01SeInicializaUnaPartidaDeFormaCorrecta() {
        Partida partida = juego.crearPartida(10, 10);
        assertTrue(partida.cantMovimientos() == 0);
        assertFalse(partida.terminada());
    }

    @test
    public void prueba02SeIniciaEnLaPosicionCorrecta() {
        Partida partida = juego.crearPartida(10, 10);
        assertTrue(partida.posicionActual()[COL].equals('A'));
        assertTrue(0 <= partida.posicionActual()[FIL] <= 9);
    }

    @test
    public void prueba03ElDestinoEstaEnLaPosicionCorrecta() {
        Partida partida = juego.crearPartida(10, 10);
        assertTrue(partida.destino()[COL].equals('J'));
        assertTrue(0 <= partida.destino()[FIL] <= 9);
    }


}
