package edu.fiuba.algo3.GPS.Obstaculos;

import edu.fiuba.algo3.GPS.Vehiculos.*;


public class ControlPolicial implements IObstaculo {

    private final boolean detenido;

    public ControlPolicial(boolean detenido) {
        this.detenido = detenido;
    }

    public int penalizar(Auto auto) {
        return detenido ? 3 : 0; // Refactorizar para no usar un if
    }

    public int penalizar(Moto moto) {
        return detenido ? 3 : 0; // Refactorizar para no usar un if
    }

    public int penalizar(Camioneta camioneta) {
        return detenido ? 3 : 0; // Refactorizar para no usar un if
    }

    public int return1SiEsPozo() {
        return 0;
    }
}
