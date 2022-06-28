package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SorpresaDesfavorableTest {

    @Test
    public void prueba01UnaSorpresaDesfavorableDevuelveLaCantidadCorrectaDeMovimientos() {
        SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
        assertEquals(125, sorpresaDesfavorable.actualizarMovimientos(100));
    }

    @Test
    public void prueba02UnaSorpresaDesfavorableNoIntercambiaAlAuto() {
        SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
        Auto auto = new Auto();
        assertEquals(auto, sorpresaDesfavorable.intercambiarVehiculo(auto));
    }

    @Test
    public void prueba03UnaSorpresaDesfavorableNoIntercambiaALaMoto() {
        SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
        Moto moto = new Moto();
        assertEquals(moto, sorpresaDesfavorable.intercambiarVehiculo(moto));
    }

    @Test
    public void prueba04UnaSorpresaDesfavorableNoIntercambiaALaCamioneta() {
        SorpresaDesfavorable sorpresaDesfavorable = new SorpresaDesfavorable();
        Camioneta camioneta = new Camioneta();
        assertEquals(camioneta, sorpresaDesfavorable.intercambiarVehiculo(camioneta));
    }
}
