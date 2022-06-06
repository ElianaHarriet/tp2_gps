package edu.fiuba.algo3.GPS;

public class Jugador {
    int movimientos;
    String nick;
    Esquina posicion;
    Vehiculo vehiculo;

    public Jugador() {
        this.movimientos = 0;
        this.posicion = new Esquina();
    }

    public void setVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }


    public Jugador crearJugadorConNombre(String unNombre){
        Jugador jugador = new Jugador();

        jugador.nick = unNombre;
        return jugador;
    }

    public int cantMovimientos(){
        return this.movimientos;
    }

    public boolean estaEnDestino(){
        return this.posicion.esDestino();

    }

    public actualizarEstado(Esquina siguienteEsquina,Sorpresa sorpresa, Obstaculo obstaculo){
        this.vehiculo.atravesarObstaculo(obstaculo);
    }

}