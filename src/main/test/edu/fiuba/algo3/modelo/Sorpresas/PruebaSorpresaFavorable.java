package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebaSorpresaFavorable {

    @Test
    public void prueba01UnaSorpresaFavorableDevuelveLaCantidadCorrectaDeMovimientos() {
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        assertEquals(8, sorpresaFavorable.actualizarMovimientos(10));
    }

    @Test
    public void prueba02UnaSorpresaFavorableNoIntercambiaAlAuto() {
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        Auto auto = new Auto();
        assertEquals(auto, sorpresaFavorable.intercambiarVehiculo(auto));
    }

    @Test
    public void prueba03UnaSorpresaFavorableNoIntercambiaALaMoto() {
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        Moto moto = new Moto();
        assertEquals(moto, sorpresaFavorable.intercambiarVehiculo(moto));
    }

    @Test
    public void prueba04UnaSorpresaFavorableNoIntercambiaALaCamioneta() {
        SorpresaFavorable sorpresaFavorable = new SorpresaFavorable();
        Camioneta camioneta = new Camioneta();
        assertEquals(camioneta, sorpresaFavorable.intercambiarVehiculo(camioneta));
    }
}
