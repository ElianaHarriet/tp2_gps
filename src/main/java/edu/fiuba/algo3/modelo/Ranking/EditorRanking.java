package edu.fiuba.algo3.modelo.Ranking;

import java.util.*;

public class EditorRanking {
    private ArrayList<Jugada> ranking;
    final String path;

    public EditorRanking(String pathRanking) {
        this.ranking = new ArrayList<Jugada>();
        this.path = pathRanking;
    }

    public void guardarMovimientos(String nick, int movimientos) {
        Jugada jugada = new Jugada(nick, movimientos);
        ranking.add(jugada);
        guardarRanking();
    }

    public void guardarRanking() {
        FormatoJson jsonRanking = new FormatoJson(this.path);
        for (Jugada jugada : ranking) {
            jsonRanking.guardarElemento(jugada.getNick(), jugada.getMovimientos());
        }
    }

    public String obtenerRankingComoString() {
        FormatoJson lectorRanking = new FormatoJson(this.path);
        ranking = lectorRanking.convertirJsonALista();
        Collections.sort(ranking);
        String rankingString = "";
        for (Jugada jugada : ranking) {
            rankingString += "✩-- " + jugada.getNick() + "\t--✩--\t" + jugada.getMovimientos() + " --✩\n";
        }
        return rankingString;
    }

    public void vaciarRanking() {
        FormatoJson ranking = new FormatoJson(this.path);
        ranking.vaciarArchivo();
    }
}
