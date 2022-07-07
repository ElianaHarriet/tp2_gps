package edu.fiuba.algo3.modelo.Obstaculos;
import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class Piquete implements IObstaculo {
    public int penalizar(Auto auto) {

        return 0;
    }

    public int penalizar(Moto moto) {

        return 2;
    }

    public int penalizar(Camioneta camioneta) {
        return 0;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Auto auto) {
        return origen;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Camioneta camioneta) {
        return origen;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Moto moto) {
        return destino;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, ReliantRobin reliantRobin) {
        return destino;
    }

}
