package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PiqueteTest {

    @Test
    public void prueba01ElPiquetePenalizaConDosMovimientosALaMoto() {
        Piquete piquete = new Piquete();
        Moto moto = new Moto();
        assertEquals(2, piquete.penalizar(moto));
    }

    @Test
    public void prueba02ElPiqueteNoPenalizaAlAuto() {
        Piquete piquete = new Piquete();
        Auto auto = new Auto();
        assertEquals(0, piquete.penalizar(auto));
    }

    @Test
    public void prueba03ElPiqueteNoPenalizaALaCamioneta() {
        Piquete piquete = new Piquete();
        Camioneta camioneta = new Camioneta();
        assertEquals(0, piquete.penalizar(camioneta));
    }
}
