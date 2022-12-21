/**
* Interfaz Observable, que implementan las clases a observar
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public interface Observable{
	/**
	 * Método encargado de agregar un observador a la lista de espectadores del combate
	 * @param espectador el espectador a agregar.
	 */
	public void agregarObservador(Espectadores espectador);
	/**
	 * Método encargado de notificar los cambios realizados en la clase observada a todos los espectadores
	 */
	public void notificar();
}