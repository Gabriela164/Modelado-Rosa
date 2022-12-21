package Vista;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;
import java.io.*; 

/**
* Clase que una skin donde la mascota es el conejo que habita en la luna.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class ConejoLunar implements Apariencia{
	
	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está contenta.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota siendo feliz.
	**/
	@Override
	public String graficoFeliz(){
		return   "\u001B[33m" + " ------------------------ " + "\n"
				+"  ♪  *  ∩    ∩  ♬         " + "\n"
				+"        ||__||  *         " + "\n"
				+"  *    (*. ὼ .)    *      " + "\n"
				+"      (() ♪   /))     *   " + "\n"
				+"   *(( (_____|            " + "\n"
				+" *       U  U    ♫        " + "\n"
				+" ------------------------ " + "\n" + "\u001B[0m";
	}

	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está jugando.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota jugando.
	**/
	@Override
	public String graficoJugando(){
		return   "\u001B[33m" + " ------------------------- " + "\n"
				+"     *  ∩    /)        *   " + "\n"
				+" YUPI!  ||__//  * (||)     " + "\n"
				+"  *    ( . ▼ .)            " + "\n"
				+"       /Ο    γϽ       *    " + "\n"
				+"   * (( ) _ /)  *          " + "\n"
				+"      \\Ͻ  \\Ͻ     *       " + "\n"
				+"  *                  *     " + "\n"
				+" ------------------------- " + "\n" + "\u001B[0m";
	}

	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está comiendo.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota comiendo.
	**/	
	@Override
	public String graficoComiendo(){
		return   "\u001B[33m" + " ------------------------ " + "\n"
				+"   YUM! ∩    ∩    *   *   " + "\n"
				+"     *  ||__||  *         " + "\n"
				+"  *    (*. ▼ .)   Ѽ  *   " + "\n"
				+"       /Ο     Ͻ  ѼѼ  *  " + "\n"
				+"   *(((_____/   ѼѼѼ    " + "\n"
				+" *     U  U    ѼѼѼѼ   " + "\n"
				+" ------------------------ " + "\n" + "\u001B[0m";
	}

	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está durmiendo.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota durmiendo.
	**/
	@Override	
	public String graficoDurmiendo(){
		return   "\u001B[33m" + " ------------------------ " + "\n"
				+"     *      *      *      " + "\n"
				+"         *    z  *   *    " + "\n"
				+"  *    *     * z          " + "\n"
				+"     _  ___     z /) /)   " + "\n"
				+"  ((Ϲ γ'    '\\ ,// //    " + "\n"
				+"     |_)>____´Ͻ( - ὼ -)´Ͻ " + "\n"
				+" ------------------------ " + "\n" + "\u001B[0m";
	}	

	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota no se encuentra de buen ánimo.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota no muy contenta.
	**/	
	@Override
	public String graficoIndispuesto(){
		return   "\u001B[33m" + " ------------------------ " + "\n"
				+"          *       *       " + "\n"
				+"     *  ∩    ∩        *   " + "\n"
				+"        ||__||  *         " + "\n"
				+"  *    (      )    *      " + "\n"
				+"       )      \\       *  " + "\n"
				+"   *   (    Ο )  *        " + "\n"
				+" ------------------------ " + "\n" + "\u001B[0m";
	}

	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota necesita un baño.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota con manchas de suciedad encima.
	**/	
	@Override
	public String graficoSucio(){
		return   "\u001B[33m" + " ------------------------- " + "\n"
				+"     *  ∩    ∩     *   *   " + "\n"
				+"        ||__||  *          " + "\n"
				+"  *    (░. _ .)    *    *  " + "\n"
				+"       ()   /))      *     " + "\n"
				+"   *(( (___░_|    *        " + "\n"
				+" *       U  U          *   " + "\n"
				+" ------------------------- " + "\n" + "\u001B[0m";
	}


	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota murió.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota ya fallecida.
	**/	
	@Override
	public String graficoMuerto(){
		return   "\u001B[33m" + " ------------------------- " + "\n"
				+"     *       *   *    *    " + "\n"
				+"          *             *  " + "\n"
				+"  *      ,,,,*    *  *     " + "\n"
				+"       .'   '.             " + "\n"
				+"   *   | RIP |  *      *   " + "\n"
				+" *     |     |     *       " + "\n"
				+" ------------------------- " + "\n" + "\u001B[0m";
	}

	/**
	* Método que permite acceder al nombre de la mascota.
	* @return cadena con el nombre de la apariencia.
	**/	
	@Override
	public String getNombre(){
		return "Conejo Lunar";
	}


	/**
	* Método que permite acceder al precio de la skin.
	* @return entero con el precio en moneda virtual de la skin.
	**/	
	@Override
	public int precio(){
		return 5;
	}
}