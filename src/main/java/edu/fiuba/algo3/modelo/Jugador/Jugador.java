package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

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


        this.movimientos = sorpresa.actualizarMovimientos(this.movimientos);
        this.vehiculo = this.vehiculo.actualizarVehiculo(sorpresa);


        /* INTERFAZ ATRAVESABLE??? Interfaz tumama*/
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public IVehiculo getVehiculo() {
        return vehiculo;
    }
}