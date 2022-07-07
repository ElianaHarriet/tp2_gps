package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Constructor.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

import java.util.ArrayList;


public class Controlador {

	int cantCuadras = 10;
	private Esquina[][] mapa;
	private RankingManager rankingManager = new RankingManager("src/main/java/edu/fiuba/algo3/modelo/Ranking/ranking.json");
	private ArrayList<Jugador> jugadores;
	//private ConstructorJugador cJugadorActual;
	private int turno;

	private ArrayList<String> nicks = new ArrayList<>();
	private ArrayList<String> vehiculos = new ArrayList<>();
	int cantJugadores = 0;
	public Controlador() {

	}

	public void agregarJugador(String nick, String vehiculo) {
		this.nicks.add(nick);
		this.vehiculos.add(vehiculo);
		this.cantJugadores++;
	}

	public void iniciarPartida(){
		iniciarPartidaCon(this.nicks, this.vehiculos, this.cantJugadores);
	}
	//public void iniciarPartidaCon(ArrayList<String> nicks, String[] vehiculos, int cantidadDeJugadores ) {
	public void iniciarPartidaCon(ArrayList<String> nicks, ArrayList<String> vehiculos, int cantJugadores ) {
		this.turno = 0;
		this.cantJugadores = cantJugadores;
		ConstructorJuego cons = new ConstructorJuego();
		ConstructorVehiculo cVehiculo = new ConstructorVehiculo();

		ArrayList<IVehiculo> vehiculosJugadores = new ArrayList<>();

		for (int i = 0; i < cantJugadores; i++) {
			cVehiculo.crearVehiculo(vehiculos.get(i));
			vehiculosJugadores.add(cVehiculo.getResultado());
		}

		cons.crearJuego(this.cantCuadras, nicks, vehiculosJugadores, cantJugadores);
		this.jugadores = cons.getResultado();
		this.mapa = cons.getTablero();
	}

	public Jugador getJugadorActual(){
		return this.jugadores.get(this.turno);
	}


	private void pasarTurno(){
		this.turno = (this.turno+1)%cantJugadores;
	}

	public void moverJugadorHacia(IDireccion direccion) {
		getJugadorActual().moverseHacia(direccion);
		if (getJugadorActual().estaEnDestino()) {
			rankingManager.guardarNuevaPuntuacion(getJugadorActual().getNick(), getJugadorActual().getMovimientos());
		}
		pasarTurno();
	}


	public Esquina[][] getMapa() {
		return this.mapa;
	}

	public boolean terminoElJuego(){
		return getJugadorActual().estaEnDestino();
	}

	public ArrayList<Jugador> getJugadores() {
		return this.jugadores;
	}

	public int getMovimientosJugador(){
		return this.getJugadorActual().getMovimientos();
	}

	public String getRanking(){
		return this.rankingManager.obtenerRanking();
	}

	public String getNick(){
		return getJugadorActual().getNick();
	}

}
