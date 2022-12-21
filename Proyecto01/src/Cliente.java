/**
* Clase que define los clientes que comprarán en la tienda
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Cliente{
	private String nombre;
	private String region;
	private String contrasena;
	private int claveBancaria;
	private int id;	
	private Monedero monedero;

	/**
	 * Constructor de clientes
	 * @param nombre el nombre del cliente
	 * @param region la región del mundo desde donde accede el cliente 
	 * @param contraseña contraseña del cliente
	 * @param id número de cuenta del cliente
	 */
	public Cliente(String nombre, String region, String contrasena, int id){	
		this.nombre = nombre;
		this.region = region;
		this.contrasena = contrasena;
		this.id = id;		
	}
	
	/**
	 * Regresa el nombre del cliente
	 * @return cadena con el nombre del cliente
	 */
	public String getNombre(){
		return nombre;
	}

	/**
	 * Regresa la región del cliente
	 * @return cadena con las siglas de la región del cliente
	 */
	public String getRegion(){
		return region;
	}

	/**
	 * Regresa la contraseña del cliente
	 * @return cadena con la contraseña del cliente
	 */
	public String getContrasena(){
		return contrasena;
	}

	/**
	 * Regresa la clave del cliente
	 * @return entero con la clave bancaria de acceso (NIP) del cliente
	 */
	public int getClaveBancaria(){
		return claveBancaria;
	}

	/**
	 * Regresa el ID de usuario del cliente
	 * @return entero con el id del cliente
	 */
	public int getId(){
		return id;
	}

	/**
	 * Regresa el monedero del cliente
	 * @return objeto que modela el depósito para saldo del cliente
	 */
	public Monedero getMonedero(){
		return monedero;
	}

	/**
	 * Método que asigna un nuevo monedero del cliente
	 * @param money el nuevo monedero del cliente
	 * @return true si lo asigna, false en cualquier otro caso
	 */
	public boolean setMonedero(Monedero money){
		if(money == null)return false;
		monedero = money;
		claveBancaria = monedero.getClave();
		return true;
	}


}