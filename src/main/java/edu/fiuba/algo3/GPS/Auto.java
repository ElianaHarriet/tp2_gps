package edu.fiuba.algo3.GPS;

public class Auto implements IVehiculo{
    @Override
    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo){

        return obstaculo.penalizar(this);
    }

}
