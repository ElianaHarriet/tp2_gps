package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;

public class Camioneta implements IVehiculo {

    private int pozos;

    public Camioneta() {
        pozos = 0;
    }

    public int atravesarObstaculo(IObstaculo obstaculo) {
        pozos = pozos % 3;
        pozos += obstaculo.return1SiEsPozo();
        return obstaculo.penalizar(this) + (int)Math.floor(pozos / 3) * 2;
    }

    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    public boolean equals(Object otro) {
        return otro instanceof Camioneta;
    }
}
