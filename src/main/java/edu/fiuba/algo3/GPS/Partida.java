package edu.fiuba.algo3.GPS;

public class Partida {
    Jugador jugador;

    public Partida (int m, int n) {
        this.jugador = new Jugador(new Esquina(false), null);
    }

    public int cantMovimientos(){
        return this.jugador.cantMovimientos();
    }
    public boolean terminada() {

        return jugador.estaEnDestino();
    }
}
