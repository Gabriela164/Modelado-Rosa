package Modelo;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Controlador.*;
import Vista.*;
import java.util.Random;

/**
* Clase que define una estructura donde se guarda un glosario con las palabras
* a ser adivinadas por el usuario. 
* @author Gabby, SanMa, Immerwahr.
* @version 1.1 
**/
public class PalabraSecreta{
	private String palabras [] = new String[30];

	/**
	* Constructor auxiliar de almacen con todas las palabras disponibles para el juego
	*/
	private void almacenDePalabras(){
		palabras[0] = "japon";
		palabras[1] = "nave";
		palabras[2] = "mesa";
		palabras[3] = "silla";
		palabras[4] = "beso";
		palabras[5] = "amor";
		palabras[6] = "gato";
		palabras[7] = "perro";
		palabras[8] = "puma";
		palabras[9] = "canek";
		palabras[10] = "bacalao";
		palabras[11] = "ayudantia";
		palabras[12] = "teclado";
		palabras[13] = "computadora";
		palabras[14] = "algoritmo";
		palabras[15] = "monitor";
		palabras[16] = "almeja";
		palabras[17] = "quesadilla";
		palabras[18] = "ciencia";
		palabras[19] = "materia";
		palabras[20] = "electroencefalografista";
		palabras[21] = "anticonstitucional";
		palabras[22] = "desproporcionadamente";
		palabras[23] = "bioluminiscencia";
		palabras[24] = "bioelectromagnetismo";
		palabras[25] = "electrodomestico";
		palabras[26] = "televisor";
		palabras[27] = "paralelepipedo";
		palabras[28] = "caleidoscopio";
		palabras[29] = "ñ";
	}

	/**
	* Método que se encarga de escoger una palabra al azar del almacen y la regresa
	* @param tope está relaciona con la dificultad escogida por el usuario, y este hace referencia al tope 
	* en el arreglo a palabras para buscar, es decir, si la dificultad esogida es fácil, <code>tope<code> será 10
	* así, la palabra escogida al azar sólo podrá estar en las 10 primeras.
	* @return la palabra escogida
	**/
	public String elegirPalabra(int tope){
		almacenDePalabras();
		int numero = 0;
		if (tope == 10) {
			numero = (int)(Math.random()*10);
			return palabras[numero];
		}else if(tope == 20){
			numero = (int)(Math.random()*10 + 10);
			return palabras[numero];
		}else{
			numero = (int)(Math.random()*10 + 20);
			return palabras[numero];
		}
	}

}