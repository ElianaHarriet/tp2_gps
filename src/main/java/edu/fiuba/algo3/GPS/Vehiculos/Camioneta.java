package edu.fiuba.algo3.GPS.Vehiculos;

import edu.fiuba.algo3.GPS.Obstaculos.IObstaculo;

public class Camioneta implements IVehiculo {

    private int pozos;

    public Camioneta() {
        pozos = 0;
    }

    public int atravesarObstaculo(IObstaculo obstaculo) {
    
        return obstaculo.penalizar(this) + (int)Math.floor(pozos / 3);
    }

}
