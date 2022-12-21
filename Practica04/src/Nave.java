/**
* Clase que define una nave de combate general, misma que ha de ser construida según las especificaciones requeridas por el usuario.
* La construcción concreta del objeto se relega a la clase <code>NaveDirector</code> según lo estipulado por el patrón Builder.
* @author Immerwahr, SanMa, Gabby 
* @version 1.2
**/
public class Nave{
	/**
	* <code>arma</code> arsenal de ataque de la nave.
	* <code>blindaje</code> protección ante ataques enemigos.
	* <code>propulsores</code> sistema que permite a la nave desplazarse por el espacio.
	* <code>cabina</code> espacio para el traslado de la tripulación de la nave.
	* <code>precioTotal</code> costo de la nave, consta de la suma de los precios de los componentes.
	* <code>pesoTotal</code> peso en kilogramos de la nave, consta de la suma de los pesos de los componentes.
	* <code>puntosAtaque</code> capacidad de inflingir daño de la nave, determinado por <code>arma</code>.
	* <code>puntosDefensa</code> resistencia a los ataques enemigos de la nave, determinada por <code>blindaje</code>.
	* <code>velocidad</code> rapidez a la que se puede desplazar la nave, determinada por <code>propulsores</code>.
	**/
	private Arma arma;
	private Blindaje blindaje;
	private SistemaDePropulsion propulsores;	
	private Cabina cabina;
	private double precioTotal;
	private double pesoTotal;
	private int puntosAtaque;
	private int puntosDefensa;
	private double velocidad;

	/**
	* Método de acceso al precio de la nave.
	* @return número de coma flotante de doble precisión que indica el precio que alcanza la nave
	* en pumadolares.
	**/	
	public double getPrecioTotal(){
		return precioTotal;
	}
	
	/**
	* Método de acceso al peso total de la nave.
	* @return número de coma flotante de doble precisión que indica el peso total de la nave
	* en kilogramos.
	**/	
	public double getPesoTotal(){
		return pesoTotal;
	}

	/**
	* Método de acceso a las capacidades ofensivas de la nave.
	* @return número entero que indica la fuerza del impacto proporcionado por la nave.
	**/	
	public int getPuntosDeAtaque(){
		return puntosAtaque;
	}

	/**
	* Método de acceso a las capacidades defensivas de la nave.
	* @return número entero que indica la capacidad de la nave para recibir impactos.
	**/	
	public int getPuntosDefensa(){
		return puntosDefensa;
	}

	/**
	* Método de acceso a la velocidad de la nave.
	* @return número de coma flotante de doble precisión que indica la velocidad 
	* en mega kilometros sobre hora de la nave.
	**/	
	public double getVelocidad(){
		return velocidad;
	}

	/**
	* Método para asignar un arma a la nave
	* @param armaNueva el arma que portara la nave y que le permitira infringir daño
	* a los enemigos.
	* @throws IllegalArgumentException si se pasa un arma no inicializada.
	**/		
	public void agregaArma(Arma armaNueva)throws IllegalArgumentException{
		if(armaNueva == null)throw new IllegalArgumentException("Ese no es un argumento válido");		
		arma = armaNueva;
		puntosAtaque = armaNueva.getPuntosAtaque();	
		pesoTotal += armaNueva.peso();
		precioTotal += armaNueva.precio();	
	}

	/**
	* Método para asignar un blindaje a la nave
	* @param armaNueva el blindaje que protejera la nave y que le permitira resistir
	* los embates del enemigo.
	* @throws IllegalArgumentException si se pasa un blindaje no inicializado.
	**/	
	public void agregaBlindaje(Blindaje blindajeNuevo)throws IllegalArgumentException{
		if(blindajeNuevo == null)throw new IllegalArgumentException("Ese no es un argumento válido");	
		blindaje = blindajeNuevo;	
		puntosDefensa = blindajeNuevo.getPuntosDefensa();
		pesoTotal += blindajeNuevo.peso();
		precioTotal += blindajeNuevo.precio();			
	}

	/**
	* Método para asignar un sistema de propulsión a la nave
	* @param armaNueva el sistema de propulsores de la nave y que le permitira desplazarse
	* por el espacio.
	* @throws IllegalArgumentException si se pasa un sistema de propulsión no inicializado.
	**/	
	public void agregaPropulsores(SistemaDePropulsion nuevosPropulsores)throws IllegalArgumentException{
		if(nuevosPropulsores == null)throw new IllegalArgumentException("Ese no es un argumento válido");	
		propulsores = nuevosPropulsores;
		velocidad = nuevosPropulsores.velocidad();
		pesoTotal += nuevosPropulsores.peso();
		precioTotal += nuevosPropulsores.precio();			
	}

	/**
	* Método para asignar una cabina a la nave
	* @param armaNueva la cabina en la que la nave transportara al personal que la maneja.	
	* @throws IllegalArgumentException si se pasa una cabina no inicializada.
	**/	
	public void agregaCabina(Cabina cabinaNueva)throws IllegalArgumentException{
		if(cabinaNueva == null)throw new IllegalArgumentException("Ese no es un argumento válido");	
		cabina = cabinaNueva;
		pesoTotal += cabinaNueva.peso();
		precioTotal += cabinaNueva.precio();			
	}

	/**
	* Método que permite conocer el estado de construcción de la nave.
	* @return respuesta en formato booleano que nos dice si la nave cuenta ya con todos
	* los atributos necesarios para ponerse en marcha.	
	**/	
	public boolean estaTerminada(){
		return (arma != null && blindaje != null && propulsores != null && cabina != null);
	}	

	/**
	* Método que permite conocer las características generales de la nave.
	* @return cadena en formato de presentación para el usuario que contiene las características que
	* definen a la nave siempre que se haya construido por completo.
	**/	
	public String descripcion(){		
		if(!estaTerminada())return "";
		String descripcionNave = "Su nave fue armada con las siguientes piezas: " + "\n";
		descripcionNave += (arma.descripcion() + "\n");
		descripcionNave += (blindaje.descripcion() + "\n");
		descripcionNave += (propulsores.descripcion() + "\n");
		descripcionNave += (cabina.descripcion() + "\n");
		descripcionNave += ("El precio total de la nave es: " + getPrecioTotal() + " puma dolares" +"\n");
		descripcionNave += ("El peso total de la nave es: " + getPesoTotal() + " kg" + "\n");
		descripcionNave += ("Las características funcionales de la nave son: " + "\n");
		descripcionNave += ("Tiene "+getPuntosDeAtaque()+" puntos de ataque, "+getPuntosDefensa()+" puntos de defensa, "+"\n");
		descripcionNave += ("y "+getVelocidad()+" Mkm/h de velocidad."+"\n");
		return descripcionNave;
	}


}
