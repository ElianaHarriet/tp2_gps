package edu.fiuba.algo3.GPS;

import java.util.HashMap;

public class Piquete extends Obstaculo {

    public Piquete() {
        vehiculos.put(Moto.class.toString(), 2);
    }

    public int penalizar(Vehiculo vehiculo/*, int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }
}
