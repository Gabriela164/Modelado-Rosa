package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.io.*;

/**
* Clase que define el comportamiento de un tamagotchi cuando se encuentra hambriento
* acorde al patrón de diseño State para la clase <code>Tamagotchi</code>.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Hambriento implements State {
    private Tamagotchi tamagotchi;
    private int contadorSinComer = 0;
    private int tope = 11;

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra hambriento
    * una vez que se le solicita que juegue con el usuario.
    **/
    @Override
    public void jugar() {
        if (contadorSinComer < tope) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("No quiero jugar!" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoIndispuesto());
            contadorSinComer++;   
        }else{
            tamagotchi.setState(new Muerto());
        }
    }
    
    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra hambriento
    * una vez que se le trata de alimentar.
    **/
    @Override
    public void alimentar() {
        int comida = new TiendaComida().ordenar();
        if (tamagotchi.getMonedas() >= comida) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("Ñom ñom ñom" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoComiendo());
            tamagotchi.setMonedas(tamagotchi.getMonedas() - comida);
            tamagotchi.setState(new Feliz());   
        }else{
            System.out.println("\u001B[34m" + " ");
            System.out.println("No te alcanza para comprar ese Hot dog");
            System.out.println("(Se donó el hot dog a un matemático)" + "\u001B[0m");
        }
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando se trata de hacerle dormir con el
    * estomago vacío.
    **/
    @Override
    public void dormir() {
        if (contadorSinComer < tope) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("No quiero dormir!" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoIndispuesto());
            contadorSinComer++;   
        }else{
            tamagotchi.setState(new Muerto());
        }
    }
    
    /**
    * Método que define la respuesta del tamagotchi cuando está hambriento
    * si se intenta darle un baño.
    **/
    @Override
    public void baniar() {
        if (contadorSinComer < tope) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("No me quiero bañar >:(" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoIndispuesto());
            contadorSinComer++;
        }else{
            tamagotchi.setState(new Muerto());
        }
    }
    
    /**
    * Método que nos da una descripción del estado actual del tamagotchi.
    **/
    @Override
    public void comoEstas() {
        if (contadorSinComer < tope) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("Dame de comer!" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoIndispuesto());
            contadorSinComer++;
        }else{
            tamagotchi.setState(new Muerto());
        }
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
