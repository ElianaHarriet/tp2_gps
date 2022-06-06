package edu.fiuba.algo3.GPS;

public class Auto implements IVehiculo{
    @Override
    public void atravesarObstaculo(Esquina esquina, int movimientos, IObstaculo obstaculo) {

    }
    public void atravesarPozo(int movimientos ){
        movimientos = movimientos +3;
    }

}
