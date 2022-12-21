/**
* Clase que define una cabina para un sólo tripulante, no recomendada para naves de gran envergadura.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
public class UnPiloto extends Cabina{

	/**
	* Método que permite conocer el nombre del componente.
	* @return una cadena que nos otorga el nombre general de la pieza.
	**/
	@Override public String nombre(){
		return "Cabina para un único piloto";
	}

	/**
	* Método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/
	@Override public double precio(){
		return 75.00;
	}

	/**
	* Método que permite conocer el peso en kilogramos del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el peso de la pieza.
	**/
	@Override public double peso(){
		return 60.5;
	}

	/**
	* Método que genera una descripción para el componente.
	* @return una cadena con la descripción de las características esenciales de la pieza
	* en formato de presentación para el usuario.
	**/ 
	@Override public String descripcion(){
		return (nombre()+"\n"+"Este es la cabina más ligera, más barata y con menos capacidad"+"\n"+"costo: "
			+ precio() +" pumadolares"+"\n"+ "peso: " + peso() + " kg" + "\n");		
	}
}
