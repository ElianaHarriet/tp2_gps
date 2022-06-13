package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class Pozo implements IObstaculo {

    public int penalizar(Auto auto) {
        return 3;
    }

    public int penalizar(Moto moto) {
        return 3;
    }

    public int penalizar(Camioneta camioneta) {
        return camioneta.atravesarObstaculo(this);

    }

    public int return1SiEsPozo() {
        return 1;
    }
}
