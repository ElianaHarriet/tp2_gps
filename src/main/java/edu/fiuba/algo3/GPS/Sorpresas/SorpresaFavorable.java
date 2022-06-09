package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;
import edu.fiuba.algo3.GPS.Vehiculos.IVehiculo;

public class SorpresaFavorable implements IAtravesable {

    public int atravesar(int movimientos){
        return movimientos - (movimientos * (20/100));
    }
}
