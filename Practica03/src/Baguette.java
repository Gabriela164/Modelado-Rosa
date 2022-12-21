/**
* Interfaz a implementar por aquellos objetos que modelan los distintos platillos
* ofrecidos por la compañia "Waysub" en sus restaurantes, incluye complementos y pan
* base.
* @author Gabby
* @version 1.1 
**/

public interface Baguette{       

    /**
    * Declaración del método de acceso a la descripcion de la baguette.
    * @return cadena con las características generales del producto. 
    **/
    public String getDescripcion();
    
    /**
    * Declaración del método de acceso al precio del producto.
    * @return número de coma flotante con precisión doble que indica
    * el precio con el cuál se comercializa el producto.
    **/
    public double getPrecio();
}
