package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/
import Modelo.*;
import Vista.*;
import java.util.Timer;
import java.util.TimerTask;
import java.io.*;

/**
* Clase que define el comportamiento de un tamagotchi mientras se encuentra durmiendo
* acorde al patrón de diseño State para la clase <code>Tamagotchi</code>.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Durmiendo implements State {
    private Tamagotchi tamagotchi;

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra durmiendo
    * una vez que se le solicita que juegue con el usuario.
    **/    
    @Override
    public void jugar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("ZzzZzzzZzZzZ" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoDurmiendo());
    }
    
    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra durmiendo
    * una vez que se le trata de alimentar.
    **/
    @Override
    public void alimentar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("ZzzZzzzZzZzZ" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoDurmiendo());
    }

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra durmiendo
    * cuando se trata de hacerle dormir (un tanto redundante).
    **/
    @Override
    public void dormir() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("ZzzZzzzZzZzZ" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoDurmiendo());
    }
    
    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra durmiendo
    * una vez que se intenta darle un baño.
    **/
    @Override
    public void baniar() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("ZzzZzzzZzZzZ" + "\u001B[0m");
        System.out.println(tamagotchi.getSkin().graficoDurmiendo());
    }

    /**
    * Método que nos da una descripción del estado actual del tamagotchi.
    **/
    @Override
    public void comoEstas() {
        System.out.println("\u001B[34m" + " ");
        System.out.println("(está durmiendo shh)" + "\u001B[0m");
    }

    /**
    * Método que permite asignar un tamagotchi del cuál se manipulara su estado.
    * @param tamagotchi la mascota virtual de la cuál se cambia el estado. 
    **/
    @Override
    public void setTamagotchi(Tamagotchi tamagotchi) {
        this.tamagotchi = tamagotchi;

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Durmiendo.this.tamagotchi.setState(new Hambriento());
            }
        }, 10000);
    }
}
