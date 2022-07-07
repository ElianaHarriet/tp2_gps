package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReliantRobinTest {

    //Obstaculos
    @Test
    public void Test01UnReliantRobinComoAutoPasaPorUnPozoYSePenalizaCon3Movimientos(){
        int movimientosPenalizacionEsperados = 3;
        ReliantRobin rb = new ReliantRobin();
        Pozo pozo = new Pozo();
        float probabilidad = 0.5f;

        int movimientosPenalizacionEfectuados = rb.atravesarObstaculo(pozo, probabilidad);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }


    @Test
    public void Test02UnReliantRobinPasaPorUnControlPolicialYEsPenalizadoEn3MovimientosAlSerDetenido(){
        int movimientosPenalizacionEsperados = 3;
        ReliantRobin robin = new ReliantRobin();
        DetencionEfectuada detencion = new DetencionEfectuada();
        ControlPolicial controlPolicial = new ControlPolicial(detencion);

        int movimientosPenalizacionEfectuados = robin.atravesarObstaculo(controlPolicial);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test03UnReliantRobinComoAutoPasaPorUnPiqueteYNoPuedePasar(){
        ReliantRobin robin = new ReliantRobin();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = new EsquinaNormie(0,1);

        Esquina esquinaFinal = robin.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(esquinaOrigen, esquinaFinal);
    }

    @Test
    public void Test03bUnReliantRobinComoMotoPasaPorUnPiqueteYPuedePasar(){
        ReliantRobin robin = new ReliantRobin();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = esquinaOrigen;

        Esquina esquinaFinal = robin.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(esquinaOrigen, esquinaFinal);
    }

    @Test
    public void Test04UnReliantRobinComoAutoPasaPorUnPiqueteYPuedePasar(){
        ReliantRobin robin = new ReliantRobin();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = esquinaOrigen;
        float proba = 0.4f;
        int movimientos = robin.atravesarObstaculo(piquete, proba);


        //Esquina esquinaFinal = robin.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(movimientos, 0);
    }

    //Sorpresas
    @Test
    public void Test05UnReliantRobinComoAutoPasaPorUnaSorpresaCambioDeVehiculoYNoSeTransforma(){
        ReliantRobin robin = new ReliantRobin();
        SorpresaCambioVehiculo cambio = new SorpresaCambioVehiculo();
        ReliantRobin cambioEsperado = new ReliantRobin();

        IVehiculo cambioEfectuado = robin.actualizarVehiculo(cambio);
        assertEquals(cambioEsperado, cambioEfectuado);
    }



}
