package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.*;



public class Camioneta implements IVehiculo {

    private int pozos;

    public Camioneta() {
        pozos = 0;
    }

    public int atravesarObstaculo(Pozo obstaculo) {
        this.pozos++;
        return this.pozos % 3 == 0 ? 2 : 0; // Ver si se puede hacer un refactor para no usar if
    }

    public int atravesarObstaculo(IObstaculo obstaculo) {
        return obstaculo.penalizar(this);
    }


    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, IObstaculo obstaculo) {
        return obstaculo.siguienteEsquina(origen, destino, this);
    }

    public boolean equals(Object otro) { //exclusivo para pruebas
        return otro instanceof Camioneta;
    }
}
