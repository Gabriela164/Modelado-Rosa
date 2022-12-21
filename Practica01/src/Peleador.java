 /**
* Clase abstracta Peleador, que sirve como molde para las clases de los peleadores.
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
 public abstract class Peleador{
    protected int danio; 
    protected int defensa; 
    protected int vida;  

    /**
     * Constructor de la clase Peleador, encargado de darle valores enteros a la vida, defensa y ataque.
     */
    public Peleador(){
        this.danio = 1;
        this.defensa = 1;
        this.vida = 15;
    }

    /**
     * Método encargado de avisar la defensa, y la nueva vida del Peleador. 
     */
    public abstract void defensa();

    /**
     * Método encargado de avisar cuando el Peleador hace un ataque, mostrando el daño en un entero.
     */
    public abstract void ataque();

    /**
     * Método encargado de avisar cuando el peleador recibe daño, además muestra cuánto recibió.
     */
    public abstract void recibeDanio(int n);

    /**
     * Método encargado de regresar el daño actual del Peleador
     * @return danio, el daño del Peleador.
     */
    public int getDanio(){
        return danio;
    }

    /**
     * Método encargado de asignar el nuevo daño del Peleador
     * @param danioNuevo nuevo daño a asignar.
     */
    public void setDanio(int danioNuevo){
        danio = danioNuevo;
    }

    /**
     * Método encargado de regresar la defensa actual del Peleador
     * @return defensa, la defensa del Peleador.
     */
    public int getDefensa(){
        return defensa;
    }

    /**
     * Método encargado de asignar la nueva defensa del Peleador
     * @param defensaNueva nueva defensa a asignar.
     */
    public void setDefensa(int defensaNueva){
        defensa = defensaNueva;
    }

    /**
     * Método encargado de regresar la vida actual del Peleador
     * @return vida, la vida del Peleador.
     */
    public int getVida(){
        return vida;
    }

    /**
     * Método encargado de asignar la nueva vida del Peleador
     * @param vidaNueva nueva vida a asignar.
     */
    public void setVida(int vidaNueva){
        vida = vidaNueva;
    }
}