package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Controlador.*;
import Vista.*;
import java.util.LinkedList;

/**
* Clase que define una estructura donde se almacenan las skins que permiten
* emular distintos tipos de mascota.
* @author Gabby, SanMa, Immerwahr. 
**/
public class AlmacenDeSkins{

	private LinkedList<Apariencia> apariencias = new LinkedList<>();

	/**
	* Constructor de la clase con 2 skins por defecto, <code>Gato</code> y <code>Rana</code>.
	*/
	public AlmacenDeSkins(){
		apariencias.add(new Gato());
		apariencias.add(new Rana());
	}

	/**
	* Método de acceso a la lista que almacena los skins.
	* @return <code>LinkedList</code> que almacena las apariencias.
	*/
	public LinkedList<Apariencia> getLista(){
		return this.apariencias;
	}

	/**
	* Método que permite añadir nuevas apariencias al catálogo.
	* @param skin nueva apariencia para emular una criatura distinta. ////ESTE ES EL REPETIDO
	*/
	public void agregarJuegoDisponible(Apariencia skin){
		this.apariencias.add(skin);
	}
}