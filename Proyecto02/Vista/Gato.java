package Vista;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Controlador.*;
import java.io.*;

/**
* Clase que una skin donde la mascota es un michi.
* @author Gabby, SanMa, Immerwahr.
* @version 1.3 
**/
public class Gato implements Apariencia{
    
    /**
    * Método que permite al tamagotchi mostrar una imagen que indique
    * que la mascota está contenta.
    * @return cadena que genera una imagen con caractéres que nos muestra
    * a la mascota siendo feliz.
    **/
     @Override
    public String graficoFeliz(){
         return "\u001B[35m" + "  --------------------------------- " + "\n"
               + "                                 .--.       " + "\n"
               + "                                 \\   \\      " + "\n"
               + "                                  \\   \\     " + "\n"
               + "                                  |    |      " + "\n"
               + "                                  |    |      " + "\n"
               + "              /\\---/\\   _,---._ |    |      " + "\n"
               + "             /^   ^  \\,'                ;    " + "\n"
               + "            ( O   O   )                ;      " + "\n"
               + "             `.=o=__,'                \\      " + "\n"
               + "             /         _,--.__       \\       " + "\n" 
               + "            /  _ )   ,'   `-. `-.     \\      " + "\n"
               + "           / ,' /  ,'        \\  \\  \\   \\  " + "\n"
               + "          / /  / ,'          (,__)  (,__)     " + "\n"
               + "         (,;  (,,)                            " + "\n"
               + " ---------------------------------- " + "\n" + "\u001B[0m";
    }

     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota está jugando.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota jugando.
     **/
     @Override
	public String graficoJugando(){
     return "\u001B[35m"+ " ---------------------------------------- "      + "\n"
          + "                                                 " + "\n"
          + "                            ,,                   " + "\n"
          + "     ,-.       _,---._ __  /  \\                 " + "\n"
          + "    /  )    .-'       `./ /    \\                " + "\n"
          + "   (  (___,'            `/     /|                " + "\n"  
          + "   \\                   \\ \\    / |                " + "\n"
          + "    `.              ,  \\ \\   /  |                " + "\n"
          + "      /`.          ,'-`----Y    |                " + "\n"
          + "     (            ;        |    '                " + "\n"
          + "     |  ,-.    ,-'         |   /                 " + "\n"
          + "     |  | (   |            |  /                  " + "\n"
          + "     )  |  \\  `.__________|/                    " + "\n"
          + "     `--'   `--'                                 " + "\n"
          + " ------------------------------------------     " + "\n" +"\u001B[0m";
    }	
	
     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota está comiendo.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota comiendo.
     **/  
     @Override
     public String graficoComiendo(){
        return "\u001B[35m" +" ------------------------------------ "             + "\n"
             + "                         _  .----.                     " + "\n"
             + "               |\\---/|  / ) | cat|                     " + "\n"     
             + "  ------------;      |-/ /  |food|---                  " + "\n"
             + "              )      (' /   `----'                     " + "\n"
             + "  ===========(       ,'==========                      " + "\n"
             + "  ||   _     |       |                                 " + "\n"
             + "  || o/ )    |       | o                               " + "\n"
             + "  || ( (    /        ;                                 " + "\n"
             + "  ||  \\ `._/        /                                 " + "\n"
             + "  ||   `._          /|                                 " + "\n"
             + "  ||      | \\    _/||                                 " + "\n"
             + "__||_____.'  )   |__||____________                     " + "\n"
             + "________\\   |   |_________________                    " + "\n"
             + "         \\  \\   `-.                                  " + "\n"
             + "          `----`----'                                  " + "\n"
             + " -------------------------------------                " + "\n" +"\u001B[0m";
    }
	
     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota está durmiendo.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota durmiendo.
     **/
     @Override
     public String graficoDurmiendo(){
        return "\u001B[35m" + " --------------------------------------------------           " + "\n"
             + "                      ,                                       " + "\n"
             + "                     /|                                       " + "\n"
             + "                ___,/'\\                                      " + "\n"
             + "           ,-''`    ~ `;                                      " + "\n"
             + "          .`\\  /     `\\.                                    " + "\n"
             + "        ,/_ _ |\\       `\\     ,--,_____,-''                 " + "\n"
             + "  ,_,-'''`    \\`\\ `-/ ,  \\  /     /   __/                  " + "\n"
             + "    `''~-\\    \\    /  .-' |/         /                      " + "\n"
             + "         `\\ ___, .-; '.-'   /                                " + "\n"
             + "          `\\_. `-'__,  ___/  ___/                            " + "\n"
             + "           `\\`  /`__  /     /                                " + "\n"
             + "             _,-`--'  /                                       " + "\n"
             + "          .-''      _/   /    /                               " + "\n"
             + "         /    _,-''`/  /'    /                                " + "\n"
             + "         \\___/                                               " + "\n"     
             + " -------------------------------------------------            " + "\n" + "\u001B[0m";
    }
	
     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota no se encuentra de buen ánimo.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota no muy contenta.
     **/  
     @Override
     public String graficoIndispuesto(){
      return "\u001B[35m" + " --------------------------------------------------           " + "\n"
           + "                    *     ,MMM8&&&.            *              " + "\n"
           + "                         MMMM88&&&&&    .                     " + "\n"
           + "                        'MMM88&&&&&&'                         " + "\n"
           + "                          'MMM8&&&'      *                    " + "\n"
           + "                  |\\___/|                                    " + "\n"
           + "                  )     (            .              '         " + "\n"
           + "                 =\\     /=                                    " + "\n"
           + "                   )===(       *                              " + "\n"
           + "                  /     \\                                    " + "\n"
           + "                 |       |                                    " + "\n"
           + "                /        \\                                   " + "\n"
           + "                \\        /                                   " + "\n"
           + "         \\_/\\_/\\__  _/_/\\_/\\_/\\_/\\_/\\_                " + "\n"
           + "         |  |  |  | ( ( |  |  |  |  |  |  |  |                " + "\n"
           + "         |  |  |  | ) ) |  |  |  |  |  |  |  |                " + "\n"
           + "         |  |  |  |  |  |  |  |  |  |  |  |  |                " + "\n"
           + " --------------------------------------------------           " + "\n" + "\u001B[0m";
    }	

     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota necesita un baño.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota con manchas de suciedad encima.
     **/  
     @Override
     public String graficoSucio(){
        return "\u001B[35m" + " --------------------------------------------------          " + "\n" 
             + "     ,_         _,                                           " + "\n" 
             + "     |\\.-'''''-./|                                          " + "\n" 
             + "     \\`   ░░░░    `/                                        " + "\n" 
             + "     / ░░░_   _░░░ \\                                        " + "\n" 
             + "     |    a _ a    |                                         " + "\n" 
             + "     '.= ░░ Y ░░ =.'                                         " + "\n" 
             + "       >._  ^  _.<                                           " + "\n" 
             + "      /   `````   \\                                         " + "\n" 
             + "      )  ░░░░░░    (                                         " + "\n" 
             + "     ,( ░░░░░░░░░  ),                                        " + "\n" 
             + "    / ) ░ /   \\ ░ ( \\                                      " + "\n" 
             + "    ) ( ░ )   ( ░  ) (                                       " + "\n" 
             + "    ( ) ░ (   ) ░  ( )                                       " + "\n" 
             + "    )_( ░ )   ( ░  )_(-.._                                   " + "\n" 
             + "   (  )_░ (._.) ░_ (  )__, `\\                               " + "\n" 
             + "    ``( ░░)   ( ░░ )``  .' .'                                " + "\n" 
             + "        ```     ```    ( (`                                  " + "\n" 
             + "                        '-'                                  " + "\n" 
             + " --------------------------------------------------          " + "\n" + "\u001B[0m";
    }	 

