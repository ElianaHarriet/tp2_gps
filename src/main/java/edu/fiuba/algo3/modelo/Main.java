package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Constructor.*;

import java.util.HashMap;

public class Main {

    private Jugador jugador;

    private final int tamMapa = 15;

    private HashMap<String, Integer> puntajes;

    public Main() {
        ConstructorJuego constructor = new ConstructorJuego();
        //pedir por interfaz el nick
        String nick = "manolo";
        //pedir por interfaz el auto
        String vehiculo = "fitito";
        constructor.crearJuego(tamMapa, nick, vehiculo);
        jugador = constructor.getResultado();

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
