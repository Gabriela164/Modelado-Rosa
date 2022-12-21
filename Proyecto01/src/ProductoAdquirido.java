/**
* Clase que crea se encarga de cambiar la etiqueta a  un producto cuando se agrega al carrito
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class ProductoAdquirido{
	private Producto productoContenido;
	private int vecesAdquirido;

	/**
	 * Constructor del producto
	 * @param producto el producto comprado
	 * se inicializa con su contador de adquisiciones en 1
	 */
	public ProductoAdquirido(Producto producto){
		productoContenido = producto;
		vecesAdquirido = 1;
	}

	/**
	 * Método que regresa el producto que se está comprando
	 * @return el producto que se está comprando
	 */
	public Producto getProductoContenido(){
		return productoContenido;
	}

	/**
	 * Método que egresa las veces que se ha comprado el producto
	 * @return las veces que se ha comprado el producto
	 */
	public int getVecesAdquirido(){
		return vecesAdquirido;
	}

	/**
	 * Método que asigna las veces que se ha comprado el producto
	 * @param veces las veces que se ha comprado el producto
	 */
	public void setVecesAdquirido(int veces){
		if(veces<1)return;
		vecesAdquirido = veces;		
	}
}