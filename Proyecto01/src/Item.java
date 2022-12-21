/**
* Interface que se encarga de darle una etiqueta y un comportamiento definido a los productos de 
* la tienda virtual, nos permite implementar el patrón Decorator
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public interface Item{

    /**
     * Declaración del método que egresa el precio del producto
     * @return el precio del producto
     */
    public double getPrecio();

    /**
     * Declaración del método que regresa la descripción del producto
     * @return la descripcion del producto
     */
    public String getDescripcion();

    /**
     * Regresa si el producto es núcleo o no, es decir si está envuelto en un descuento o no
     * @return true si tienen aplicado un descuento, false en cualquier otro caso
     */
    public boolean esNucleo();

    /**
     * Regresa el Produto del núcleo, es decir el que no tiene aplicado ningún descuento (o sí si se aplcian varios decoradores)
     * @return el producto núcleo
     */
    public Item getCentro();
}