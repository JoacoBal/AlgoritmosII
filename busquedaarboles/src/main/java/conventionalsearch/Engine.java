package conventionalsearch;

public interface Engine <S extends State, P extends StateProblem<S>> {
    /*
     * Metodo para realizar la busqueda en el arbol
     */
    void performSearch();
    
}
