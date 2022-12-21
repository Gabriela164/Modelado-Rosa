/**
* Interfaz a implementar por aquellos objetos tales que, encapsulan el comportamiento
* referente a la capacidad de recorrer una estructura de datos, en una sola dirección.
* @author Immerwahr
* @version 1.1
**/

public interface Iterador{

	/**
	* Método que permite al iterador conocer  la existencia de elementos
	* subsecuentes, dentro de la estructura a recorrer.
	* @return respuesta en formato booleano sobre si hay o no un objeto subsecuente.
	**/
	public boolean hasNext();

	/**
	* Declaración del método para acceder a los objetos almacenados dentro 
	* de la estructura de datos a recorrer.
	* @return objeto almacenado dentro de la estructura de datos.
	**/
	public Object next();

	/**
	* Declaración del método para reiniciar la lectura de la estructura de datos de principio a fin.	
	**/	
	public void reiniciar();
}