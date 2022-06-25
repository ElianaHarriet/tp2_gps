package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ControlPolicial implements IObstaculo {

    private Detencion detencion;

    public ControlPolicial(Detencion detencion) { // usado para las pruebas
        this.detencion = detencion;
    }

    public ControlPolicial() { // usado en el juego
        this.detencion = null;
    }

    public int penalizar(Auto auto) {
        this.detencion = detencion != null ? detencion : Detencion.obtenerDetencion(auto);
        int penalizacion = this.detencion.penalizar(auto);
        this.detencion = null;
        return penalizacion;
    }

    public int penalizar(Moto moto) {
        this.detencion = detencion != null ? detencion : Detencion.obtenerDetencion(moto);
        int penalizacion = this.detencion.penalizar(moto); //Ver de eliminar el codigo repetido
        this.detencion = null;
        return penalizacion;
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
        this.detencion = detencion != null ? detencion : Detencion.obtenerDetencion(camioneta);
        int penalizacion = this.detencion.penalizar(camioneta); //Ver de eliminar el codigo repetido
        this.detencion = null;
        return penalizacion;
    }
}
