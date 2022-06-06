package edu.fiuba.algo3.GPS;


public class Esquina {
    boolean esDestino;
    Calle adyacenteN;
    Calle adyacenteS;
    Calle adyacenteW;
    Calle adyacenteE;

    public Esquina(){

    }
    public Esquina crearEsquina(boolean esDestino){
        Esquina esquina = new Esquina();
        esquina.esDestino = esDestino;
        return Esquina;

    }

    public boolean esDestino(){
        return this.esDestino;
    }
}

