package conventionalsearch;

public interface State  {

    
    /*
     * Determina si este estado es un estado final correcto
     */

     boolean isSuccess();

     /*
      * Devuelve el estado padre que llevo a ese estado (se utiliza para reconstruir el camino)
      */
      State getParent();

      /*
       * Representacion del estado
       */

       String toString();

       /*
        * Es importante sobreescribir equals y hashCode para evitar ciclos en la busqueda
        */
        @Override
        boolean equals(Object obj);

        @Override
        int hashCode();
}
