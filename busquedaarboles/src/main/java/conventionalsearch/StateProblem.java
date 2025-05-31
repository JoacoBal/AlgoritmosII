package conventionalsearch;

import java.util.List;

public interface StateProblem <S extends State>{

    /*
     * Metodo para inicializar la busqueda, es el estado inicial generico
     */
    S initialState();

    /*
     * Metodo para poder obtener los sucesores, es decir, las reglas de avance
     */
    List<S> getSuccesors(S state);
    /*
     * Metodo para reconstruir el camino que llegue al estado correcto
     */
    void getPath(S stateFinal);
}
