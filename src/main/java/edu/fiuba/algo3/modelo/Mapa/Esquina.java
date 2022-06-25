package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.TeFaltaCalleError;
import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Calle;

public abstract class Esquina { //dividir esquina normal de esquina destino

    private Calle adyacenteN;
    private Calle adyacenteS;
    private Calle adyacenteW;
    private Calle adyacenteE;

    public Esquina() {
        this.adyacenteN = null;
        this.adyacenteS = null;
        this.adyacenteW = null;
        this.adyacenteE = null;
    }

    public void setAdySuperior(Calle adyacente) {
        this.adyacenteN = adyacente;
    }

    public void setAdyInferior(Calle adyacente) {
        this.adyacenteS = adyacente;
    }

    public void setAdyIzquierda(Calle adyacente) {
        this.adyacenteW = adyacente;
    }

    public void setAdyDerecha(Calle adyacente) {
        this.adyacenteE = adyacente;
    }

    public abstract boolean esDestino();


    public void mover(Jugador jugador, Arriba arriba){

    }


    public void moverseHacia(Jugador jugador, Arriba direccion) {
        this.validarMovimiento(this.adyacenteN);
        this.adyacenteN.moverse(this, jugador);
    }

    public void moverseHacia(Jugador jugador, Abajo direccion) {
        this.validarMovimiento(this.adyacenteS);
        this.adyacenteS.moverse(this, jugador);
    }

    public void moverseHacia(Jugador jugador, Izquierda direccion) {
        this.validarMovimiento(this.adyacenteW);
        this.adyacenteW.moverse(this, jugador);
    }

    public void moverseHacia(Jugador jugador, Derecha direccion) {
        this.validarMovimiento(this.adyacenteE);
        this.adyacenteE.moverse(this, jugador);
    }


    public abstract void moverse();


    private void validarMovimiento(Calle calle) {
        if (calle == null) {
            throw new TeFaltaCalleError();
        }
    }
}

