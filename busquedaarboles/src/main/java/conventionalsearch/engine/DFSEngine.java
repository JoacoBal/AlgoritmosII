package conventionalsearch.engine;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import conventionalsearch.Engine;
import conventionalsearch.State;
import conventionalsearch.StateProblem;

public class DFSEngine <S extends State, P extends StateProblem<S>> implements Engine<S, P>{

    private final P problem;

    public DFSEngine(P problem){
        this.problem = problem;
    }

    @Override
    public void performSearch() {
    Stack <S> stack = new Stack<>();
        Set<S> visitados = new HashSet<>();

        S inicial = problem.initialState();
        stack.push(inicial);

        while(!stack.isEmpty()){
            S actual = stack.pop();

            if(visitados.contains(actual)){
                continue;
            }
                visitados.add(actual);

            if(actual.isSuccess()){
                System.out.println("Solucion encontrada!!");
                problem.getPath(actual);
                return;
            }

            for(S sucesor : problem.getSuccesors(actual)){
                if(!visitados.contains(sucesor)){
                    stack.push(sucesor);
                }
            }
        }
        
        System.out.println("No se encontraron caminos posibles en DFS..");
    }
}
