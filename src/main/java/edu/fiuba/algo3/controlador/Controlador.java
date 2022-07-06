package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Constructor.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.vista.Ranking;


public class Controlador {

	int cantCuadras;
	Jugador jugador;
	Esquina[][] mapa;
	RankingManager rankingManager;
	IVista observador;
	public Controlador(RankingManager rankingManager){
		cantCuadras = 10;
		this.rankingManager = rankingManager;

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
			observador.terminarJuego();
		}
	}

	public Esquina[][] getMapa() {
		return this.mapa;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public int getMovimientosJugador(){
		return this.jugador.getMovimientos();
	}

	public String getNick(){
		return jugador.getNick();
	}
}