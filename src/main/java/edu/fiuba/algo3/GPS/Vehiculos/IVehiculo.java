package edu.fiuba.algo3.GPS.Vehiculos;

import edu.fiuba.algo3.GPS.Obstaculos.IObstaculo;

public interface IVehiculo {
    
    int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo);
}
