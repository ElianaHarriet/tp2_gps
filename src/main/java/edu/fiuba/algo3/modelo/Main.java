package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;

import java.util.HashMap;

public class Main {
    private Mapa mapa;
    private Jugador jugador;
    private final int tamMapa = 15;

    private HashMap<String, Integer> puntajes;

    public Main() {
        mapa = new Mapa(tamMapa);
        //pedir por interfaz el nick
        String nick = "manolo";
        //pedir por interfaz el auto
        jugador = new Jugador(mapa.posicionInicio(), nick, /*lo que quiera el jugador*/);

        while (!jugador.estaEnDestino()) {  //varios jugadores
            //pedir where se va a mover
            /* moverse */
            /* ver que moverse no explote */
        }

        int movimientos = jugador.getMovimientos();
        puntajes.put(nick, movimientos);
        /*se guarda en un json -> Para que trascienda de la partida*/  // patron facade
    }
}
