package edu.fiuba.algo3.GPS;

public class Moto implements IVehiculo{
    /*
    * Pozos: Le suma 3 movimientos a motos.
    * Piquete: Las motos pueden pasar con una penalización de 2 movimientos.
    * Control Policial: Para todos los vehículos la penalización es de 3 movimientos,
    * la probabilidad es de 0,8 para las motos
    * */
    void atravesarObstaculo(Esquina esquina, int movimientos, Obstaculo obstaculo){
        /*ta hecho feo despues vemos como hacerlo lindo*/
        movimientos = obstaculo.aplicar(self, movimientos);

        if obstaculo == pozo:
            movimientos += 3;
        if obstaculo == piquete:
            movimientos += 2;
        if obstaculo == poli:
            movimientos += 3 * probabilidad_xd

        return esquina, movimientos; /*xd*/

    }

}