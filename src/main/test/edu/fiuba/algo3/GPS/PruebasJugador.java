package edu.fiuba.algo3.GPS;

import edu.fiuba.algo3.GPS.Jugador.Esquina;
import edu.fiuba.algo3.GPS.Jugador.Jugador;
import edu.fiuba.algo3.GPS.Obstaculos.*;
import edu.fiuba.algo3.GPS.Sorpresas.*;;
import edu.fiuba.algo3.GPS.Vehiculos.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PruebasJugador {

    @Test
    public void prueba00ElJugadorSeCreaSinMovimientos() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        assertEquals(jugador.cantMovimientos(), 0);
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

        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void prueba02UnAutoSeEncuentraConUnPozoYEsPenalizadoTresMovimientos() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void prueba03UnaCamionetaSeEncuentraConUnPozoYNoEsPenalizada() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void prueba04UnaCamionetaPasaPorTresPozosYEsPenalizadaDosMovimientos() {
        int movimientosEsperados = 2; // this!!!!
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "qwe");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo pozo = new Pozo();

        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        jugador.actualizarEstado(null, new SorpresaNula(), pozo);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void prueba05UnaMotoPasaUnPiqueteYEsPenalizadaDosMovimientos() {
        int movimientosEsperados = 2;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        IObstaculo piquete = new Piquete();

        jugador.actualizarEstado(null, new SorpresaNula(), piquete);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                              Extras (piquete)                                               *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso A1: Un auto quiere pasar por un piquete y no es penalizado porque no puede pasar                *
     * Caso de uso B1: Una 4x4 quiere pasar por un piquete y no es penalizada porque no puede pasar                *
     * Caso de uso A2: Un auto quiere pasar por un piquete y vuelve a su lugar porque no puede pasar               *
     * Caso de uso B2: Una 4x4 quiere pasar por un piquete y vuelve a su lugar porque no puede pasar               *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    @Test
    public void pruebaA1UnAutoQuierePasarPorUnPiqueteYNoEsPenalizado() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo piquete = new Piquete();

        jugador.actualizarEstado(null, new SorpresaNula(), piquete);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaB1Una4x4QuierePasarPorUnPiqueteYNoEsPenalizado() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo piquete = new Piquete();

        jugador.actualizarEstado(null, new SorpresaNula(), piquete);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaA2UnAutoQuierePasarPorUnPiqueteYVuelveAlLugarInicial() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo piquete = new Piquete();
        Esquina esquinaInicial = new Esquina(false);
        Esquina esquinaSiguiente = new Esquina(false);
        jugador.setPosicion(esquinaInicial);

        jugador.actualizarEstado(esquinaSiguiente, new SorpresaNula(), piquete);
        assertEquals(jugador.getPosicion(), esquinaInicial);
    }

    @Test
    public void pruebaB2Una4x4QuierePasarPorUnPiqueteYVuelveAlLugarInicial() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo piquete = new Piquete();
        Esquina esquinaInicial = new Esquina(false);
        Esquina esquinaSiguiente = new Esquina(false);
        jugador.setPosicion(esquinaInicial);

        jugador.actualizarEstado(esquinaSiguiente, new SorpresaNula(), piquete);
        assertEquals(jugador.getPosicion(), esquinaInicial);
        //assertEquals(3, 8); // -> Usado solo para que no de OK (marca que falta hacer cosas)
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                           Extras (control policial)                                         *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso C1: Un auto pasa con exito un control policial (no es penalizado)                               *
     * Caso de uso D1: Una moto pasa con exito un control policial (no es penalizada)                              *
     * Caso de uso E1: Una 4x4 pasa con exito un control policial (no es penalizado)                               *
     * Caso de uso C2: Un auto no pasa con exito un control policial (es penalizado)                               *
     * Caso de uso D2: Una moto no pasa con exito un control policial (es penalizada)                              *
     * Caso de uso E2: Una 4x4 no pasa con exito un control policial (es penalizada)                               *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    @Test
    public void pruebaC1UnAutoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo controlPolicial = new ControlPolicial(false);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaD1UnaMotoPasaConExitoUnControlPolicialNoEsPenalizado() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo controlPolicial = new ControlPolicial(false);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaE1Una4x4PasaConExitoUnControlPolicial() {
        int movimientosEsperados = 0;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo controlPolicial = new ControlPolicial(false);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaC2UnAutoNoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo auto = new Auto();
        jugador.setVehiculo(auto);
        IObstaculo controlPolicial = new ControlPolicial(true);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }


    @Test
    public void pruebaD2UnaMotoNoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        IObstaculo controlPolicial = new ControlPolicial(true);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    @Test
    public void pruebaE2Una4x4NoPasaConExitoUnControlPolicial() {
        int movimientosEsperados = 3;
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "alister");
        IVehiculo camioneta = new Camioneta();
        jugador.setVehiculo(camioneta);
        IObstaculo controlPolicial = new ControlPolicial(true);

        jugador.actualizarEstado(null, new SorpresaNula(), controlPolicial);
        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     *                                                  Entrega 02                                                 *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Caso de uso 1: Un vehículo atraviesa la ciudad y encuentra una sorpresa favorable.                          *
     * Caso de uso 2: Un vehículo atraviesa la ciudad y encuentra una sorpresa desfavorable.                       *
     * Caso de uso 3: Un vehículo atraviesa la ciudad y encuentra una sorpresa cambio de vehículo.                 *
     * EXTRAS                                                                                                      *
     * Caso de uso 4:                                                                                              *
     * Caso de uso 5:                                                                                              *
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

  /*  @Test
    public void prueba01UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaFavorable() {
        Esquina esqInicial = new Esquina(false);
        Jugador jugador = new Jugador(esqInicial, "Beto");
        IVehiculo moto = new Moto();
        jugador.setVehiculo(moto);
        ISorpresa sorpresa = new SorpresaFavorable();

        int movimientosEsperados = jugador.cantMovimientos() - (jugador.cantMovimientos()*100/25);
        jugador.actualizarEstado(null, sorpresa, null);

        assertEquals(movimientosEsperados, jugador.cantMovimientos());
    }*/

//    @Test
//    public void prueba02UnVehiculoAtraviesaLaCiudadYEncuentraUnaSorpresaDesfavorable() {
//        Esquina esqInicial = new Esquina(false);
//        Jugador jugador = new Jugador(esqInicial, "Beto");
//        IVehiculo moto = new Moto();
//        jugador.setVehiculo(moto);
//        ISorpresa sorpresa = new SorpresaDesfavorable();
//
//        int movimientosEsperados = jugador.cantMovimientos() + (jugador.cantMovimientos()*100/20);
//
//        jugador.actualizarEstado(null, sorpresa, null);
//        assertEquals(movimientosEsperados, jugador.cantMovimientos());
//    }


}