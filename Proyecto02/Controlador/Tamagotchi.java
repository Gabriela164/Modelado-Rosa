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
* Clase que define al tamagotchi per se, un tipo de mascota virtual cuyo comportamiento
* depende de su estado actual.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Tamagotchi {
    private State estado;
    private Apariencia skin;
    private int monedas = 3;
    private AlmacenDeMiniJuegos juegos;
    private AlmacenDeSkins apariencias;

    /**
    * Constructor de la clase que inicializa al tamagotchi con apariencia de rana por defecto. 
    **/
    public Tamagotchi() {
        setState(new Aburrido());
        juegos = new AlmacenDeMiniJuegos();
        apariencias = new AlmacenDeSkins();
        skin = new Rana();
    }

    /**
    * Método que permite al tamagotchi cambiar de apariencia. 
    */
    public void cambiarSkin(){
        if (this.estado instanceof Muerto) {
            System.out.println("\u001B[36m" + "No está dispoible esa acción" + "\u001B[0m");
        }else{
            System.out.println("\u001B[36m" + "Skins disponibles: " + "\u001B[0m");
            for (int i = 0; i < apariencias.getLista().size() ; i++) {
                System.out.println((i+1) + ".- " + apariencias.getLista().get(i).getNombre());
            }
            int opcion = auxiliar(1, apariencias.getLista().size());
            this.setSkin(apariencias.getLista().get(opcion-1));
        }
    }

    /**
    * Método de acceso al cátalogo de juegos disponible para el usuario.
    * @return objeto de la clase <code>AlmacenDeMiniJuegos</code> con el catálogo.
    **/
    public AlmacenDeMiniJuegos juegosDisponibles(){
        return this.juegos;
    }

    /**
    * Método de acceso al cátalogo de apariencias disponible para tamagotchi.
    * @return objeto de la clase <code>AlmacenDeSkins</code> con el catálogo.
    **/
    public AlmacenDeSkins skinsDisponibles(){
        return this.apariencias;
    }

    /**
    * Método para ajustar la cantidad de monedas disponibles para adquirir productos.
    * @param monedas nueva cantidad de monedas.
    **/
    public void setMonedas(int monedas){
        this.monedas = monedas;
    } 

    /**
    * Método de acceso a la cantidad de monedas disponibles para adquirir productos.
    * @return entero que indica la cantidad de monedas disponibles.
    **/
    public int getMonedas(){
        return this.monedas;
    }

    /**
    * Método de acceso a la apariencia actual de la mascota.
    * @return objeto que implementa la interfaz <code>Apariencia</code>.
    **/
    public Apariencia getSkin(){
        return this.skin;
    }
    
    /**
    * Método para modificar la apariencia actual de la mascota.
    * @param skin nueva apariencia de la mascota.
    **/
    public void setSkin(Apariencia skin){
        this.skin = skin;
    }

    /**
    * Método que permite ajustar el estado actual de la mascota.
    * @param estado nuevo estado anímico del tamagotchi. 
    **/
    public void setState(State estado) {
        this.estado = estado;
        this.estado.setTamagotchi(this);
    }

    /**
    * Método que permite intentar dar alimentos a la mascota acorde a su estado actual.
    **/
    public void alimentar() {
        this.estado.alimentar();
    }

    /**
    * Método que permite intentar mandar a dormir a la mascota acorde a su estado actual.
    **/
    public void dormir() {
        this.estado.dormir();
    }

    /**
    * Método que permite intentar jugar con la mascota acorde a su estado actual.
    **/
    public void jugar() {
        this.estado.jugar();
    }    

    /**
    * Método que permite conocer el estado anímico actual de la mascota.
    **/
    public void comoEstas() {
        this.estado.comoEstas();
    }

    /**
    * Método que permite intentar dar un baño a la mascota acorde a su estado actual.
    **/
    public void baniar() {
        this.estado.baniar();
    }

    /**
    * Declaración del método que se encarga de controlar excepciones al momento de leer desde terminal
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
                System.out.print("\u001B[36m" + "---> " +"\u001B[0m");
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
