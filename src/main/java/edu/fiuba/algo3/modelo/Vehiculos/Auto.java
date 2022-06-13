package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;

public class Auto implements IVehiculo {

    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo) {
        return obstaculo.penalizar(this);
    }

    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    public boolean equals(Object obj) {
        return obj instanceof Auto;
    }
}
