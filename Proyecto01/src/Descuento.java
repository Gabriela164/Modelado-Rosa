/**
* Clase que se encarga de aplicar el patrón decorator en los Items del catálogo de productos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public abstract class Descuento implements Item{
    protected Item productoCentro;

    /**
     * Método constructor que envuelve al producto que se le pasa como atributo, para poder modificar sus atributos 
     * sin cambiarlos permanentemente.
     * @param productoCentro el producto a envolver
     */
    public Descuento(Producto productoCentro){
        this.productoCentro = productoCentro;
    }
    
    /**
     * Método que regresa el producto envuelto al que se le pueden modificar sus atributos
     * @return el producto envuelto
     */    
    public Item getCentro(){
        return productoCentro;
    }
    
    /**
     * Método que verifica si la instancia de clase es un decorador o una implementación
     * concreta a decorar
     * @return false pues la clase se extiende exclusivamente por objetos decoradores
     */
    @Override public boolean esNucleo(){
        return false;
    }

    /**
     * Método que retorna el precio del objeto, este metódo implementara el
     * decorado, la variante en el comportamiento
     * @return número de coma flotante de precisión doble con el precio del objeto.
     */
    @Override public abstract double getPrecio();

    /**
     * Método que retorna la descripción del objeto, este metódo implementara el
     * decorado, la variante en el comportamiento
     * @return cadena con la descripción modificada del objeto.
     */
    @Override public abstract String getDescripcion();
    
}