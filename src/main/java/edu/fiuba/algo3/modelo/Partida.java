package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.*;

public class Partida {

    Jugador jugador;

    public Partida () {
        this.jugador = new Jugador(new EsquinaNormie(0, 0), null, null);
    }

    public boolean terminada() {

        return jugador.estaEnDestino();
    }
}
