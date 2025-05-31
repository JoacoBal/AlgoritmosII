package conventionalsearch.puzzle;

import java.util.ArrayList;
import java.util.List;

import conventionalsearch.StateProblem;

public class StateProblemPuzzle implements StateProblem<StatePuzzle> {

    private final StatePuzzle initial;

    //Recibe el tablero inicial
    public StateProblemPuzzle(StatePuzzle initial){
        this.initial = initial;
    }

    @Override
    public StatePuzzle initialState() {
        return initial;
    }

    //Dependiendo el tablero, genera todos los posibles movimientos para mover una ficha en la posicion vacia 0
    @Override
    public List<StatePuzzle> getSuccesors(StatePuzzle state) {
        List<StatePuzzle> successors = new ArrayList<>();
        //Obtenemos el tablero actual que es una matriz 4x4
        int[][] board = state.getBoard();

        //Debemos buscar donde se encuentra el espacio vacio
        int vacioFila = -1, vacioColumna = -1;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(board[i][j] == 0){
                    vacioFila = i;
                    vacioColumna = j;
                    break;
                }
            }
        }

        //Para cada movimiento posible, intentamos mover el 0 (si es valido)

        //Mover arriba
        if(vacioFila > 0){
            int[][] nuevoTablero = copiarTablero(board);
            //Intercambiamos el 0 (posicion vacia) con la ficha de arriba
            nuevoTablero[vacioFila][vacioColumna] = nuevoTablero[vacioFila - 1][vacioColumna];
            nuevoTablero[vacioFila - 1][vacioColumna] = 0;
            successors.add(new StatePuzzle(nuevoTablero, state));
        }

        //Mover abajo
        if(vacioFila < 3){
            int[][] nuevoTablero = copiarTablero(board);
            //Intercambiamos el 0 (posicion vacia) con la ficha de abajo
            nuevoTablero[vacioFila][vacioColumna] = nuevoTablero[vacioFila + 1][vacioColumna];
            nuevoTablero[vacioFila + 1][vacioColumna] = 0;
            successors.add(new StatePuzzle(nuevoTablero, state));
        }

        //Mover derecha
        if(vacioColumna < 3){
            int[][] nuevoTablero = copiarTablero(board);
            //Intercambiamos el 0 (posicion vacia) con la ficha de la derecha
            nuevoTablero[vacioFila][vacioColumna] = nuevoTablero[vacioFila][vacioColumna + 1];
            nuevoTablero[vacioFila][vacioColumna + 1] = 0;
            successors.add(new StatePuzzle(nuevoTablero, state));
        }

        //Mover izquierda
        if(vacioColumna > 0){
            int[][] nuevoTablero = copiarTablero(board);
            //Intercambiamos el 0 (posicio vacia) con la ficha de la izquierda
            nuevoTablero[vacioFila][vacioColumna] = nuevoTablero[vacioFila][vacioColumna - 1];
            nuevoTablero[vacioFila][vacioColumna-1] = 0;
            successors.add(new StatePuzzle(nuevoTablero, state));
        }

        return successors;

    }

    //Reconstruye el camino 
    @Override
    public void getPath(StatePuzzle stateFinal) {
        List<StatePuzzle> path = new ArrayList<>();
        StatePuzzle actual = stateFinal;

        while(actual != null){
            path.add(actual);
            actual = (StatePuzzle) actual.getParent();
        }

        //Ahora lo imprimimos en el orden correcto
        for(int i = path.size()-1; i >= 0; i--){
            System.out.println("Tablero despues de " + (path.size() - i - 1) +" movimiento/s");
            System.out.println(path.get(i));
        }
    }

    private int [][] copiarTablero(int [][] original){
        int[][] copia = new int [4][4];
        for(int i = 0; i < 4;i++){
            System.arraycopy(original[i], 0, copia[i], 0, 4);
        }
        return copia;
    }
    
}
