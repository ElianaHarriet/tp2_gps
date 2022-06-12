package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;
import edu.fiuba.algo3.GPS.Vehiculos.IVehiculo;


public class SorpresaDesfavorable implements ISorpresa {

    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        return (int)(movimientos * 1.25);
    }
}
