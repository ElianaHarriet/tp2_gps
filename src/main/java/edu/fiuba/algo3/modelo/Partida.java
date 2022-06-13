package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

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
