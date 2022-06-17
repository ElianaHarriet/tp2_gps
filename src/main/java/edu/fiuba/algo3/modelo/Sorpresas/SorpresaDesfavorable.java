package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;



public class SorpresaDesfavorable extends SorpresaNeutra {

    @Override
    public int actualizarMovimientos(int movimientos) {
        return (int)(movimientos * 1.25);
    }
}
