/**
* Clase que define un decorador para añadir nuevos comportamientos o modificar los ya existentes, 
* de aquel núcleo al que envuelven, ésto según lo estipulado por el patrón de diseño Decorator. 
* En este caso en concreto, define una aplicación (una unción, un chorro) de mostaza amarilla.
* @author Gabby
* @version 1.1 
**/

public class Mostaza extends IngredienteDecorador{
    
    /**
    * Constructor de la clase, permite al ingrediente decorar al pan base
    * para modificar su comportamiento en tiempo de ejecución.
    * @param baguette_centro núcleo a decorar, uno de los tipos de pan que ofrece
    * la cadena de restaurantes para preparar los sandwiches.
    **/
    public Mostaza(Baguette baguette_centro) {
        super(baguette_centro);
    }
    
    /**
    * Declaración del método que retorna la descripción del sandwich con el complemento añadido.
    * @return cadena que nos indica que al sandwich se le aplicó una porción de
    * mostaza.    
    **/
    @Override public String getDescripcion(){
        return baguette_centro.getDescripcion() + ", Mostaza";
    }
    
    /**
    * Declaración del método que retorna el precio del sandwich una vez se le 
    * añadió el complemento.
    * @return número de coma flotante de precisión doble que nos indica el precio
    * del sandwich más el precio unitario de la porción de mostaza.    
    **/ 
    @Override public double getPrecio(){
        return baguette_centro.getPrecio() + 5.50;
    }
}