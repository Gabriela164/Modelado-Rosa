/**
* Clase que se encarga de aplicar el patrón decorator en los Items del catálogo de productos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Descuento40 extends Descuento{
 
    /**
     * Constructor de el caso en particular que el producto se le aplique un 40 por ciento de descuento
     * @param productoCentro el producto que se pasará a envolver en el descuento
     */
    public Descuento40(Producto productoCentro){
        super(productoCentro);
    }
    
    /**
     * Método que regresa el nuevo precio del producto
     * @return el precio con el descuento aplicado
     */
    @Override public double getPrecio(){
        return productoCentro.getPrecio() * 0.6;
    }
    
    /**
     * Método que avisa que el producto tiene aplicado un 40% de descuento
     * @return la cadena con la descripción del contenido junto al porcentaje de descuento
     */
    @Override public String getDescripcion(){
        return productoCentro.getDescripcion() + " - 40% "+ "\n";
    }
   
}