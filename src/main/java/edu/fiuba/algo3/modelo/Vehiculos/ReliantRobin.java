package edu.fiuba.algo3.modelo.Vehiculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Obstaculos.IObstaculo;
import edu.fiuba.algo3.modelo.Sorpresas.ISorpresa;
import java.util.Random;

public class ReliantRobin implements IVehiculo {

    private int actuaComoObstaculo(IObstaculo obstaculo, float randomNumber) {
        return randomNumber < 0.6 ? obstaculo.penalizar(new Auto()): obstaculo.penalizar(new Moto());
    }

    public int atravesarObstaculo(IObstaculo obstaculo) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return actuaComoObstaculo(obstaculo, randomNumber);
    }

    public IVehiculo actualizarVehiculo(ISorpresa sorpresa) {
        return sorpresa.intercambiarVehiculo(this);
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, IObstaculo obstaculo) {
        Random random = new Random(System.currentTimeMillis());
        float randomNumber = random.nextFloat();
        return randomNumber < 0.6 ? obstaculo.siguienteEsquina(origen, destino, new Auto()) : obstaculo.siguienteEsquina(origen, destino, new Moto());
    }

    public boolean equals(Object otroVehiculo) {
        return otroVehiculo instanceof Moto;
    }

    // Metodo para probar y que no se comporte de forma random
    public int atravesarObstaculo(IObstaculo obstaculo, float randomNumber) {
        return actuaComoObstaculo(obstaculo, randomNumber);
    }
}
