package edu.fiuba.algo3.GPS;

public class Pozo extends Obstaculo {

    public Pozo() {
        vehiculos.put(Moto.class.toString(), 3);
        vehiculos.put(Auto.class.toString(), 3);
    }

    public int penalizar(Vehiculo vehiculo/* int movimientos*/) {
        return vehiculos.get(vehiculo.getClass().toString());
    }

}
