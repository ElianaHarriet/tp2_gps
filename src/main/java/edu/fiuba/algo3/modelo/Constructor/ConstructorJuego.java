package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.ArrayList;


public class ConstructorJuego implements IConstructor{
	//c = constructor no tenemos ganas de escribir
    private ConstructorJugador cJugador;
    private ArrayList<ConstructorJugador> cJugadores;


    private ConstructorTablero cTablero;

    public ConstructorJuego() {
        //hacer en estas clases un error para cuando se pide el elemento antes de que se crees
        //cuando funcione borrar todo lo que sea cJugador, no queremos 1 solo
        this.cJugador = new ConstructorJugador();

        /*this.cJugadores = new ArrayList<>();
        for (int i = 0; i < cantJugadores; i++) {
            cJugadores.add(new ConstructorJugador());
        }*/

        this.cTablero = new ConstructorTablero();
    }

    public void crearJuego(int tam, String nick, IVehiculo vehiculo) {
        this.cTablero.crearConTamanio(tam);

       /* for (ConstructorJugador jugador: cJugadores) {
            jugador.crearConNick();

        }*/

        this.cJugador.crearConNick(nick, cTablero.getResultado(), vehiculo);
    }
    public Jugador getResultado() {
        return this.cJugador.getResultado();
    }

    public Esquina[][] getTablero() {
        return this.cTablero.getMapa();
    }
}
