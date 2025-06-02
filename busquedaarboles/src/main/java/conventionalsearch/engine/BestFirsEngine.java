package conventionalsearch.engine;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import conventionalsearch.Engine;
import conventionalsearch.Heuristic;
import conventionalsearch.State;
import conventionalsearch.StateProblem;

public class BestFirsEngine <S extends State, P extends StateProblem<S>> implements Engine <S,P>{
    
    private final P problem;
    private final Heuristic<S> heuristic;

    public BestFirsEngine(P problem, Heuristic<S> heuristic){
        this.problem = problem;
        this.heuristic = heuristic;
    }

    @Override
    public void performSearch(){
        //Cola de prioridad ordenado por el valor heurístico(menor primero)
        PriorityQueue<S> open = new PriorityQueue<>(Comparator.comparingInt(heuristic::estimate));
        Set<S> visited = new HashSet<>();

        S initial = problem.initialState();
        open.add(initial);

        while(!open.isEmpty()){
            S current = open.poll();

            if(visited.contains(current)){
                continue;
            }

            visited.add(current);

            if(current.isSuccess()){
                System.out.println("Solucion encontrada utilizando Heuristica!!");
                problem.getPath(current);
                return;
            }

            for(S successor : problem.getSuccesors(current)){
                if(!visited.contains(successor)){
                    open.add(successor);
                }
            }
        }
        System.out.println("No se encontró ninguna solucion..");
    }
}
