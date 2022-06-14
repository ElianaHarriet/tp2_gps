package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Esquina;

import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import edu.fiuba.algo3.modelo.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PruebasJugador {

    @Test
    public void prueba00ElJugadorSeCreaSinMovimientos() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        assertEquals(0, jugador.movimientos);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                  Entrega 01                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso 1: Una moto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.  *
     * Caso de uso 2: Un auto atraviesa la ciudad y se encuentra con un Pozo. Es penalizada en tres movimientos.   *
     * Caso de uso 3: Una 4x4 atraviesa la ciudad y se encuentra con un Pozo. No es penalizada.                    *
     * Caso de uso 4: Para una 4x4 se penaliza en 2 movimientos luego de atravesar 3 pozos.                        *
     * Caso de uso 5: Una moto pasa un piquete y es penalizada dos movimientos.                                    *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    @Test
    public void prueba01UnaMotoSeEncuentraConUnPozoYEsPenalizadaTresMovimientos() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba02UnAutoSeEncuentraConUnPozoYEsPenalizadoTresMovimientos() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba03UnaCamionetaSeEncuentraConUnPozoYNoEsPenalizada() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba04UnaCamionetaPasaPorTresPozosYEsPenalizadaDosMovimientos() {
        int movimientosEsperados = 2; // this!!!!
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "qwe");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        jugador.actualizarEstado(null, new SorpresaNeutra(), pozo);
        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba05UnaMotoPasaUnPiqueteYEsPenalizadaDosMovimientos() {
        int movimientosEsperados = 2;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        IObstaculo piquete = new Piquete();

        jugador.actualizarEstado(null, new SorpresaNeutra(), piquete);
        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                              Extras (piquete)                                               *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso A: Un auto quiere pasar por un piquete y vuelve a su lugar porque no puede pasar                *
     * Caso de uso B: Una 4x4 quiere pasar por un piquete y vuelve a su lugar porque no puede pasar                *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    @Test
    public void pruebaAUnAutoQuierePasarPorUnPiqueteYVuelveAlLugarInicial() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo piquete = new Piquete();
        Esquina esquinaInicial = new Esquina(false);
        Esquina esquinaSiguiente = new Esquina(false);
        jugador.setPosicion(esquinaInicial);

        jugador.actualizarEstado(esquinaSiguiente, new SorpresaNeutra(), piquete);
        assertEquals(esquinaInicial, jugador.esquina);
    }

    @Test
    public void pruebaBUna4x4QuierePasarPorUnPiqueteYVuelveAlLugarInicial() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo piquete = new Piquete();
        Esquina esquinaInicial = new Esquina(false);
        Esquina esquinaSiguiente = new Esquina(false);
        jugador.setPosicion(esquinaInicial);

        jugador.actualizarEstado(esquinaSiguiente, new SorpresaNeutra(), piquete);
        assertEquals(esquinaInicial, jugador.esquina);
    }


    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                  Entrega 02                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso 1: Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.                          *
     * Caso de uso 2: Un vehículo atraviesa la ciudad y encuentra una sorpresa desfavorable.                       *
     * Caso de uso 3: Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo (caso Auto).     *
     * Caso de uso 4: Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo (caso Moto).     *
     * Caso de uso 5: Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo (caso Camioneta).*
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    @Test
    public void prueba01UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Beto");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        SorpresaNeutra sorpresa = new SorpresaFavorable();

        int movimientosInicio = 10;
        int movimientosEsperados = (int)(10 - 10 * 0.2);
        jugador.setMovimientos(movimientosInicio);
        jugador.actualizarEstado(null, sorpresa, new ObstaculoNulo());

        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba02UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Beto");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        SorpresaNeutra sorpresa = new SorpresaDesfavorable();

        int movimientosInicio = 10;
        int movimientosEsperados = (int)(10 + 10 * 0.25);
        jugador.setMovimientos(movimientosInicio);
        jugador.actualizarEstado(null, sorpresa, new ObstaculoNulo());

        assertEquals(movimientosEsperados, jugador.movimientos);
    }

    @Test
    public void prueba03UnAutoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Bonshot");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        SorpresaNeutra sorpresa = new SorpresaCambioVehiculo();
        IVehiculo vehiculoEsperado = new Camioneta();

        jugador.actualizarEstado(null, sorpresa, new ObstaculoNulo());
        assertEquals(vehiculoEsperado, jugador.vehiculo);

    }

    @Test
    public void prueba04UnaMotoAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Bonshot");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        SorpresaNeutra sorpresa = new SorpresaCambioVehiculo();
        IVehiculo vehiculoEsperado = new Auto();

        jugador.actualizarEstado(null, sorpresa, new ObstaculoNulo());
        assertEquals(vehiculoEsperado, jugador.vehiculo);
    }

    @Test
    public void prueba05UnaCamionetaAtraviesaLaCiudadYEncuentraUnaSorpresaCambioDeVehiculo() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Bonshot");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        SorpresaNeutra sorpresa = new SorpresaCambioVehiculo();
        IVehiculo vehiculoEsperado = new Moto();

        jugador.actualizarEstado(null, sorpresa, new ObstaculoNulo());
        assertEquals(vehiculoEsperado, jugador.vehiculo);
    }
}
