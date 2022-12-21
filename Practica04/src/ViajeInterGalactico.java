/**
* Clase que define un sistema de propulsión ultra potente capaz de hacer saltos espacio temporales
* para viajes inter galácticos.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
public class ViajeInterGalactico extends SistemaDePropulsion{

	/**
	* Método que permite conocer el nombre del componente.
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/
	@Override public String nombre(){
		return "Viaje Inter-Galactico";
	}

	/**
	* Método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/
	@Override public double precio(){
		return 500.00;
	}

	/**
	* Método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/
	@Override public double peso(){
		return 1020.5;
	}

	/**
	* Método que permite conocer la velocidad a la que el sistema de propulsión le permite desplazarse a la nave.
	* @return un número de coma flotante en doble precisión que indica la velocidad en mega kilometros sobre hora.
	**/ 
	@Override public double velocidad(){
		return 350;
	}

	/**
	* Método que genera una descripción para el componente.
	* @return una cadena con la descripción de las características esenciales de la pieza
	* en formato de presentación para el usuario.
	**/ 
	@Override public String descripcion(){
		return (nombre()+"\n"+"Este sistema de propulsion más rápido, más pesado, y más caro"+"\n"+"costo: "
			+precio()+" pumadolares"+"\n"+ "peso: " + peso() + " kg" + "\n");		
	}
}
