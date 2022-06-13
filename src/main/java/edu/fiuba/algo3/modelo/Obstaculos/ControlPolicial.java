package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ControlPolicial implements IObstaculo {

    private final int detenido;

    public ControlPolicial(int detenido) {
        this.detenido = detenido;
    }

    public int penalizar(Auto auto) {
        return 3 * detenido;
    }

    public int penalizar(Moto moto) {
        return 3 * detenido;
    }

    public int penalizar(Camioneta camioneta) {
        return 3 * detenido;
    }

    public int return1SiEsPozo() {
        return 0;
    }
}
