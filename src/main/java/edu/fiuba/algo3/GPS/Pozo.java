package edu.fiuba.algo3.GPS;

import java.util.HashMap;

public class Pozo implements IObstaculo {

    private final HashMap<String, Integer> vehiculos;

    public Pozo() {
        this.vehiculos = new HashMap<>();
        vehiculos.put(Moto.class.toString(), 3);
        vehiculos.put(Auto.class.toString(), 3);
        vehiculos.put(Camioneta.class.toString(), 0);
    }
    public int penalizar(IVehiculo vehiculo/*, int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }
}
