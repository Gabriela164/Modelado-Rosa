/**
* Clase abstracta a extender por aquellos objetos, que permiten añadir
* nuevos comportamientos o modificar los ya existentes, de aquel al que envuelven
* según lo estipulado por el patrón de diseño Decorator. 
* En este caso definen el complemento para un sandwich.
* @author Gabby
* @version 1.1 
**/

public abstract class IngredienteDecorador implements Baguette{
    
    /**
    * <code>baguette</code> objeto a ser decorado, conocido como núcleo.
    **/
    protected Baguette baguette_centro;
    
    public IngredienteDecorador(Baguette baguette_centro){
    	this.baguette_centro = baguette_centro;
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
    * el costo total de la baguette junto con la porción del complemento.  
    **/
    @Override public abstract double getPrecio();       

}
