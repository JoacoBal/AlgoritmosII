package conventionalsearch.queens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import conventionalsearch.StateProblem;

public class StateProblem8Queens implements StateProblem<State8Queens>{

    private final State8Queens initial;


    public StateProblem8Queens(){
        //Comenzamos con un tablero vacio, ninguna reina colocada
        this.initial = new State8Queens();
    }

    @Override
    public State8Queens initialState() {
        return initial;
    }

    @Override
    public List<State8Queens> getSuccesors(State8Queens state) {
        List<State8Queens> successors = new ArrayList<>();

        int fila = state.getCantQueens(); //Siguiente fila a colocar
        int[] posicionesActuales = state.getQueenPositions();

        if(fila >= 8){
            return Collections.emptyList(); //Ya hay 8 reinas, no hay sucesores
        }

        //Intentamos colocar una reina en cada columna de la fila actual
        for(int col = 0; col < 8; col++){
            if(state.isSafe(fila, col)){
                //Creamos un nuevo arreglo con la nueva reina
                int[] nuevoTablero = posicionesActuales.clone();
                nuevoTablero[fila] = col;

                //Creamos un nuevo estado con el nuevo tablero
                State8Queens nuevoEstado = new State8Queens(nuevoTablero, state, fila + 1);
                successors.add(nuevoEstado);
            }
        }
        return successors;
    }

    @Override
    public void getPath(State8Queens stateFinal) {
        List<State8Queens> path = new ArrayList<>();
        State8Queens actual = stateFinal;

        while(actual != null){
            path.add(actual); //Agregamos al principio para mantener el orden correcto
            actual = (State8Queens) actual.getParent();
        }

        //Imprimimos el camino completo
        for(int i = path.size() - 1; i >= 0; i--){
            System.out.println("Paso "+(path.size() - i - 1) + ":\n" + path.get(i));
        }
        }
    }
    
