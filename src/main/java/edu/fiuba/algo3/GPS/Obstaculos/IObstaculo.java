package edu.fiuba.algo3.GPS.Obstaculos;

import edu.fiuba.algo3.GPS.Vehiculos.Auto;
import edu.fiuba.algo3.GPS.Vehiculos.Camioneta;
import edu.fiuba.algo3.GPS.Vehiculos.Moto;

public interface IObstaculo {

    int penalizar(Auto auto);

    int penalizar(Camioneta camioneta);

    int penalizar(Moto moto);


}

