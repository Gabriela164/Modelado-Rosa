/**
* Clase que define una interfaz a implementar por aquellos objetos que almacenaran
* los elemntos con los que trabajaremos
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public interface Catalogo{
	/**
	 * Método que crea un iterador para recorrer el catálogo
	 * @return el iterador creado
	 */	
	public Iterador creaIterador();

	/**
	 * Busca por el catalogo con un id y regresa el objeto
	 * @param id el objeto a buscar tiene ese Id
	 * @return el objeto que tenga como id el buscado
	 */
	public Object busquedaPorId(int id);	
}