/**
 * Clase abstracta a extender por los objetos de tipo menú
 * que almacenan una estructura de datos cuyo contenido son
 * platillos ofrecidos por la cadena de restaurantes.
 * @author Immerwhar.
 * @version 1.2
 ***/

public abstract class Menu{

	/**
	* Método que genera un iterador que permite recorrer la estructura de datos
	* donde se almacena el menú.	
	* @return el iterador recien creado, incializado en su forma base.
	**/
	public abstract Iterador creaIterador();	
	
	/**
	 * Método para incluir un nuevo platillo en el menú.
	 * @param platilloAnadido platillo que sera incluído dentro del menú. 
	**/
	public abstract void addItem(Platillo platilloAnadido);	
	
	/**
	 * Método para remover un platillo del menú.
	 * @param platilloRemovido platillo que sera eliminado del menú. 
	**/
	public abstract void removeItem(Platillo platilloRemovido);

	/**
	 * Método para buscar un platillo del menú según su id.
	 * @param id cadena que define el id del platillo buscado.
	 * @return el platillo buscado si el id coincide con alguno de los almacenados o null si no se 
	 * encuentra (aplica para entradas nulas o vacias).
	**/
	public Platillo busquedaPorId(String id){		
		Iterador iterador = this.creaIterador();
		Platillo comida;
		while(iterador.hasNext()){
			comida = (Platillo)iterador.next();
			if(comida.getId().equals(id))
				return comida;			
		}
		return null;
	}
	
}