package conventionalsearch.examples.jarra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import conventionalsearch.StateProblem;

public class StatesProblemJarra implements StateProblem<StatesJarra> {

    @Override
    public List<StatesJarra> getSuccesors(StatesJarra state) {
        List<StatesJarra> sucesores = new ArrayList<>();
        int a = state.getA();
        int b = state.getB();

        //Llenar jarra A
        sucesores.add(new StatesJarra(4, b, state));

        //Llenar jarra B
        sucesores.add(new StatesJarra(a, 3, state));

        //Vaciar jarra A
        sucesores.add(new StatesJarra(0, b, state));

        //Vaciar jarra B
        sucesores.add(new StatesJarra(a, 0, state));

        //Volcar A en B
        if(a > 0 && b < 3){
        int transferAB = Math.min(a, 3 - b);
        sucesores.add(new StatesJarra(a - transferAB, transferAB + b, state));
        }

        if(b > 0 && a < 4){
        //Volcar B en A
        int transferBA = Math.min(b, 4 - a);
        sucesores.add(new StatesJarra(transferBA + a, b - transferBA, state));
        }

        return sucesores;
    }
    

    @Override
    public void getPath(StatesJarra stateFinal) {
        List<StatesJarra> camino = new ArrayList<>();
        StatesJarra actual = stateFinal;

        while(actual != null){
            camino.add(actual);
            actual = (StatesJarra) actual.getParent();
        }

        Collections.reverse(camino);
        System.out.println("Camino hasta la solucion");
        for(StatesJarra e : camino){
            System.out.println(e);
        }
    }


    @Override
    public StatesJarra initialState() {
        return new StatesJarra(0,0,null);
    }
}
     
