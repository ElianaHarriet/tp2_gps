package edu.fiuba.algo3.modelo.Obstaculos;


import edu.fiuba.algo3.modelo.Vehiculos.IVehiculo;

public interface IAtravesable {

    int atravesar(IVehiculo vehiculo); //
        //return movimientos * cuentita random

    /* para sorpresas:
            hacer lo que sea necesario.
            movi = vehiculo.movimientos() --> el vehiculo deberia saber eso? no es mas del jugador?
       para obstaculos:
            igual como esta.

    @Override
    IVehiculo atravesar(IVehiculo vehiculo);
        // cambiar el vehiculo

    * */
}

//PASA  LOSIGUIENTE: LOS OBSTACULOS TIENEN UN METODO POR CADA IVEHICULO
//                   LAS SORPRESAS RECIBEN INT MOVIMIENTO (Y) -> haer que sproresa tambien reciba ivehiculo funcionara?
// probar