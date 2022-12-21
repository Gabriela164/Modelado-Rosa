package Modelo;


/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/


import Controlador.*;
import Vista.*;

/**
* Clase que define objetos concretos que fungiran como núcleos a decorar, ésto según
* lo estipulado por el patrón de diseño Decorator.
* En concreto, esta clase define un tipo de pan hecho a base de harina de trigo refinada y procesada.
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public class HotDogChorizo implements HotDogLoco {


    /**
    * <code>descripción</code> cadena que explica las características del hot dog con salchicha de chorizo.
    * <code>precio</code> número de coma flotante con doble precisión que indica
    * el precio del producto en la moneda local, pumadolares. 
    **/
    private String descripcion = "Hot Dog hecho con salchicha de chorizo";
    private int precio = 2;


    /**
    * Método que retorna la descripción del tipo de salchicha empleado en la elaboración
    * del hot dog.
    * @return cadena que nos indica que el tipo de hot dog.
    **/
    @Override public String getDescripcion() {
        return descripcion;
    }

    /**
    * Método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo del hot dog con salchicha de chorizo.
    **/
    @Override public int getPrecio() {
        return precio;
    }
}
