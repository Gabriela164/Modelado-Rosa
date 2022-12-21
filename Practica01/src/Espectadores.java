/**
* Clase de Espectadores encargada de crear Espectadores del Combate
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Espectadores implements Observador{

    // Atributos de un espectador
    String nombre; 
    Peleador apoyaPersonaje; //Personaje que apoyara en la pelea
    Combate pelea; //Combate en el que participara
    Bitacora bitacora; //Bitacora que se encarga de guardar los detalles de la pelea

    /**
     * Actualiza los detalles de la pelea
     */
    @Override
    public void actualizar(){
        bitacora = pelea.getBitacora();
    }

    /* Constructor 
     * @param nombre, nombre del espectador
     * @param personaje, personaje que apoyara en la pelea
     * @param pelea, combate en el que participara
     */
    public Espectadores(String nombre, Peleador apoyaPersonaje, Combate pelea){
        this.nombre = nombre; 
        this.apoyaPersonaje = apoyaPersonaje;
        this.pelea = pelea;
        this.bitacora = pelea.getBitacora();
    }
    
    /**
     * Método encargado de regresar el peleador que apoya el espectador
     * @return el nombre del espectador
     */
    public Peleador getApoyaPersonaje(){
        return apoyaPersonaje;
    }

    /**
     * Método encargado de asignar el peleador al que apoya el espectador
     * @param apoyaPersonaje personaje a asignar
     */
    public void setApoyaPersonaje(Peleador apoyaPersonaje){
        this.apoyaPersonaje = apoyaPersonaje;
    }

    /**
     * Método encargado de asignar el nombre del espectador
     * @param nombre nombre a asignar
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    /**
     * Método encargado de regresar el nombre del espectador
     * @return el nombre del espectador
     */
    public String getNombre(){
        return nombre;
    }

}
