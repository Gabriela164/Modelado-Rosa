/**
* Clase de los Objetos especiales que sirven como aumento de podere para MeganMan.
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class ObjetoEspecialMeganMan implements IObjetoEspecialMeganMan{
	
	private int defensa;
	private String nombre;
	private int ataque;

	/**
     * Constructor de la clase ObjetoEspecialDittu
     * @param ataque el ataque que tendrá la habilidad
     * @param defensa la defensa que tendrá la habilidad
     * @param nombre nombre que tendrá la habilidad
     */
    public ObjetoEspecialMeganMan(int ataque, int defensa, String nombre){
        this.ataque = ataque;
        this.defensa = defensa;
        this.nombre = nombre;
    }

    /**
     * Método encargado de regresar el ataque otorgado por el Objeto Especial
     */
    public int getAtaqueNuevo(){
        return ataque;
    }

    /**
     * Método encargado de asignar el ataque que otorgará el Objeto especial
     * @param newAtaque nuevo daño de ataque a asignar
     */
    public void setAtaqueNuevo(int newAtaque){
        ataque = newAtaque;
    }

    /**
     * Método encargado de regresar la nueva defensa otrogada por el powerUp
     * @return La nueva defensa 
     */
    public int getDefensaNuevo(){
        return defensa;
    }

    /**
     * Método encargado de asignar la nueva defensa otorgada por el powerUp
     * @param newDefensa nueva defensa a asignar  
     */
    public void setDefensaNuevo(int newDefensa){
        defensa = newDefensa;
    }

    /**
     * Método encargado de regresar el nombre de la habilidad
     * @return el nombre de la habilidad
     */
    public String getNombreNuevo(){
        return nombre;
    }

    /**
     * Método encargado de asignar el nuevo nombre de la habilidad
     * @param newNombre nuevo nombre a asignar 
     */
    public void setNombreNuevo(String newNombre){
        nombre = newNombre;
    }

    /**
     * Método encargado de regresar las caracteristicas de la habilidad en forma de cadena 
     */
    public String toString(){
        return "MeganMan adquirió el objeto " + nombre + " con las siguientes características: " + "\n" + 
                    " Daño: " + ataque + "\n" +
                    " Defensa: " + defensa;
    }
}