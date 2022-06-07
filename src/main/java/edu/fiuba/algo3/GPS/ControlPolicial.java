package edu.fiuba.algo3.GPS;

import java.util.HashMap;

public class ControlPolicial implements IObstaculo{

    private final boolean detenido;

    public ControlPolicial(boolean detenido) {
        this.detenido = detenido;
    }
    public int penalizar(IVehiculo vehiculo/*, int movimientos*/) {
        return detenido ? 3 : 0; // Operador ternario -> hacer un refactor asi no se usa un if
    }
}
