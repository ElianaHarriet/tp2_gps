package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;

public class Moto implements IVehiculo{
    /*
    * Pozos: Le suma 3 movimientos a motos.
    * Piquete: Las motos pueden pasar con una penalización de 2 movimientos.
    * Control Policial: Para todos los vehículos la penalización es de 3 movimientos,
    * la probabilidad es de 0,8 para las motos
    * */

    public int atravesarObstaculo(/*Esquina esquina, int movimientos, */IObstaculo obstaculo) {
        return obstaculo.penalizar(this);
    }

    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    public boolean equals(Object otroVehiculo){
        return otroVehiculo instanceof Moto;
    }
}