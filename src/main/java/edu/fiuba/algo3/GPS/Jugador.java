package edu.fiuba.algo3.GPS;

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

    public void setVehiculo(IVehiculo vehiculo){
        this.vehiculo = vehiculo;
    }



    public int cantMovimientos(){
        return this.movimientos;
    }

    public boolean estaEnDestino(){
        return this.esquina.esDestino();

    }

    public void actualizarEstado(Esquina siguienteEsquina, ISorpresa sorpresa, IObstaculo obstaculo){
        //this.vehiculo.atravesarPozo(this.movimientos); //provisorio
        this.movimientos += this.vehiculo.atravesarObstaculo(obstaculo);
    }

}