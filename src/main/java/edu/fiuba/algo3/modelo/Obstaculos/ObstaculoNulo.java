package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ObstaculoNulo implements IObstaculo {

    public int penalizar(Auto auto) {
        return 0;
    }

    public int penalizar(Camioneta camioneta) {
        return 0;
    }

    public int penalizar(Moto moto) {
        return 0;
    }
}
