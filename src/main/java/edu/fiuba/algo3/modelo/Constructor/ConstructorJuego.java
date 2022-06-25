package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;


public class ConstructorJuego implements IConstructor{
	//c = constructor no tenemos ganas de escribir
    private ConstructorJugador cJugador;

    private ConstructorTablero cTablero;

    private ConstructorVehiculo cVehiculo;

    public ConstructorJuego() {
        //hacer en estas clases un error para cuando se pide el elemento antes de que se crees
        this.cJugador = new ConstructorJugador();
        this.cTablero = new ConstructorTablero();
        this.cVehiculo = new ConstructorVehiculo();
    }

    public void crearJuego(int n, String nick, String vehiculo) {
        /*
        * si quieren sacar el switch/hash de crearVehiculo, pasennos directamente el vehiculo
        * saquen cvehiculo.crear... y cambien c.vehiculo.get por vehiculo
        * */
        this.cTablero.crearConTamanio(n);
        this.cJugador.crearConNick(nick, cTablero.getResultado(), new Auto());//cVehiculo.getResultado());
        this.cVehiculo.crearVehiculo(vehiculo);
    }
    public Jugador getResultado() {
        return this.cJugador.getResultado();
    }

}
