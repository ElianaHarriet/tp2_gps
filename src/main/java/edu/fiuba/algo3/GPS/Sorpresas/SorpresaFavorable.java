package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;
import edu.fiuba.algo3.GPS.Vehiculos.IVehiculo;

public class SorpresaFavorable implements ISorpresa {

    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        return (int)(movimientos * 0.8);
    }
}
