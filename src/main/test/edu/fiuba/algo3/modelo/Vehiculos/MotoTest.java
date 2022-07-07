package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MotoTest {

    //Obstaculos
    @Test
    public void Test01UnaMotoPasaPorUnPozoYSePenalizaCon3Movimientos(){
        int movimientosPenalizacionEsperados = 3;
        Moto moto = new Moto();
        Pozo pozo = new Pozo();

        int movimientosPenalizacionEfectuados = moto.atravesarObstaculo(pozo);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test02UnaMotoPasaPorUnControlPolicialYEsPenalizadoEn3MovimientosAlNoPasarlo(){
        int movimientosPenalizacionEsperados = 3;
        Moto moto = new Moto();
        DetencionEfectuada detencion = new DetencionEfectuada();
        ControlPolicial controlPolicial = new ControlPolicial(detencion);

        int movimientosPenalizacionEfectuados = moto.atravesarObstaculo(controlPolicial);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test03UnaMotoPasaPorUnPiqueteYPasaConUnaPenalizacionDe2Movimientos(){
        Moto moto = new Moto();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = new EsquinaNormie(0,1);

        Esquina esquinaFinal = moto.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(esquinaDestino, esquinaFinal);
    }

    //Sorpresas
    @Test
    public void Test04UnaMotoPasaPorUnaSorpresaCambioDeVehiculoYSeVuelveUna4x4(){
        Moto moto = new Moto();
        SorpresaCambioVehiculo cambio = new SorpresaCambioVehiculo();
        Auto cambioEsperado = new Auto();

        IVehiculo cambioEfectuado = moto.actualizarVehiculo(cambio);
        assertEquals(cambioEsperado, cambioEfectuado);
    }
}
