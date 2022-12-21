/**
* Clase que se encarga de crear un iterador para recorrer el carrito de compras
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/

public class IteradorCarrito implements Iterador{	
	private Carrito carrito;
	private int posicion;
	

	/**
	 * Método constructor del iterador
	 * @param carritoNuevo el carro que recorrerá el iterador
	 */
	public IteradorCarrito(Carrito carritoNuevo){
		if(carritoNuevo == null)throw new IllegalArgumentException();
		carrito = carritoNuevo;
		posicion = 0;
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
	 * Método que regresa el carrito que está recorriendo el iterador
	 * @return el carrito en cuestión
	 */
	public Carrito getCarrito(){
		return carrito;
	}	

	/**
	 * Método que asigna la posicion del iterador
	 * @param nuevaPosicion entero mayor o igual que cero y menor que la longitud
	 * de la lista donde el carrito almacena sus productos
	 * @return true si se logra asignar la posicion, false en cualquier otro caso
	 */
	public boolean setPosicion(int nuevaPosicion){
		if(nuevaPosicion<0 || nuevaPosicion>= carrito.getLista().size()){
			return false;			
		}else{
			posicion = nuevaPosicion;
			return true;
		}
		
	}


	/**
	 * Método que asigna el carrito a recorrer
	 * @param nuevaReferencia el nuevo carrito a recorrer
	 * @return false si el carrito es null, true en cualquier otro caso
	 */
	public boolean setCarrito(Carrito nuevaReferencia){
		if(nuevaReferencia == null){
			return false;		
		}else{
			carrito = nuevaReferencia;
			return true;
		}		
	}

	/**
	 * Método que verifica la existencia de objetos subsecuentes dentro
	 * del objeto a iterar
	 * @return false si no hay más elementos subsecuentes, true en cualquier otro caso
	 */
	@Override public boolean hasNext(){
		if((this.getPosicion()<carrito.getLista().size()) && carrito.getLista().get(this.getPosicion()) != null)return true;		
		return false;
	}

	/**
	 * Método que retorna los objetos subsecuentes dentro del objeto a iterar
	 * @return el elemento subsecuente en la iteración de la estructura
	 */	
	@Override public ProductoAdquirido next(){		
		ProductoAdquirido objetoSiguiente = carrito.getLista().get(this.getPosicion());
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