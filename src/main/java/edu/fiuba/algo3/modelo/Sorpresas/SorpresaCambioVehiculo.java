package edu.fiuba.algo3.modelo.Sorpresas;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class SorpresaCambioVehiculo extends SorpresaNeutra {

    @Override
    public IVehiculo intercambiarVehiculo(Auto auto) {
        return new Camioneta();
    }

    @Override
    public IVehiculo intercambiarVehiculo(Moto moto) {
        return new Auto();
    }

    @Override
    public IVehiculo intercambiarVehiculo(Camioneta camioneta) {
        return new Moto();
    }

}

