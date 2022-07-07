package edu.fiuba.algo3.modelo.Obstaculos;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.Auto;
import edu.fiuba.algo3.modelo.Vehiculos.Camioneta;
import edu.fiuba.algo3.modelo.Vehiculos.Moto;
import edu.fiuba.algo3.modelo.Vehiculos.ReliantRobin;

public interface IObstaculo {

    int penalizar(Auto auto);

    int penalizar(Camioneta camioneta);

    int penalizar(Moto moto);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Auto auto);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Camioneta camioneta);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, Moto moto);

    Esquina siguienteEsquina(Esquina origen, Esquina destino, ReliantRobin reliantRobin);
}

