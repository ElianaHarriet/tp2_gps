package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AutoTest {

    //Obstaculos
    @Test
    public void Test01UnAutoPasaPorUnPozoYSePenalizaCon3Movimientos(){
        int movimientosPenalizacionEsperados = 3;
        Auto auto = new Auto();
        Pozo pozo = new Pozo();

        int movimientosPenalizacionEfectuados = auto.atravesarObstaculo(pozo);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test02UnAutoPasaPorUnControlPolicialYEsPenalizadoEn3MovimientosAlNoPasarlo(){
        int movimientosPenalizacionEsperados = 3;
        Auto auto = new Auto();
        DetencionEfectuada detencion = new DetencionEfectuada();
        ControlPolicial controlPolicial = new ControlPolicial(detencion);

        int movimientosPenalizacionEfectuados = auto.atravesarObstaculo(controlPolicial);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test03UnAutoPasaPorUnPiqueteYNoPuedePasar(){
        Auto auto = new Auto();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = new EsquinaNormie(0,1);

        Esquina esquinaFinal = auto.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(esquinaOrigen, esquinaFinal);
    }

    //Sorpresas
    @Test
    public void Test04UnAutoPasaPorUnaSorpresaCambioDeVehiculoYSeVuelveUna4x4(){
        Auto auto = new Auto();
        SorpresaCambioVehiculo cambio = new SorpresaCambioVehiculo();
        Camioneta cambioEsperado = new Camioneta();

        IVehiculo cambioEfectuado = auto.actualizarVehiculo(cambio);
        assertEquals(cambioEsperado, cambioEfectuado);
    }

}
