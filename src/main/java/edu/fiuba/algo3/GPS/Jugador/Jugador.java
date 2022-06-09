package edu.fiuba.algo3.GPS.Jugador;

import edu.fiuba.algo3.GPS.Sorpresas.ISorpresa;
import edu.fiuba.algo3.GPS.Obstaculos.IObstaculo;
import edu.fiuba.algo3.GPS.Vehiculos.IVehiculo;

public class Jugador {
    int movimientos;
    String nick;
    Esquina esquina;
    IVehiculo vehiculo;

    public Jugador(Esquina esqInicial, String nick) {
        this.movimientos = 0;
        this.esquina = esqInicial;
        this.nick = nick;
    }

    public void setVehiculo(IVehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setPosicion(Esquina esquina) {
        this.esquina = esquina;
    }

    public Esquina getPosicion() {
        return this.esquina;
    }

    public int cantMovimientos() {
        return this.movimientos;
    }

    public boolean estaEnDestino() {
        return this.esquina.esDestino();

    }

    public void actualizarEstado(Esquina siguienteEsquina, ISorpresa sorpresa, IObstaculo obstaculo) {
        this.movimientos += this.vehiculo.atravesarObstaculo(obstaculo);

        /* INTERFAZ ATRAVESABLE??? Interfaz tumama*/
    }




}