/**
* Clase que representa la tienda en línea de wolmar
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Tienda implements Servicio{
	private CatalogoDeProductos productos;
	private CatalogoDeClientes clientes;

	/**
	 * Constructor de la clase 
	 * @param productos los productos de la tienda
	 * @param clientes los clientes registrados
	 */
	public Tienda(CatalogoDeProductos productos, CatalogoDeClientes clientes){
		this.productos = productos;
		this.clientes = clientes;
	}

	/**
	 * Método que regresa los productos de la tienda
	 * @return los productos de la tienda
	 */
	public CatalogoDeProductos getProductos(){
		return productos;
	}

	/**
	 * Método que regresa el catálogo con los clientes registrados en la tienda
	 * @return los clientes de la tienda
	 */
	public CatalogoDeClientes getClientes(){
		return clientes;
	}

	/**
	 * Método que se encarga de cerrar la compra de determinados productos
	 * añadidos a un carrito de compras
	 * @param compras el carrito a iterar
	 * @return 0 si el carrito pasado como argumento es nulo, 1 al cerrar el trato
	 */
	@Override public int concretaCompra(Carrito carrito){
		if(carrito == null)return 0;		
		IteradorCarrito iterador = carrito.creaIterador();		
		ProductoAdquirido temporal;
		while(iterador.hasNext()){
			int contador = 0;
			temporal = iterador.next();
			while(contador < temporal.getVecesAdquirido()){
				productos.removeProducto(temporal.getProductoContenido());
				contador++;
			}			
		}
		return 1;
	}
}