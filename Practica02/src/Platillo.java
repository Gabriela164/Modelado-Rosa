/**
* Clase que define los platillos a ser ingresados en el menú y que
* serán ofrecidos por la cadena de restaurantes.
* @author SanMa
* @version 1.2
**/
public class Platillo{

	/**<code>id</code> clave alfanúmerica diseñada para identificar de forma única al producto.
	* <code>nombre</code> marca registrada por la cadena de restaurantes que identifica al producto.
	* <code>descripcion</code> un breve sumario de las características del producto.
	* <code>precio</code> costo en moneda de circulación universitaria.	
	* <code>conQueso</code> booleano que define la existencia de queso dentro de la preparación del platillo.
	* <code>vegetariano</code> booleano que define el tipo de proteína que se uso dentro de la preparación del platillo.	 
	**/
	private String id;
	private String nombre;
	private String descripcion;
	private double precio;
	private boolean conQueso;
	private boolean vegetariano;

	
	/**
	* Metodo constructor de la clase
	* @param id clave alfanúmerica que identifica al producto dentro del sistema.
	* @param nombre marca comercial con la que se conocerá el producto.
	* @param descripcion un listado de las caractrísticas más relevantes del producto.
	* @param precio costo del platillo (en pumadolares).
	* @param conQueso booleano que nos indica si el producto tiene queso o no.
	* @param vegetariano booleano que nos indica si el producto es vegetariano. 
	**/
	public Platillo(String id, String nombre, String descripcion, double precio, boolean conQueso, boolean vegetariano){
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.conQueso = conQueso;
		this.vegetariano = vegetariano;
	}

	/**
	* Método de acceso al id del producto.
	* @return cadena con la clave alfanúmerica que identifica al producto.
	**/
	public String getId(){
		return this.id;
	} 

	/**
	* Método de acceso al nombre del producto.
	* @return cadena con el nombre comercial del producto.
	**/
	public String getNombre(){
		return this.nombre;
	}

	/**
	* Método de acceso a la descripción del producto.
	* @return cadena con una descripción general del producto y sus ingredientes.
	**/
	public String getDescripcion(){
	    return this.descripcion;	
	}

	/**
	* Método de acceso al precio del producto.
	* @return número de coma flotante con doble precisión que indica el 
	* precio en la moneda oficial, pumadolares.
	**/
	public double getPrecio(){
		return this.precio;
	}

	/**
	* Método que nos indica si el producto tiene queso.
	* @return respuesta en formato booleano sobre si el producto tiene queso o no.
	**/
	public boolean getConQueso(){
		return this.conQueso;
	}

	/**
	* Método que nos indica si el producto está hecho a base de proteina animal o vegetal.
	* @return respuesta en formato booleano sobre si el producto está hecho con imitación
	* de carne hecha de soja o no.
	**/
	public boolean getVegetariano(){
		return this.vegetariano;
	}

	/**
	* Método que presenta la información general del producto.
	* @return cadena que contiene toda la información sobre el producto en formato
	* para su lectura y presentación.
	**/
	public String toString(){
		return "La Hamburguesa "+ getNombre() +" tiene las siguientes características: " + "\n" +
		       "Id de la Hamburguesa: " + getId() + "\n" + 		 
		       "Descripción de la Hamburguesa: " + getDescripcion() + "\n" + 
		       "Precio de la Hamburguesa: " + getPrecio() + "\n" + 
		       "La Hamburguesa lleva queso T/F: " + getConQueso() + "\n" +
		       "La Hamburguesa es vegetariana: " + getVegetariano() + "\n"; 
	}
}