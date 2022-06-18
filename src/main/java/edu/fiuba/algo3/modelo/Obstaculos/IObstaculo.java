package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;

public interface IObstaculo {

    int penalizar(Auto auto);

    int penalizar(Camioneta camioneta);

    int penalizar(Moto moto);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Auto auto);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Camioneta camioneta);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Moto moto);

}

