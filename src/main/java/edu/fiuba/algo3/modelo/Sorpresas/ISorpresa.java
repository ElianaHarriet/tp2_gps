package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;

public interface ISorpresa {
    int actualizarMovimientos(int movimientos);
    IVehiculo intercambiarVehiculo(Auto auto);
    IVehiculo intercambiarVehiculo(Moto moto);
    IVehiculo intercambiarVehiculo(Camioneta camioneta);
}
