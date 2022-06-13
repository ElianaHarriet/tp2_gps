package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;
import edu.fiuba.algo3.GPS.Vehiculos.*;

public class SorpresaFavorable implements ISorpresa {
/*
    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        return (int)(movimientos * 0.8);
    }*/
    @Override
    public int actualizarMovimientos(int movimientos) {
        return (int)(movimientos * 0.8);
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
