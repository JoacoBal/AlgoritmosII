package conventionalsearch.queens;

import java.util.Arrays;

import conventionalsearch.State;

public class State8Queens implements State {
    private final int[] queenPositions; //Indice = fila, valor = columna de la reina en esa fila
    private final State8Queens parent; //Estado padre para construir el camino
    private final int cantQueens; // fila donde se coloco la última reina (o numero de reinas colocadas) 

    private static final int SIZE = 8;

    //Constructor para estado inicial, sin reinas colocadas
    public State8Queens(){
        this.queenPositions = new int[SIZE];
        Arrays.fill(this.queenPositions, -1); //-1 significa sin reina colocada
        this.parent = null;
        this.cantQueens = 0; //Aun no colocamos ninguna reina
    }

    //Constructor para el estado sucesor
    public State8Queens(int [] queenPositions, State8Queens parent, int cantQueens){
        this.queenPositions = Arrays.copyOf(queenPositions, SIZE);
        this.parent = parent;
        this.cantQueens = cantQueens; //Fila donde se acaba de colocar una reina
    }

    //Getter para saber la cantidad de reinas colocadas
    public int getCantQueens(){
        return cantQueens;
    }

    //Getter para la posicion de las reinas (puede servir para generar sucesores)
    public int[] getQueenPositions(){
        return queenPositions;
    }

    @Override
    public boolean isSuccess(){
        return cantQueens == SIZE;
    }

    @Override
    public State getParent(){
        return parent;
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(!(o instanceof State8Queens)){
            return false;
        }
        State8Queens other = (State8Queens) o;
        return Arrays.equals(this.queenPositions, other.queenPositions);
    }

    @Override
    public int hashCode(){
        return Arrays.hashCode(queenPositions);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int r = 0; r < SIZE; r++){
            for(int c = 0; c < SIZE; c++){
                if(queenPositions[r] == c){
                    sb.append("Q ");
                }else{
                    sb.append(". ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //Verificamos si la posicion (fila, columna) es segura para colocar una reina
    public boolean isSafe(int fila, int columna){
        // Recorremos todas las reinas ya colocadas (de 0 hasta fila - 1)
        for(int existeFila = 0; existeFila < fila; existeFila++){
                int existeColumna = queenPositions[existeFila];

                //Esta en la misma columna?
                if(existeColumna == columna){
                    return false;
                }

                //Estan en la misma diagonal?
                //Dos reinas estan en la misma diagonal si la diferencia de filas es igual a la diferencia de columnas
                int filaDiferencia = Math.abs(existeFila - fila);
                int columnaDiferencia = Math.abs(existeColumna - columna);
                if(filaDiferencia == columnaDiferencia){
                    return false;
                }
        }
        return true;
    }



}