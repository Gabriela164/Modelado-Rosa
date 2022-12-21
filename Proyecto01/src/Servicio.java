/**
* Interfaz a implementar por las clases que siguen el patrón Proxy que en este caso
* sirve para gestionar la compra de productos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public interface Servicio{
	
	/**
	 * Método que se encarga de cerrar la compra de determinados productos
	 * añadidos a un carrito de compras
	 * @param compras el carrito a iterar
	 * @return un entero que indica el estado alcanzado dentro del proceso de compra
	 */
	public int concretaCompra(Carrito compras);
}