package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;

public class ObstaculoNulo implements IObstaculo {

    public int penalizar(Auto auto) {
        return 0;
    }

    public int penalizar(Camioneta camioneta) {
        return 0;
    }

    public int penalizar(Moto moto) {
        return 0;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Auto auto) {
        return destino;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Camioneta camioneta) {
        return destino;
    }

    @Override
    public Esquina siguienteEsquina(Esquina origen, Esquina destino, Moto moto) {
        return destino;
    }
}
