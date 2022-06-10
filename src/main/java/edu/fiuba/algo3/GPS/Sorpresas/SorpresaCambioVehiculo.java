package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Vehiculos.*;


public class SorpresaCambioVehiculo implements ISorpresa {

     /*
     moto --> auto.
     auto --> 4x4.
     4x4  --> moto.
     */
    final HashMap<IVehiculo, IVehiculo> vehiculos;

    public SorpresaCambioVehiculo() {
        this.vehiculos = new HashMap<>();
        vehiculos.put(Moto.class, Auto.class);
        vehiculos.put(Auto.class, Camioneta.class);
        vehiculos.put(Camioneta.class, Moto.class);
    }

    @Override
    public int aplicar(IVehiculo vehiculo, int movimientos) {
        //no me deja devolver IVehiculo, por eso sigue el int,
        // asi que el override esta al pedo creo
            vehiculo = vehiculos(vehiculo); //No se si el vehiculo que recibo funciona como puntero, espero que si
            return 0;
        }

        /*
        Otra opcion es
        @Override
        public int aplicar(IVehiculo vehiculo, int movimientos, Jugador jugador) {
            jugador.setVehiculo(vehiculos(vehiculo))
        }

        pero creo que rompo pilares con eso


        YYy falta agregar lo que se que necesite para poder usar el hashmap
         */

}

