import java.util.Random;
import java.util.LinkedList;
/**
* Clase que define los mensajes en español de España para aquellas clases que aplican el patrón Strategy* 
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class RegionEsp implements Region{
	

	/**
	 * Método que regresa una cadena con la bienvenida a la tienda
	 */
	@Override public String mensajeBienvenida(){
		return "Hola tio, bienvenido a la tienda virtual de lobezno, a todo gas";
	}

	/**
	 * Método que regresa una cadena con la despedida a la tienda
	 */
	@Override public String mensajeDespedida(){
		return "Espero que os haya molado, suscribiros al canal y activad la campanita";
	}

	/**
	 * Método que regresa una cadena con las ofertas de la tienda, en este caso se aplican 
	 * en el departamento de electrodomésticos
	 */
	@Override public String mensajeOfertas(){
		return "¡Jolines!, contamos con ofertas sorpresa en todo el departamento de electrodomésticos" +
				"\n ofertas del 10, 20, 40 y 60 por ciento";
	}

	/**
	 * Método que regresa una cadena con un menu para el cliente con las opciones que ofrece la tienda
	 */
	@Override public String mensajePrimerMenu(){
		return "1- Leer menú " +
			   "\n 2- Hacer la compra" +
			   "\n 3- Concretar compra"+
			   "\n 4- Salir";
	}

	/**
	 * Método que regresa una cadena con un mensaje avisando la entrada a lectura del menú
	 */
	@Override public String mensajeLeeCatalogo(){
		return "El catálogo de la tienda es el siguiente tío";
	}

	/**
	 * Método que regresa una cadena avisando que entraste a la zona de compras de la tienda
	 */
	@Override public String mensajeVenta(){
		return "Acabaís de entrar a la sección de ventas";
	}

	/**
	 * Método que regresa una cadena con el menú con las opciones para adquirir un producto o removerlo
	 * del carrito
	 */
	@Override public String menuVenderProducto(){
		return "0- Añadir un producto a la compra" +
               "\n 1- Regresar al menú anterior" +
               "\n 2- Eliminar un producto del carrito";
	}
	
	/**
	 * Método que regresa una cadena avisando que es una opcion invalida
	 */
	@Override public String mensajeOpcionInvalida(){
		return "Opción inválida Tío";
	}

	/**
	 * Método que regresa una cadena avisando que se está removiendo un producto del carrito
	 */
	@Override public String mensajeRemocionProducto(){
		return "El articulo se eliminará de la compra";
	}

	/**
	 * Método que regresa una cadena solicitando código de barras para añadir un producto al carrito
	 */
	@Override public String mensajeVentaProducto(){
		return "Se añadirá el producto a la compra, inserta su código: ";
	}

	/**
	 * Método que regresa una cadena avisando que no hay productos sufientes en el almacen
	 */
	@Override public String mensajeProductosInsuficientes(){
		return "Joee, no hay suficientes representantes de este producto";
	}

	/**
	 * Método que regresa una cadena avisando que se está concretando la compra
	 */
	@Override public String mensajeConcretarCompra(){
		return "Estas por concretar tu compra";
	}

	/**
	 * Método que regresa una cadena avisando que la compra falló
	 */
	@Override public String mensajeCompraFallida(){
		return "Compra fallida";
	}
	
	/**
	 * Método que regresa una cadena avisando que necesita la clave del cliente para concretar la compra
	 * @param contador las oportunidades que le quedan para meter bien su clave, sino se cierra el programa
	 */	
	@Override public String mensajeSolicitaClave(int contador){
		return "Por favor, ingresa tu contraseña: " +
		       "\n oportunidades restantes(" + contador +").";
	}

	/**
	 * Método que regresa una cadena avisando que se aceptó la clave 
	 */
	@Override public String mensajeClaveAceptada(){
		return "Clave aceptada";
	}

	/**
	 * Método que regresa una cadena avisando que no hay saldo sucifiente
	 * @param costo el costo del producto
	 * @param saldo el saldo del cliente
	 */
	@Override public String mensajeSaldoInsuficiente(double costo, double saldo){
		return "Lo siento, tu saldo es insuficiente, lo que quieres comprar tiene un costo de " + costo + " , y tu saldo es " + saldo;
	}
	
	/**
	 * Método que regresa una cadena con la presentación del ticket de compra
	 */
	@Override public String mensajeTicket(){
		return "*****Este es tu ticket tío*****";
	}

	/**
	 * Método que se encarga de verificar si el producto es válido para un decuento dependiendo de la región
	 * @param producto el producto a checar
	 */
	@Override public Item aplicaOfertas(Producto producto){
		if (producto.getTipo().equals("electrodomésticos")) {
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