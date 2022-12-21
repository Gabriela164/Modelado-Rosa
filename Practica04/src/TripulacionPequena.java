/**
* Clase que define una cabina para una tripulación pequeña parte de una nave del ejercito imperial.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
public class TripulacionPequena extends Cabina{

	/**
	* Método que permite conocer el nombre del componente.
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/
	@Override public String nombre(){
		return "Cabina para una tripulación de 8 personas";
	}

	/**
	* Método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/
	@Override public double precio(){
		return 125.00;
	}

	/**
	* Método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/
	@Override public double peso(){
		return 190;
	}

	/**
	* Declaración del método que permite conocer los puntos de defensa que definen al tipo blindaje en concreto.
	* @return un número entero que determina las capacidades de defensa otorgadas
	* por el blindaje.
	**/ 
	@Override public String descripcion(){
		return (nombre()+"\n"+"Este es la cabina más equilibrada"+"\n"+"costo: "+precio()+" pumadolares"+"\n" 
		+ "peso: " + peso() + " kg" + "\n");		
	}
}
