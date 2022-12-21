package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Controlador.*;
import Vista.*;

/**
* Interfaz a implementar por aquellos objetos que modelan los distintos platillos
* ofrecidos por la compañia "hot dogs locos" en sus restaurantes, incluye complementos y hot dogs con salchicha 
* ya predeterminados.
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public interface HotDogLoco{       

    /**
    * Declaración del método de acceso a la descripcion del hot dog.
    * @return cadena con las características generales del producto. 
    **/
    public String getDescripcion();
    
    /**
    * Declaración del método de acceso al precio del producto.
    * @return número de coma flotante con precisión doble que indica
    * el precio con el cuál se comercializa el producto.
    **/
    public int getPrecio();
}
