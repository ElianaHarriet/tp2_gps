package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.Vehiculo;

public class SorpresaFavorable implements ISorpresa {
    public int aplicar(Vehiculo vehiculo, int movimientos) {
        return movimientos + (movimientos * (25 / 100));
    }
}
