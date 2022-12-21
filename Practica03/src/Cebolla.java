/**
* Clase que define un decorador para añadir nuevos comportamientos o modificar los ya existentes, 
* de aquel núcleo al que envuelven, ésto según lo estipulado por el patrón de diseño Decorator. 
* En este caso en concreto, define una porción de rebanadas de cebolla.
* @author Gabby
* @version 1.1 
**/

public class Cebolla extends IngredienteDecorador{

    /**
    * Constructor de la clase, permite al ingrediente decorar al pan base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param baguette_centro núcleo a decorar, uno de los tipos de pan que ofrece
    * la cadena de restaurantes para preparar los sandwiches.
    **/
    public Cebolla(Baguette baguette_centro) {
        super(baguette_centro);
    }
    
    /**
    * Declaración del método que retorna la descripción del complemento añadido.
    * @return cadena que nos indica que al sandwich se le aplicó una porción de
    * rebanadas de cebolla.    
    **/ 
    public String getDescripcion(){
        return baguette_centro.getDescripcion() + ", Cebolla";
    }
    
    /**
    * Declaración del método que devuelve el costo del producto.
    * @return número de coma flotante de precisión doble que define 
    * el costo total de la baguette junto con la aplicación de una porción de cebolla.  
    **/ 
    public double getPrecio(){
        return baguette_centro.getPrecio() + 5.50;
    }
    
}