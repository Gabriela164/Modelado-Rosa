package Controlador;

/**
* Declaración e importación de paquetes tanto propios como axuiliares externos.
* Se separan las clases en el proyecto acorde al patrón MVC.
*/

import Modelo.*;
import Vista.*;
import java.io.*;

/**
* Clase que define el comportamiento de un tamagotchi mientras se encuentra feliz y satisfecho
* acorde al patrón de diseño State para la clase <code>Tamagotchi</code>.
* @author Gabby, SanMa, Immerwahr. 
* @version 1.3
**/
public class Feliz implements State {
    private Tamagotchi tamagotchi;
    private int contadorDeRondas = 0;

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra feliz
    * una vez que se le solicita que juegue con el usuario.
    **/
    @Override
    public void jugar() {
        if (contadorDeRondas < 10) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("Vale, vamos a jugar :D" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoJugando());
            contadorDeRondas++;
            tamagotchi.setState(new Sucio());
            int monedas = new MenuDeJuegos().menuJuegos(tamagotchi.juegosDisponibles());
            tamagotchi.setMonedas(tamagotchi.getMonedas()+monedas);
        }else{
            System.out.println("\u001B[34m" + "Juegas muy mal, ya me aburrí de ti" + "\u001B[0m");
            tamagotchi.setState(new Muerto());
        }
    }

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra feliz
    * una vez que se le trata de alimentar.
    **/
    @Override
    public void alimentar() {
        if (contadorDeRondas < 10) {
            int comida = new TiendaComida().ordenar();
            if (tamagotchi.getMonedas() >= comida) {
                System.out.println("\u001B[34m" + " ");
                System.out.println("Ricooooooo" + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoComiendo());
                contadorDeRondas++;;
                tamagotchi.setMonedas(tamagotchi.getMonedas() - comida);
            }else{
                System.out.println("\u001B[34m" + " ");
                System.out.println("\u001B[34m" + "No te alcanza para comprar ese Hot dog" + "\u001B[0m");
                System.out.println("\u001B[34m" + "(Se donó el hot dog a un matemático)" + "\u001B[0m");
            }
        }else{
            System.out.println("\u001B[34m" + "Ya estoy obeso, ayudaaaaaaaaaa, mi colesteroooooooooooooooooool" + "\u001B[0m");
            tamagotchi.setState(new Muerto());
        }
    }

    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra feliz
    * cuando se trata de hacerle dormir.
    **/
    @Override
    public void dormir() {
        if (contadorDeRondas < 10) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("A mimiiiir" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoFeliz());
            contadorDeRondas++;
            tamagotchi.setState(new Hambriento()); 
        }else{
            System.out.println("\u001B[34m" + "Prefiero dormir permanentemente a seguir tolerandote" + "\u001B[0m");
            tamagotchi.setState(new Muerto());
        }
    }
    
    /**
    * Método que define la respuesta del tamagotchi mientras se encuentra feliz
    * una vez que se intenta darle un baño.
    **/
    @Override
    public void baniar() {
        if (contadorDeRondas < 10) {
            System.out.println("\u001B[34m" + " ");
            System.out.println("OK :D" + "\u001B[0m");
            System.out.println(tamagotchi.getSkin().graficoFeliz());
            contadorDeRondas++;
            tamagotchi.setState(new Cansado());
        }else{
            System.out.println("\u001B[34m" + "(Se ahogó xd)" + "\u001B[0m");
            tamagotchi.setState(new Muerto());
        }
    }
    
    /**
    * Método que nos da una descripción del estado actual del tamagotchi.
    **/
    @Override
    public void comoEstas() {
       switch (contadorDeRondas) {
            default:
                System.out.println("\u001B[34m" + " ");
                System.out.println("Estoy muy felíz contigo" + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoFeliz());
                contadorDeRondas++;
                break;
            case 7:
                System.out.println("\u001B[34m" + " ");
                System.out.println("Estoy felíz contigo" + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoFeliz());
                contadorDeRondas++;
                break;
            case 8:
                System.out.println("\u001B[34m" + " ");
                System.out.println("Me estás empezando a cansar un poco" + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoIndispuesto());
                contadorDeRondas++;
                break;
            case 9:
                System.out.println("\u001B[34m" + " ");
                System.out.println("AYUDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoFeliz());
                contadorDeRondas++;
                break;
            case 10:
                System.out.println("\u001B[34m" + "Tú causaste esto..." + "\u001B[0m");
                System.out.println(tamagotchi.getSkin().graficoMuerto());
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
