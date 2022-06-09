package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.Vehiculo;

public class SorpresaCambioVehiculo implements ISorpresa {
    /*
    *  Si es una moto, la convierte en auto.
    * Si es un auto lo convierte en 4x4.
    * Si es una 4x4 la convierte en moto.
     * */
    /*final HashMap<Vehiculo, Vehiculo> vehiculos;

    public SorpresaCambioVehiculo() {
        this.vehiculos = new HashMap<>();
        vehiculos.put(Moto.class, Auto.class);
        vehiculos.put(Auto.class, Camioneta.class);
        vehiculos.put(Camioneta.class, Moto.class);
        //Bueno no se puede hacer asi, pero capaz hay una forma mas linda con esa idea
    }*/

    public int aplicar(Vehiculo vehiculo, int movimientos) {
        return 3;//vehiculos(vehiculo);
        // o jugador.setVehiculo(tukituki) pero no se si deberia tocar eso desde aca
    }
}
