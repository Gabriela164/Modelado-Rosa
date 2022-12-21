/**
* Interfaz IObjetoEspecialKorby, que implementa la clase ObjetoEspecialKorby.
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public interface IObjetoEspecialKorby{

   /**
     * Método encargado de regresar el ataque otorgado por el Objeto Especial
     */
    public int getAtaqueNuevo();

    /**
     * Método encargado de asignar el ataque que otorgará el Objeto especial
     * @param newAtaque nuevo daño de ataque a asignar
     */
    public void setAtaqueNuevo(int newAtaque);

    /**
     * Método encargado de regresar la nueva defensa otrogada por el powerUp
     * @return La nueva defensa 
     */
    public int getDefensaNuevo();

    /**
     * Método encargado de asignar la nueva defensa otorgada por el powerUp
     * @param newDefensa nueva defensa a asignar  
     */
    public void setDefensaNuevo(int newDefensa);

    /**
     * Método encargado de regresar el nombre de la habilidad
     * @return el nombre de la habilidad
     */
    public String getNombreNuevo();

    /**
     * Método encargado de asignar el nuevo nombre de la habilidad
     * @param newNombre nuevo nombre a asignar 
     */
    public void setNombreNuevo(String newNombre);

    /**
     * Método encargado de regresar las caracteristicas de la habilidad en forma de cadena 
     */
    public String toString();
	
}