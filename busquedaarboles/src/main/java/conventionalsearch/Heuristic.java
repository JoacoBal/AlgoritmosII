package conventionalsearch;

public interface Heuristic <S extends State> {
    //Devuelve un entero que representa la estimación de lo "lejos" que esta State del objetivo, cuanto menor mejor
    int estimate(S state); 
}
