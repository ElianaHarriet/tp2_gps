package edu.fiuba.algo3.GPS.Obstaculos;

import edu.fiuba.algo3.GPS.Vehiculos.*;


public class Piquete implements IObstaculo {
    /*QUEDO ANEMICO*/
    public int penalizar(Auto auto) {
        return 0;
    }

    public int penalizar(Moto moto) {
        return 2;
    }

    public int penalizar(Camioneta camioneta) {
        return 0;
    }

    public int return1SiEsPozo() {
        return 0;
    }
}
