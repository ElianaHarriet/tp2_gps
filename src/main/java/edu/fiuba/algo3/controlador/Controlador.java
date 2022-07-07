package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Constructor.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import edu.fiuba.algo3.modelo.Mapa.*;

import java.util.ArrayList;


public class Controlador {

	int cantCuadras = 10;
	private Jugador jugador;
	private Esquina[][] mapa;
	private RankingManager rankingManager = new RankingManager("src/main/java/edu/fiuba/algo3/modelo/Ranking/ranking.json");
	private ArrayList<Jugador> jugadores;
	private ConstructorJugador cJugadorActual;
	public Controlador() {
	}

	public void iniciarPartidaCon(String unNick, String unVehiculo/*, int cantidadDeJugadores*/ ) {

		ConstructorJuego cons = new ConstructorJuego();
		ConstructorVehiculo cVehiculo = new ConstructorVehiculo();
		cVehiculo.crearVehiculo(unVehiculo);

		cons.crearJuego(this.cantCuadras, unNick, cVehiculo.getResultado());
		this.jugador = cons.getResultado();
		this.mapa = cons.getTablero();
	}

	public void moverJugadorHacia(IDireccion direccion) {
		jugador.moverseHacia(direccion);
		if (jugador.estaEnDestino()) {
			rankingManager.guardarNuevaPuntuacion(jugador.getNick(), jugador.getMovimientos());
		}
	}

	public Esquina[][] getMapa() {
		return this.mapa;
	}

	public boolean terminoElJuego(){
		return jugador.estaEnDestino();
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public int getMovimientosJugador(){
		return this.jugador.getMovimientos();
	}

	public String getRanking(){
		return this.rankingManager.obtenerRanking();
	}

	public String getNick(){
		return jugador.getNick();
	}

	public void crearJugador(String nick, String vehiculo) {
		this.cJugadorActual = new ConstructorJugador();
		//this.cJugadorActual.crearConNick();
	}
}