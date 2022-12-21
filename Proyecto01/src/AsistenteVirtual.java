import java.util.LinkedList;
import java.util.Scanner;

/**
* Clase que define un agente que se encarga de controlar las interacciones del usuario con los recursos de
* la tienda.
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/

public class AsistenteVirtual implements Servicio{
	private Region region;
	private Cliente cliente;
	private Tienda tienda;


	/**
	 * Constructor de la clase
	 * @param region la region del cliente, que sirve para ver en qué idioma imprimir el menú
	 * @param cliente el cliente que estará haciendo la compra
	 * @param tienda la tienda a la cuál se va comprar (contiene los catalogos de los productos)
	 * @throws IllegalArgumentException si alguno de los parámetros es null
	 */
	public AsistenteVirtual(Region region, Cliente cliente, Tienda tienda)throws IllegalArgumentException{
		if(region == null || cliente == null || tienda == null)throw new IllegalArgumentException();
		this.region = region;
		this.cliente = cliente;
		this.tienda = tienda;		
	}

	/**
	 * Regresa la region del asistente virtual
	 * @return la region del asistente virtual
	 */	
	public Region getRegion(){
		return region;
	}

	/**
	 * Regresa el cliente que está haciendo la compra
	 * @return el cliente que está haciendo la compra
	 */
	public Cliente getCliente(){
		return cliente;
	}

	/**
	 * Regresa la tienda a la cuál se está comprando
	 * @return la tienda a la cuál se está comprando
	 */
	public Tienda getTienda(){
		return tienda;
	}

	/**
	 * Método que se encarga de imprimir en terminal el mensaje de bienvenida a la tienda
	 * dependiendo de la region lo imprime en un idioma u otro
	 */
	public void bienvenida(){
		System.out.println(region.mensajeBienvenida());
	}

	/**
	 * Método que se encarga de imprimir en terminal el mensaje de despedida de la tienda
	 * dependiendo de la region lo imprime en un idioma u otro
	 */
	public void despedida(){
		System.out.println(region.mensajeDespedida());

	}

	/**
	 * Método que se encarga de imprimir en terminal el mensaje de ofertas de la tienda
	 * dependiendo de la region lo imprime en un idioma u otro
	 */
	public void ofertas(){
		System.out.println(region.mensajeOfertas());
	}

	/**
	 * Método que se encarga de imprimir en terminal el mensaje presentando el menu de la tienda
	 * dependiendo de la region lo imprime en un idoma u otro
	 */
	public void primerMenu(){
		System.out.println(region.mensajePrimerMenu());

	}	

	/**
	 * Método que se encarga de imprimir en terminal el menu de la tienda
	 */
	public void leeCatalogo(){
		System.out.println(region.mensajeLeeCatalogo());
		IteradorCatalogoDeProductos iterador = tienda.getProductos().creaIterador();
		LinkedList<Integer> lista = new LinkedList<Integer>();
		Producto temporal;
		while(iterador.hasNext()){
			temporal = iterador.next();
			if(lista.contains(temporal.getCodigoDeBarras()))continue;
			lista.add(temporal.getCodigoDeBarras());
			System.out.println(temporal.getDescripcion());
		}
	}


	/**
	 * Se encarga de asesroar al usuario durante la compra,agrega los productos al carrito y tramita los pagos.
	 * @param carritoNuevo el carrito al que se le va a ir agregando los productos
	 */
	public void venta(Carrito carritoNuevo){
		System.out.println(region.mensajeVenta());
		this.leeCatalogo();		
		Scanner lector = new Scanner(System.in);
		int opcion;
		boolean salida = false;		
		while(true){
			try{
				System.out.println(region.menuVenderProducto());
				opcion = lector.nextInt();
			}catch(NumberFormatException excepcion){
				System.out.println(region.mensajeOpcionInvalida());
				lector = new Scanner(System.in);
				continue;
			}			
			switch (opcion){
				case 0:
					this.despachaProducto(carritoNuevo);
					break;
				case 1:
					salida = true;
					break;
				case 2:
					this.remueveProducto(carritoNuevo);
					break;			
				default:
					System.out.println(region.mensajeOpcionInvalida());
					break;			

			}
			if(salida == true)break;
		}		
	}

	/**
	 * Se encarga de cancelar la compra, es decir, elimina un producto del carrito, dependiendo de su codigo de barras
	 * @param carritoNuevo el carrito al que se le va a eliminar los productos
	 */
	private void remueveProducto(Carrito carritoCompras){
		System.out.println(region.mensajeRemocionProducto());
		Scanner lectorCodigo = new Scanner(System.in);
		int codigoBarras;
		try{		
			codigoBarras = lectorCodigo.nextInt();
		}catch(Exception excepcion){
			System.out.println(region.mensajeOpcionInvalida());
			return;				
		}			
		Producto prod = carritoCompras.busquedaPorId(codigoBarras);
		if(prod == null){
			System.out.println(region.mensajeOpcionInvalida());
			return;
		}
		carritoCompras.removeProducto(prod);
		System.out.println(region.mensajeRemocionProducto());
	}

	/**
	 * Método que se encarga de verificar suficientes existencias del producto en el almacen
	 * @param producto el prodcuto a checar
	 * @return el número de existencias en el almacen si no hay suficientes o -1 si hay las requeridas.
	 */
	private int aseguraExistencias(ProductoAdquirido producto){
		IteradorCatalogoDeProductos iterador = tienda.getProductos().creaIterador();
		int contador = 0;
		Producto temporal;
		while(iterador.hasNext()){
			temporal = iterador.next();
			if(temporal.sonIguales(producto.getProductoContenido()))contador++;
		}
		if(contador == 0 || contador < producto.getVecesAdquirido())return contador;		
		return -1;
	}

	/**
	 * Método auxiliar que se encarga de añadir al carrito el producto requerido por el usuario.
	 * @param carritoCompras se checan sus productos a ver si hay suficientes existencias y de ser así, se
	 * añade al carrito.
	 */
	private void despachaProducto(Carrito carritoCompras){
		System.out.println(region.mensajeVentaProducto());		
		Scanner lectorCodigo = new Scanner(System.in);
		int codigoBarras;
		try{		
			codigoBarras = lectorCodigo.nextInt();
		}catch(Exception excepcion){
			System.out.println(region.mensajeOpcionInvalida());
			lectorCodigo = new Scanner(System.in);
			return;				
		}			
		Producto prod = tienda.getProductos().busquedaPorId(codigoBarras);
		if(prod == null){
			System.out.println(region.mensajeOpcionInvalida());
			return;	
		}
		carritoCompras.addProducto(prod.clonar());		
	}

	/**
	 * Método auxiliar que imprime el ticket de compras
	 * @param carritoDeCompras los elementos de este serán los que se irán agregando al ticket.
	 */
	private void extiendeTicket(Carrito carritoDeCompras){		
		System.out.println(region.mensajeTicket());
		IteradorCarrito iterador = carritoDeCompras.creaIterador();
		ProductoAdquirido temporal;		
		while(iterador.hasNext()){
			temporal = iterador.next();
			int contador = 0;
			Item productoConDescuento;
			while(contador < temporal.getVecesAdquirido()){
				productoConDescuento = this.region.aplicaOfertas(temporal.getProductoContenido());
				System.out.println(productoConDescuento.getDescripcion());
				contador++;				
			}
		}				
	}

	/**
	 * Método que hace la suma de los precios de los productos y regresa el total
	 * @param carritoDeCompras los productos se sacarán de éste
	 * @return el costo total
	 */
	private double costoDeCompra(Carrito carritoDeCompras){
		IteradorCarrito iterador = carritoDeCompras.creaIterador();
		ProductoAdquirido temporal;
		double precioTotal = 0;
		while(iterador.hasNext()){
			temporal = iterador.next();
			int contador = 0;
			Item productoConDescuento;
			while(contador < temporal.getVecesAdquirido()){
				productoConDescuento = this.region.aplicaOfertas(temporal.getProductoContenido());				
				precioTotal = precioTotal + productoConDescuento.getPrecio();
				contador++;
			}
		}
		return precioTotal;
	}

	/**
	 * Método que verifica si todos los productos requeridos están disponibles 
	 * en el almacen para su venta.
	 * @param compras el carrito a revisar
	 * @return -1 si el carrito no contiene productos, 1 si hay existencias suficientes
	 * de todos los productos requeridos y 0 si no los hay.
	 */
	private int aseguraCarrito(Carrito compras){
		if(compras.getLista().isEmpty())return -1;
		IteradorCarrito analizador = compras.creaIterador();
		LinkedList<ProductoAdquirido> lista = new LinkedList<ProductoAdquirido>();
		ProductoAdquirido temporal;
		ProductoAdquirido prodInsuficiente;
		while(analizador.hasNext()){
			temporal =  analizador.next();			
			int verificador = this.aseguraExistencias(temporal);
			if(verificador == -1)continue;			
			if(verificador >= 0){
				prodInsuficiente = new ProductoAdquirido(temporal.getProductoContenido().clonar());	
				prodInsuficiente.setVecesAdquirido(verificador);		
				lista.add(prodInsuficiente);
			}
		}
		if(lista.isEmpty())return 1;
		System.out.println(region.mensajeProductosInsuficientes());
		int posicion = 0;
		ProductoAdquirido temporal2;
		while(posicion < lista.size()){
			temporal2 = lista.get(posicion);
			System.out.println(temporal2.getProductoContenido().getDescripcion() + "  " + temporal2.getVecesAdquirido() + "\n");
			posicion++;			
		}
		return 0;
	}

	/**
	 * Método que se encarga de pedir los datos finales para la cerrar de la compra
	 * @param productosComprados el carrito con los productos que el usuario solicita.
	 * @return numeros menores o iguales a cero si falla la compra: 0 siel carrito es nulo, -4 si no
	 * hay productos en el almacen y no se puede cerrar el trato, -3 si no hay existencias suficientes
	 * de los productos y no se puede cerrar el trato, -2 si después de 3 intentos no se ingreso la clave
	 * adecuada, -1 si el usuario no tiene el saldo necesario para saldar su cuenta y el resultado provisto
	 * por la tienda si pudo satisfacer los requerimentos.
	 */
	@Override public int concretaCompra(Carrito productosComprados){		
		if(productosComprados == null)return 0;
		System.out.println(region.mensajeConcretarCompra());
		Scanner lector = new Scanner(System.in);
		int seguro = this.aseguraCarrito(productosComprados);
		if(seguro == -1)return -4;
		if(seguro == 0)return -3;			
		int contador = 3;
		int password = 0;
		while(contador > 0){
			try{
				System.out.println(region.mensajeSolicitaClave(contador));
				password = lector.nextInt();
				if(password == cliente.getClaveBancaria()){
					System.out.println(region.mensajeClaveAceptada());
					break;
				}
				contador = contador-1;
			}catch(Exception io){
				lector = new Scanner(System.in);
				contador = contador-1;
				continue;
			}			
		}
		if(password == 0)return -2;
		double costo = this.costoDeCompra(productosComprados);
		double saldo = this.cliente.getMonedero().getSaldo();					
		if(costo > saldo){
			System.out.println(region.mensajeSaldoInsuficiente(costo, saldo));
			return -1;
		}
		int resultado = tienda.concretaCompra(productosComprados);
		cliente.getMonedero().setSaldo(saldo-costo);
		this.extiendeTicket(productosComprados);
		return resultado;			
	}

	
	


	
}