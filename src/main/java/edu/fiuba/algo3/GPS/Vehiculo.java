package edu.fiuba.algo3.GPS;

public class Vehiculo {
    
    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */Obstaculo obstaculo) {
        return obstaculo.penalizar(this);
    }
}
