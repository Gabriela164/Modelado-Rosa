package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.io.*;
import java.util.Scanner;

/**
* Clase que define un minijuego, en concreto el juego conocido como piedra, papel o tijeras,
* para que el usuario tenga una experiencia más entretenida.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class PiedraPapelTijeras implements MiniJuego{
	private static final String NOMBRE = "Piedra, papel o tijeras";
	
    /**
    * Método que permite conocer el nombre del juego.
    * @return una cadena con el nombre que identifica al juego.
    **/
    @Override
	public String getNombre(){
		return NOMBRE;
	}


    /**
    * Método que permite conocer el precio del juego.
    * @return un entero con el costo en moneda virtual del juego.
    **/
	public int precio(){
		return 0;
	}

	/**
    * Método que gestiona el acceso al juego y sus opciones,
    * además se encarga de devolver los puntos obtenidos al jugar.
    * @return entero con los puntos obtenidos en una partida del juego.
    **/
    @Override
	public int minijuego(){
		Scanner lector = new Scanner(System.in);
		int opcionUsuario = 0;
		int opcionComputadora = 0;
		int contadorVictorias = 0;
		int contadorDerrotas = 0;
		boolean salidaConcedida = false;
		System.out.println("\u001B[36m"+"¡Juguemos piedra, papel o tijeras!");
		String menu = "¿Cuál será tu movimiento?" + "\n" +"Papel:= presiona 1" + "\n" + "Piedra:= presiona 2" + 
					  "\n" + "Tijeras:= 3" + "\n" + "Salir:= 4" + "\n";
		while(true){			
			System.out.print(menu);
			try{
				opcionUsuario = lector.nextInt();
				opcionComputadora = (int)((Math.random() * ((3 - 1) + 1)) + 1);
			}catch(Exception excp){
				System.out.println("Esa no es una opción valida");
				lector = new Scanner(System.in);
				continue;
			}			
			if(opcionUsuario == opcionComputadora){
			System.out.println("Empate");
			continue;
			}
			switch (opcionUsuario){
			case 1:
				if(opcionComputadora == 2){					
					System.out.println("Elegiste papel y tu contrincante eligió piedra,¡Ganaste!");
					contadorVictorias++;
				}else{
					System.out.println("Elegiste papel y tu contrincante eligió tijeras, perdiste :(");
					contadorDerrotas++;
				}
				break;			
			case 2:
				if(opcionComputadora == 1){
					System.out.println("Elegiste piedra y tu contrincante eligio papel, perdiste :(");
					contadorDerrotas++;
				}else{
					System.out.println("Elegiste piedra y tu contrincante eligio tijeras, ¡Ganaste!");
					contadorVictorias++;
				}
				break;	
			case 3:
				if(opcionComputadora == 1){
					System.out.println("Elegiste tijeras y tu contrincante eligio papel, ¡Ganaste!");
					contadorVictorias++;
				}else{
					System.out.println("Elegiste tijeras y tu contrincante eligio piedra, perdiste :(");
					contadorDerrotas++;
				}
				break;
			case 4:
				String despedida = "Fin de la partida." + "\n" + "Marcador: " + contadorVictorias + " triunfos, " + 
					                contadorDerrotas + " derrotas" + "\u001B[0m";
				System.out.println(despedida);
				salidaConcedida = true;
				break;
			default:
				System.out.println("Esa no es una opción valida");
				break;
			}
			if(salidaConcedida == true){
				if(contadorDerrotas >= contadorVictorias)return 0;
				return (contadorVictorias - contadorDerrotas);
			}

		}
 	}
	
	

	


}