package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ControlPolicial implements IObstaculo {

    private final Detencion detencion;

    public ControlPolicial(Detencion detencion) {
        this.detencion = detencion;
    }

    public int penalizar(Auto auto) {
        return this.detencion.penalizar(auto);
    }

    public int penalizar(Moto moto) {
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
        return this.detencion.penalizar(camioneta); //Ver de eliminar el codigo repetido
    }
}
