package edu.fiuba.algo3.GPS;

import edu.fiuba.algo3.GPS.Jugador.Esquina;
import edu.fiuba.algo3.GPS.Jugador.Jugador;

public class Partida {

    Jugador jugador;

    public Partida () {
        this.jugador = new Jugador(new Esquina(false), null);
    }

    public int cantMovimientos() {
        return this.jugador.cantMovimientos();
    }

    public boolean terminada() {

        return jugador.estaEnDestino();
    }
}
