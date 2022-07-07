package edu.fiuba.algo3.modelo.Sorpresas;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class SorpresaNeutra implements ISorpresa {

    public int actualizarMovimientos(int movimientos) {
        return movimientos;
    }

    public IVehiculo intercambiarVehiculo(Auto auto) {
        return auto;
    }

    public IVehiculo intercambiarVehiculo(Moto moto) {
        return moto;
    }

    public IVehiculo intercambiarVehiculo(Camioneta camioneta) {
        return camioneta;
    }

}
