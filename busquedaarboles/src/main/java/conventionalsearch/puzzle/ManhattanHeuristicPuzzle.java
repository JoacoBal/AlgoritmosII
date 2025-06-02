package conventionalsearch.puzzle;

import conventionalsearch.Heuristic;

public class ManhattanHeuristicPuzzle implements Heuristic<StatePuzzle>{

    @Override
    public int estimate(StatePuzzle state) {
        int [][] board = state.getBoard();
        int distanciaTotal = 0;

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                int valor = board[i][j];
                if(valor != 0){
                    int objetivoFila = (valor - 1) / 4;
                    int objetivoColumna = (valor - 1) % 4;
                    distanciaTotal += Math.abs(i - objetivoFila) + Math.abs(j - objetivoColumna);
                }
            }
        }
        return distanciaTotal;
    }
    
}
