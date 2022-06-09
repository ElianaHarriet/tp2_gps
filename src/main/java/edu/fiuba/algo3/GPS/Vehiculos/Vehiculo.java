package edu.fiuba.algo3.GPS.Vehiculos;

import edu.fiuba.algo3.GPS.Obstaculos.Obstaculo;

public class Vehiculo {
    
    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */Obstaculo obstaculo) {
        return obstaculo.penalizar(this);
    }
}
