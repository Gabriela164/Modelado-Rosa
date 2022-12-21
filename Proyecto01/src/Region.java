/**
* Interface a implementar por las clases que aplican el patrón Strategy con los múltiples idiomas dependiendo de la región
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public interface Region {

	/**
	 * Método que regresa una cadena con la bienvenida a la tienda
	 */
	public String mensajeBienvenida();

	/**
	 * Método que regresa una cadena con la despedida a la tienda
	 */
	public String mensajeDespedida();

	/**
	 * Método que regresa una cadena con las ofertas de la tienda
	 */
	public String mensajeOfertas();

	/**
	 * Método que regresa una cadena con un menu para el cliente solicitando su opción para entrar a la tienda
	 */
	public String mensajePrimerMenu();

	/**
	 * Método que regresa una cadena con un mensaje avisando la entrada del menú
	 */
	public String mensajeLeeCatalogo();

	/**
	 * Método que regresa una cadena avisando que entraste a la zona de compras de la tienda
	 */
	public String mensajeVenta();

	/**
	 * Método que regresa una cadena avisando que se agregó un producto al carrito
	 */
	public String menuVenderProducto();

	/**
	 * Método que regresa una cadena avisando que es una opcion invalida
	 */
	public String mensajeOpcionInvalida();

	/**
	 * Método que regresa una cadena avisando que se está removiendo un producto del carrito
	 */
	public String mensajeRemocionProducto();

	/**
	 * Método que regresa una cadena solicitando código de barras para añadir un producto al carrito
	 */
	public String mensajeVentaProducto();

	/**
	 * Método que regresa una cadena avisando que no hay productos sufientes en el almacen
	 */
	public String mensajeProductosInsuficientes();

	/**
	 * Método que regresa una cadena avisando que se está concretando la compra
	 */
	public String mensajeConcretarCompra();

	/**
	 * Método que regresa una cadena avisando que la compra falló
	 */
	public String mensajeCompraFallida();	

	/**
	 * Método que regresa una cadena avisando que necesita la clave del cliente para concretar la compra
	 * @param contador las oportunidades que le quedan para meter bien su clave, sino se cierra el programa
	 */
	public String mensajeSolicitaClave(int contador);

	/**
	 * Método que regresa una cadena avisando que se aceptó la clave 
	 */
	public String mensajeClaveAceptada();

	/**
	 * Método que regresa una cadena avisando que no hay saldo sucifiente
	 * @param costo el costo del producto
	 * @param saldo el saldo del cliente
	 */
	public String mensajeSaldoInsuficiente(double costo, double saldo);

	/**
	 * Método que regresa una cadena con la presentación del ticket de compra
	 */
	public String mensajeTicket();

	/**
	 * Método que se encarga de verificar sie l producto es válido para un decuento dependiendo de la región
	 * @param producto el producto a checar
	 */
	public Item aplicaOfertas(Producto producto);
}