package edu.fiuba.algo3.GPS;

public class Camioneta implements IVehiculo{
    @Override
    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo){
        //movimientos = obstaculo.aplicar(this, movimientos);

        /*if (obstaculo == pozo) {
            movimientos += 3;
        }
        if (obstaculo == piquete) {
            movimientos += 2;
        }
        if (obstaculo == poli) {
            movimientos += 3;  * probabilidad_xd
        }*/
        return obstaculo.penalizar(this);
    }
    public void atravesarPozo(int movimientos){

    }
}
