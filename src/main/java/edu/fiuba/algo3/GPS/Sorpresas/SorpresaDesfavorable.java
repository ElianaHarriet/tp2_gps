package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.Vehiculo;

public class SorpresaDesfavorable implements ISorpresa {
    public int aplicar(Vehiculo vehiculo, int movimientos) {
        return movimientos - (movimientos * (20 / 100));
    }
}
