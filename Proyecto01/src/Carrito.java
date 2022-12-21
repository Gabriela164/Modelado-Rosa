import java.util.LinkedList;

/**
* Clase que define se encarga de almacenar instancias de los pedidos hechos por el cliente
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Carrito implements Catalogo{
	private LinkedList<ProductoAdquirido> lista;

	/**
	 * Constructor de la clase de carritos
	 */
	public Carrito(){
		lista = new LinkedList<ProductoAdquirido>();
	}

	/**
	 * Regresa la lista de pedidos hechos por el cliente
	 * @return la lista de pedidos hechos por el cliente
	 */
	public LinkedList<ProductoAdquirido> getLista(){
		return lista;
	}

	/**
	 * Asigna la lista de productos al objeto Carrito
	 * @param nuevoCarrito la nueva lista que se está asignando
	 * @return false si el carrito no está inicializado, true en cualquier otro caso
	 */
	public boolean setLista(LinkedList<ProductoAdquirido> nuevoCarrito){
		if(nuevoCarrito == null){
			return false;			
		}else{
			lista = nuevoCarrito;
			return true;
		}
	}

	/**
	 * Crea el iterador que ayuda a recorrer el carrito
	 * @return el iterador que ayuda a recorrer el carrito
	 */
	@Override public IteradorCarrito creaIterador(){
		IteradorCarrito iterador = new IteradorCarrito(this);
		return iterador;
	}
	

	/**
	 * Método que se encarga de buscar un producto en el carrito
	 * @param idBuscado el Id del producto en cuestión
	 * @return el producto (si lo encuentra), null en cualquier otro caso 
	 */
	@Override public Producto busquedaPorId(int idBuscado){
		IteradorCarrito iterador = this.creaIterador();
		Producto productoEnCarrito;
		while(iterador.hasNext()){
			productoEnCarrito = iterador.next().getProductoContenido();
			if(productoEnCarrito.getCodigoDeBarras() == idBuscado)return productoEnCarrito;							
		}
		return null;
	}

	
	public boolean addProducto(Producto nuevoProducto){
		if(nuevoProducto == null)return false;		
		IteradorCarrito iterador = this.creaIterador();
		ProductoAdquirido producto;	
		while(iterador.hasNext()){
			producto = iterador.next();
			if(producto.getProductoContenido().equals(nuevoProducto)){
				producto.setVecesAdquirido(producto.getVecesAdquirido() + 1);
				return true;
			}
		}
		lista.add(new ProductoAdquirido(nuevoProducto));
		return true;					
	}

	public boolean removeProducto(Producto productoAEliminar){
		if(productoAEliminar == null)return false;			
		IteradorCarrito iterador = this.creaIterador();
		ProductoAdquirido producto;		
		while(iterador.hasNext()){
			producto = iterador.next();
			if(producto.getProductoContenido().equals(productoAEliminar)){
				if(producto.getVecesAdquirido()>1){
					producto.setVecesAdquirido(producto.getVecesAdquirido() - 1);					
				}else{
					lista.remove(producto);	
				}
				return true;
			}

		}
		return false;
	}			

	
}