package conventionalsearch.puzzle;

import conventionalsearch.engine.BFSEngine;
import conventionalsearch.StateProblem;

public class MainPuzzle {

    public static void main(String[] args) {
        int[][] tableroInicial = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 0, 14, 15}
    };
        StatePuzzle estadoInicial = new StatePuzzle(tableroInicial, null);
        StateProblemPuzzle problema = new StateProblemPuzzle(estadoInicial);

        BFSEngine<StatePuzzle, StateProblem<StatePuzzle>> motor = new BFSEngine<>(problema);
        motor.performSearch(); // Busca e imprime el camino
    }
}
