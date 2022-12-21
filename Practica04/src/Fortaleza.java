/**
* Clase que define un blindaje de vibranium capaz de soportar ataques de gran intensidad.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
public class Fortaleza extends Blindaje{

	/**
	* Método que permite conocer el nombre del componente.
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/
	@Override public String nombre(){
		return "Blindaje tipo Fortaleza";
	}

	/**
	* Método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/
	@Override public double precio(){
		return 300.00;
	}

	/**
	* Método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/ 
	@Override public double peso(){
		return 1000;
	}

	/**
	* Declaración del método que permite conocer los puntos de defensa que definen al tipo blindaje en concreto.
	* @return un número entero que determina las capacidades de defensa otorgadas
	* por el blindaje.
	**/ 	
	@Override public int getPuntosDefensa(){
		return 100;
	}
	
	/**
	* Método que genera una descripción para el componente.
	* @return una cadena con la descripción de las características esenciales de la pieza
	* en formato de presentación para el usuario.
	**/ 
	@Override public String descripcion(){
		return (nombre()+"\n"+"Este es el blindaje más pesado, más reforzado y más caro"+"\n"+"costo: "+precio()+" pumadolares"+"\n" 
		+ "peso: " + peso() + " kg" + "\n");		
	}
}
