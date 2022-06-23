package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ControlPolicial implements IObstaculo {

    private Detencion detencion;

    public ControlPolicial(Detencion detencion) { // usado para las pruebas
        this.detencion = detencion;
    }

    public ControlPolicial() { // usado en el juego
    }

    public int penalizar(Auto auto) {
        this.detencion = Detencion.obtenerDetencion(auto);
        return this.detencion.penalizar(auto);
    }

    public int penalizar(Moto moto) {
        this.detencion = Detencion.obtenerDetencion(moto);
        return this.detencion.penalizar(moto); //Ver de eliminar el codigo repetido
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Auto auto) {
        return destino;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Camioneta camioneta) {
        return destino;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Moto moto) {
        return destino;
    }

    public int penalizar(Camioneta camioneta) {
        this.detencion = Detencion.obtenerDetencion(camioneta);
        return this.detencion.penalizar(camioneta); //Ver de eliminar el codigo repetido
    }
}
