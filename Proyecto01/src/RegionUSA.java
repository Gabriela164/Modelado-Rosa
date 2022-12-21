import java.util.Random;
import java.util.LinkedList;
/**
* Clase que define los mensajes en inglés de estados unidos para aquellas clases que aplican el patrón Strategy
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/

public class RegionUSA implements Region{
	
	/**
	 * Método que regresa una cadena con la bienvenida a la tienda
	 */	
	@Override public String mensajeBienvenida(){
		return "**Hi there, welcome to the virtual store WOLMAR**";
	}

	/**
	 * Método que regresa una cadena con la despedida a la tienda
	 */
	@Override public String mensajeDespedida(){
		return "**See u later bro, I hope you found the gun you were looking for**";
	}

	/**
	 * Método que regresa una cadena con las ofertas de la tienda, en este caso se aplican 
	 * en el departamento de electrónica
	 */
	@Override public String mensajeOfertas(){
		return "Hey, hey! we have surprise offers in the electronics department for our USA members" +
				"\n offers of 10, 20, 40 and 60 percent";
	}

	/**
	 * Método que regresa una cadena con un menu para el cliente con las opciones que ofrece la tienda
	 */
	@Override public String mensajePrimerMenu(){
		return "1- Check menu " +
			   "\n 2- Make a purchase" +
			   "\n 3- Seal the deal"+
			   "\n 4- Exit";
	}


	/**
	 * Método que regresa una cadena con un mensaje avisando la entrada a lectura del menú
	 */
	@Override public String mensajeLeeCatalogo(){
		return "The store catalog is as follows";
	}

	/**
	 * Método que regresa una cadena avisando que entraste a la zona de compras de la tienda
	 */
	@Override public String mensajeVenta(){
		return "You just entered the sales section";
	}

	/**
	 * Método que regresa una cadena con el menú con las opciones para adquirir un producto o removerlo
	 * del carrito
	 */
	@Override public String menuVenderProducto(){
		return "0- to add a product to the cart" +
               "\n 1- to exit to the previous menu" +
               "\n 2- to remove a product from the cart";
	}

	/**
	 * Método que regresa una cadena avisando que es una opcion inválida
	 */
	@Override public String mensajeOpcionInvalida(){
		return "That is an invalid option.";
	}

	/**
	 * Método que regresa una cadena avisando que se está removiendo un producto del carrito
	 */
	@Override public String mensajeRemocionProducto(){
		return "The item is about to be removed from the cart";
	}

	/**
	 * Método que regresa una cadena solicitando código de barras para añadir un producto al carrito
	 */
	@Override public String mensajeVentaProducto(){
		return "The product will be added to the cart, type it's code: ";
	}

	/**
	 * Método que regresa una cadena avisando que no hay productos sufientes en el almacen
	 */
	@Override public String mensajeProductosInsuficientes(){
		return "Sorry, there is not enough stock of this product";
	}

	/**
	 * Método que regresa una cadena avisando que se está concretando la compra
	 */
	@Override public String mensajeConcretarCompra(){
		return "You're going to seal the deal";
	}

	/**
	 * Método que regresa una cadena avisando que la compra falló
	 */
	@Override public String mensajeCompraFallida(){
		return "Failed purchase";
	}
	
	/**
	 * Método que regresa una cadena avisando que necesita la clave del cliente para concretar la compra
	 * @param contador las oportunidades que le quedan para meter bien su clave, sino se cierra el programa
	 */	
	@Override public String mensajeSolicitaClave(int contador){
		return "Please enter your password:" +
		       "\n remaining opportunities(" + contador +").";
	}

	/**
	 * Método que regresa una cadena avisando que se aceptó la clave 
	 */
	@Override public String mensajeClaveAceptada(){
		return "accepted key";
	}

	/**
	 * Método que regresa una cadena avisando que no hay saldo sucifiente
	 * @param costo el costo del producto
	 * @param saldo el saldo del cliente
	 */
	@Override public String mensajeSaldoInsuficiente(double costo, double saldo){
		return "Sorry, your balance is insufficient, what you want to buy has a cost of" + costo + ", and your balance is " + saldo;
	}

	/**
	 * Método que regresa una cadena con la presentación del ticket de compra
	 */
	@Override public String mensajeTicket(){
		return "*****This is your ticket*****";
	}

	/**
	 * Método que se encarga de verificar si el producto es válido para un decuento dependiendo de la región
	 * @param producto el producto a checar
	 */
	@Override public Item aplicaOfertas(Producto producto){
		if (producto.getTipo().equals("electronica")) {
			LinkedList<Integer> posiblesResultados = new LinkedList<Integer>();
			posiblesResultados.add(1);
			posiblesResultados.add(2);
			posiblesResultados.add(3);
			posiblesResultados.add(4);
			Random numero = new Random();
			int resultado = posiblesResultados.get(numero.nextInt(posiblesResultados.size()));
			Descuento descuento;
			switch (resultado) {
			case 1:
				descuento = new Descuento10(producto);
				return descuento;
			case 2:
				descuento = new Descuento20(producto);
				return descuento;
			case 3:
				descuento = new Descuento40(producto);
				return descuento;
			case 4:
				descuento = new Descuento60(producto);
				return descuento;
			}
		}
		return producto;
	}
}