package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/
import Controlador.*;
import Vista.*;
import java.util.LinkedList;

/**
* Clase que define una estructura donde se almacenan los juegos que enriquecen
* la experiencia del usuario.
* @author Gabby, SanMa, Immerwahr. 
**/
public class AlmacenDeMiniJuegos{
	private LinkedList<MiniJuego> juegos = new LinkedList<>();

	/**
	* Constructor de la clase con 2 juegos por defecto, <code>PiedraPapelTijeras</code> y <code>Ahorcado</code>.
	*/
	public AlmacenDeMiniJuegos(){
		juegos.add(new PiedraPapelTijeras());
		juegos.add(new Ahorcado());
	}

	/**
	* Método de acceso a la lista que almacena los juegos.
	* @return <code>LinkedList</code> que almacena los minijuegos.
	*/
	public LinkedList<MiniJuego> getLista(){
		return this.juegos;
	}

	/**
	* Método que permite añadir nuevos juegos al catálogo.
	* @param juego nueva opción para entretener al usuario. ////ESTE ES EL REPETIDO
	*/
	public void agregarJuegoDisponible(MiniJuego juego){
		this.juegos.add(juego);
	}
}