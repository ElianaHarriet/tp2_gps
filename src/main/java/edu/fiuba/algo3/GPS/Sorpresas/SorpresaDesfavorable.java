package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;


public class SorpresaDesfavorable implements IAtravesable {

    public int atravesar(int movimientos){
        return movimientos - (movimientos * (20/100));
    }
}
