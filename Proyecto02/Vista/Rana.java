package Vista;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;
import java.io.*;

/**
* Clase que una skin donde la mascota es una ranita saltarina.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Rana implements Apariencia {
	
	/**
	* Método que permite al tamagotchi mostrar una imagen que indique
	* que la mascota está contenta.
	* @return cadena que genera una imagen con caractéres que nos muestra
	* a la mascota siendo feliz.
	**/
	@Override
	public String graficoFeliz(){
		return    "\u001B[32m" + " ------------------------- " + "\n"
		        + "          _    _           " + "\n"
		        + "         (o)--(o)          " + "\n"
		        + "        /.______.\\        " + "\n"
		        + "        \\________/        " + "\n"
		        + "       ./        \\.       " + "\n"
		        + "      ( .        , )       " + "\n"
		        + "       \\ \\_\\\\//_/ /    " + "\n"
		        + "        ~~  ~~  ~~         " + "\n"
		        + " ------------------------- " + "\n" + "\u001B[0m";
	}

	/**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota está jugando.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota jugando.
    **/
    @Override
	public String graficoJugando(){
		return    "\u001B[32m" + " ---------------------------------------" + "\n"
		        + "    .(0,-.0)._                          " + "\n"
		        + "    (------,   ` -. _                   " + "\n"
		        + "     \\.____/         \\._              " + "\n"
		        + "       / /  /  __          \\_._        " + "\n"
		        + "      / /   / ./  \\_____./'\\._  <     " + "\n"
		        + "   /\\/\\    /\\/\\    \\  /       \\/' " + "\n"
		        + "                        \\ \\_          " + "\n"
		        + "                      ./\\/\\/'         " + "\n"
		        + " ---------------------------------------" + "\n" + "\u001B[0m";
	}

	/**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota está comiendo.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota comiendo.
    **/  
    @Override
	public String graficoComiendo(){
		return   "\u001B[32m" + " -----------------------------------" + "\n"
				+"          ___      ___              " + "\n"
				+"         /   \\----/   \\           " + "\n"
				+"        |-----|  |-----|            " + "\n"
				+"        /\\_0_/    \\_0_/\\         " + "\n"
				+"      -|      o  o      |-          " + "\n"
				+"     /  \\______________/  \\       " + "\n"
				+"     \\ \\ |   |    |   | / /       " + "\n"
				+"      ww ooooo----ooooo ww          " + "\n"
				+" -----------------------------------" + "\n" + "\u001B[0m";
	}

	/**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota está durmiendo.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota durmiendo.
    **/
    @Override
	public String graficoDurmiendo(){
		return   "\u001B[32m" + " ------------------------           " + "\n"
				+"        ___      ___                " + "\n"
				+"       ((-)).--.((-))               " + "\n"
				+"       /     ''     \\        z Z   " + "\n"
				+"      (    ------    )    z Z       " + "\n"
				+"       \\            / z Z           " + "\n"
				+"       / /~      ~\\ \\             " + "\n"
				+" ------------------------           " + "\n" + "\u001B[0m";
	}	

	/**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota no se encuentra de buen ánimo.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota no muy contenta.
    **/  
    @Override
	public String graficoIndispuesto(){
		return   "\u001B[32m" + " ----------------------------------------                              " + "\n"
				+"                __   __                              . '  '  .       " + "\n"
				+"         /`\\  .( o)-( o).  /`\\                   . '            '  . " + "\n"
				+"        / , \\(  _______  )/ , \\             () .'                    " + "\n"
				+"    ___/ /_\\ /`---------`\\ /_\\ \\___        `()                     " + "\n"
				+"    `~//^\\~_`\\  <__ __>  /`_~/^\\\\~`                                " + "\n"
				+"            `~//^\\~`~//^\\~`                                        " + "\n"
				+" ----------------------------------------                              " + "\n" + "\u001B[0m";
	}


    /**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota necesita un baño.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota con manchas de suciedad encima.
    **/  
    @Override
	public String graficoSucio(){
		return    "\u001B[32m" + " ------------------------- " + "\n"
		        + "          _    _           " + "\n"
		        + "         (o)--(o)          " + "\n"
		        + "        /.______.\\        " + "\n"
		        + "        \\________/        " + "\n"
		        + "       ./   ░    \\.       " + "\n"
		        + "      ( .  ░    ░, )       " + "\n"
		        + "       \\ \\_\\\\//_/ /    " + "\n"
		        + "        ~~  ~~  ~~         " + "\n"
		        + " ------------------------- " + "\n" + "\u001B[0m";
	}

	/**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota murió.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota ya fallecida.
    **/  
    @Override
	public String graficoMuerto(){
		return    "\u001B[32m" + " ------------------------- " + "\n"
		        + "          _    _           " + "\n"
		        + "         (x)--(x)          " + "\n"
		        + "        /.______.\\        " + "\n"
		        + "        \\________/        " + "\n"
		        + "       ./        \\.       " + "\n"
		        + "      ( .        , )       " + "\n"
		        + "       \\ \\_\\\\//_/ /    " + "\n"
		        + "        ~~  ~~  ~~         " + "\n"
		        + " ------------------------- " + "\n" + "\u001B[0m";
	}


    /**
    * Método que permite acceder al nombre de la mascota.
    * @return cadena con el nombre de la apariencia.
    **/  
    @Override
	public String getNombre(){
		return "Rana";
	}
	
	/**
    * Método que permite acceder al precio de la skin.
    * @return entero con el precio en moneda virtual de la skin.
    **/  
    @Override 
	public int precio(){
		return 0;
	}
}