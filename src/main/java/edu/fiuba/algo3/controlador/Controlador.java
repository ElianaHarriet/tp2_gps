package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Constructor.*;
import edu.fiuba.algo3.modelo.Jugador.*;
import edu.fiuba.algo3.modelo.Obstaculos.ControlPolicial;
import edu.fiuba.algo3.modelo.Obstaculos.ObstaculoNulo;
import edu.fiuba.algo3.modelo.Obstaculos.Piquete;
import edu.fiuba.algo3.modelo.Obstaculos.Pozo;
import edu.fiuba.algo3.modelo.Ranking.RankingManager;
import edu.fiuba.algo3.modelo.Mapa.*;
import edu.fiuba.algo3.modelo.Sorpresas.SorpresaDesfavorable;
import edu.fiuba.algo3.modelo.Sorpresas.SorpresaFavorable;
import edu.fiuba.algo3.modelo.Sorpresas.SorpresaNeutra;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.util.ArrayList;


public class Controlador {

	int cantCuadras = 10;
	private Esquina[][] mapa;
	private RankingManager rankingManager = new RankingManager("src/main/java/edu/fiuba/algo3/modelo/Ranking/ranking.json");
	private ArrayList<Jugador> jugadores;
	//private ConstructorJugador cJugadorActual;
	private int turno;
	static private MediaPlayer mediaPlayer;
	static private MediaPlayer efectosDeSonido;
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
		iniciarPartidaCon(this.nicks, this.vehiculos);
	}

	public void iniciarPartidaCon(ArrayList<String> nicks, ArrayList<String> vehiculos ) {
		this.turno = 0;
		ConstructorJuego cons = new ConstructorJuego();
		ConstructorVehiculo cVehiculo = new ConstructorVehiculo();

		ArrayList<IVehiculo> vehiculosJugadores = new ArrayList<>();

		for (int i = 0; i < nicks.size(); i++) {
			cVehiculo.crearVehiculo(vehiculos.get(i));
			vehiculosJugadores.add(cVehiculo.getResultado());
		}

		cons.crearJuego(this.cantCuadras, nicks, vehiculosJugadores, nicks.size());
		this.jugadores = cons.getResultado();
		this.mapa = cons.getTablero();
	}

	public Jugador getJugadorActual(){
		return this.jugadores.get(this.turno);
	}
	private void pasarTurno(){
		this.turno = (this.turno + 1) % this.jugadores.size();
	}

 private Calle obtenerCalleAtravesada(int xI, int yI, int xF, int yF) {
        if (xI == xF){
	          if (yI == yF){
			return new Calle(this.mapa[xI][yI], this.mapa[xI][yI], new SorpresaNeutra(), new ObstaculoNulo());
          } else if(yI > yF){
				return this.mapa[xF][yF].getSur();
		   } else {
 				return this.mapa[xI][yI].getSur();
		   }

       } else {
       	if (xI < xF) {
       		return this.mapa[xI][yI].getEste();
       	} else {
				return this.mapa[xF][yF].getEste();
       	}
       }

 }


 public Calle moverJugadorHacia(String direccionString) {
    int xI = jugadores.get(turno).getX();
    int yI = jugadores.get(turno).getY();

	IDireccion direccion = obtenerDireccion(direccionString);

    getJugadorActual().moverseHacia(direccion);

    int xF = jugadores.get(turno).getX();
    int yF = jugadores.get(turno).getY();
    if (getJugadorActual().estaEnDestino()) {
       rankingManager.guardarNuevaPuntuacion(getJugadorActual().getNick(), getJugadorActual().getMovimientos());
    }

    Calle resultado =  obtenerCalleAtravesada(xI, yI, xF, yF);
    pasarTurno();
    return resultado;
 }
	public IDireccion obtenerDireccion(String direccion) {
	 	if (direccion.equals("arriba")) {
			 return new Arriba();
		}
		if (direccion.equals("abajo")) {
			return new Abajo();
		}
		if (direccion.equals("derecha")) {
			return new Derecha();
		}
		return new Izquierda();
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

	public void setAudioMediaPlayer(String path){
		String musicFile = path;
		Media sound = new Media(new File(musicFile).toURI().toString());
		if(this.mediaPlayer != null){
			this.mediaPlayer.stop();
		}
		this.mediaPlayer = new MediaPlayer(sound);
		this.mediaPlayer.setAutoPlay(true);
		this.mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
		this.mediaPlayer.setVolume(0.6);
		this.mediaPlayer.play();
	}

	public void reproducirEfectoDeSonido(Calle calleARevisar){
		Class obstaculoCalle = calleARevisar.getObstaculo().getClass();
		Class sorpresaCalle = calleARevisar.getSorpresa().getClass();
		String musicaPath = "";

		/* Si hay sorpresa, optamos por reproducir el sonido de la sorpresa y no
		 * la del obstáculo ya que la imagen de la sorpresa no aclara qué le tocó
		 * al jugador. En caso de no haber sorpresa, reproducimos el sonido del
		 * obstáculo. (Si no hay nada no se reproduce nada)
		 */
		if (!sorpresaCalle.equals(SorpresaNeutra.class)) {
			if (sorpresaCalle.equals(SorpresaFavorable.class)) {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Sorpresas/sorpresaFavorableSound.mp3";
			} else if (sorpresaCalle.equals(SorpresaDesfavorable.class)) {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Sorpresas/sorpresaDesfavorableSound.mp3";
			} else {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Sorpresas/sorpresaCambioDeVehiculoSound.mp3";
			}
		} else {
			if (obstaculoCalle.equals(Piquete.class)) {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Obstaculos/piqueteSound.mp3";
			} else if (obstaculoCalle.equals(Pozo.class)) {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Obstaculos/pozoSound.mp3";
			} else if (obstaculoCalle.equals(ControlPolicial.class)) {
				musicaPath = "src/main/java/edu/fiuba/algo3/Vista/media/audio/Obstaculos/controlPolicialSound.mp3";
			}
		}
		if (musicaPath.length() == 0) return;
		Media sonido = new Media(new File(musicaPath).toURI().toString());
		MediaPlayer reproductorSonido = new MediaPlayer(sonido);
		this.efectosDeSonido = reproductorSonido;
		this.efectosDeSonido.play();
 }

	public void setVolumenMediaPlayer(double volumen){
		if(this.mediaPlayer != null){
			this.mediaPlayer.setVolume(volumen);
		}
	}

	public void resumirMediaPlayer(){
		if(this.mediaPlayer != null){

			this.mediaPlayer.play();
		}
	}

	public void pausarMediaPlayer(){
		if(this.mediaPlayer != null){
			this.mediaPlayer.pause();
		}
	}
}
