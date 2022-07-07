package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Mapa.EsquinaNormie;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CamionetaTest {

    //Obstaculos
    @Test
    public void Test01Una4x4PasaPorUnPozoYSePenalizaCon2Movimientos(){
        int movimientosPenalizacionEsperados = 2;
        Camioneta camio = new Camioneta();
        Pozo pozo = new Pozo();

        int movimientosPenalizacionEfectuados = camio.atravesarObstaculo(pozo);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test02Una4x4PasaPorUnControlPolicialYEsPenalizadoEn3MovimientosAlNoPasarlo(){
        int movimientosPenalizacionEsperados = 3;
        Camioneta camio = new Camioneta();
        DetencionEfectuada detencion = new DetencionEfectuada();
        ControlPolicial controlPolicial = new ControlPolicial(detencion);

        int movimientosPenalizacionEfectuados = camio.atravesarObstaculo(controlPolicial);
        assertEquals(movimientosPenalizacionEsperados, movimientosPenalizacionEfectuados);
    }

    @Test
    public void Test03Una4x4PasaPorUnPiqueteYNoPuedePasar(){
        Camioneta camio = new Camioneta();
        Piquete piquete = new Piquete();
        EsquinaNormie esquinaOrigen = new EsquinaNormie(0,0);
        EsquinaNormie esquinaDestino = new EsquinaNormie(0,1);

        Esquina esquinaFinal = camio.siguienteEsquina(esquinaOrigen, esquinaDestino, piquete);
        assertEquals(esquinaOrigen, esquinaFinal);
    }

    //Sorpresas
    @Test
    public void Test04Una4x4PasaPorUnaSorpresaCambioDeVehiculoYSeVuelveUna4x4(){
        Camioneta camio = new Camioneta();
        SorpresaCambioVehiculo cambio = new SorpresaCambioVehiculo();
        Moto cambioEsperado = new Moto();

        IVehiculo cambioEfectuado = camio.actualizarVehiculo(cambio);
        assertEquals(cambioEsperado, cambioEfectuado);
    }
}
