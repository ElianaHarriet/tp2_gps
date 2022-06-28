package edu.fiuba.algo3.modelo.Mapa;

import edu.fiuba.algo3.modelo.Jugador.Jugador;

public class Abajo implements IDireccion {

    public void moverseHacia(Jugador jugador, Esquina esquina) {
        esquina.moverseHacia(jugador, this);
    }
}
