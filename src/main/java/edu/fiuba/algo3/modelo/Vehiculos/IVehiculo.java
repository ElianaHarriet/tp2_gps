package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;

public interface IVehiculo {

    int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo);

    IVehiculo actualizarVehiculo(ISorpresa sorpresa);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, IObstaculo obstaculo);

    @Override
    boolean equals(Object o);
}
