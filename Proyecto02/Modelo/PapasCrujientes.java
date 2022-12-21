package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Controlador.*;
import Vista.*;

/**
* Clase que define un decorador para añadir nuevos comportamientos o modificar los ya existentes, 
* de aquel núcleo al que envuelven, ésto según lo estipulado por el patrón de diseño Decorator. 
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public class PapasCrujientes extends IngredienteDecorador{
    
    /**
    * Constructor de la clase, permite al ingrediente decorar al hot dog base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param hotDogLoco_centro núcleo a decorar
    **/
    public PapasCrujientes(HotDogLoco hotDogLoco_centro) {
        super(hotDogLoco_centro);
    }
    
    /**
    * Declaración del método que retorna la descripción del hot dog con complemento añadido.
    * @return cadena que nos indica que al hot dog se le añadieron papas crujientes   
    **/
    @Override public String getDescripcion(){
        return hotDogLoco_centro.getDescripcion() + ", papas crujientes";
    }
    
    /**
    * Declaración del método que retorna el precio del hot dog una vez se le 
    * añadió el complemento.
    * @return número de coma flotante de precisión doble que nos indica el precio
    * del hot dog más el precio unitario de la porción de papas crujientes    
    **/  
    @Override public int getPrecio(){
        return hotDogLoco_centro.getPrecio() + 1;
    }
    
}