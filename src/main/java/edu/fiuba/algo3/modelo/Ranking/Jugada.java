package edu.fiuba.algo3.modelo.Ranking;


public class Jugada implements Comparable<Jugada> {

    private String nick;
    private int movimientos;

    public Jugada(String nick, int movimientos) {
        this.nick = nick;
        this.movimientos = movimientos;
    }

    @Override
    public int compareTo(Jugada otra) {
        return this.movimientos - otra.movimientos;
    }

    public String getNick() {
        return nick;
    }

    public int getMovimientos() {
        return movimientos;
    }
}
