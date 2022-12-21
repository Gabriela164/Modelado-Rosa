import java.util.LinkedList;

/**
* Clase encargada de llevar un control más limpio de los productos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class CatalogoDeProductos implements Catalogo{
	private LinkedList<Producto> tablaProductos;
	
	/**
	 * Constructor del catálogo de productos, que los almacena en una linkedlist
	 */
	public CatalogoDeProductos(){
		tablaProductos = new LinkedList<Producto>();
	}

	/**
	 * Método que regresa la lista donde se están almacenando los productos
	 * @return objeto de tipo linkedlist donde se están almacenando los productos
	 */
	public LinkedList<Producto> getTablaProductos(){
		return tablaProductos;
	}

	/**
	 * Método que asigna una nueva lista para almacenar el catálogo de productos
	 * @param nuevoCatalogo la nueva hashtable donde se van a almacenar los productos
	 * @return false, si el la hashtable es null, true en cualquier otro caso 
	 */
	public boolean setTablaProductos(LinkedList<Producto> nuevoCatalogo){
		if(nuevoCatalogo == null)return false;
		tablaProductos = nuevoCatalogo;	
		return true;

	}	

	/**
	 * Método encargado de agregar un producto al catálogo
	 * @param nuevoProducto el nuevo producto a agregar
	 * @return true si se agregó el producto, false en cualquier otro caso
	 */
	public boolean addProducto(Producto nuevoProducto){
		if(nuevoProducto == null)return false;							
		tablaProductos.add(nuevoProducto);
		return true;
	}

	/**
	 * Método encargado de eliminar un cliente del catálogo
	 * @param productoAEliminar el cliente a eliminar
	 * @return true si se eliminó el cliente, false en cualquier otro caso
	 */
	public boolean removeProducto(Producto productoAEliminar){
		if(productoAEliminar == null || !tablaProductos.contains(productoAEliminar))return false;
		tablaProductos.remove(productoAEliminar);
		return true;			
	}

	/**
	 * Método que crea un iterador para recorrer el catálogo
	 * @return el recién iterador creado
	 */
	@Override public IteradorCatalogoDeProductos creaIterador(){
		IteradorCatalogoDeProductos iterador = new IteradorCatalogoDeProductos(this);
		return iterador;		
	}

	/**
	 * Busca por el catálogo con un id y regresa el objeto
	 * @param idBuscado código de barras del objeto a buscar
	 * @return el objeto que tenga el id buscado si lo encuentra, si no coincide con
	 * el de ningún producto entonces regresa null
	 */
	@Override public Producto busquedaPorId(int idBuscado){
		IteradorCatalogoDeProductos iterador = this.creaIterador();
		Producto producto;
		while(iterador.hasNext()){
			producto = (Producto)iterador.next();
			if(producto.getCodigoDeBarras() == idBuscado)
				return producto;			
		}
		return null;
	}

	/**
	 * Método que regresa el número de veces que se repite un producto en el catálogo
	 * @param producto el producto a buscar
	 * @return el número de existencias del producto
	 */
	public int existenciasDelProducto(Producto producto){
		if(producto == null)return 0;
		IteradorCatalogoDeProductos iterador = new IteradorCatalogoDeProductos(this);
		int contador = 0;
		while(iterador.hasNext()){
			if(producto.sonIguales(iterador.next()))contador++;
		}
		return contador;
	}
	
}