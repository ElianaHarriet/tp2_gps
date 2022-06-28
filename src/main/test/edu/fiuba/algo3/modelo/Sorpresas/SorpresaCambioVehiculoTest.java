package edu.fiuba.algo3.modelo.Sorpresas;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SorpresaCambioVehiculoTest {

    @Test
    public void prueba01UnaSorpresaCambioVehiculoDevuelveLaCantidadCorrectaDeMovimientos() {
        SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        assertEquals(100, sorpresaCambioVehiculo.actualizarMovimientos(100));
    }

    @Test
    public void prueba02UnaSorpresaCambioVehiculoIntercambiaCorrectamenteAlAuto() {
        SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Auto auto = new Auto();
        assertEquals(new Camioneta(), sorpresaCambioVehiculo.intercambiarVehiculo(auto));
    }

    @Test
    public void prueba03UnaSorpresaCambioVehiculoIntercambiaCorrectamenteALaMoto() {
        SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Moto moto = new Moto();
        assertEquals(new Auto(), sorpresaCambioVehiculo.intercambiarVehiculo(moto));
    }

    @Test
    public void prueba04UnaSorpresaCambioVehiculoIntercambiaCorrectamenteALaCamioneta() {
        SorpresaCambioVehiculo sorpresaCambioVehiculo = new SorpresaCambioVehiculo();
        Camioneta camioneta = new Camioneta();
        assertEquals(new Moto(), sorpresaCambioVehiculo.intercambiarVehiculo(camioneta));
    }
}
