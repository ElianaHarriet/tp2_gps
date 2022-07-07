package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Jugador.Jugador;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.ArrayList;


public class ConstructorJuego implements IConstructor{

    private ConstructorJugador cJugador;
    //private ArrayList<ConstructorJugador> cJugadores;
    private ArrayList<Jugador> jugadores;

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

    public void crearJuego(int tam, ArrayList<String> nicks, ArrayList<IVehiculo> vehiculos, int cantJugadores) {
        this.cTablero.crearConTamanio(tam);



        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (int i = 0; i < cantJugadores; i++){
            Esquina esquina = cTablero.getResultado();
            IVehiculo vehiculo =  vehiculos.get(i);
            cJugador.crearConNick(nicks.get(i),esquina,vehiculo);
            jugadores.add(cJugador.getResultado());
        }
        this.jugadores = jugadores;
    }

    public ArrayList<Jugador> getResultado() {
        return this.jugadores;
    }

    public Esquina[][] getTablero() {
        return this.cTablero.getMapa();
    }
}
