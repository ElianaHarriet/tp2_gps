package edu.fiuba.algo3.GPS;

public class Moto implements IVehiculo{
    /*
    * Pozos: Le suma 3 movimientos a motos.
    * Piquete: Las motos pueden pasar con una penalización de 2 movimientos.
    * Control Policial: Para todos los vehículos la penalización es de 3 movimientos,
    * la probabilidad es de 0,8 para las motos
    * */

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

}