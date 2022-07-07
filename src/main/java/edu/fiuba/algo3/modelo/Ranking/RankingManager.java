package edu.fiuba.algo3.modelo.Ranking;


public class RankingManager {
    private EditorRanking editorRanking;

    public RankingManager(String path){
        this.editorRanking = new EditorRanking(path);
    }

    public String obtenerRanking() {
        return this.editorRanking.obtenerRankingComoString();
    }

    public void guardarNuevaPuntuacion(String nick, int movimientos) {
        this.editorRanking.guardarMovimientos(nick, movimientos);
    }

    public void limpiarRanking(){
        this.editorRanking.vaciarRanking();
    }

}
