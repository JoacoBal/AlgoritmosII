package conventionalsearch.queens;

import conventionalsearch.State;
import conventionalsearch.StateProblem;
import conventionalsearch.engine.BFSEngine;

public class Main8Queens {
    public static void main(String[] args) {
        //Creamos el problema
        StateProblem8Queens problem = new StateProblem8Queens();
        //Creamos el motor bfs
        BFSEngine<State8Queens, StateProblem8Queens> motor = new BFSEngine<>(problem);

        //Ejecutamos la busqueda
        motor.performSearch();
    }
}
