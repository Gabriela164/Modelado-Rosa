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
public class MenuDeJuegos{
	
	/**
	* Método que gestiona la selección de un minijuego para el tamagotchi.
	* @param juegosDisponibles los juegos disponibles para entretener al usuario.
	* @return entero que indica la selección el usuario.
	*/
	public int menuJuegos(AlmacenDeMiniJuegos juegosDisponibles){
		System.out.println("\u001B[34m" + "Bienvenido a la zona de minijuegos");
		System.out.println("Los juegos disponibles son los siguientes: ");
		for (int i = 0; i < juegosDisponibles.getLista().size(); i++) {
			System.out.println( i+1 + ".- " + juegosDisponibles.getLista().get(i).getNombre());
		}

		System.out.println("Ingresa el número del juego que quieras jugar: " + "\u001B[0m");
		int opcion = auxiliar(1, juegosDisponibles.getLista().size());
		int i = 0;
		switch (opcion) {
			case 1:
				i = new PiedraPapelTijeras().minijuego();
				break;
			case 2:
				i = new Ahorcado().minijuego();
				break;
			case 3:
				i = new JuegoGato().minijuego();
				break;
		}
		return i;

	}

	/**
    * Método auxiliar que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
    private int auxiliar(int inicio, int fin)throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("\u001B[34m"+ " ---> " + "\u001B[0m");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("\u001B[34m"+"Ingresa una opción válida"+ "\u001B[0m");
                }
            }catch (NumberFormatException ex){
                System.out.println("\u001B[34m"+"Ingresa un NUMERO valido"+ "\u001B[0m");
            }       
        }while(bandera == false);
        return opcion;
    }
}