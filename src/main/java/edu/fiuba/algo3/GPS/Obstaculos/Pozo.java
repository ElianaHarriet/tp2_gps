package edu.fiuba.algo3.GPS.Obstaculos;

import edu.fiuba.algo3.GPS.Vehiculos.*;


public class Pozo implements IObstaculo {

    public int penalizar(Auto auto) {
        return 3;
    }

    public int penalizar(Moto moto) {
        return 3;
    }

    public int penalizar(Camioneta camioneta) {
        return 0;
    }

}
