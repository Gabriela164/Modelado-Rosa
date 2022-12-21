/**
* Clase que define una clase de objetos que representan pizzas producidas y
* distribuidas, por la cadena de restaurantes "Las pizzas de Don Cangrejo".
* La cadena de restaurantes es ahora una filial de "WaySub".
* @author Immerwahr
* @version 1.0 
**/

import java.lang.IllegalArgumentException;

public class Pizza{
	
	/**
	* <code>nombrePizza</code> nombre distintivo que recuerda a uno de los miembros
	* de la "Liga de los súper conocidos", marca registrada.
	* <code>tipoQueso</code> variedad de queso con el cuál se gratina la pizza
	* de entre 2 a elegir: Chedar y Manchego.
	* <code>tipoMasa</code> determina el grosor de la masa sobre la cuál se prepara
	* la pizza.
	* <code>tipoCarne</code> variedad de producto carnico que cubre la superficie
	* de la pizza de entre tres a elegir: salchicha, jamón y pollo.
	* <code>precio</code> costo del producto en moneda local, puma dolares.
	**/
	private String nombrePizza;
	private String tipoQueso;
	private String tipoMasa;
	private String tipoCarne;
	private float precio;
	
	/**
	* Constructor de la clase.
	* Permite construir única y exclusivamente, objetos de entre 5 variedades fijas
	* y predefinidas.
	* @param nombre determina la variedad de pizza a construir.
	* @throws IllegalArgumentException en caso de que se trate de construir una variedad
	* de pizza que no se encuentre entre las 5 permisibles, incluye entradas nulas o vacías.
	**/
	public Pizza(String nombre) throws IllegalArgumentException{		
		nombrePizza = nombre;
		switch (nombre){
		case "Banda elastica":			
			tipoQueso = "Manchego";
			tipoMasa = "delgada";
			tipoCarne = "jamon y salchicha";
			precio = (float)35.0;
			break;
		case "Desiaparicion":
			tipoQueso = "Manchego";
			tipoMasa = "gruesa";
			tipoCarne = "salchicha";
			precio = (float)30.0;
			break;
		case "Capitan Magma":
			tipoQueso = "Manchego";
			tipoMasa = "delgada";
			tipoCarne = "pepperoni";
			precio = (float)31.0;
			break;
		case "Carrerin":
			tipoQueso = "Chedar y Manchego";
			tipoMasa = "gruesa";
			tipoCarne = "sin carne";
			precio = (float)27.0;
			break;
		case "Sirenoman":
			tipoQueso = "Chedar y Manchego";
			tipoMasa = "gruesa";
			tipoCarne = "salchicha, pollo y jamon";
			precio = (float)40.5;
			break;
		default:
			throw new IllegalArgumentException("Esa no es una entrada valida");
		}
	}

	/**
	* Método de acceso al nombre comercial del producto.
	* @return marca registrada que distingue a la variedad de pizza en cuestión.
	**/
	public String getNombre(){
		return nombrePizza;
	}

	/**
	* Método de acceso al tipo de queso que gratina al producto.
	* @return cadena que indica la variedad de queso que recubre 
	* la superficie de la pizza.
	**/
	public String getTipoQueso(){
		return tipoQueso;
	}

	/**
	* Método de acceso al tipo de masa con la que se elaboró el producto.
	* @return cadena que indica el grosor de la masa.
	**/
	public String getTipoMasa(){
		return tipoMasa;
	}

	/**
	* Método de acceso al tipo de carne con la que se elaboró el producto.
	* @return cadena que indica el tipo de carne empleada en la elaboración
	* de la pizza.
	**/
	public String getTipoCarne(){
		return tipoCarne;
	}

	/**
	* Método de acceso al precio del producto.
	* @return número de coma flotante con precisión simple que indica
	* el precio con el cuál se comercializa el producto.
	**/
	public float getPrecio(){
		return precio;
	}	
	

}
