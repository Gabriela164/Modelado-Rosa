package Vista;


/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;

/**
* Interfaz que define el comportamiento básico de los objetos que se encargan
* de presentar la apariencia de la máscota acorde al patrón Strategy.
* depende de su estado actual.
* @author Gabby, SanMa, Immerwahr.
* @version 1.3
**/
public interface Apariencia{

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está contenta.
	**/	
	public String graficoFeliz();

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está jugando.
	**/	
	public String graficoJugando();	

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está comiendo.
	**/	
	public String graficoComiendo();

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está durmiendo.
	**/	
	public String graficoDurmiendo();

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota no se encuentra de buen ánimo.
	**/	
	public String graficoIndispuesto();

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota necesita un baño.
	**/	
	public String graficoSucio();

	/**
	* Declaración del método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota murió.
	**/		
	public String graficoMuerto();

	/**
	* Declaración del método que permite acceder al nombre de la mascota.
	**/	
	public String getNombre();

	/**
	* Declaración del método que permite acceder al precio de la skin.
	**/	
	public int precio();
}