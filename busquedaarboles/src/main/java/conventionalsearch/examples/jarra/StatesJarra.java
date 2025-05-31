package conventionalsearch.examples.jarra;

import java.util.Objects;

import conventionalsearch.State;

public class StatesJarra implements State{
    
    private int a;
    private int b;
    private State parent;

    public StatesJarra(int a, int b, State parent) {
        this.a = a;
        this.b = b;
        this.parent = parent;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean isSuccess() {
        return a == 2; // Esta lógica depende del problema concreto
    }

    @Override
    public State getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StatesJarra)) return false;
        StatesJarra other = (StatesJarra) o;
        return a == other.a && b == other.b;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ")";
    }

}
