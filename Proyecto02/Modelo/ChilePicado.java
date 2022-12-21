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
* En este caso en concreto, define pequeños trozos de chile picado.
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public class ChilePicado extends IngredienteDecorador{

    /**
    * Constructor de la clase, permite al ingrediente decorar al hot dog base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param hotDogLoco_centro núcleo a decorar.
    **/
    public ChilePicado(HotDogLoco hotDogLoco_centro) {
        super(hotDogLoco_centro);
    }

    /**
    * Declaración del método que retorna la descripción del complemento añadido.
    * @return cadena que nos indica que al hot dog se le aplicó una pequeña porción de
    * trozos de chile picado.    
    **/
    @Override public String getDescripcion(){
        return hotDogLoco_centro.getDescripcion() + ", chile picado";
    }

    /**
    * Declaración del método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo total del hot dog junto con la aplicación de pequeños
    * trozos de chile picado.  
    **/  
    @Override public int getPrecio(){
        return hotDogLoco_centro.getPrecio() + 1;
    }
    
    
}
