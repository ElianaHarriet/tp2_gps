package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PozoTest {

    @Test
    public void prueba01ElPozoPenalizaConTresMovimientosALaMoto() {
        Pozo pozo = new Pozo();
        Moto moto = new Moto();
        assertEquals(3, pozo.penalizar(moto));
    }

    @Test
    public void prueba02ElPozoPenalizaConTresMovimientosAlAuto() {
        Pozo pozo = new Pozo();
        Auto auto = new Auto();
        assertEquals(3, pozo.penalizar(auto));
    }

    @Test
    public void prueba03ElPozoNoPenalizaALaCamioneta() {
        Pozo pozo = new Pozo();
        Camioneta camioneta = new Camioneta();
        assertEquals(0, pozo.penalizar(camioneta));
    }

    @Test
    public void prueba04UnaCamionetaPasaTresVecesPorElPozoYEsPenalizadaConDosMovimientos() {
        Pozo pozo = new Pozo();
        Camioneta camioneta = new Camioneta();
        assertEquals(0, pozo.penalizar(camioneta));
        assertEquals(0, pozo.penalizar(camioneta));
        assertEquals(2, pozo.penalizar(camioneta));
    }
}
