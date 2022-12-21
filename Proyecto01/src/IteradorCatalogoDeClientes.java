import java.util.Hashtable;
import java.util.Enumeration;
/**
* Clase que se encarga de crear un iterador para recorrer el catalogo de clientes
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class IteradorCatalogoDeClientes implements Iterador{
	private CatalogoDeClientes catalogo;
	private Enumeration<Cliente> catalogoALeer;
	
	/**
	 * Constructor del iterador
	 * @param catalogoNuevo el catalogo que recorrerá el iterador
	 * @throws IllegalArgumentException si se pasa como argumento un catálogo nulo
	 */
	public IteradorCatalogoDeClientes(CatalogoDeClientes catalogoNuevo) throws IllegalArgumentException{
		if(catalogoNuevo == null)throw new IllegalArgumentException();
		this.catalogo = catalogoNuevo;
		this.catalogoALeer = catalogo.getTablaClientes().elements();
	}

	/**
	 * Método que regresa el catálogo donde se está iterando
	 * @return el catalogo donde se está iterando
	 */
	public CatalogoDeClientes getCatalogo(){
		return catalogo;
	}

	/**
	 * Método que regresa un subcatálogo del catalogo que se está iterando
	 * @return enumeración con un subcatalogo del catalogo que se está iterando
	 */
	public Enumeration<Cliente> getCatalogoALeer(){
		return catalogoALeer;
	}

	/**
	 * Asigna un nuevo subcatalogo a leer
	 * @param nuevoCatalogo el nuevo catálogo a leer
	 * @return true si se asigna el catalogo, false en cualquier otro caso
	 */
	public boolean setCatalogo(CatalogoDeClientes nuevoCatalogo){
		if(nuevoCatalogo == null)return false;
		catalogo = nuevoCatalogo;
		catalogoALeer = catalogo.getTablaClientes().elements();
		return true;
				
	}
	
	/**
	 * Método que verifica la existencia de objetos subsecuentes dentro
	 * del objeto a iterar
	 * @return false si no hay más elementos subsecuentes, true en cualquier otro caso
	 */
	@Override public boolean hasNext(){
		return catalogoALeer.hasMoreElements();
	}	

	/**
	 * Método que retorna los objetos subsecuentes dentro del objeto a iterar
	 * @return el elemento subsecuente en la iteración de la estructura
	 */	
	@Override public Cliente next(){
		return catalogoALeer.nextElement();
	}

	/**
	 * Método que retorna al iterador a su posición inicial
	 */	
	@Override public void reiniciar(){
		catalogoALeer = catalogo.getTablaClientes().elements();
	}


}