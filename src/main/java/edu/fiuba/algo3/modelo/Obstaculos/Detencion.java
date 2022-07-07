package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import java.util.Random;

abstract class Detencion {

    private static final double FACTOR_AUTO = 0.5;
    private static final double FACTOR_MOTO = 0.8;
    private static final double FACTOR_CAMIONETA = 0.3;


    abstract int penalizar(IVehiculo vehiculo);

    static Detencion obtenerDetencion(Auto auto) {
        return detener(FACTOR_AUTO);
    }

    static Detencion obtenerDetencion(Moto moto) {
        return detener(FACTOR_MOTO);
    }

    static Detencion obtenerDetencion(Camioneta camioneta) {
        return detener(FACTOR_CAMIONETA);
    }
    static Detencion detener(double factorVehiculo) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return randomNumber < factorVehiculo ? new DetencionEfectuada() : new DetencionPasada();
    }

}
