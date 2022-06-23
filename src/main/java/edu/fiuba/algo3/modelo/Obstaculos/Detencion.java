package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import java.util.Random;

abstract class Detencion {

    abstract int penalizar(IVehiculo vehiculo);

    static Detencion obtenerDetencion(Auto auto) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return randomNumber < 0.5 ? new DetencionEfectuada() : new DetencionPasada();
    }

    static Detencion obtenerDetencion(Moto moto) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return randomNumber < 0.8 ? new DetencionEfectuada() : new DetencionPasada();
    }

    static Detencion obtenerDetencion(Camioneta camioneta) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return randomNumber < 0.3 ? new DetencionEfectuada() : new DetencionPasada();
    }


}
