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
* Clase que define un minijuego, en concreto el juego del ahorcado,
* para que el usuario tenga una experiencia más entretenida.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Ahorcado implements MiniJuego{
    private int intentosTotales = 10;
    private static final String NOMBRE = "Ahorcado";
    
    /**
    * Método que permite conocer el nombre del juego.
    * @return una cadena con el nombre que identifica al juego.
    */
    @Override
    public String getNombre(){
        return this.NOMBRE;
    }

    /**
    * Método que permite conocer el precio del juego.
    * @return 0 toda vez que el juego viene integrado por defecto en el tamagotchi.
    **/
    @Override
    public int precio(){
        return 0;
    }

    /**
    * Método que gestiona el acceso al juego y sus opciones,
    * además se encarga de devolver los puntos obtenidos al jugar.
    * @return entero con los puntos obtenidos en una partida del juego.
    **/
    
    public int minijuego(){
        Scanner in = new Scanner(System.in);
        System.out.println("\u001B[32m" + "¿Qué dificultad prefieres?");
        System.out.println("1- Fácil");
        System.out.println("2- Medio");
        System.out.println("3- Difícil" + "\u001B[0m");
        int opcion = auxiliar(1,3);
        int premio = partidaDeAhorcado(opcion * 10);
        return premio;
    }

    /**
    * Método que ejecuta una partida del juego
    * @param dificultad esta sólo puede tener 3 valores, 10, 20, 30. Así se pone
    * un tope en el método elegirPalabra de la clase PalabraSecreta para escoger 
    * una palabra al azar.
    **/
    public int partidaDeAhorcado(int dificultad){
        String palabraSecreta = new PalabraSecreta().elegirPalabra(dificultad);
        int intentos = 0;
        int aciertos = 0;
        Scanner teclado = new Scanner(System.in);
        char[] arregloDeCaracteres = separa(palabraSecreta);
        char[] copia = separa(palabraSecreta);
        char[] tusRespuestas = new char[arregloDeCaracteres.length];
        char resp;

        // Rellenamos palabras con guiones
        for(int i = 0; i < tusRespuestas.length; i++){
            tusRespuestas[i] = '_';
        }

        System.out.println("\u001B[32m" + "Adivina la palabra" + "\u001B[0m");

        // Mientras que no nos pasemos con los intentos y no la acertemos...
        while(intentos < intentosTotales && aciertos != tusRespuestas.length){
            imprimeOculta(tusRespuestas);
            System.out.println("\u001B[32m" + " ");
            System.out.println("Introduce una letra: ");
            System.out.print("---> " + "\u001B[0m");
            resp = teclado.next().toLowerCase().charAt(0);
            System.out.println(" ");

            // Recorremos el array y comprobamos si se ha producido un acierto
            for(int i = 0; i < arregloDeCaracteres.length; i++){
                if(arregloDeCaracteres[i]==resp){
                    tusRespuestas[i] = arregloDeCaracteres[i];
                    arregloDeCaracteres[i] = ' ';
                    aciertos++;
                    intentos--;
                }
            }
            intentos++;

        }

        // Si se aciertan todas
        if(aciertos == tusRespuestas.length){
            System.out.println("\u001B[32m" + "Felicidades!! has acertado la palabra: " + "\u001B[0m");
            imprimeOculta(tusRespuestas);
            System.out.println("\u001B[32m" + " ");
            System.out.println("Te sobraron  " + (intentosTotales - intentos) + " intentos");
            System.out.println(" " + "\u001B[0m");
            if (dificultad == 10) {
                return 1;
            }else if(dificultad == 20){
                return 3;
            }else{
                return 5;
            }
        }

        // Si no se acertaron
        else{
            System.out.println("\u001B[32m" + "Suerte para la la próxima, la palabra era: " + "\u001B[0m");
            for(int i = 0; i < copia.length; i++){
                System.out.print(copia[i] + " ");
            }
            System.out.println(" ");
            if (dificultad == 10) {
                return -1;
            }else if(dificultad == 20){
                return -2;
            }else{
                return -3;
            }
        }
    }

    /**
    * Método que se encarga de separar el String en un array de caracteres
    * @return array de letras.
    **/
    private char[] separa(String palabra){
        char[] letras;
        letras = new char[palabra.length()];
        for(int i = 0; i < palabra.length(); i++){
            letras[i] = palabra.charAt(i);
        }

        return letras;

    }

    /**
    * Esto imprime la palabra con espacios
    * @param tusRespuestas el array de caracteres
    */
    private void imprimeOculta(char[] tusRespuestas){
        for(int i = 0; i < tusRespuestas.length; i++){
            System.out.print(tusRespuestas[i] + " ");
        }
    }

    /**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
    private static int auxiliar(int inicio, int fin)throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("\u001B[32m" + "---> "  + "\u001B[0m");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("\u001B[32m" + "Ingresa una opción válida" + "\u001B[0m");
                }
            }catch (NumberFormatException ex){
                System.out.println("\u001B[32m" + "Ingresa un NUMERO valido" + "\u001B[0m");
            }       
        }while(bandera == false);
        return opcion;
    }
}