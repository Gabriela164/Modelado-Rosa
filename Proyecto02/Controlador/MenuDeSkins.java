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
* Clase que presenta un menú de skins a elegir por el usuario.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class MenuDeSkins{
	
	
	/**
	* Método que gestiona la selección de una skin para el tamagotchi.
	* @param skinsDisponibles las apariencias disponibles para mostrarle al usuario.
	* @return la <code>Apariencia</code> seleccionada por el usuario.
	*/
	public Apariencia menuSkins(AlmacenDeSkins skinsDisponibles){
		System.out.println("\u001B[36m" + "Bienvenido a la zona de apariencias del tamagotchi");
		System.out.println("Las apariencias disponibles son las siguientes: ");
		for (int i = 0; i < skinsDisponibles.getLista().size(); i++) {
			System.out.println( i+1 + ".- " + skinsDisponibles.getLista().get(i).getNombre());
		}

		System.out.println("Ingresa el número de la apariencia que te quieres probar: " + "\u001B[0m");
		int opcion = auxiliar(1, skinsDisponibles.getLista().size());
		int i = 0;
		Apariencia skin = null;
		switch (opcion) {
			case 1:
				skin = new Gato();
				break;
			case 2:
				skin = new Rana();
				break;
			case 3:
				skin = new ConejoLunar();
				break;
		}

		return skin;
	}

	/**
    * Método auxiliar que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin Cota superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
    private int auxiliar(int inicio, int fin)throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("\u001B[36m" + "---> " + "\u001B[0m");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("\u001B[36m" + "Ingresa una opción válida" + "\u001B[0m");
                }
            }catch (NumberFormatException ex){
                System.out.println("\u001B[36m" + "Ingresa un NUMERO valido" + "\u001B[0m");
            }       
        }while(bandera == false);
        return opcion;
    }
}