package edu.fiuba.algo3.modelo.Sorpresas;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class SorpresaFavorable implements ISorpresa {

    @Override
    public int actualizarMovimientos(int movimientos) {
        return (int)(movimientos * 0.8);
    }

    @Override
    public IVehiculo intercambiarVehiculo(Auto auto) {
        return auto;
    }

    @Override
    public IVehiculo intercambiarVehiculo(Moto moto) {
        return moto;
    }

    @Override
    public IVehiculo intercambiarVehiculo(Camioneta camioneta) {
        return camioneta;
    }
}
