package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public class ConstructorTablero implements IConstructor{
    Esquina esquinaInicial;
    public ConstructorTablero() {

    }

    public void crearConTamanio(int m, int n) {

    }

    @Override
    public Esquina getResultado() {
        return this.esquinaInicial;
    }
}
