package edu.fiuba.algo3.GPS.Obstaculos;

import edu.fiuba.algo3.GPS.Vehiculos.Auto;
import edu.fiuba.algo3.GPS.Vehiculos.Moto;
import edu.fiuba.algo3.GPS.Vehiculos.Vehiculo;

public class Pozo extends Obstaculo {

    public Pozo() {
        vehiculos.put(Moto.class.toString(), 3);
        vehiculos.put(Auto.class.toString(), 3);
    }

    public int penalizar(Vehiculo vehiculo/* int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }

}
