package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
* Clase que define una tienda de alimentos para controlar el acceso y preparación de los 
* alimentos que el usuario brindara a su masctoa
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class TiendaComida{

    /**
    * Método que gestiona la presentación de los alimentos disponibles y 
    * la elección del usuario.
    * @return entero con la opción elegida por el usuario.
    **/
    public int ordenar (){
        System.out.println("\u001B[34m" + "***** Holaaa! Bienvenido a tu tienda de comida favorita **** \n ¿Listo para ordenar tu hot dog? ^-^");
        System.out.println("¿Qué tipo de salchicha le gustaría que tenga su hot dog loco?");
        System.out.println("1- Hot dog con salchicha de arrachera");
        System.out.println("2- Hot dog con salchicha de chorizo");
        System.out.println("3- Hot dog con salchicha de salami" + "\u001B[0m");
        int opcion2 = auxiliar(1,3);
        int i = 0;
        switch (opcion2) {
        case 1:
            HotDogArrachera hotDogArrachera = new HotDogArrachera();
            i = opcionBaguette(hotDogArrachera);
            break;
        case 2:
            HotDogChorizo hotDogChorizo = new HotDogChorizo();
            i = opcionBaguette(hotDogChorizo);
            break;
        case 3:
            HotDogSalami hotDogSalami = new HotDogSalami();
            i = opcionBaguette(hotDogSalami);
            break;
        }
        return i;
    }

    /**
    * Método auxiliar que se encarga de mostrar el menú de complementos y gestionar la preparación
    * del platillo.
    * @param hotDogLoco el ente concreto que sirve como base para la preparación del platillo.
    * @return entero que indica el precio en moneda virtual del alimento preparado.
    **/
    private int opcionBaguette(HotDogLoco hotDogLoco){
        int bandera1 = 0;
        int bandera2 = 0;
        int bandera3 = 0;
        int bandera4 = 0;
        int bandera5 = 0;
        int bandera6 = 0;
        int bandera7 = 0;
        int bandera8 = 0;
        int bandera9 = 0;

        if (hotDogLoco instanceof HotDogArrachera) {
            hotDogLoco = (HotDogArrachera)hotDogLoco;
        }
        else if (hotDogLoco instanceof HotDogChorizo) {
            hotDogLoco= (HotDogChorizo)hotDogLoco;
        }
        else{
            hotDogLoco = (HotDogSalami)hotDogLoco;
        }
        int opcion = 100;
        while(opcion != 0){
            System.out.println("\u001B[34m" + "¿Qué ingrediente quieres agregar?");
            System.out.println("1- Jitomate");
            System.out.println("2- Catsup");
            System.out.println("3- Cebolla");
            System.out.println("4- Papas crujientes");
            System.out.println("5- Mostaza");
            System.out.println("6- Chile picado");
            System.out.println("7- Mayonesa");
            System.out.println("8- Lechuga");
            System.out.println("9- Pan");
            System.out.println("0- Recibir ticket" + "\u001B[0m");
            opcion = auxiliar(0,9);
            switch (opcion) {
                case 1:
                    if (bandera1 <= 2) {
                        hotDogLoco = new Jitomate(hotDogLoco);
                        bandera1++;   
                    }   
                    
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 2:
                    
                    if (bandera2 <= 2) {
                        hotDogLoco = new Catsup(hotDogLoco);
                        bandera2++; 
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 3:
                    
                    if (bandera3 <= 2) {
                        hotDogLoco = new Cebolla(hotDogLoco);
                        bandera3++; 
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 4:
                    if (bandera4 <= 2) {
                        hotDogLoco = new PapasCrujientes(hotDogLoco);
                        bandera4++;  
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 5:
                    if (bandera5 <= 2) {
                        hotDogLoco = new Mostaza(hotDogLoco);
                        bandera5++;  
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 6:
                    if (bandera6 <= 2) { 
                        hotDogLoco = new ChilePicado(hotDogLoco);
                        bandera6++;
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 7:
                    if (bandera7 <= 2) {
                        hotDogLoco = new Mayonesa(hotDogLoco);
                        bandera7++;
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 8:
                    if (bandera8 <= 2) {
                        hotDogLoco = new Lechuga(hotDogLoco);
                        bandera8++;  
                    }
                    else{
                        System.out.println("\u001B[34m" + "Haz alcanzado el máximo de ese ingrediente" + "\u001B[0m");
                    }
                    break;
                case 9:
                    if (bandera9 <= 0) {
                        hotDogLoco = new Pan(hotDogLoco);
                        bandera9++;  
                    }
                    else{
                        System.out.println("\u001B[34m" + "Solamente puedes agregar un solo pan" + "\u001B[0m");
                    }
                    break;
                case 0:
                    System.out.println("\u001B[34m" + "***********Ticket*************");
                    System.out.println("¡¡ Tu hot dog esta listo ^-^ !! \nHas ordenado un "+hotDogLoco.getDescripcion()+"\nQue lo disfrutes :D ");
                    System.out.println("Total a pagar: " + hotDogLoco.getPrecio());
                    System.out.println("******************************" + "\u001B[0m");
                    break;
            }
        }

        return hotDogLoco.getPrecio();
    }
    

    /**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
    * estando acotada por arriba y por abajo.
    * @param inicio Cota inferior para la lectura del entero
    * @param fin COta superior para la lectura del entero
    * @throws NumberFormatException si se ingresa un dígito que no sea un entero
    **/
     private int auxiliar(int inicio, int fin) throws NumberFormatException {
        Scanner sc = new Scanner(System.in);
        int opcion = -100;
        boolean bandera = false;

        do{
            try {
                System.out.print("\u001B[34m" + "---> " + "\u001B[0m");
                String opcionUsuario = sc.nextLine();
                opcion = Integer.parseInt(opcionUsuario);
                if (opcion >= inicio && opcion <= fin) {
                    break;  
                }
                else{
                    System.out.println("\u001B[34m" + "Ingresa una opción válida" + "\u001B[0m");
                }
            }catch (NumberFormatException ex){
                System.out.println("\u001B[34m" + "Ingresa un NUMERO valido" + "\u001B[0m");
            }       
        }while(bandera == false);
        return opcion;
    }
}
