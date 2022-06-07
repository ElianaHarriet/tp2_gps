package edu.fiuba.algo3.GPS;

public class Piquete implements IObstaculo{

    @Override
    public int penalizar(IVehiculo vehiculo/*, int movimientos*/) {
        return 1000;
    }
}
