import java.util.LinkedList;

/**
* Clase que se encarga de crear un iterador para recorrer el catalogo de productos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class IteradorCatalogoDeProductos implements Iterador{
	private CatalogoDeProductos catalogo;
	private int posicion;
	
	/**
	 * Constructor del iterador que recorrerá el catalogo de productos
	 * @param catalogoNuevo el catalogo a recorrer
	 */
	public IteradorCatalogoDeProductos(CatalogoDeProductos catalogoNuevo){
		if(catalogoNuevo == null)throw new IllegalArgumentException();
		catalogo = catalogoNuevo;
		posicion = 0;
	}

	/**
	 * Método que egresa el catálogo que se está iterando
	 * @return el catalogo que se está iterando
	 */
	public CatalogoDeProductos getcatalogo(){
		return catalogo;
	}

	/**
	 * Método que regresa la posción a la que apunta el iterador. Haciendo uso de una especie de indice que 
	 * representa la posicion de los objetos del carrito
	 * @return la posición a donde apunta
	 */
	public int getPosicion(){
		return posicion;
	}

	/**
	 * Método que asigna la posicion del iterador
	 * @param nuevaPosicion entero mayor o igual que cero y menor que la longitud
	 * de la lista donde el catálogo almacena sus productos
	 * @return true si se logra asignar la posicion, false en cualquier otro caso
	 */
	public boolean setPosicion(int nuevaPosicion){
		if(nuevaPosicion<0 || nuevaPosicion>= catalogo.getTablaProductos().size()){
			return false;			
		}else{
			posicion = nuevaPosicion;
			return true;
		}		
	}

	/**
	 * Método que asigna un nuevo catálogo a leer
	 * @param nuevoCatalogo el nuevo catálogo a leer
	 * @return true si se asigna el catálogo, false en cualquier otro caso
	 */
	public boolean setCatalogoProductos(CatalogoDeProductos nuevoCatalogo){
		if(nuevoCatalogo == null)return false;		
		catalogo = nuevoCatalogo;		
		return true;		
	}

	/**
	 * Método que verifica la existencia de objetos subsecuentes dentro
	 * del objeto a iterar
	 * @return false si no hay más elementos subsecuentes, true en cualquier otro caso
	 */
	@Override public boolean hasNext(){
		if((this.getPosicion()<catalogo.getTablaProductos().size()) && catalogo.getTablaProductos().get(this.getPosicion()) != null)return true;		
		return false;
	}
	
	/**
	 * Método que retorna los objetos subsecuentes dentro del objeto a iterar
	 * @return el elemento subsecuente en la iteración de la estructura
	 */	
	@Override public Producto next(){		
		Producto objetoSiguiente = catalogo.getTablaProductos().get(this.getPosicion());
		posicion++;
		return objetoSiguiente;
	}

	/**
	 * Método que retorna al iterador a su posición inicial
	 */
	@Override public void reiniciar(){
		this.setPosicion(0);
	}
}