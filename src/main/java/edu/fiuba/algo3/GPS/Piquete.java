package edu.fiuba.algo3.GPS;

import java.util.HashMap;

public class Piquete implements IObstaculo{

    private final HashMap<String, Integer> vehiculos;

    public Piquete() {
        this.vehiculos = new HashMap<>();
        vehiculos.put(Moto.class.toString(), 2);
        vehiculos.put(Auto.class.toString(), 0);
        vehiculos.put(Camioneta.class.toString(), 0);
    }
    public int penalizar(IVehiculo vehiculo/*, int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }
}
