import java.util.LinkedList;

/**
* Clase Combate encargada de generar los tres combates requeridos
* @author Juan Daniel San Martin Macias, Gabriela López Diego.
* @version 1.0 Septiembre 2022
*/
public class Combate implements Observable{

	private LinkedList<Espectadores> listaDeEspectadores; //Espectadores del combate (Observers)
	private Peleador Dittu;
	private Peleador Korby;
	private Peleador MeganMan;
	private Peleador ganadorDelCombate;
	private Peleador perdedorDelCombate;
	private Bitacora bitacora; //Bitacora que se encarga de guardar los detalles del combate

	/**
	 * Constructor de la clase Combate
	 */
	public Combate(Korby Korby, Dittu Dittu, MeganMan MeganMan, LinkedList<Espectadores> listaDeEspectadores){
		this.Korby = Korby;
		this.Dittu = Dittu;
		this.MeganMan = MeganMan;
		this.listaDeEspectadores = listaDeEspectadores;
	}

	/*
	 * Metodo que se encarga de notificar a cada uno de los espectadores los
	 * detalles de la pelea en un archivo de texto
	 */
	@Override
	public void notificar(){
		bitacora.crearArchivo(listaDeEspectadores);
	}

	/**
	 * Método que se encarga de agregar un observador a la lista de espectadores del Combate.
	 * @param espectador espectador a ser agregado a la lista
	 */
	@Override
	public void agregarObservador(Espectadores espectador){
		listaDeEspectadores.add(espectador);
	}

	/**
	 * Método que se encarga de agregar una Bitacora al Combate
	 * @param bitacora bitacora a ser agregada
	 */
	public void setBitacora(Bitacora bitacora){
		this.bitacora = bitacora;
	}

	/**
	 * Método que se encarga de regresar la Bitacora del Combate
	 * @return bitacora, la bitacora en cuestión
	 */
	public Bitacora getBitacora(){
		return bitacora;
	}

	/**
	 * Método que se encarga de regrasar la lista de espectadores del Combate
	 * @return la lista de Espectadores
	 */
	public LinkedList<Espectadores> getListaDeEspectadores(){
		return listaDeEspectadores;
	}

	/**
	 * Método que se encarga de regresar al Peleador Ganador del Combate
	 * @return ganador del combate
	 */
	public Peleador getGanadorDelCombate(){
		return ganadorDelCombate;
	}

	/**
	 * Método que se encarga de asignar el ganador del Combate.
	 * @param ganadorDelCombate peleador ganador del Combate
	 */
	public void setGanadorDelCombate(Peleador ganadorDelCombate){
		this.ganadorDelCombate = ganadorDelCombate;
	}

	/**
	 * Método que se encarga regresar el perdedor del combate
	 * @return el Peleador perdedor del combate
	 */
	public Peleador getPerdedorDelCombate(){
		return perdedorDelCombate;
	}

	/**
	 * Método que se encarga de asignar el perdedor del combate
	 * @param perdedorDelCombate peleador perdedor del combate
	 */
	public void setPerdedorDelCombate(Peleador perdedorDelCombate){
		this.perdedorDelCombate = perdedorDelCombate;
	}
}
