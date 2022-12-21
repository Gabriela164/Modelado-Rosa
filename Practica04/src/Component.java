/**
* Interfaz que declara los métodos que deben implementar las piezas/componentes de una 
* nave necesariamente
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/

public interface Component{

	/**
	* Declaración del método que permite conocer el nombre del componente
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/ 
	public String nombre();

	/**
	* Declaración del método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/ 
	public double precio();

	/**
	* Declaración del método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/ 
	public double peso();

	/**
	* Declaración del método que genera una descripción para el componente.
	* @return una cadena con la descripción de las características esenciales de la pieza
	* en formato de presentación para el usuario.
	**/ 
	public String descripcion();	
	
}
