package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.IVehiculo;

public class SorpresaNula implements ISorpresa {
    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        return movimientos;
    }
}
