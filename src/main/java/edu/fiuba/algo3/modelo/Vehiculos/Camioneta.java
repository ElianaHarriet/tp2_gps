package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Obstaculos.*;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;;



public class Camioneta implements IVehiculo {

    private int pozos;

    public Camioneta() {
        pozos = 0;
    }

    public int atravesarObstaculo(Pozo obstaculo){
        this.pozos++;
        if (this.pozos % 3 == 0) {return 2;}
        return 0;
    }

    public int atravesarObstaculo(IObstaculo obstaculo) {
        return obstaculo.penalizar(this);

        //pozos = pozos % 3;
        //pozos += obstaculo.return1SiEsPozo();
        //return obstaculo.penalizar(this) + (int)Math.floor(pozos / 3) * 2;
    }


    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    public boolean equals(Object otro) { //exclusivo para pruebas
        return otro instanceof Camioneta;
    }
}
