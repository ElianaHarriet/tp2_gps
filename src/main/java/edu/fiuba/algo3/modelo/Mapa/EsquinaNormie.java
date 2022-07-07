package edu.fiuba.algo3.modelo.Mapa;

public class EsquinaNormie extends Esquina {

    public EsquinaNormie(int posX, int posY) {
        super(posX, posY);
    }

    public boolean esDestino() {
        return false;
    }
}
