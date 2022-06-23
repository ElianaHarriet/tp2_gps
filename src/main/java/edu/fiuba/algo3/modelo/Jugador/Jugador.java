package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Sorpresas.*;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class Jugador {
    int movimientos;
    String nick;
    Esquina esquina;
    IVehiculo vehiculo;

    public Jugador(Esquina esqInicial, String nick, IVehiculo vehiculo) {
        this.movimientos = 0;
        this.esquina = esqInicial;
        this.nick = nick;
        this.vehiculo = vehiculo;
    }

    public boolean estaEnDestino() {
        return this.esquina.esDestino();

    }

    public void actualizarEstado(Esquina siguienteEsquina, ISorpresa sorpresa, IObstaculo obstaculo) {

        this.movimientos += this.vehiculo.atravesarObstaculo(obstaculo);
        this.movimientos = sorpresa.actualizarMovimientos(this.movimientos);
        this.vehiculo = this.vehiculo.actualizarVehiculo(sorpresa);
        this.esquina = this.vehiculo.siguienteEsquina(this.esquina, siguienteEsquina, obstaculo);
        /*
        * this.movimiento = this.vehiculo.atravezarAtravesable(atravesable1)
        *  this.movimiento = this.vehiculo.atravezarAtravesable(atravesable2)
        *
        *   PONIENDO MOVIMIENTOS EN VEHICULO + CREAR INICIALIZADOR
        * */
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public void moverseArriba() {
        this.esquina.moverseArriba(this);
        movimientos++;
    }

    public void moverseAbajo() {
        this.esquina.moverseAbajo(this);
        movimientos++;
    }

    public void moverseIzquierda() {
        this.esquina.moverseIzquierda(this);
        movimientos++;
    }

    public void moverseDerecha() {
        this.esquina.moverseDerecha(this);
        movimientos++;
    }
}