     /**
     * Método que permite al tamagotchi mostrar una imagen que indique
     * que la mascota murió.
     * @return cadena que genera una imagen con caractéres que nos muestra
     * a la mascota ya fallecida.
     **/  
     @Override
	public String graficoMuerto(){
        return "\u001B[35m" + " ----------------------------------            " + "\n" 
             + "    RIP       ____                             " + "\n" 
             + "   ,_        (----)      ___,_,                " + "\n" 
             + "    \\ `-.__ |\\__/|_.-'     /                  " + "\n" 
             + "   |       =) 'T' (=       |                   " + "\n" 
             + "     \\      /'--' \\     /                     " + "\n" 
             + "      '.___()    (/___.'                       " + "\n" 
             + "            |    |                             " + "\n" 
             + "           /\\   /\\                           " + "\n" 
             + "           \\  T  /                            " + "\n" 
             + "           (/   \\)                            " + "\n" 
             + "              ))                               " + "\n" 
             + "             ((                                " + "\n" 
             + "             \\)                               " + "\n" 
             + " ----------------------------------            " + "\n" + "\u001B[0m"; 
    }

    /**
    * Método que permite acceder al nombre de la mascota.
    * @return cadena con el nombre de la apariencia.
    **/  
    @Override
    public String getNombre(){
		return "Gato";
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