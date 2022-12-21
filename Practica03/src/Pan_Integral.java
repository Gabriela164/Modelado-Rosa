/**
* Clase que define objetos concretos que fungiran como núcleos a decorar, ésto según
* lo estipulado por el patrón de diseño Decorator.
* En concreto, esta clase define un tipo de pan hecho a base de harina de trigo sin procesar ni refinar.
* @author Gabby
* @version 1.1 
**/

public class Pan_Integral implements Baguette {

    /**
    * <code>descripción</code> cadena que explica las características del pan.
    * <code>precio</code> número de coma flotante con doble precisión que indica
    * el precio del producto en la moneda local, pumadolares. 
    **/
    private String descripcion = "Baguette hecho con Pan Integral";
    private double precio = 25.00;

    /**
    * Método que retorna la descripción del tipo de pan empleado en la elaboración
    * del sandwich.
    * @return cadena que nos indica que el tipo de pan es integral.
    **/
    @Override 
    public String getDescripcion() {
       return descripcion;
    }

    /**
    * Método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo del pan.
    **/
    @Override 
    public double getPrecio() {
        return precio;
    }

}