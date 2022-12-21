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
* En este caso en concreto, define una aplicación (una unción, un chorro) de mayonesa clásica.
* @author Gabby, SanNa, Immerwahr.
* @version 1.1 
**/
public class Mayonesa extends IngredienteDecorador{
    
    /**
    * Constructor de la clase, permite al ingrediente decorar al hot dog base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param hotDogLoco_centro núcleo a decorar
    **/
    public Mayonesa(HotDogLoco hotDogLoco_centro) {
        super(hotDogLoco_centro);
    }
    
    /**
    * Declaración del método que retorna la descripción del hot dog con complemento añadido.
    * @return cadena que nos indica que al hot dog se le aplicó una porción de
    * mayonesa.    
    **/
    @Override public String getDescripcion(){
        return hotDogLoco_centro.getDescripcion() + ", Mayonesa";
    }
    
    /**
    * Declaración del método que retorna el precio del hot dog una vez se le 
    * añadió el complemento.
    * @return número de coma flotante de precisión doble que nos indica el precio
    * del hot dog más el precio unitario de la porción de mayonesa.    
    **/   
    @Override public int getPrecio(){
        return hotDogLoco_centro.getPrecio() + 1;
    }
    
}