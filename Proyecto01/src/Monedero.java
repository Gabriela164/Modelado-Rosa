/**
* Clase que crea el atributo Monedero de los clientes donde se almacena su saldo
* @author Immerwahr, Gaby, SanMa
* @version 1.2
**/
public class Monedero{
	private double saldo;
	private int clave;
	private Cliente propietario;

	/**
	 * Constructor de la clase
	 * @param saldo el saldo que tendrá cuando se crea el monedero
	 * @param propietario el dueño del monedero
	 * @param clave el NIP para que sea válido su uso
	 */
	public Monedero(double saldo, Cliente propietario, int clave){
		if(saldo<0 || propietario == null)throw new IllegalArgumentException();
		this.saldo = saldo;
		this.propietario = propietario;		
		this.clave = clave;			
	}	

	/**
	 * Método que regresa el saldo de la cuenta
	 * @return el saldo de la cuenta
	 */
	public double getSaldo(){
		return saldo;
	}

	/**
	 * Método que regresa la clave de la cuenta
	 * @return la clave de la cuenta
	 */
	public int getClave(){
		return clave;
	}

	/**
	 * Método que regresa el propietario de la cuenta
	 * @return el propietario de la cuenta
	 */
	public Cliente getPropietario(){
		return propietario;
	}

	/**
	 * Método que asigna el saldo nuevo de la cuenta
	 * @param nuevoSaldo el nuevo saldo a asignar
	 * @return true si el saldo se asigna exitosamente siempre que sea una cantidad mayor o igual que cero, 
	 * false en cualquier otro caso
	 */
	public boolean setSaldo(double nuevoSaldo){
		if(nuevoSaldo <0)return false;
		saldo = nuevoSaldo;
		return true;
	}


}

