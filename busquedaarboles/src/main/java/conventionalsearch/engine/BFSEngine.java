package conventionalsearch.engine;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import conventionalsearch.Engine;
import conventionalsearch.State;
import conventionalsearch.StateProblem;

public class BFSEngine <S extends State, P extends StateProblem<S>> implements Engine<S, P> {

    private final P problem;

    public BFSEngine(P problem){
        this.problem = problem;
    }

    @Override
    public void performSearch() {
        Queue<S> queue = new LinkedList<>();
        Set<S> visited = new HashSet<>();

        S initial = problem.initialState();
        queue.add(initial);
        visited.add(initial);

        while(!queue.isEmpty()){
            S actual = queue.poll();

            if(actual.isSuccess()){
                System.out.println("Solucion encontrada!!");
                problem.getPath(actual);
                return;
            }

            for(S sucesor : problem.getSuccesors(actual)){
                if(!visited.contains(sucesor)){
                    visited.add(sucesor);
                    queue.add(sucesor);
                }
            }
        }
        System.out.println("No se encontro ninguna solucion..");

    }
}
    

