/**
* Clase que define un iterador para recorrer un menú de lujo para clientes especiales. 
* @author Immerwahr
* @version 1.1
**/
import java.util.Hashtable;
import java.util.Enumeration;

public class IteradorMenuEspecial implements Iterador{
	
	/**
	* <code>menuParaLeer</code> estructura que almacena el menú.
	* <code>platillosDelMenu</code> enumeración que permite iterar sobre el menú.
	**/
	Hashtable<String, Platillo> menuParaLeer;
	Enumeration<Platillo> platillosDelMenu;


	/**
	* Método constructor de la clase.
	* @param menu <code>Hastable</code> donde se almacena el menú, dicha estructura 
	* será recorrida por el iterador.
	* @throws IllegalArgumentException cuando se trata de inicializar el iterador con
	* una estructura no válida para recorrer. 
	**/
	public IteradorMenuEspecial(Hashtable<String, Platillo> menu)throws IllegalArgumentException{
		if(menu==null)throw new IllegalArgumentException("No es un argumento válido");
		this.menuParaLeer = menu;
		this.platillosDelMenu = menuParaLeer.elements();
	}

	/**
	* Método que retorna el menú que recorre el iterador.
	* @return objeto del tipo <code>Hashtable</code> que almacena platillos de lujo.
	**/
	public Hashtable<String, Platillo> getMenuParaLeer(){
		return menuParaLeer;		
	}

	/**
	* Método que retorna una enumeración con los platillos almacenados en el menú.
	* @return objeto del tipo <code>Enumeration</code> que permite iterar sobre el menú.
	**/
	public Enumeration<Platillo> getPlatillosDelMenu(){
		return platillosDelMenu;
	}

	/**
	* Método que asigna un nuevo menú a recorrer.
	* @param menuNuevo estructura del tipo <code>Hashtable</code> que almacena el nuevo menú
	* a recorrer. 
	**/
	public void setMenuParaLeer(Hashtable<String, Platillo> menuNuevo){
		if(menuNuevo == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}
		menuParaLeer = menuNuevo;
	}

	/**
	* Método auxiliar que asigna una nueva enumeración como instrumento para 
	* recorrer el menú. Se usara exclusivamente como auxiliar del método para reiniciar el
	* iterador, de lo contrario, la estabilidad del mismo no quedaria garantizada.
	* @param enumeracionNueva objeto de tipo <code>Enumeration</code> que nos permite
	* iterar sobre la estructura que recorre el menú.
	**/
	private void setPlatillosDelMenu(Enumeration<Platillo> enumeracionNueva){
		if(enumeracionNueva == null){
			System.out.println("Esa no es una entrada válida");
			return;
		}
		platillosDelMenu = enumeracionNueva;
	}		

	/**
	* Método que nos permite conocer la existencia de elementos subsecuentes en la
	* estructura de datos a recorrer.
	* @return respuesta en formato booleano sobre si existe un elemento siguiente o no.	
	**/	
	@Override public boolean hasNext(){
		return platillosDelMenu.hasMoreElements();
	}

	/**
	* Método que nos permite obtener el siguiente elemento dentro de la estructura.
	* @return platillo que se encuentra almacenado en la posición actual.	
	**/	
	@Override public Platillo next(){
		return platillosDelMenu.nextElement();
	}
	
	/**
	* Método para reiniciar la lectura del menú de principio a fin.	
	**/	
	@Override public void reiniciar(){
		this.setPlatillosDelMenu(menuParaLeer.elements());
	}	
}