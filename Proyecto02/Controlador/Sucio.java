package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/
import Modelo.*;
import Vista.*;
import java.io.*;

/**
* Clase que define el comportamiento de un tamagotchi cuando se encuentra sucio
* acorde al patrón de diseño State para la clase <code>Tamagotchi</code>.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Sucio implements State {
    private Tamagotchi tamagotchi;
    private int vecesDeJuego = 0;
    
    /**
    * Método que define la respuesta del tamagotchi cuando se encuentra sucio
    * y se le solicita que juegue con el usuario.
    **/
    @Override
    public void jugar() {
        if (vecesDeJuego < 3) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("\u001B[34m" + "Síiiiiii :D" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoJugando());
            int monedas = new MenuDeJuegos().menuJuegos(tamagotchi.juegosDisponibles());
            tamagotchi.setMonedas(tamagotchi.getMonedas()+monedas);
            vecesDeJuego++;
        }else{
            System.out.println("\u001B[34m" + "Ya estoy muy cansado :(, además necesito una ducha" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoSucio());
        }
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando está sucio
    * y se le trata de alimentar.
    **/
    @Override
    public void alimentar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("No quiero comer" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoSucio());
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando se trata de hacerle dormir
    * pero no ha tomado un baño.
    **/
    @Override
    public void dormir() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("No puedo irme a dormir así de sucio :(" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoSucio());
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando está sucio
    * y se intenta darle un baño.
    **/
    @Override
    public void baniar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("¡Yeiiiiiii!" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoFeliz());
        vecesDeJuego = 0;
        tamagotchi.setState(new Cansado());
    }
    
    /**
    * Método que nos da una descripción del estado actual del tamagotchi.
    **/
    @Override
    public void comoEstas() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("Estoy muy sucio, necesito bañarme" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoSucio());
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