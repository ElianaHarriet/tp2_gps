package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.SorpresaNeutra;

public interface IVehiculo {

    int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo);

    IVehiculo actualizarVehiculo(SorpresaNeutra sorpresa);

    @Override
    boolean equals(Object o);
}
