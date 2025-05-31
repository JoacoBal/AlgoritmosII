package conventionalsearch.puzzle;

import java.util.Arrays;

import conventionalsearch.State;

public class StatePuzzle implements State {

    private final int [][] board; //Tablero 4x4
    private final StatePuzzle parent; 
    private static final int SIZE = 4; //4x4

    public StatePuzzle(int [][] board, StatePuzzle parent){
        this.board = new int[SIZE][SIZE];
        for(int i = 0; i < SIZE; i++){
            this.board[i] = Arrays.copyOf(board[i], SIZE);
        }
        this.parent = parent;
    }

    public int [][] getBoard(){
        return board;
    }

    @Override
    public boolean isSuccess() {
        //Verificamos si el tablero esta ordenado
        int expected = 1;
        for(int i = 0; i < SIZE; i++){
            for(int j = 0; j < SIZE; j++){
                //Ultima posicion debe ser 0 (espacio vacio)
                if(i == SIZE - 1 && j == SIZE - 1){
                    if(board[i][j] != 0){
                        return false;
                    }
                }else{
                        if(board[i][j] != expected){
                            return false;
                        }
                        expected++;
                    }
                }
            }
        return true;
    }

    @Override
    public State getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof StatePuzzle)){
            return false;
        }
        StatePuzzle other = (StatePuzzle) o;
        for(int i = 0; i < SIZE; i++){
            if(!Arrays.equals(this.board[i], other.board[i])){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode(){
        int result = 1;
        for(int i = 0; i < SIZE; i++){
            result = 31 * result + Arrays.hashCode(board[i]);
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int[] row : board){
            for(int val : row){
                sb.append(val == 0 ?" " : String.format("%2d", val)).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    
}
