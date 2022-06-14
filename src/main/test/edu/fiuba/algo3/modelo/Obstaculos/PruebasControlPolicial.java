package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebasControlPolicial {
    @Test
    public void prueba01UnAutoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 0;
        Auto auto = new Auto();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionPasada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(auto));
    }

    @Test
    public void prueba02UnaMotoPasaConExitoUnControlPolicialNoEsPenalizado() {
        int movimientosEsperados = 0;
        Moto moto = new Moto();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionPasada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(moto));
    }

    @Test
    public void prueba03Una4x4PasaConExitoUnControlPolicial() {
        int movimientosEsperados = 0;
        Camioneta camioneta = new Camioneta();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionPasada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(camioneta));
    }

    @Test
    public void prueba04UnAutoNoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Auto auto = new Auto();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionEfectuada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(auto));
    }


    @Test
    public void prueba05UnaMotoNoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Moto moto = new Moto();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionEfectuada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(moto));
    }

    @Test
    public void prueba06Una4x4NoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Camioneta camioneta = new Camioneta();
        IObstaculo controlPolicial = new ControlPolicial(new DetencionEfectuada());
        assertEquals(movimientosEsperados, controlPolicial.penalizar(camioneta));
    }
}
