/**
* Clase que define objetos concretos que fungiran como núcleos a decorar, ésto según
* lo estipulado por el patrón de diseño Decorator.
* En concreto, esta clase define un tipo de pan hecho a base de avena y con una ligera cobertura
* de miel.
* @author Gabby
* @version 1.1 
**/

public class Pan_AvenaMiel implements Baguette {

    /**
    * <code>descripción</code> cadena que explica las características del pan.
    * <code>precio</code> número de coma flotante con doble precisión que indica
    * el precio del producto en la moneda local, pumadolares. 
    **/
    private String descripcion = "Baguette hecho con pan de avena y cobertura de miel";
    private double precio = 35.00;

    /**
    * Método que retorna la descripción del tipo de pan empleado en la elaboración
    * del sandwich.
    * @return cadena que nos indica que el tipo de pan es aquel de avena y miel.
    **/
    @Override public String getDescripcion() {
        return descripcion;
    }

    /**
    * Método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo del pan.
    **/
    @Override public double getPrecio() {
        return precio;
    }
    
}
