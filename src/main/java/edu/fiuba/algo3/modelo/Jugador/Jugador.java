package edu.fiuba.algo3.modelo.Jugador;

import edu.fiuba.algo3.modelo.Mapa.*;
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
    }

    public void setMovimientos(int movimientos) {
        this.movimientos = movimientos;
    }

    public void moverseHacia(IDireccion direccion) {
        direccion.moverseHacia(this, this.esquina);
        movimientos++;
    }

    public int getMovimientos() {
        return movimientos;
    }

    public String getNick() {
        return this.nick;
    }

    public int getX() {
        return this.esquina.getX();
    }

    public int getY() {
        return this.esquina.getY();
    }

    public IVehiculo getVehiculo(){
        return this.vehiculo;
    }
}
