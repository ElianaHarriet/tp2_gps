package edu.fiuba.algo3.GPS;

public class Jugador {
    int movimientos;
    String nick;
    Esquina esquina;
    Vehiculo vehiculo;

    public Jugador(Esquina esqInicial, String nick) {
        this.movimientos = 0;
        this.esquina = esqInicial;
        this.nick = nick;
    }

    public void setVehiculo(Vehiculo vehiculo) {
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

    public void actualizarEstado(Esquina siguienteEsquina, ISorpresa sorpresa, Obstaculo obstaculo) {
        this.movimientos += this.vehiculo.atravesarObstaculo(obstaculo);
    }

}