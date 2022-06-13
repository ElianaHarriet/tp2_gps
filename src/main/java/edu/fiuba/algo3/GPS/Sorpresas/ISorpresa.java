package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.*;

public interface ISorpresa {

    //int aplicar(IVehiculo vehiculo, int movimientos);

    int actualizarMovimientos(int movimientos);
    IVehiculo actualizarVehiculo(Auto auto);
    IVehiculo actualizarVehiculo(Moto moto);
    IVehiculo actualizarVehiculo(Camioneta camioneta);
}
