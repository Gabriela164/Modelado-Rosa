/**
* Clase que define un arma que dispara un lasér capaz de destruir planetas pequeños.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
public class LaserDestructorDePlanetas extends Arma{

	/**
	* Método que permite conocer el nombre del componente.
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/
	@Override public String nombre(){
		return "Laser Destructor De Planetas";
	}

	/**
	* Método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/
	@Override public double precio(){
		return 105.00;
	}

	/**
	* Método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/ 
	@Override public double peso(){
		return 235.5;
	}

	/**
	* Método abstracto que brinda los puntos de ataque que la pieza le proporciona a la nave.
	* @return un entero que indica la cantidad exacta de puntos de ataque.
	**/
	@Override public int getPuntosAtaque(){
		return 100;
	}

	/**
	* Método que genera una descripción para el componente.
	* @return una cadena con la descripción de las características esenciales de la pieza
	* en formato de presentación para el usuario.
	**/ 
	@Override public String descripcion(){
		return (nombre()+"\n"+"Este lasér es el más potente del mercado"+"\n"+"costo: "+precio()+" pumadolares"+"\n" 
		+ "peso: " + peso() + " kg" + "\n");			
	}
}
