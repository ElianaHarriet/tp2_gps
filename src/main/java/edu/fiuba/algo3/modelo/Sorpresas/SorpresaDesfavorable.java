package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;



public class SorpresaDesfavorable implements ISorpresa {

    @Override
    public int actualizarMovimientos(int movimientos) {
        return (int)(movimientos * 1.25);
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

    public String tipo() {return "desfavorable";}

}
