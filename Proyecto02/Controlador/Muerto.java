package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/
import Modelo.*;
import Vista.*;
import java.io.*;

/**
* Clase que define el comportamiento de un tamagotchi cuando se encuentra muerto
* acorde al patrón de diseño State para la clase <code>Tamagotchi</code>.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Muerto implements State {
    private Tamagotchi tamagotchi;
    
    /**
    * Método que define la respuesta del tamagotchi cuando está ya muerto
    * y se le solicita que juegue con el usuario.
    **/
    @Override
    public void jugar() {
        System.out.println("\u001B[34m" +" ");
        System.out.println("..." + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoMuerto());
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando está muerto
    * y se le trata de alimentar.
    **/
    @Override
    public void alimentar() {
        System.out.println("\u001B[34m"+ " ");
        System.out.println("..." + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoMuerto());
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando se trata de hacerle dormir
    * pero ya está dormido para siempre.
    **/
    @Override
    public void dormir() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("..." + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoMuerto());
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando está muerto
    * y se intenta darle un baño.
    **/
    @Override
    public void baniar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("..." + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoMuerto());
    }
    
    /**
    * Método que nos da una descripción del estado actual del tamagotchi.
    **/
    @Override
    public void comoEstas() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("(Está tieso)" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoMuerto());
    }

    /**
    * Método que permite asignar un tamagotchi del cuál se manipulara su estado.
    * @param tamagotchi la mascota virtual de la cuál se cambia el estado. 
    **/
    @Override
    public void setTamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;
    }
}
