package Vista;


/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;
import java.util.Scanner;
import java.io.*;

/**
* Clase que presenta un menú de acceso a los recursos que ofrece el tamagotchi.
* @author Gabby, SanMa, Immerwahr.
* @version 1.3 
**/
public class Menu {
    Tamagotchi tamagotchi;
    Tienda tienda;

    /**
    * Cosntructor de la clase.
    * @param tamagochi mascota con la cuál interactua el usuario
    * @param tienda almacen de recursos a los que accede el usuario para mejorar su experiencia.
    **/
    public Menu(Tamagotchi tamagochi, Tienda tienda) {
        this.tamagotchi = tamagochi;
        this.tienda = tienda;
    }

    /**
    * Método que presenta las distintas opciones con las que cuenta
    * el usuario para interactuar con su mascota.
    **/
    public void display() {
        String bye =  "\u001B[31m" + " _  *    *          _  *      *    * _ "  + "\n" +
                    "\u001B[31m" + "| |  *        *    | |    *         | |"  + "\n" +
                    "\u001B[33m" + "| |__  _   _  ___ *| |__  _   _ *___| |"  + "\n" +
                    "\u001B[33m" + "| '_ \\| | | |/ _ \\ | '_ \\| | | |/ _ \\ |"  + "\n" +
                    "\u001B[37m" + "| |_) | |_| |  __/ | |_) | |_| |  __/_|" + "\n" +
                    "\u001B[37m" + "|_.__/ \\__, |\\___| |_.__/ \\__, |\\___(_)"  + "\n" +
                    "\u001B[30m" + " *      __/ |  *    *      __/ |  *    * "  + "\n" +
                    "\u001B[30m" + "    *  |___/    *      *  |___/  *   * "  + "\n" + "\u001B[0m";
        Scanner scanner = new Scanner(System.in);
        char opcion;
        String mensajeOpciones = "\u001B[32m" + "Realizar acción: " +"\n"
                                +"a) Alimentar" +"\n"
                                +"b) Bañar "+"\n"
                                +"d) Dormir"+"\n"
                                +"j) Jugar"+"\n"
                                +"p) Preguntar ¿Cómo estás?"+"\n"
                                +"c) Cambiar skin"+"\n"
                                +"t) Tienda"+"\n"
                                +"s) Salir";
        while (true) {
            System.out.println(" ");
            System.out.println(mensajeOpciones);
            System.out.print("--> ");
            opcion = scanner.next().charAt(0);
            opcion = Character.toLowerCase(opcion);
            switch (opcion) {
                case 'a': 
                    tamagotchi.alimentar(); 
                    break;
                case 'b': 
                    tamagotchi.baniar(); 
                    break;
                case 'd': 
                    tamagotchi.dormir(); 
                    break;
                case 'j': 
                    tamagotchi.jugar(); 
                    break;
                case 't':
                    tienda.operacionTienda(tamagotchi);  
                    break;
                case 'c':
                    tamagotchi.cambiarSkin();
                    break;
                case 'p': 
                    tamagotchi.comoEstas(); 
                    break;
                case 's':                     
                    System.out.println(bye + "\u001B[0m"); 
                    System.exit(0);
                default: 
                    System.out.println("Opcion no válida");
            }
        }
    }
}
