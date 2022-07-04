package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;


public class ConstructorJuego implements IConstructor{
	//c = constructor no tenemos ganas de escribir
    private ConstructorJugador cJugador;

    private ConstructorTablero cTablero;

    public ConstructorJuego() {
        //hacer en estas clases un error para cuando se pide el elemento antes de que se crees
        this.cJugador = new ConstructorJugador();
        this.cTablero = new ConstructorTablero();
    }

    public void crearJuego(int tam, String nick, IVehiculo vehiculo) {


        this.cTablero.crearConTamanio(tam);
        this.cJugador.crearConNick(nick, cTablero.getResultado(), vehiculo);
    }
    public Jugador getResultado() {
        return this.cJugador.getResultado();
    }

    public Esquina[][] getTablero() {
        return this.cTablero.getMapa();
    }
}
