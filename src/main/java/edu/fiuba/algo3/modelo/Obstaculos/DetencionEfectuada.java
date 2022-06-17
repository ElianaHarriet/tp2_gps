package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class DetencionEfectuada extends Detencion {

    public int penalizar(IVehiculo vehiculo) {
        return 3;
    }
}
