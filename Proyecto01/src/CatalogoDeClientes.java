import java.util.Hashtable;
import java.util.Enumeration;

/**
* Clase encargada de llevar un control más limpio de los clientes
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class CatalogoDeClientes implements Catalogo{
	private Hashtable<Integer, Cliente> tablaClientes;
	


	/**
	 * Constructor del catálogo de clientes, que los almacena en una hashtable inicializada
	 * con una capacidad para 25 objetos del tipo cliente.
	 */
	public CatalogoDeClientes(){
		tablaClientes = new Hashtable<Integer, Cliente>(25);
	}


	/**
	 * Regresa la hastable donde se están almacenando los clientes
	 * @return la hastable donde se están almacenando los clientes
	 */
	public Hashtable<Integer, Cliente> getTablaClientes(){
		return tablaClientes;
	}

	/**
	 * Método que asigna una nueva hashtable en el catalogo del clientes
	 * @param nuevoCatalogo la nueva hashtable donde se van a almacenar los clientes
	 * @return false, si el la hashtable es null, true en cualquier otro caso 
	 */
	public boolean setTablaClientes(Hashtable<Integer, Cliente> nuevoCatalogo){
		if(nuevoCatalogo == null){
			return false;		
		}else{
			tablaClientes = nuevoCatalogo;
			return true;
		}

	}

	/**
	 * Método encargado de agregar un cliente al catálogo
	 * @param cliente el nuevo cliente a agregar.
	 * @return true si se agregó el cliente, false en cualquier otro caso
	 */
	public boolean addCliente(Cliente cliente){
		if(cliente == null || tablaClientes.contains(cliente) || tablaClientes.containsKey(cliente.getId()))return false;			
		tablaClientes.put(cliente.getId(),cliente);
		return true;
	}

	/**
	 * Método encargado de eliminar un cliente del catálogo
	 * @param cliente el cliente a eliminar.
	 * @return true si se eliminó el cliente, false en cualquier otro caso
	 */
	public boolean removeCliente(Cliente clienteAEliminar){
		if(clienteAEliminar == null || !tablaClientes.contains(clienteAEliminar))return false;		
		tablaClientes.remove(clienteAEliminar.getId(),clienteAEliminar);
		return true;		
	}

	/**
	 * Método que crea un iterador para recorrer el catálogo
	 * @return el iterador creado
	 */
	@Override public IteradorCatalogoDeClientes creaIterador(){
		IteradorCatalogoDeClientes iterador = new IteradorCatalogoDeClientes(this);
		return iterador;
	}

	/**
	 * Busca por el catálogo con un id y regresa el objeto
	 * @param idBuscado  id del objeto buscado que corresponde a su número de usuario
	 * @return el objeto que tenga como id aquel pasado como parámetro
	 */
	@Override public Cliente busquedaPorId(int idBuscado){
		IteradorCatalogoDeClientes iterador = this.creaIterador();
		Cliente cliente;
		while(iterador.hasNext()){
			cliente = (Cliente)iterador.next();
			if(cliente.getId() == idBuscado)
				return cliente;			
		}
		return null;
	}
	
}