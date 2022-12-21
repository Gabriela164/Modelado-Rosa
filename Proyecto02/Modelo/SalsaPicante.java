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
* En este caso en concreto, define una porción medida de salsa picante.
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public class SalsaPicante extends IngredienteDecorador{
   
    
    /**
    * Constructor de la clase, permite al ingrediente decorar al pan base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param hotDogLoco_centro núcleo a decorar
    **/
    public SalsaPicante(HotDogLoco hotDogLoco_centro) {
        super(hotDogLoco_centro);
    }
    
    /**
    * Declaración del método que retorna la descripción del sandwich con complemento añadido.
    * @return cadena que nos indica que al sandwich se le añadió una porción de carne de pollo.
    **/
    @Override public String getDescripcion(){
        return hotDogLoco_centro.getDescripcion() + ", salsa picante";
    }
    
    /**
    * Declaración del método que retorna el precio del sandwich una vez se le 
    * añadió el complemento.
    * @return número de coma flotante de precisión doble que nos indica el precio
    * del sandwich más el precio unitario de la porción de carne deshebrada de pollo.    
    **/  
    @Override public int getPrecio(){
        return hotDogLoco_centro.getPrecio() + 1;
    }
    
}
