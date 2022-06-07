package edu.fiuba.algo3.GPS;

import java.util.HashMap;

public class Obstaculo {

    final HashMap<String, Integer> vehiculos;

    public Obstaculo() {
        this.vehiculos = new HashMap<>();
        vehiculos.put(Moto.class.toString(), 0);
        vehiculos.put(Auto.class.toString(), 0);
        vehiculos.put(Camioneta.class.toString(), 0);
    }

    public int penalizar(Vehiculo vehiculo/*, int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }
}