package edu.fiuba.algo3.modelo.Jugador;


import edu.fiuba.algo3.modelo.Jugador.Calle;

public class Esquina {

    private final boolean esDestino;

    private Calle adyacenteN;
    private Calle adyacenteS;
    private Calle adyacenteW;
    private Calle adyacenteE;

    public Esquina(boolean esDestino) {
        this.esDestino = esDestino;
        this.adyacenteN = null;
        this.adyacenteS = null;
        this.adyacenteW = null;
        this.adyacenteE = null;
    }

    public void setAdyacentes(Calle adyacenteN, Calle adyacenteS, Calle adyacenteW, Calle adyacenteE) {
        this.adyacenteN = adyacenteN;
        this.adyacenteS = adyacenteS;
        this.adyacenteW = adyacenteW;
        this.adyacenteE = adyacenteE;
    }
    public boolean esDestino() {
        return this.esDestino;
    }

    public void moverseArriba(Jugador jugador) {
        this.adyacenteN.moverse(this, jugador);
    }

    public void moverseAbajo(Jugador jugador) {
        this.adyacenteS.moverse(this, jugador);
    }

    public void moverseIzquierda(Jugador jugador) {
        this.adyacenteW.moverse(this, jugador);
    }

    public void moverseDerecha(Jugador jugador) {
        this.adyacenteE.moverse(this, jugador);
    }
}

