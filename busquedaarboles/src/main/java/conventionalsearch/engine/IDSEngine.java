package conventionalsearch.engine;

import java.util.HashSet;
import java.util.Set;

import conventionalsearch.Engine;
import conventionalsearch.State;
import conventionalsearch.StateProblem;

public class IDSEngine <S extends State, P extends StateProblem<S>> implements Engine<S, P>{

    private final P problem;

    public IDSEngine(P problem){
        this.problem = problem;
    }

    @Override
    public void performSearch() {
        int profundidadMaxima = 20; //Maximo razonable para este problema
        for(int limite = 0; limite <=profundidadMaxima; limite++){
            Set<S> visitados = new HashSet<>();
            if(dls(problem.initialState(), limite, visitados)){
                return;
            }
        }
        System.out.println("No se encontro ninguna solucion con IDS");
    }

    public boolean dls(S actual, int limite, Set<S> visitados){
        if(actual.isSuccess()){
            System.out.println("Se encontro una solucion!");
            problem.getPath(actual);
            return true;
        }
        if(limite == 0){
            return false;
        }

        for(S sucesor : problem.getSuccesors(actual)){
            if(!visitados.contains(sucesor)){
                if(dls(sucesor, limite-1, visitados)){
                    return true;
                }
            }
        }
        return false;
    }
    }
    

