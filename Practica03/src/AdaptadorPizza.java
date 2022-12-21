/**
* Clase que define un adaptador para la clase de objetos, que representan pizzas producidas y
* distribuidas por la cadena de restaurantes "Las pizzas de Don Cangrejo", de tal suerte que puedan
* ser acopladas dentro del sistema de administración de platillos de "Waysub", pues la cadena
* de restaurantes, es ahora una filial de la antes mencionada.
* @author Immerwahr
* @version 1.0 
**/

public class AdaptadorPizza implements Baguette{
	
	private Pizza pizzerola;


	/**
	* Constructor de la clase.
	* Permite construir un adaptador que implementa los métodos de la
	* clase <code>Baguette</code> para acoplar las pizzas dentro del sistema de "Waysub"
	* @param pizzaNueva pizza que será ajustada a los requerimentos del sistema previo.
	* @throws IllegalArgumentException en caso de que se trate de construir un adaptador
	* con una entrada no soportada.
	**/
	public AdaptadorPizza(Pizza pizzaNueva) throws IllegalArgumentException{
		if(pizzaNueva == null)throw new IllegalArgumentException("Esa no es una entrada valida");
		pizzerola = pizzaNueva;
	}

	/**
	* Método que nos brinda una descripción general del producto.
	* @return cadena en forma de listado con los atributos del producto.
	**/
	public String getDescripcion(){
	
		String descripcion = "El producto seleccionado es: " + "pizza " + pizzerola.getNombre()+ "\n"+
		"Tipo de queso: " + pizzerola.getTipoQueso() + "\n" +
		"Tipo de masa: " + pizzerola.getTipoMasa() + "\n" +
		"Tipo de carne: " + pizzerola.getTipoCarne() + "\n" +
		"Precio: " + pizzerola.getPrecio() + "\n"; 	
		return descripcion;
	}

	/**
	* Método de acceso al precio del producto.
	* @return número de coma flotante con precisión doble que indica
	* el precio con el cuál se comercializa el producto.
	**/
	public double getPrecio(){
		return pizzerola.getPrecio();
	}


}
