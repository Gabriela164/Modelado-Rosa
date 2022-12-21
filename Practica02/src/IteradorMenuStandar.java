/**
* Clase que define un iterador para recorrer un menú que se mantiene a lo largo del tiempo,
* todos los días activos del negocio. 
* @author Immerwahr
* @version 1.1
**/

public class IteradorMenuStandar implements Iterador{
	/**
	* <code>posicionActual</code> entero que indica la posición a la que apunta el iterador.
	* <code>menuParaLeer</code> arreglo que almacena los platillos en el menu.
	**/	
	private int posicionActual;
	private Platillo[] menuParaLeer;

	/**
	* Método constructor de la clase.
	* @param menu arreglo donde se almacena el menú, dicha estructura 
	* será recorrida por el iterador.
	* @throws IllegalArgumentException cuando se trata de inicializar el iterador con
	* una estructura no valida para recorrer. 
	**/
	public IteradorMenuStandar(Platillo[] menu)throws IllegalArgumentException{
		if(menu == null)throw new IllegalArgumentException("No es un argumento valido");
		posicionActual = 0;
		menuParaLeer = menu;
	}
	
	/**
	* Método que retorna la posición en la que se encuentra el iterador.
	* @return entero que indica la posición actual del iterador.
	**/
	public int getPosicionActual(){
		return posicionActual;
	}

	/**
	* Método que retorna la estructura que recorre el iterador.
	* @return arreglo que almacena objetos de la clase <code>Platillo</code> en el menú estandar.
	**/
	public Platillo[] getMenuParaLeer(){
		return menuParaLeer;
	}	

	/**
	* Método que ajusta la posición a la que apunta el iterador.
	* @param posicionNueva entero que indica la nueva posición en el arreglo
	* desde la cual se lo va a recorrer, servira para reiniciarlo.
	**/
	public void setPosicionActual(int posicionNueva){
		if(posicionNueva<0 || posicionNueva>= menuParaLeer.length){
			System.out.println("Esa no es una posicion aceptable");
			return;
		}
		posicionActual = posicionNueva;
	}

	/**
	* Método que ajusta el menu a leer por el iterador.
	* @param menuNuevo arreglo que almacena el nuevo menú a recorrer siempre que sea válido.
	**/
	public void setMenuParaLeer(Platillo[] menuNuevo){
		if(menuNuevo == null){
			System.out.println("Esa no es una posicion aceptable");
			return;
		}
		menuParaLeer = menuNuevo;
	}	

	/**
	* Método que nos permite conocer la existencia de elementos subsecuentes en la
	* estructura de datos a recorrer.
	* @return respuesta en formato booleano sobre si existe un elemento siguiente o no.
	**/	
	@Override public boolean hasNext(){
		if(getPosicionActual()<menuParaLeer.length && menuParaLeer[getPosicionActual()] != null)return true;		
		return false;
	}

	/**
	* Método que nos permite obtener el siguiente elemento dentro de la estructura, actualiza
	* la posición de lectura una vez devuelto el elemento inmediato en la sucesión.
	* @return platillo que se encuentra almacenado en la posición actual.	
	**/	
	@Override public Platillo next(){		
		Platillo platilloRetornado = menuParaLeer[getPosicionActual()];
		posicionActual++;
		return platilloRetornado;
	}

	/**
	* Método para reiniciar la lectura del menú de principio a fin.	
	**/	
	@Override public void reiniciar(){
		this.setPosicionActual(0);
	}	

	
}