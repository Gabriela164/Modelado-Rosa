/**
* Clase abstracta que declara los métodos que deben implementar las piezas/componentes del tipo cabina,
* mismos que los distinguen de otro tipo de componentes para una nave.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/
///Para esta implementación de la solución, no hay características particulares que
///distingan a una cabina de otros componentes, pero la clase abstracta evita que se asignen
///componentes inadecuados en el apartado correspondiente de la nave.

public abstract class Cabina implements Component{

	/**
	* Declaración del método que permite conocer el costo del componente en cuestión.
	* @return un número de coma flotante en doble precisión que indica el costo
	* de la pieza en pumadolares.
	**/ 	
	@Override public abstract double precio();	
}
