/**
* Clase que define un iterador para recorrer un menú que puede cambiar diariamente. 
* @author Immerwahr
* @version 1.1
**/
import java.util.ArrayList;

public class IteradorMenuCambiante implements Iterador{
	/**
	* <code>posicion</code> entero que indica la posición desde la que se accede al menú.
	* <code>menuParaLeer</code> estructura que almacena el menú.	
	**/
	private int posicion;
	private ArrayList<Platillo> menuParaLeer;
	

	/**
	* Método constructor de la clase.
	* @param menu <code>ArrayList</code> donde se almacena el menú, dicha estructura 
	* sera recorrida por el iterador.
	* @throws IllegalArgumentException cuando se trata de inicializar el iterador con
	* una estructura no válida para recorrer. 
	**/
	public IteradorMenuCambiante(ArrayList<Platillo> menu)throws IllegalArgumentException{
		if(menu == null)throw new IllegalArgumentException("No es un argumento válido");	
		menuParaLeer = menu;
		posicion = 0;
	}

	/**
	* Método que retorna la posición en la que se encuentra el iterador.
	* @return entero que indica la posición actual del iterador.
	**/
	public int getPosicion(){
		return posicion;
	}

	/**
	* Método que retorna la estructura de datos recorrida por el iterador.
	* @return objeto del tipo <code>ArrayList</code> que almacena los platillos en el menú.
	**/
	public ArrayList<Platillo> getMenuParaLeer(){
		return menuParaLeer;
	}

	/**
	* Método que permite asignar una nueva posición de lectura al iterador, servira para reiniciar
	* su recorrido.
	* @param nuevaPosicion entero que indica la nueva posición a asumir por el iterador.
	**/
	public void setPosicion(int nuevaPosicion){
		if(nuevaPosicion<0 || nuevaPosicion>= getMenuParaLeer().size()){
			System.out.println("Esa no es una posicion válida");
			return;
		}
		posicion = nuevaPosicion;
	}

	/**
	* Método que permite asignar un nuevo menú de lectura al iterador.
	* @param nuevoMenu <code>ArrayList</code> con un nuevo conjunto de platillos.
	**/
	public void setMenuParaLeer(ArrayList<Platillo> nuevoMenu){
		if(nuevoMenu == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}
		menuParaLeer = nuevoMenu;
	}
	
	/**
	* Método que nos permite conocer la existencia de elementos subsecuentes 
	* en la estructura de datos a recorrer.
	* @return respuesta en formato booleano sobre si existe un elemento siguiente o no.
	* Se verifica la existencia del elemento inmediato, si hay un "hueco" respondera que 
	* no hay elemento. Esta versión simple no cubre estructuras con tales "huecos" con precisión.
	**/		
	@Override public boolean hasNext(){
		if((this.getPosicion()<menuParaLeer.size()) && menuParaLeer.get(getPosicion()) != null)return true;		
		return false;
	}

	/**
	* Método que nos permite obtener el siguiente elemento dentro de la estructura, actualiza
	* la posición de lectura una vez devuelto el elemento inmediato en la sucesión.
	* @return platillo que se encuentra almacenado en la posición actual.	
	**/	
	@Override public Platillo next(){		
		Platillo platilloRetornado = menuParaLeer.get(getPosicion());
		posicion++;
		return platilloRetornado;
	}

	/**
	* Método para reiniciar la lectura del menú de principio a fin.	
	**/	
	@Override public void reiniciar(){
		this.setPosicion(0);
	}	

	
}