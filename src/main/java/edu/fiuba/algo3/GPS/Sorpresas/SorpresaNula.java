package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.*;

public class SorpresaNula implements ISorpresa {
    /*
    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        return movimientos;
    }
    */

    @Override
    public int actualizarMovimientos(int movimientos) {
        return movimientos;
    }

    @Override
    public IVehiculo actualizarVehiculo(Auto auto) {
        return auto;
    }

    @Override
    public IVehiculo actualizarVehiculo(Moto moto) {
        return moto;
    }

    @Override
    public IVehiculo actualizarVehiculo(Camioneta camioneta) {
        return camioneta;
    }

}
