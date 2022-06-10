package edu.fiuba.algo3.GPS.Sorpresas;

import edu.fiuba.algo3.GPS.Obstaculos.IAtravesable;


public abstract class SorpresaDesfavorable implements IAtravesable {

    public int aplicar(int movimientos){
        return movimientos - (movimientos * (20/100));
    }
}
