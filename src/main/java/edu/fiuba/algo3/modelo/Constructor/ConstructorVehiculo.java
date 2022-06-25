package edu.fiuba.algo3.modelo.Constructor;

import edu.fiuba.algo3.modelo.Mapa.Esquina;
import edu.fiuba.algo3.modelo.Vehiculos.*;


public class ConstructorVehiculo implements IConstructor{
    private IVehiculo vehiculo;
    public ConstructorVehiculo() {

    }

    public void crearVehiculo(String vehiculo) {
        switch (vehiculo) {
            case "auto":
                this.vehiculo = new Auto();
                break;
            case "camioneta":
                this.vehiculo = new Camioneta();
                break;
            case "moto":
                this.vehiculo = new Moto();
                break;
        }
    }


    public IVehiculo getResultado() {
        return this.vehiculo;
    }
}
