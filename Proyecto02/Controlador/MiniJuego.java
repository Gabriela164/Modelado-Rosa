package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;

/**
* Interfaz que define los métodos básicos a implementar por los minijuegos
* a los cuales el usuario podrá acceder desde el tamagotchi.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public interface MiniJuego{
	/**
    * Declaración del método que permite conocer el nombre del juego.  
    **/
	public String getNombre();

	/**
    * Declaración del método que gestiona el acceso al juego y sus opciones,
    * además se encarga de devolver los puntos obtenidos al jugar.  
    **/
	public int minijuego();
	
	/**
    * Declaración del método que permite conocer el precio del juego.
    **/
	public int precio();
}