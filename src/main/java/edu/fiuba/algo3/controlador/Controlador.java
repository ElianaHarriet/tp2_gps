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

	public Controlador() {
	}


	public void iniciarPartidaCon(ArrayList<String> nicks, String[] vehiculos, int cantidadDeJugadores ) {
		this.turno = 0;

		ConstructorJuego cons = new ConstructorJuego();
		ConstructorVehiculo cVehiculo = new ConstructorVehiculo();

		ArrayList<IVehiculo> vehiculosJugadores = new ArrayList<>();

		for (int i = 0; i < cantidadDeJugadores; i++) {
			cVehiculo.crearVehiculo(vehiculos[i]);
			vehiculosJugadores.add(cVehiculo.getResultado());
		}


		cons.crearJuego(this.cantCuadras, nicks, vehiculosJugadores, cantidadDeJugadores);
		this.jugadores = cons.getResultado();
		this.mapa = cons.getTablero();
	}

	public Jugador getJugadorActual(){
		return this.jugadores.get(this.turno);
	}

	public void moverJugadorHacia(IDireccion direccion) {
		getJugadorActual().moverseHacia(direccion);
		if (getJugadorActual().estaEnDestino()) {
			rankingManager.guardarNuevaPuntuacion(getJugadorActual().getNick(), getJugadorActual().getMovimientos());
		}
	}


	public Esquina[][] getMapa() {
		return this.mapa;
	}

	public boolean terminoElJuego(){
		return getJugadorActual().estaEnDestino();
	}

	public Jugador getJugador() {
		return this.getJugadorActual();
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
