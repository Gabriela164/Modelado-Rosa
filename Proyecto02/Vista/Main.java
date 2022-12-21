package Vista;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;
import java.io.*;

/**
* Clase con la entrada en ejecución main para interactuar con el programa.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Main {
    
    /**
    * Entrada a main.
    */
    public static void main(String[] args) {
        String banner =  "\u001B[36m" + " _____     *                 *       _     * _     _ _" + "\n"
                       +"\u001B[36m" + "|_   _|        *   *        *     * | |     | |  *(_) |" + "\n"
                       +"\u001B[34m" + "  | |_ _ _ __ ___   __ _  __ _  ___ | |_ ___| |__  _| |" + "\n"
                       +"\u001B[34m" + "  |/ _` | '_ ` _  \\/ _` |/ _` |/ _\\| __/ __| '_ \\ | | |" + "\n"
                       +"\u001B[32m" + "  | (_| | | | | | | (_| | (_| | (_) | || (__| | | | |_|" + "\n"
                       +"\u001B[32m" + "  |\\__,_|_| |_| |_|\\__,_|\\_ ,  \\___/ \\__\\___|_| |_|_(_)" + "\n"
                       +"\u001B[35m" + "       *          *    *  __/ |   *      *    *        " + "\n"
                       +"\u001B[35m" + "  *         *        *   |___/     *    *         *    " + "\n" + "\u001B[0m";

        Tamagotchi miTamagotchi = new Tamagotchi();
        Tienda tienda = new Tienda();
        System.out.println(banner);
        new Menu(miTamagotchi, tienda).display();
    }
}
