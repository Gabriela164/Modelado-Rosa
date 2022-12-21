package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Controlador.*;
import Vista.*;

/**
* Clase abstracta a extender por aquellos objetos, que permiten añadir
* nuevos comportamientos o modificar los ya existentes, de aquel al que envuelven
* según lo estipulado por el patrón de diseño Decorator. 
* En este caso definen el complemento para un hot dog.
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public abstract class IngredienteDecorador implements HotDogLoco{
    
    /**
    * <code>baguette</code> objeto a ser decorado, conocido como núcleo.
    **/
    protected HotDogLoco hotDogLoco_centro;
    
    public IngredienteDecorador(HotDogLoco hotDogLoco_centro){
    	this.hotDogLoco_centro = hotDogLoco_centro;
    }
    
    /**
    * Declaración del método que retorna la descripción del complemento añadido.
    * @return cadena que nos indica que tipo de complemento fue añadido
    * al alimento.   
    **/
    @Override public abstract String getDescripcion();     

    /**
    * Declaración del método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo total del hot dog junto con la porción del complemento.  
    **/
    @Override public abstract int getPrecio();       

}
