package edu.fiuba.algo3.modelo.Sorpresas;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class SorpresaFavorable extends SorpresaNeutra {

    @Override
    public int actualizarMovimientos(int movimientos) {
        return (int)(movimientos * 0.8);
    }
}
