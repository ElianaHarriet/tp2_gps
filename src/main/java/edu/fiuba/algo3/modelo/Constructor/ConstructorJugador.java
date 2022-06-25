package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class ConstructorJugador implements IConstructor{
    Jugador jugador;
    public ConstructorJugador() {

    }

    public void crearConNick(String nick, Esquina esquinaInicial, IVehiculo vehiculo) {
        this.jugador = new Jugador(esquinaInicial, nick, vehiculo);
    }

    @Override
    public Jugador getResultado() {
        return this.jugador;
    }
}
