/**
* Clase abstracta que declara los métodos que deben implementar las piezas/componentes del tipo arma,
* mismos que los distinguen de otro tipo de componentes para una nave.
* @author Immerwahr, SanMa, Gabby 
* @version 1.1
**/

public abstract class Arma implements Component{	
	
	/**
	* Declaración del método abstracto que brinda los puntos de ataque
	* que la pieza le proporciona a la nave.
	* @return un entero que indica la cantidad exacta de puntos de ataque.
	**/
	public abstract int getPuntosAtaque();
}
