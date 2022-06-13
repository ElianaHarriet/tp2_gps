package edu.fiuba.algo3.modelo;


public class Esquina {

    private final boolean esDestino;
    /*
    Calle adyacenteN;
    Calle adyacenteS;
    Calle adyacenteW;
    Calle adyacenteE;
    */

    public Esquina(boolean esDestino) {
        this.esDestino = esDestino;
    }

    public boolean esDestino() {
        return this.esDestino;
    }
}

