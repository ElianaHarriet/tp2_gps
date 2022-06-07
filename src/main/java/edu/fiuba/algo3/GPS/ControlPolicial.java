package edu.fiuba.algo3.GPS;

public class ControlPolicial extends Obstaculo {

    private final boolean detenido;

    public ControlPolicial(boolean detenido) {
        this.detenido = detenido;
    }

    @Override
    public int penalizar(Vehiculo vehiculo/*, int movimientos*/) {
        return detenido ? 3 : 0; // Operador ternario -> hacer un refactor asi no se usa un if
    }
}
